FROM openjdk:17-jdk

COPY ./target/ticketing-app.jar /app/ticketing-app.jar
COPY ./target/classes/templates /app/src/main/resources/templates
COPY ./target/classes/static /app/src/main/resources/static
COPY ./target/classes/messages /app/src/main/resources/messages
COPY ./target/classes/db /app/src/main/resources/db
COPY ./target/classes/data.sql /app/src/main/resources/data.sql
COPY ./target/classes/application.properties /app/src/main/resources/application.properties

EXPOSE 8084

WORKDIR /app

CMD ["java","-jar","ticketing-app.jar"]
#ENTRYPOINT ["java","-jar","deploy-demo.jar"]