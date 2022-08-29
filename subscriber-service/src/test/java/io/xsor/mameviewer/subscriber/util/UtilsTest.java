package io.xsor.mameviewer.subscriber.util;

import io.xsor.mameviewer.CreateSubscriberRequest;
import io.xsor.mameviewer.Tier;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilsTest {

    @Test
    public void test_isSubscriberValid_True() {
        assertFalse(Utils.isSubscriberInvalid(CreateSubscriberRequest.newBuilder()
                .setName("Med")
                .setEmail("med@oz.io")
                .setTier(Tier.PREMIUM)
                .build()));
    }

    @Test
    public void test_isSubscriberValid_Failure() {
        assertTrue(Utils.isSubscriberInvalid(CreateSubscriberRequest.newBuilder().build()));
    }

    @Test
    public void test_isSubscriberValid_False_EmptyEmail() {
        CreateSubscriberRequest csr = CreateSubscriberRequest.newBuilder()
                .setName("Med")
                .build();
        assertTrue(Utils.isSubscriberInvalid(csr));
    }

    @Test
    public void test_isSubscriberValid_False_EmptyName() {
        CreateSubscriberRequest csr = CreateSubscriberRequest.newBuilder()
                .setEmail("med@oz.io")
                .build();
        assertTrue(Utils.isSubscriberInvalid(csr));
    }

    @Test
    public void test_isSubscriberValid_False_EmptyTier() {
        CreateSubscriberRequest csr = CreateSubscriberRequest.newBuilder()
                .setName("Med")
                .setEmail("med@oz.io")
                .build();
        assertTrue(Utils.isSubscriberInvalid(csr));
    }

    @Test
    public void test_isSubscriberValid_False_UnknownTier() {
        CreateSubscriberRequest csr = CreateSubscriberRequest.newBuilder()
                .setName("Med")
                .setEmail("med@oz.io")
                .setTier(Tier.UNKNOWN)
                .build();
        assertTrue(Utils.isSubscriberInvalid(csr));
    }
}
