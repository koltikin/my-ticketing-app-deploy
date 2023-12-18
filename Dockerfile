FROM openjdk:17-jdk

COPY ./target/ticketing-app.jar /app/ticketing-app.jar

EXPOSE 8083

WORKDIR /app

CMD ["java","-jar","ticketing-app.jar"]
#ENTRYPOINT ["java","-jar","deploy-demo.jar"]