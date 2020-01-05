FROM centos:centos7

RUN yum update -y
RUN yum install svn java-1.8.0-openjdk-devel -y
RUN svn co http://svn.apache.org/repos/asf/ofbiz/branches/release16.11 ofbiz.16.11

ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.232.b09-0.el7_7.x86_64
ENV PATH=$PATH:$JAVA_HOME/bin

WORKDIR /ofbiz*

RUN ./gradlew cleanAll loadDefault ofbiz
