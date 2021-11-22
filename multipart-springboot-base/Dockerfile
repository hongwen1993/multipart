FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
COPY target/*.jar app.jar

#设置alpine系统时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone

EXPOSE 8012
ENTRYPOINT [ "java", "-jar", "/app.jar" ]