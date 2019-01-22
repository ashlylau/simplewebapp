FROM openjdk:11

COPY . /src

RUN apt-get update
RUN apt-get install maven -y
# RUN apt-get install software-properties-common -y
# RUN add-apt-repository ppa:linuxuprising/java

CMD mvn package

ENV PORT 8080
EXPOSE 8080

CMD sh /target/bin/simplewebapp

