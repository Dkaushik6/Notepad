# Use a base image with OpenJDK
FROM openjdk:21-jdk-slim

# Install Maven, necessary libraries, and procps
RUN apt-get update && \
    apt-get install -y maven xvfb libxrender1 libxtst6 libxi6 procps && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml ./
COPY src ./src

# Build the application (this will create the JAR file)
RUN mvn clean package

# Debugging step: list files in the target directory
RUN ls -l target/

# Copy the JAR file to the current directory
COPY target/*.jar app.jar

# Start Xvfb and run the application with DISPLAY set to use the virtual display
ENTRYPOINT ["sh", "-c", "Xvfb :99 -screen 0 1024x768x16 & sleep 2; DISPLAY=:99 java -jar app.jar"]

# Expose any ports your application needs (adjust as necessary)
EXPOSE 8081
