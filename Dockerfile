# Use a Debian-based Maven image with OpenJDK
FROM maven:3.9.9-openjdk-21-slim

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml ./
COPY src ./src

# Build the application (this will create the JAR file)
RUN mvn clean package

# Copy the JAR file to the current directory
COPY target/*.jar app.jar

# Install Xvfb and necessary libraries for GUI support
RUN apt-get update && \
    apt-get install -y xvfb libxrender1 libxtst6 libxi6 && \
    apt-get clean

# Start Xvfb and run the application with DISPLAY set to use the virtual display
ENTRYPOINT ["sh", "-c", "Xvfb :99 -screen 0 1024x768x16 & DISPLAY=:99 java -jar app.jar"]

# Expose any ports your application needs (adjust as necessary)
EXPOSE 8081
