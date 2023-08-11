FROM moxm/java:1.8-full

RUN mkdir -p /campus-imaotai

WORKDIR /campus-imaotai

ARG JAR_FILE=target/campus-modular*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8160

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone


ENTRYPOINT ["java","-jar","app.jar","--spring.profiles.active=prod","$JAVA_OPTS"]
