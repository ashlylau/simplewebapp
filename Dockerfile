FROM openjdk:11

WORKDIR /app

COPY target/bin ./target/bin
COPY target/repo ./target/repo

RUN apt-get update && apt-get install -y \
    pandoc \
    texlive-latex-base \
    texlive-fonts-recommended

ENV PORT 80
EXPOSE 80

CMD ["/bin/sh", "./target/bin/simplewebapp"]
