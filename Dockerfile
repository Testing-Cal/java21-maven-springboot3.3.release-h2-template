FROM amazoncorretto:21-alpine
ENV context ""
ENV port 8288
RUN addgroup -S lazsa -g 1000 && adduser -S lazsa -u 1000 -G lazsa -s /bin/sh && mkdir /src  && mkdir /temp && chown -R lazsa:lazsa /src
USER lazsa

ADD /src/main/resources/application.properties //
ADD /target/demo-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java","-jar", "/demo-0.0.1-SNAPSHOT.jar", "--server.servlet.context-path=${context}","--server.port=${port}"]
