package io.xsor.mameviewer.subscriber.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;

import java.util.regex.Pattern;

import io.xsor.mameviewer.CreateSubscriberRequest;
import io.xsor.mameviewer.CreateSubscriberResponse;
import io.xsor.mameviewer.GetSubscriberRequest;
import io.xsor.mameviewer.GetSubscriberResponse;
import io.xsor.mameviewer.SubscriberGrpc;
import io.xsor.mameviewer.Tier;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SubscriberServerIntegrationTest {
    /**
     * This rule manages automatic graceful shutdown for the registered channel at the end of test.
     */
    public static final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

    private static SubscriberServer subscriberServer;

    private static SubscriberGrpc.SubscriberBlockingStub stub;


    @BeforeClass
    public static void setUp() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        subscriberServer = new SubscriberServer(
                InProcessServerBuilder.forName(serverName).directExecutor(), 0);
        subscriberServer.start();
        // Create a client channel and register for automatic graceful shutdown.
        ManagedChannel inProcessChannel = grpcCleanup.register(
                InProcessChannelBuilder.forName(serverName).directExecutor().build());
        stub = SubscriberGrpc.newBlockingStub(inProcessChannel);

    }

    @AfterClass
    public static void tearDown() throws Exception {
        subscriberServer.stop();
    }

    @Test
    public void createSubscriber_Success() {
        CreateSubscriberRequest csr = CreateSubscriberRequest.newBuilder()
                .setName("Med")
                .setEmail("med@oz.io")
                .setTier(Tier.PREMIUM)
                .build();

        CreateSubscriberResponse actual = stub.createSubscriber(csr);

        assertEquals(36, actual.getSubscriberId().length());
        assertTrue(actual.getSubscriberId().matches(Pattern.compile("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})").pattern()));
    }

    @Test
    public void createSubscriber_EmptyName_Failure() {
        CreateSubscriberRequest csr = CreateSubscriberRequest.newBuilder()
                .setEmail("med@oz.io")
                .setTier(Tier.PREMIUM)
                .build();

        StatusRuntimeException e = assertThrows(StatusRuntimeException.class, () -> {
            CreateSubscriberResponse actual = stub.createSubscriber(csr);
            if (actual != null)  {
                fail("Expected createSubscriber throw an error");
            }
        });
        assertEquals("FAILED_PRECONDITION", e.getStatus().getCode().toString());
        assertEquals("FAILED_PRECONDITION: Request is missing required fields", e.getMessage());

    }

    @Test
    public void getSubscriber_Success() {
        CreateSubscriberRequest expected = CreateSubscriberRequest.newBuilder()
                .setName("Med")
                .setEmail("med@oz.io")
                .setTier(Tier.PREMIUM)
                .build();

        CreateSubscriberResponse newSubscriber = stub.createSubscriber(expected);

        GetSubscriberRequest gsr = GetSubscriberRequest.newBuilder()
                .setSubscriberId(newSubscriber.getSubscriberId())
                .build();

        GetSubscriberResponse actual = stub.getSubscriber(gsr);

        assertEquals(newSubscriber.getSubscriberId(), actual.getSubscriberId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getTier(), actual.getTier());
    }

    @Test
    public void getSubscriber_Failure() {
        GetSubscriberRequest gsr = GetSubscriberRequest.newBuilder()
                .setSubscriberId(String.valueOf(System.currentTimeMillis()))
                .build();

        StatusRuntimeException e = assertThrows(StatusRuntimeException.class, () -> {
            GetSubscriberResponse actual = stub.getSubscriber(gsr);
            if (actual != null)  {
                fail("Expected createSubscriber throw an error");
            }
        });

        assertEquals("NOT_FOUND", e.getStatus().getCode().toString());
        assertEquals("NOT_FOUND: Subscriber not found in database", e.getMessage());
    }
}