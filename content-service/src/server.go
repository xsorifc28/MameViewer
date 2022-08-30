package main

import (
	"content-service/generated"
	"context"
	"flag"
	"fmt"
	"github.com/google/uuid"
	"google.golang.org/grpc"
	"log"
	"net"
)

var (
	host = flag.String("host", "0.0.0.0", "The host")
	port = flag.Int("port", 9092, "The server port")
)

type contentServer struct {
	generated.UnimplementedContentServer
}

func (s *contentServer) GetMedia(_ context.Context, mediaRequest *generated.MediaRequest) (*generated.MediaResponse, error) {
	return &generated.MediaResponse{
		EntitlementId:  mediaRequest.EntitlementId,
		StreamableLink: fmt.Sprintf("https://mame-viewer.io/%s/%s.mp4", mediaRequest.EntitlementId, uuid.New().String()),
	}, nil
}

func newServer() *contentServer {
	s := &contentServer{}
	return s
}

func main() {
	flag.Parse()
	lis, err := net.Listen("tcp", fmt.Sprintf("%s:%d", *host, *port))
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	log.Printf("listening on port %d", *port)
	var opts []grpc.ServerOption
	grpcServer := grpc.NewServer(opts...)
	generated.RegisterContentServer(grpcServer, newServer())
	err = grpcServer.Serve(lis)
	if err != nil {
		log.Fatalf("listening on port %s", err.Error())
		return
	}
}
