# 使用官方Java 8镜像作为基础镜像
FROM openjdk:8-jdk

# 设置工作目录
WORKDIR /app
# 使用Maven构建项目
#RUN mvn package -DskipTests

# 将构建的jar包复制到当前目录
# 这里假设jar包在/app/target目录下，并且jar包的名称是app.jar
COPY target/lenosp.jar /app

EXPOSE 8088
# 指定容器启动时执行的命令
# 这里使用java命令运行jar包，你可以根据自己的需求调整
CMD ["java", "-jar", "lenosp.jar"]
