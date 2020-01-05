FROM centos:centos7

COPY . opt/src

RUN yum update -y
RUN yum install sudo -y
RUN sudo yum install java-1.8.0-openjdk-devel wget unzip vim -y
RUN wget https://services.gradle.org/distributions/gradle-6.0.1-bin.zip -P /tmp
RUN sudo unzip -d /opt/src/gradle /tmp/gradle-6.0.1-bin.zip
RUN echo "export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.232.b09-0.el7_7.x86_64" >> etc/profile.d/envars.sh
RUN echo "export GRADLE_HOME=/opt/src/gradle/gradle-6.0.1" >> etc/profile.d/envars.sh
RUN source /etc/profile.d/envars.sh
RUN echo "export PATH=${PATH}:${GRADLE_HOME}/bin:${JAVA_HOME}/bin" >> etc/profile.d/envars.sh
RUN sudo chmod +x /etc/profile.d/envars.sh
RUN source /etc/profile.d/envars.sh
