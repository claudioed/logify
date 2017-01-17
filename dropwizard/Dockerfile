FROM java:8

ENV JAR_FILE dropwizard-1.0-SNAPSHOT-fat.jar
ENV APP_HOME /usr/app
COPY target/$JAR_FILE $APP_HOME/
EXPOSE 8081

WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar $JAR_FILE server" ]