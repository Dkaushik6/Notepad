# Use a base image with OpenJDK
FROM openjdk:21-jdk-slim

# Install Maven, necessary libraries, VNC server, and desktop environment
RUN apt-get update && \
    apt-get install -y maven xvfb libxrender1 libxtst6 libxi6 procps xfce4 xfce4-goodies tightvncserver dbus-x11 x11-xserver-utils && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/GUI-0.0.1-SNAPSHOT.jar .

# Set the VNC password (you can change this to a different password if you like)
RUN mkdir -p /root/.vnc && \
    echo "password" | vncpasswd -f > /root/.vnc/passwd && \
    chmod 600 /root/.vnc/passwd

# Start VNC server and then run the application
ENTRYPOINT ["/bin/bash", "-c", "vncserver :1 -geometry 1024x768 -depth 16 && export DISPLAY=:1 && java -jar GUI-0.0.1-SNAPSHOT.jar"]

# Expose the VNC port (5901 for display :1) and any other application ports (like 8081)
EXPOSE 5901 8081
