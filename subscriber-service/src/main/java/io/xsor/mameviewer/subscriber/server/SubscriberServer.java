package io.xsor.mameviewer.subscriber.server;

import io.grpc.ServerBuilder;
import io.xsor.mameviewer.subscriber.service.SubscriberService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubscriberServer {
    private static final Logger logger = Logger.getLogger(SubscriberServer.class.getName());

    private final int port;

    private final io.grpc.Server server;

    /**
     * Create a MameViewer server listening on {@code port}
     */
    public SubscriberServer(int port) {
        this(ServerBuilder.forPort(port), port);
    }

    /**
     * Create a SubscriberServer server using serverBuilder as a base and features as data
     */
    public SubscriberServer(ServerBuilder<?> serverBuilder, int port) {
        this.port = port;
        server = serverBuilder.addService(new SubscriberService())
                .build();
    }

    /**
     * Start serving requests
     */
    @SuppressWarnings("java:S106")
    public void start() throws IOException {
        server.start();
        logger.log(Level.INFO, "Server started, listening on port {0}", port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("Shutting down gRPC server since JVM is shutting down");
            try {
                this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
                Thread.currentThread().interrupt();
            }
            System.err.println("Server shut down");
        }));
    }

    /**
     * Stop serving requests and shutdown resources
     */
    public void stop() throws InterruptedException {
        server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads
     */
    public void blockUntilShutdown() throws InterruptedException {
        server.awaitTermination();
    }
}
