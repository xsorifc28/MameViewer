const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const { v4 } = require('uuid');
const PROTO_PATH = __dirname + (process.env.PROTO_PATH || '/../MameViewer.proto');

const { uniqueNamesGenerator, adjectives, colors, animals } = require('unique-names-generator');

const packageDefinition = protoLoader.loadSync(
    PROTO_PATH,
    {
        keepCase: true,
        longs: String,
        enums: String,
        defaults: true,
        oneofs: true
    });

const mameViewer = grpc.loadPackageDefinition(packageDefinition).mameviewer;

const entitlementDb = generateEntitlementDb();

const subscriberClient = new mameViewer.Subscriber(
    process.env.SUBSCRIBER_SERVICE_ENDPOINT || 'host.docker.internal:9090',
    grpc.credentials.createInsecure());

const server = new grpc.Server();

server.addService(mameViewer.Entitlements.service, { getEntitlements });

server.bindAsync('0.0.0.0:9091', grpc.ServerCredentials.createInsecure(), () => {
    server.start();
    console.info('Service started on port 9091');
});

function getSubscriberCallback(callback) {
    return function (error, subscriber) {
        if (error) {
            console.error(error);
            callback(error);
        } else {
            const entitlements = getEntitlementsByTier(subscriber.tier)
            callback(null, { entitlements });
        }
    };
}

function getEntitlements(entitlementRequest, callback) {
    subscriberClient.getSubscriber({
        subscriberId: entitlementRequest.request.subscriberId
    }, getSubscriberCallback(callback));
}

function getEntitlementsByTier(tier) {
    return entitlementDb.filter(e => e.tier === tier);
}

function generateRandomInteger(min, max) {
    return Math.floor(min + Math.random()*(max - min + 1))
}

function generateEntitlementDb() {
    const entitlementDb = [];

    for (let i = 0; i < 50; i++) {

        const title = uniqueNamesGenerator({
            dictionaries: [adjectives, colors, animals],
            separator: ' ',
            style: 'capital'
        });

        entitlementDb.push({
            entitlementId: v4(),
            title: title,
            duration: generateRandomInteger(60, 183) * 60,
            coverArt: 'https://cataas.com/cat/says/' + title + "?size=10&width=100&height=100",
            rating: generateRandomInteger(0, 100) / 10,
            tier: mameViewer.Tier.type.value[generateRandomInteger(1, 2)].name
        });
    }

    // Guarantee one of each tier
    entitlementDb[0].tier = mameViewer.Tier.type.value[1].name
    entitlementDb[1].tier = mameViewer.Tier.type.value[2].name

    return entitlementDb;
}
