FROM java:8

ENV JAR_FILE vertx-1.0-SNAPSHOT-fat.jar
ENV APP_HOME /usr/app
COPY target/$JAR_FILE $APP_HOME/
EXPOSE 8005

WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar $JAR_FILE" ]