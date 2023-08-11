FROM nginx

COPY ./dist /usr/share/nginx/html

RUN rm /etc/nginx/conf.d/default.conf

ADD nginx.conf /etc/nginx/conf.d/default.conf

ENV TZ=Asia/Shanghai

RUN /bin/bash -c 'echo init ok'
