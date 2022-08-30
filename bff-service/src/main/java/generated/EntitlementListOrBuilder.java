// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MameViewer.proto

package generated;

public interface EntitlementListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:mameviewer.EntitlementList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string entitlementId = 1;</code>
   * @return The entitlementId.
   */
  String getEntitlementId();
  /**
   * <code>string entitlementId = 1;</code>
   * @return The bytes for entitlementId.
   */
  com.google.protobuf.ByteString
      getEntitlementIdBytes();

  /**
   * <code>string title = 2;</code>
   * @return The title.
   */
  String getTitle();
  /**
   * <code>string title = 2;</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string duration = 3;</code>
   * @return The duration.
   */
  String getDuration();
  /**
   * <code>string duration = 3;</code>
   * @return The bytes for duration.
   */
  com.google.protobuf.ByteString
      getDurationBytes();

  /**
   * <code>string coverArt = 4;</code>
   * @return The coverArt.
   */
  String getCoverArt();
  /**
   * <code>string coverArt = 4;</code>
   * @return The bytes for coverArt.
   */
  com.google.protobuf.ByteString
      getCoverArtBytes();

  /**
   * <code>string rating = 5;</code>
   * @return The rating.
   */
  String getRating();
  /**
   * <code>string rating = 5;</code>
   * @return The bytes for rating.
   */
  com.google.protobuf.ByteString
      getRatingBytes();

  /**
   * <code>.mameviewer.Tier tier = 6;</code>
   * @return The enum numeric value on the wire for tier.
   */
  int getTierValue();
  /**
   * <code>.mameviewer.Tier tier = 6;</code>
   * @return The tier.
   */
  Tier getTier();
}
