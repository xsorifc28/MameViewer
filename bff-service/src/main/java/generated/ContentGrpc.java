package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 **
 *The content library service returns streamable links for a given entitlement
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.48.1)",
    comments = "Source: MameViewer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ContentGrpc {

  private ContentGrpc() {}

  public static final String SERVICE_NAME = "mameviewer.Content";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<MediaRequest,
          MediaResponse> getGetMediaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMedia",
      requestType = MediaRequest.class,
      responseType = MediaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MediaRequest,
          MediaResponse> getGetMediaMethod() {
    io.grpc.MethodDescriptor<MediaRequest, MediaResponse> getGetMediaMethod;
    if ((getGetMediaMethod = ContentGrpc.getGetMediaMethod) == null) {
      synchronized (ContentGrpc.class) {
        if ((getGetMediaMethod = ContentGrpc.getGetMediaMethod) == null) {
          ContentGrpc.getGetMediaMethod = getGetMediaMethod =
              io.grpc.MethodDescriptor.<MediaRequest, MediaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMedia"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MediaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MediaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContentMethodDescriptorSupplier("GetMedia"))
              .build();
        }
      }
    }
    return getGetMediaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ContentStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContentStub>() {
        @Override
        public ContentStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContentStub(channel, callOptions);
        }
      };
    return ContentStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContentBlockingStub>() {
        @Override
        public ContentBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContentBlockingStub(channel, callOptions);
        }
      };
    return ContentBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ContentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContentFutureStub>() {
        @Override
        public ContentFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContentFutureStub(channel, callOptions);
        }
      };
    return ContentFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   **
   *The content library service returns streamable links for a given entitlement
   * </pre>
   */
  public static abstract class ContentImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMedia(MediaRequest request,
                         io.grpc.stub.StreamObserver<MediaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMediaMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMediaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      MediaRequest,
                      MediaResponse>(
                  this, METHODID_GET_MEDIA)))
          .build();
    }
  }

  /**
   * <pre>
   **
   *The content library service returns streamable links for a given entitlement
   * </pre>
   */
  public static final class ContentStub extends io.grpc.stub.AbstractAsyncStub<ContentStub> {
    private ContentStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ContentStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentStub(channel, callOptions);
    }

    /**
     */
    public void getMedia(MediaRequest request,
                         io.grpc.stub.StreamObserver<MediaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMediaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   **
   *The content library service returns streamable links for a given entitlement
   * </pre>
   */
  public static final class ContentBlockingStub extends io.grpc.stub.AbstractBlockingStub<ContentBlockingStub> {
    private ContentBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ContentBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentBlockingStub(channel, callOptions);
    }

    /**
     */
    public MediaResponse getMedia(MediaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMediaMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   **
   *The content library service returns streamable links for a given entitlement
   * </pre>
   */
  public static final class ContentFutureStub extends io.grpc.stub.AbstractFutureStub<ContentFutureStub> {
    private ContentFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ContentFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MediaResponse> getMedia(
        MediaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMediaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MEDIA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ContentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ContentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MEDIA:
          serviceImpl.getMedia((MediaRequest) request,
              (io.grpc.stub.StreamObserver<MediaResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ContentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContentBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return MameViewer.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Content");
    }
  }

  private static final class ContentFileDescriptorSupplier
      extends ContentBaseDescriptorSupplier {
    ContentFileDescriptorSupplier() {}
  }

  private static final class ContentMethodDescriptorSupplier
      extends ContentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContentMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ContentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ContentFileDescriptorSupplier())
              .addMethod(getGetMediaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
