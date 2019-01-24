FROM openjdk:11

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN apt-get update & apt-get install -y \
    maven \
    pandoc \
    texlive-latex-base \
    texlive-fonts-recommended

RUN mvn package

ENV PORT 80
EXPOSE 80

CMD ["/bin/sh", "./target/bin/simplewebapp"]


