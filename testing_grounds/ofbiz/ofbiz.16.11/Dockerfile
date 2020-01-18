FROM centos:centos7

ADD . /ofbiz

RUN yum update -y
RUN yum install svn java-1.8.0-openjdk-devel -y

ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.232.b09-0.el7_7.x86_64
ENV PATH=$PATH:$JAVA_HOME/bin

# ENTRYPOINT cd ./ofbiz; ./gradlew ofbiz
