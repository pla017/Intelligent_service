FROM openjdk:8
MAINTAINER bingo
ADD ruoyi-admin.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xmx600m","-jar","app.jar"]