# Use a base image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy all application files into the container
COPY . .

# Compile the application (if necessary)
RUN javac *.java

# Specify the command to run your application
ENTRYPOINT ["java", "GUIT"]

# Expose any ports your application needs
EXPOSE 80
