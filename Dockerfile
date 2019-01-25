FROM openjdk:11

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN apt-get update
RUN apt-get install maven -y
RUN apt-get install pandoc -y
RUN apt-get install texlive-latex-base -y
RUN apt-get install texlive-fonts-recommended -y

RUN mvn package

ENV PORT 80
EXPOSE 80

CMD ["/bin/sh", "./target/bin/simplewebapp"]


