FROM openjdk:17-jdk-slim

LABEL NAME="DIANA MEDIAVILLA"
LABEL MATERIA="DISTRIBUIDA"

COPY ./build/install/trabajo01/lib/trabajo01-1.0-SNAPSHOT.jar ./
COPY ./build/install/trabajo01/lib ./lib

CMD ["java", "-cp", "trabajo01-1.0-SNAPSHOT.jar:./lib/*", "com.distribuida.Servidor"]

EXPOSE 7001