# Usa una imagen base de Ubuntu
FROM ubuntu:20.04

# Establecer variables de entorno para interactuar sin problemas
ENV DEBIAN_FRONTEND=noninteractive
ENV ANDROID_HOME=/opt/android-sdk
ENV PATH=${PATH}:${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools

# Actualiza los paquetes e instala las dependencias necesarias
RUN apt-get update && \
    apt-get install -y wget unzip curl openjdk-8-jdk

# Instala Gradle 8.2
RUN wget https://services.gradle.org/distributions/gradle-8.2-bin.zip -P /tmp && \
    unzip -d /opt/gradle /tmp/gradle-8.2-bin.zip && \
    ln -s /opt/gradle/gradle-8.2 /opt/gradle/latest && \
    ln -s /opt/gradle/latest/bin/gradle /usr/bin/gradle

# Descarga y configura Android SDK
# https://gist.github.com/Ashok-Varma/6b5864c1e444a3f1b61158254a43c4bc#install-sdk-tools
RUN mkdir -p ${ANDROID_HOME}/cmdline-tools && \
    cd ${ANDROID_HOME}/cmdline-tools && \
    wget https://dl.google.com/android/repository/sdk-tools-linux-3859397.zip -O commandlinetools.zip && \
    unzip commandlinetools.zip -d ${ANDROID_HOME}/cmdline-tools && \
    rm commandlinetools.zip && \
    mv ${ANDROID_HOME}/cmdline-tools/tools ${ANDROID_HOME}/cmdline-tools/latest

# Aceptar licencias de Android SDK
RUN yes | sdkmanager --licenses

# Instalar Android SDK 34
RUN sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0"

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto a la imagen
#COPY . .

# Comando por defecto para compilar la aplicación
#CMD ["gradle", "build"]
