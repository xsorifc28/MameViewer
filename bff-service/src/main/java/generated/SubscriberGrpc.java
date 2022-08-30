package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 **
 *The subscriber service can create new users (subscriptions) and retrieve them
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.48.1)",
    comments = "Source: MameViewer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SubscriberGrpc {

  private SubscriberGrpc() {}

  public static final String SERVICE_NAME = "mameviewer.Subscriber";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CreateSubscriberRequest,
          CreateSubscriberResponse> getCreateSubscriberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubscriber",
      requestType = CreateSubscriberRequest.class,
      responseType = CreateSubscriberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CreateSubscriberRequest,
          CreateSubscriberResponse> getCreateSubscriberMethod() {
    io.grpc.MethodDescriptor<CreateSubscriberRequest, CreateSubscriberResponse> getCreateSubscriberMethod;
    if ((getCreateSubscriberMethod = SubscriberGrpc.getCreateSubscriberMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getCreateSubscriberMethod = SubscriberGrpc.getCreateSubscriberMethod) == null) {
          SubscriberGrpc.getCreateSubscriberMethod = getCreateSubscriberMethod =
              io.grpc.MethodDescriptor.<CreateSubscriberRequest, CreateSubscriberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSubscriber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateSubscriberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateSubscriberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("CreateSubscriber"))
              .build();
        }
      }
    }
    return getCreateSubscriberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetSubscriberRequest,
          GetSubscriberResponse> getGetSubscriberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubscriber",
      requestType = GetSubscriberRequest.class,
      responseType = GetSubscriberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetSubscriberRequest,
          GetSubscriberResponse> getGetSubscriberMethod() {
    io.grpc.MethodDescriptor<GetSubscriberRequest, GetSubscriberResponse> getGetSubscriberMethod;
    if ((getGetSubscriberMethod = SubscriberGrpc.getGetSubscriberMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getGetSubscriberMethod = SubscriberGrpc.getGetSubscriberMethod) == null) {
          SubscriberGrpc.getGetSubscriberMethod = getGetSubscriberMethod =
              io.grpc.MethodDescriptor.<GetSubscriberRequest, GetSubscriberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSubscriber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetSubscriberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetSubscriberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("GetSubscriber"))
              .build();
        }
      }
    }
    return getGetSubscriberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SubscriberStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriberStub>() {
        @Override
        public SubscriberStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriberStub(channel, callOptions);
        }
      };
    return SubscriberStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubscriberBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriberBlockingStub>() {
        @Override
        public SubscriberBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriberBlockingStub(channel, callOptions);
        }
      };
    return SubscriberBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SubscriberFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriberFutureStub>() {
        @Override
        public SubscriberFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriberFutureStub(channel, callOptions);
        }
      };
    return SubscriberFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   **
   *The subscriber service can create new users (subscriptions) and retrieve them
   * </pre>
   */
  public static abstract class SubscriberImplBase implements io.grpc.BindableService {

    /**
     */
    public void createSubscriber(CreateSubscriberRequest request,
                                 io.grpc.stub.StreamObserver<CreateSubscriberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSubscriberMethod(), responseObserver);
    }

    /**
     */
    public void getSubscriber(GetSubscriberRequest request,
                              io.grpc.stub.StreamObserver<GetSubscriberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSubscriberMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSubscriberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      CreateSubscriberRequest,
                      CreateSubscriberResponse>(
                  this, METHODID_CREATE_SUBSCRIBER)))
          .addMethod(
            getGetSubscriberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      GetSubscriberRequest,
                      GetSubscriberResponse>(
                  this, METHODID_GET_SUBSCRIBER)))
          .build();
    }
  }

  /**
   * <pre>
   **
   *The subscriber service can create new users (subscriptions) and retrieve them
   * </pre>
   */
  public static final class SubscriberStub extends io.grpc.stub.AbstractAsyncStub<SubscriberStub> {
    private SubscriberStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SubscriberStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberStub(channel, callOptions);
    }

    /**
     */
    public void createSubscriber(CreateSubscriberRequest request,
                                 io.grpc.stub.StreamObserver<CreateSubscriberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubscriberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSubscriber(GetSubscriberRequest request,
                              io.grpc.stub.StreamObserver<GetSubscriberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSubscriberMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   **
   *The subscriber service can create new users (subscriptions) and retrieve them
   * </pre>
   */
  public static final class SubscriberBlockingStub extends io.grpc.stub.AbstractBlockingStub<SubscriberBlockingStub> {
    private SubscriberBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SubscriberBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberBlockingStub(channel, callOptions);
    }

    /**
     */
    public CreateSubscriberResponse createSubscriber(CreateSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubscriberMethod(), getCallOptions(), request);
    }

    /**
     */
    public GetSubscriberResponse getSubscriber(GetSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubscriberMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   **
   *The subscriber service can create new users (subscriptions) and retrieve them
   * </pre>
   */
  public static final class SubscriberFutureStub extends io.grpc.stub.AbstractFutureStub<SubscriberFutureStub> {
    private SubscriberFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SubscriberFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CreateSubscriberResponse> createSubscriber(
        CreateSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubscriberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetSubscriberResponse> getSubscriber(
        GetSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSubscriberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SUBSCRIBER = 0;
  private static final int METHODID_GET_SUBSCRIBER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SubscriberImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SubscriberImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SUBSCRIBER:
          serviceImpl.createSubscriber((CreateSubscriberRequest) request,
              (io.grpc.stub.StreamObserver<CreateSubscriberResponse>) responseObserver);
          break;
        case METHODID_GET_SUBSCRIBER:
          serviceImpl.getSubscriber((GetSubscriberRequest) request,
              (io.grpc.stub.StreamObserver<GetSubscriberResponse>) responseObserver);
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

  private static abstract class SubscriberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubscriberBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return MameViewer.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Subscriber");
    }
  }

  private static final class SubscriberFileDescriptorSupplier
      extends SubscriberBaseDescriptorSupplier {
    SubscriberFileDescriptorSupplier() {}
  }

  private static final class SubscriberMethodDescriptorSupplier
      extends SubscriberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SubscriberMethodDescriptorSupplier(String methodName) {
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
      synchronized (SubscriberGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SubscriberFileDescriptorSupplier())
              .addMethod(getCreateSubscriberMethod())
              .addMethod(getGetSubscriberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
