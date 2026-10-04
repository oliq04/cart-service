FROM ubuntu:latest
LABEL authors="oliwi"

ENTRYPOINT ["top", "-b"]