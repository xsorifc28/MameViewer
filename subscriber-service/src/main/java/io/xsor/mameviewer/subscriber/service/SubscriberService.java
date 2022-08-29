package io.xsor.mameviewer.subscriber.service;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.xsor.mameviewer.CreateSubscriberRequest;
import io.xsor.mameviewer.CreateSubscriberResponse;
import io.xsor.mameviewer.GetSubscriberRequest;
import io.xsor.mameviewer.GetSubscriberResponse;
import io.xsor.mameviewer.SubscriberGrpc;
import io.xsor.mameviewer.subscriber.util.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SubscriberService extends SubscriberGrpc.SubscriberImplBase {

    // In-place db to hold subscribers
    private static final Map<String, CreateSubscriberRequest> subscribers = new HashMap<>();

    /**
     * Create a subscriber and store in in-place db
     * @param request the subscriber create request
     * @param responseObserver grpc stream observer
     */
    @Override
    public void createSubscriber(CreateSubscriberRequest request, StreamObserver<CreateSubscriberResponse> responseObserver) {
        if (Utils.isSubscriberInvalid(request)) {
            responseObserver.onError(Status.FAILED_PRECONDITION.withDescription("Request is missing required fields").asRuntimeException());
        } else {
            String subscriberId = UUID.randomUUID().toString();
            subscribers.put(subscriberId, request);
            responseObserver.onNext(CreateSubscriberResponse.newBuilder().setSubscriberId(subscriberId).build());
            responseObserver.onCompleted();
        }
    }

    /**
     * Search for a subscriber by id
     * @param request the get subscriber request
     * @param responseObserver grpc stream observer
     */
    @Override
    public void getSubscriber(GetSubscriberRequest request, StreamObserver<GetSubscriberResponse> responseObserver) {
        if(subscribers.get(request.getSubscriberId()) == null) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("Subscriber not found in database").asRuntimeException());
        } else {
            CreateSubscriberRequest subscriber = subscribers.get(request.getSubscriberId());
            responseObserver.onNext(GetSubscriberResponse.newBuilder()
                    .setSubscriberId(request.getSubscriberId())
                    .setName(subscriber.getName())
                    .setEmail(subscriber.getEmail())
                    .setTier(subscriber.getTier())
                    .build());
            responseObserver.onCompleted();
        }
    }
}
