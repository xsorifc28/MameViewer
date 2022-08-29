package io.xsor.mameviewer.subscriber.server;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    private static final SubscriberServer mockServer = new SubscriberServer(0);

    @BeforeClass
    public static void setUp() {
        Whitebox.setInternalState(Main.class, "subscriberServer", mockServer);

    }

    @Test
    public void main_Success() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            new ScheduledThreadPoolExecutor(1).schedule(() -> {
                try {
                    mockServer.stop();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    fail(e.getMessage());
                }
            }, 2, TimeUnit.SECONDS);

            Main.main(new String[]{});
            assertTrue(countDownLatch.await(5, TimeUnit.SECONDS));
            assertEquals(0, countDownLatch.getCount());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}