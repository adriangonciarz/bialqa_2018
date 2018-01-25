FROM node:9.4.0

RUN npm install -g json-server
WORKDIR /opt

ADD entrypoint.sh /opt/entrypoint.sh
CMD ./entrypoint.sh