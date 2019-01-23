FROM openjdk:11

RUN mkdir /app
RUN mkdir /app/src

WORKDIR /app

COPY pom.xml /app
COPY src /app/src

RUN apt-get update
RUN apt-get install maven -y
RUN apt-get install pandoc -y
RUN apt-get install texlive-latex-base -y
RUN apt-get install texlive-fonts-recommended -y

RUN mvn package

ENV PORT 80
EXPOSE 80

CMD ["/bin/sh", "/app/target/bin/simplewebapp"]

