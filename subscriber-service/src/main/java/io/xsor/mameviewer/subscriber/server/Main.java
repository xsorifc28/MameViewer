package io.xsor.mameviewer.subscriber.server;

public class Main {

    private Main() {}

    // Holds the server. Protected to make unit testing easier - alternative required
    protected static SubscriberServer subscriberServer = new SubscriberServer(9090);

    /**
     * Main
     * @param args no args expected
     * @throws Exception thrown if server initiation encounters an error
     */
    public static void main(String[] args) throws Exception {
        subscriberServer.start();
        subscriberServer.blockUntilShutdown();
    }
}
