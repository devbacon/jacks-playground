FROM centos:centos7

COPY . opt/src

RUN yum update -y
RUN yum install sudo -y
RUN sudo yum install java-1.8.0-openjdk-devel wget unzip vim -y
RUN wget https://services.gradle.org/distributions/gradle-6.0.1-bin.zip -P /tmp
RUN sudo unzip -d /opt/src/gradle /tmp/gradle-6.0.1-bin.zip

ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.232.b09-0.el7_7.x86_64
ENV GRADLE_HOME=/opt/src/gradle/gradle-6.0.1
ENV PATH=$PATH:$JAVA_HOME/bin:$GRADLE_HOME/bin

WORKDIR /opt/src

RUN gradle wrapper --gradle-version 6.0.1
RUN ./gradlew cleanAll loadDefault
