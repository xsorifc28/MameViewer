// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MameViewer.proto

package generated;

/**
 * <pre>
 **
 *Message format for subscriber create response
 *A non-zero subscriber id indicates successful creation
 * </pre>
 *
 * Protobuf type {@code mameviewer.CreateSubscriberResponse}
 */
public final class CreateSubscriberResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:mameviewer.CreateSubscriberResponse)
    CreateSubscriberResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreateSubscriberResponse.newBuilder() to construct.
  private CreateSubscriberResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateSubscriberResponse() {
    subscriberId_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new CreateSubscriberResponse();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreateSubscriberResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            String s = input.readStringRequireUtf8();

            subscriberId_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return MameViewer.internal_static_mameviewer_CreateSubscriberResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MameViewer.internal_static_mameviewer_CreateSubscriberResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            CreateSubscriberResponse.class, Builder.class);
  }

  public static final int SUBSCRIBERID_FIELD_NUMBER = 1;
  private volatile Object subscriberId_;
  /**
   * <code>string subscriberId = 1;</code>
   * @return The subscriberId.
   */
  @Override
  public String getSubscriberId() {
    Object ref = subscriberId_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      subscriberId_ = s;
      return s;
    }
  }
  /**
   * <code>string subscriberId = 1;</code>
   * @return The bytes for subscriberId.
   */
  @Override
  public com.google.protobuf.ByteString
      getSubscriberIdBytes() {
    Object ref = subscriberId_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      subscriberId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(subscriberId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, subscriberId_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(subscriberId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, subscriberId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof CreateSubscriberResponse)) {
      return super.equals(obj);
    }
    CreateSubscriberResponse other = (CreateSubscriberResponse) obj;

    if (!getSubscriberId()
        .equals(other.getSubscriberId())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SUBSCRIBERID_FIELD_NUMBER;
    hash = (53 * hash) + getSubscriberId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static CreateSubscriberResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CreateSubscriberResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CreateSubscriberResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CreateSubscriberResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CreateSubscriberResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CreateSubscriberResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CreateSubscriberResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CreateSubscriberResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static CreateSubscriberResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static CreateSubscriberResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static CreateSubscriberResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CreateSubscriberResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(CreateSubscriberResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   **
   *Message format for subscriber create response
   *A non-zero subscriber id indicates successful creation
   * </pre>
   *
   * Protobuf type {@code mameviewer.CreateSubscriberResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:mameviewer.CreateSubscriberResponse)
      CreateSubscriberResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MameViewer.internal_static_mameviewer_CreateSubscriberResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MameViewer.internal_static_mameviewer_CreateSubscriberResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CreateSubscriberResponse.class, Builder.class);
    }

    // Construct using generated.CreateSubscriberResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      subscriberId_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MameViewer.internal_static_mameviewer_CreateSubscriberResponse_descriptor;
    }

    @Override
    public CreateSubscriberResponse getDefaultInstanceForType() {
      return CreateSubscriberResponse.getDefaultInstance();
    }

    @Override
    public CreateSubscriberResponse build() {
      CreateSubscriberResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public CreateSubscriberResponse buildPartial() {
      CreateSubscriberResponse result = new CreateSubscriberResponse(this);
      result.subscriberId_ = subscriberId_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof CreateSubscriberResponse) {
        return mergeFrom((CreateSubscriberResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(CreateSubscriberResponse other) {
      if (other == CreateSubscriberResponse.getDefaultInstance()) return this;
      if (!other.getSubscriberId().isEmpty()) {
        subscriberId_ = other.subscriberId_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      CreateSubscriberResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (CreateSubscriberResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object subscriberId_ = "";
    /**
     * <code>string subscriberId = 1;</code>
     * @return The subscriberId.
     */
    public String getSubscriberId() {
      Object ref = subscriberId_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        subscriberId_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string subscriberId = 1;</code>
     * @return The bytes for subscriberId.
     */
    public com.google.protobuf.ByteString
        getSubscriberIdBytes() {
      Object ref = subscriberId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        subscriberId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string subscriberId = 1;</code>
     * @param value The subscriberId to set.
     * @return This builder for chaining.
     */
    public Builder setSubscriberId(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      subscriberId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string subscriberId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSubscriberId() {

      subscriberId_ = getDefaultInstance().getSubscriberId();
      onChanged();
      return this;
    }
    /**
     * <code>string subscriberId = 1;</code>
     * @param value The bytes for subscriberId to set.
     * @return This builder for chaining.
     */
    public Builder setSubscriberIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      subscriberId_ = value;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:mameviewer.CreateSubscriberResponse)
  }

  // @@protoc_insertion_point(class_scope:mameviewer.CreateSubscriberResponse)
  private static final CreateSubscriberResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new CreateSubscriberResponse();
  }

  public static CreateSubscriberResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateSubscriberResponse>
      PARSER = new com.google.protobuf.AbstractParser<CreateSubscriberResponse>() {
    @Override
    public CreateSubscriberResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CreateSubscriberResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateSubscriberResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<CreateSubscriberResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public CreateSubscriberResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

