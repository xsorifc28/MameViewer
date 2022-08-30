start-sonarqube:
	docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest

analyze-subscriber-service:
	mvn clean verify sonar:sonar \
      -Dsonar.projectKey=MameViewer-subscriber \
      -Dsonar.host.url=http://localhost:9000 \
      -Dsonar.login=sqp_3624b791b4b0543dc8f77a6dae82fe1420ce0c6d

stop-subscriber-service:
	(docker stop mameviewer-subscriber-service || exit 0) || (docker rm mameviewer-subscriber-service || exit 0)

build-subscriber-service: stop-subscriber-service
	docker image rm mameviewer/subscriber-service:1.0.0 || exit 0
	docker build ./subscriber-service -f subscriber-service/Dockerfile -t mameviewer/subscriber-service:1.0.0

run-subscriber-service: build-subscriber-service
	docker rm mameviewer-subscriber-service || exit 0
	docker run -d --name mameviewer-subscriber-service -p 9090:9090 mameviewer/subscriber-service:1.0.0

stop-entitlements-service:
	(docker stop mameviewer-entitlements-service || exit 0) || (docker rm mameviewer-entitlements-service || exit 0)

build-entitlements-service: stop-entitlements-service
	docker image rm mameviewer/entitlements-service:1.0.0 || exit 0
	docker buildx build ./entitlements-service \
		--build-context proto=subscriber-service/src/main/proto \
		-f entitlements-service/Dockerfile \
		-t mameviewer/entitlements-service:1.0.0

run-entitlements-service: build-entitlements-service
	docker rm mameviewer-entitlements-service || exit 0
	docker run -d --name mameviewer-entitlements-service -p 9091:9091 mameviewer/entitlements-service:1.0.0

stop-content-service:
	(docker stop mameviewer-content-service || exit 0) || (docker rm mameviewer-content-service || exit 0)

build-content-service: stop-content-service
	docker image rm mameviewer/content-service:1.0.0 || exit 0
	docker build ./content-service \
		-f content-service/Dockerfile \
		-t mameviewer/content-service:1.0.0

run-content-service: build-content-service
	docker rm mameviewer-content-service || exit 0
	docker run -d --name mameviewer-content-service -p 9092:9092 mameviewer/content-service:1.0.0

run-all: run-subscriber-service run-entitlements-service run-content-service