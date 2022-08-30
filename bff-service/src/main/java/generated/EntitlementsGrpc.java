package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 **
 *The entitlements service returns a list of content that the subscriber is entitled to view
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.48.1)",
    comments = "Source: MameViewer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EntitlementsGrpc {

  private EntitlementsGrpc() {}

  public static final String SERVICE_NAME = "mameviewer.Entitlements";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<EntitlementRequest,
          EntitlementResponse> getGetEntitlementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntitlements",
      requestType = EntitlementRequest.class,
      responseType = EntitlementResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<EntitlementRequest,
          EntitlementResponse> getGetEntitlementsMethod() {
    io.grpc.MethodDescriptor<EntitlementRequest, EntitlementResponse> getGetEntitlementsMethod;
    if ((getGetEntitlementsMethod = EntitlementsGrpc.getGetEntitlementsMethod) == null) {
      synchronized (EntitlementsGrpc.class) {
        if ((getGetEntitlementsMethod = EntitlementsGrpc.getGetEntitlementsMethod) == null) {
          EntitlementsGrpc.getGetEntitlementsMethod = getGetEntitlementsMethod =
              io.grpc.MethodDescriptor.<EntitlementRequest, EntitlementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntitlements"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EntitlementResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EntitlementsMethodDescriptorSupplier("GetEntitlements"))
              .build();
        }
      }
    }
    return getGetEntitlementsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EntitlementsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntitlementsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EntitlementsStub>() {
        @Override
        public EntitlementsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EntitlementsStub(channel, callOptions);
        }
      };
    return EntitlementsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EntitlementsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntitlementsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EntitlementsBlockingStub>() {
        @Override
        public EntitlementsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EntitlementsBlockingStub(channel, callOptions);
        }
      };
    return EntitlementsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EntitlementsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntitlementsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EntitlementsFutureStub>() {
        @Override
        public EntitlementsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EntitlementsFutureStub(channel, callOptions);
        }
      };
    return EntitlementsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   **
   *The entitlements service returns a list of content that the subscriber is entitled to view
   * </pre>
   */
  public static abstract class EntitlementsImplBase implements io.grpc.BindableService {

    /**
     */
    public void getEntitlements(EntitlementRequest request,
                                io.grpc.stub.StreamObserver<EntitlementResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEntitlementsMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetEntitlementsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      EntitlementRequest,
                      EntitlementResponse>(
                  this, METHODID_GET_ENTITLEMENTS)))
          .build();
    }
  }

  /**
   * <pre>
   **
   *The entitlements service returns a list of content that the subscriber is entitled to view
   * </pre>
   */
  public static final class EntitlementsStub extends io.grpc.stub.AbstractAsyncStub<EntitlementsStub> {
    private EntitlementsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected EntitlementsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntitlementsStub(channel, callOptions);
    }

    /**
     */
    public void getEntitlements(EntitlementRequest request,
                                io.grpc.stub.StreamObserver<EntitlementResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntitlementsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   **
   *The entitlements service returns a list of content that the subscriber is entitled to view
   * </pre>
   */
  public static final class EntitlementsBlockingStub extends io.grpc.stub.AbstractBlockingStub<EntitlementsBlockingStub> {
    private EntitlementsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected EntitlementsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntitlementsBlockingStub(channel, callOptions);
    }

    /**
     */
    public EntitlementResponse getEntitlements(EntitlementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntitlementsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   **
   *The entitlements service returns a list of content that the subscriber is entitled to view
   * </pre>
   */
  public static final class EntitlementsFutureStub extends io.grpc.stub.AbstractFutureStub<EntitlementsFutureStub> {
    private EntitlementsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected EntitlementsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntitlementsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EntitlementResponse> getEntitlements(
        EntitlementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntitlementsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ENTITLEMENTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EntitlementsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EntitlementsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ENTITLEMENTS:
          serviceImpl.getEntitlements((EntitlementRequest) request,
              (io.grpc.stub.StreamObserver<EntitlementResponse>) responseObserver);
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

  private static abstract class EntitlementsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EntitlementsBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return MameViewer.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Entitlements");
    }
  }

  private static final class EntitlementsFileDescriptorSupplier
      extends EntitlementsBaseDescriptorSupplier {
    EntitlementsFileDescriptorSupplier() {}
  }

  private static final class EntitlementsMethodDescriptorSupplier
      extends EntitlementsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EntitlementsMethodDescriptorSupplier(String methodName) {
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
      synchronized (EntitlementsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EntitlementsFileDescriptorSupplier())
              .addMethod(getGetEntitlementsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
