FROM ubuntu:latest
LABEL authors="JRG"

ENTRYPOINT ["top", "-b"]