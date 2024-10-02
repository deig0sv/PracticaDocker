# Usa una imagen base de Ubuntu
FROM ubuntu:20.04

# Establecer variables de entorno para interactuar sin problemas
ENV DEBIAN_FRONTEND=noninteractive

# Actualiza los paquetes y luego instala las dependencias necesarias
RUN apt-get update && \
    apt-get install -y curl software-properties-common build-essential zlib1g-dev libffi-dev libssl-dev

# Descargar y compilar Python 2.7.15 desde el código fuente
RUN curl -O https://www.python.org/ftp/python/2.7.15/Python-2.7.15.tgz && \
    tar -xvf Python-2.7.15.tgz && \
    cd Python-2.7.15 && \
    ./configure --enable-optimizations && \
    make altinstall && \
    ln -s /usr/local/bin/python2.7 /usr/bin/python && \
    cd .. && \
    rm -rf Python-2.7.15 Python-2.7.15.tgz

# Instala Node.js 18.19.1
RUN curl -fsSL https://deb.nodesource.com/setup_18.x | bash - && \
    apt-get install -y nodejs=18.19.1-1nodesource1

# Actualizar npm e instalar Ionic 6.17.1
RUN npm install -g npm@10.8.1 \
	&& npm install -g @ionic/cli@6.17.1

# Establece el directorio de trabajo
WORKDIR /usr
