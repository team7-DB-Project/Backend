FROM openjdk:17-oracle
COPY ./build/libs/GaBoZang-0.0.1-SNAPSHOT.jar GaBoZang.jar
ENTRYPOINT ["java", "-jar","-Xmx512M", "-Dspring.profiles.active=main","GaBoZang.jar"]