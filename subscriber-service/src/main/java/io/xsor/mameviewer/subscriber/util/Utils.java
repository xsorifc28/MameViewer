package io.xsor.mameviewer.subscriber.util;

import io.xsor.mameviewer.CreateSubscriberRequest;
import io.xsor.mameviewer.Tier;

public class Utils {

    private Utils() {}

    /**
     * Check if a subscriber is invalid
     * @param request the subscriber
     * @return false is subscriber has missing or invalid fields
     */
    public static boolean isSubscriberInvalid(CreateSubscriberRequest request) {
        return request.getEmail().isEmpty() || request.getName().isEmpty() || request.getTier().equals(Tier.UNKNOWN);
    }
}
