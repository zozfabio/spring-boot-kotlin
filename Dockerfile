FROM java:8
EXPOSE 8080
ADD ./target/sbkotlin.jar /var/sbkotlin.jar
CMD java -jar /var/sbkotlin.jar