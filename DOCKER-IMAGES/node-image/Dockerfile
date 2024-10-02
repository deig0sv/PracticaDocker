FROM node:20.17.0-slim
RUN apt update
RUN apt install wget -y
RUN wget https://download.oracle.com/java/21/latest/jdk-21_linux-x64_bin.deb
RUN dpkg -i jdk-21_linux-x64_bin.deb
RUN apt remove wget -y
RUN rm jdk-21_linux-x64_bin.deb
RUN apt install maven -y


