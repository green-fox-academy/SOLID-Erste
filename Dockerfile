FROM openjdk:11-jdk as build
ARG version='0.0.1-SNAPSHOT'
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME

COPY build.gradle gradlew settings.gradle $APP_HOME
COPY gradle gradle

RUN sh ./gradlew build -x bootJar -x test --continue

COPY src src

RUN sh ./gradlew -i -PprojVersion=$version build

FROM openjdk:11.0-jre-slim-buster
VOLUME /tmp
COPY --from=build /usr/app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]