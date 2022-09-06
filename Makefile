start-sonarqube:
	docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest

stop-sonarqube:
	(docker stop sonarqube || exit 0)

stop-subscriber-service:
	(docker stop mameviewer-subscriber-service || exit 0) && (docker rm mameviewer-subscriber-service || exit 0)

build-subscriber-service: stop-subscriber-service
	docker image rm mameviewer/subscriber-service:1.0.0 || exit 0
	docker buildx build ./subscriber-service \
		--build-context proto_source=proto \
		-f subscriber-service/Dockerfile \
		-t mameviewer/subscriber-service:1.0.0

run-subscriber-service: build-subscriber-service
	docker rm mameviewer-subscriber-service || exit 0
	docker run -d --name mameviewer-subscriber-service -p 9090:9090 mameviewer/subscriber-service:1.0.0

stop-entitlements-service:
	(docker stop mameviewer-entitlements-service || exit 0) && (docker rm mameviewer-entitlements-service || exit 0)

build-entitlements-service: stop-entitlements-service
	docker image rm mameviewer/entitlements-service:1.0.0 || exit 0
	docker buildx build ./entitlements-service \
		--build-context proto_source=proto \
		-f entitlements-service/Dockerfile \
		-t mameviewer/entitlements-service:1.0.0

run-entitlements-service: build-entitlements-service
	docker rm mameviewer-entitlements-service || exit 0
	docker run -d --name mameviewer-entitlements-service -p 9091:9091 mameviewer/entitlements-service:1.0.0

stop-content-service:
	(docker stop mameviewer-content-service || exit 0) && (docker rm mameviewer-content-service || exit 0)

build-content-service: stop-content-service
	docker image rm mameviewer/content-service:1.0.0 || exit 0
	docker build ./content-service \
		-f content-service/Dockerfile \
		-t mameviewer/content-service:1.0.0

run-content-service: build-content-service
	docker rm mameviewer-content-service || exit 0
	docker run -d --name mameviewer-content-service -p 9092:9092 mameviewer/content-service:1.0.0

stop-bff-service:
	(docker stop mameviewer-bff-service || exit 0) && (docker rm mameviewer-bff-service || exit 0)

build-bff-service: stop-bff-service
	docker image rm mameviewer/bff-service:1.0.0 || exit 0
	docker build ./bff-service \
		-f bff-service/Dockerfile \
		-t mameviewer/bff-service:1.0.0

run-bff-service: build-bff-service
	docker rm mameviewer-bff-service || exit 0
	docker run -d --name mameviewer-bff-service -p 8080:8080 mameviewer/bff-service:1.0.0

build-frontend-service: stop-frontend-service
	docker image rm mameviewer/frontend-service:1.0.0 || exit 0
	docker build ./frontend-service \
		-f frontend-service/Dockerfile \
		-t mameviewer/frontend-service:1.0.0

run-frontend-service: build-frontend-service
	docker rm mameviewer-frontend-service || exit 0
	docker run -d --name mameviewer-frontend-service -p 3000:3000 mameviewer/frontend-service:1.0.0

stop-frontend-service:
	(docker stop mameviewer-frontend-service || exit 0) && (docker rm mameviewer-frontend-service || exit 0)

run-all: run-subscriber-service run-entitlements-service run-content-service run-bff-service run-frontend-service

stop-all: stop-subscriber-service stop-entitlements-service stop-content-service stop-bff-service stop-frontend-service