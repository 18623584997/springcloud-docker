FROM dahu/javaweb:0.1
MAINTAINER dahu "1855@163.com"
# 环境变量
ENV JAVA_HOME=/usr/local/jdk1.8.0_141
ENV ACLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/jre/lib/rt.jar
ENV PATH=$PATH:$JAVA_HOME/bin
ADD client-1.0-SNAPSHOT.jar /
ENTRYPOINT ["java", "-jar", "/client-1.0-SNAPSHOT.jar"]
EXPOSE 8761


