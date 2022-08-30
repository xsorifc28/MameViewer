package io.xsor.mameviewer;

import generated.ContentGrpc;
import generated.CreateSubscriberRequest;
import generated.CreateSubscriberResponse;
import generated.EntitlementRequest;
import generated.EntitlementResponse;
import generated.EntitlementsGrpc;
import generated.GetSubscriberRequest;
import generated.GetSubscriberResponse;
import generated.MediaRequest;
import generated.MediaResponse;
import generated.SubscriberGrpc;
import generated.Tier;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MameViewerBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(MameViewerBffApplication.class, args);
    }

    ManagedChannel subscriberChannel = ManagedChannelBuilder.forTarget("host.docker.internal:9090").usePlaintext().build();
    ManagedChannel entitlementsChannel = ManagedChannelBuilder.forTarget("host.docker.internal:9091").usePlaintext().build();
    ManagedChannel contentChannel = ManagedChannelBuilder.forTarget("host.docker.internal:9092").usePlaintext().build();

    SubscriberGrpc.SubscriberBlockingStub subscriberBlockingStub = SubscriberGrpc.newBlockingStub(subscriberChannel);
    EntitlementsGrpc.EntitlementsBlockingStub entitlementsBlockingStub = EntitlementsGrpc.newBlockingStub(entitlementsChannel);
    ContentGrpc.ContentBlockingStub contentBlockingStub = ContentGrpc.newBlockingStub(contentChannel);

    @PostMapping("/subscriber")
    public SubscriberResponseModel createSubscriber(@RequestBody SubscriberRequestModel subscriberRequestModel) {
        CreateSubscriberResponse response = subscriberBlockingStub.createSubscriber(CreateSubscriberRequest.newBuilder()
                        .setName(subscriberRequestModel.getName())
                        .setEmail(subscriberRequestModel.getEmail())
                        .setTier(subscriberRequestModel.getTier())
                .build());

        SubscriberResponseModel srm = new SubscriberResponseModel();
        srm.setName(subscriberRequestModel.getName());
        srm.setEmail(subscriberRequestModel.getEmail());
        srm.setTier(subscriberRequestModel.getTier());
        srm.setSubscriberId(response.getSubscriberId());

        return srm;
    }

    @GetMapping("/subscriber")
    public SubscriberResponseModel getSubscriber(@RequestParam String id) {
        GetSubscriberResponse response = subscriberBlockingStub.getSubscriber(GetSubscriberRequest.newBuilder()
                .setSubscriberId(id)
                .build());

        SubscriberResponseModel srm = new SubscriberResponseModel();
        srm.setSubscriberId(response.getSubscriberId());
        srm.setName(response.getName());
        srm.setEmail(response.getEmail());
        srm.setTier(response.getTier());

        return srm;
    }

    @GetMapping("/entitlements")
    public List<EntitlementsResponseModel> getEntitlements(@RequestParam String subscriberId) {
        EntitlementResponse response = entitlementsBlockingStub.getEntitlements(EntitlementRequest
                .newBuilder()
                .setSubscriberId(subscriberId)
                .build());

        return response.getEntitlementsList().stream().map((e) -> {
            EntitlementsResponseModel erm = new EntitlementsResponseModel();
            erm.setTitle(e.getTitle());
            erm.setDuration(e.getDuration());
            erm.setRating(e.getRating());
            erm.setCoverArt(e.getCoverArt());
            erm.setTier(e.getTier());
            erm.setEntitlementId(e.getEntitlementId());
            return erm;
        }).toList();
    }

    @GetMapping("/content")
    public MediaResponseModel getContent(@RequestParam String entitlementId) {
        MediaResponse response = contentBlockingStub.getMedia(MediaRequest
                .newBuilder()
                .setEntitlementId(entitlementId)
                .build());


        MediaResponseModel mrm = new MediaResponseModel();
        mrm.setStreamableLink(response.getStreamableLink());

        return mrm;
    }

    public static class SubscriberRequestModel {

        private String name;
        private String email;
        private Tier tier;

        private SubscriberRequestModel() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Tier getTier() {
            return tier;
        }

        public void setTier(Tier tier) {
            this.tier = tier;
        }
    }

    public static class SubscriberResponseModel extends SubscriberRequestModel {
        private String subscriberId;

        private SubscriberResponseModel() {}

        public String getSubscriberId() {
            return subscriberId;
        }

        public void setSubscriberId(String subscriberId) {
            this.subscriberId = subscriberId;
        }

    }

    public static class EntitlementsResponseModel {
        private String entitlementId;
        private String title ;
        private String duration;
        private String coverArt;
        private String rating;
        private Tier tier;

        public String getEntitlementId() {
            return entitlementId;
        }

        public void setEntitlementId(String entitlementId) {
            this.entitlementId = entitlementId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDuration() {
            int d = Integer.parseInt(this.duration);
            return String.format("%02d:%02d:%02d", d / 3600, (d / 60) % 60, d % 60);
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getCoverArt() {
            return coverArt;
        }

        public void setCoverArt(String coverArt) {
            this.coverArt = coverArt;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public Tier getTier() {
            return tier;
        }

        public void setTier(Tier tier) {
            this.tier = tier;
        }
    }

    public static class MediaResponseModel {
        private String streamableLink;

        public String getStreamableLink() {
            return streamableLink;
        }

        public void setStreamableLink(String streamableLink) {
            this.streamableLink = streamableLink;
        }

    }
}
