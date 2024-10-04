
# DAT250 - Experiment 1 & 2 Report

## Experiment 1: Installation

For the first experiment, I followed the installation instructions for RabbitMQ as detailed in the official documentation [RabbitMQ Installation Guide](https://www.rabbitmq.com/download.html). I opted for the **Docker installation**, which provided a convenient and isolated environment for testing RabbitMQ functionalities.

### Steps Taken for Installation:

1. **Installed Docker**: I ensured that Docker was installed on my machine by following the Docker installation instructions for my operating system.

2. **Pulled RabbitMQ Image**: I pulled the official RabbitMQ Docker image using the following command:
   ```bash
   docker pull rabbitmq:management
   ```

3. **Started RabbitMQ Server**: I started the RabbitMQ server with the management plugin enabled using the command:
   ```bash
   docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
   ```

4. **Accessed Management UI**: I accessed the RabbitMQ management interface by navigating to `http://localhost:15672` in my web browser. I logged in using the default username and password (`guest` / `guest`).

5. **Verification**: I verified the installation by checking the default exchanges and queues provided by RabbitMQ.

### Technical Problems Encountered

1. **Docker Configuration**: Initially, I faced issues with Docker not starting properly. I resolved this by ensuring that my Docker installation was up to date and that my system met the requirements for running Docker.

2. **Network Configuration**: There were issues with accessing the RabbitMQ management UI. This was solved by correctly mapping the ports in the Docker run command.

## Experiment 2: Technical Problems Encountered

During the completion of Experiment 2, I encountered several technical problems:

1. **Dependency Resolution**: Initially, there were issues with resolving the RabbitMQ client dependency in Gradle. This was resolved by ensuring that the dependency was correctly defined in the `build.gradle.kts` file.

2. **Language Compatibility**: I faced compatibility issues when switching between Kotlin and Java. The Kotlin classes (`Recv.kt` and `Send.kt`) initially created caused some confusion. I had to rewrite them in Java to ensure compatibility with the rest of my project, which included Java-based code.

3. **Gradle Configuration**: I struggled with configuring the `build.gradle.kts` file correctly, particularly when it came to specifying dependencies and ensuring that the Kotlin JVM plugin was set up properly. 

4. **Testing Framework Setup**: Configuring the JUnit testing framework in Gradle posed challenges as well, especially regarding the version compatibility with the other dependencies.

## Code Repository

You can find the code for Experiments 1-4 in the following repository link:
[Link to Your Code Repository](URL_OF_YOUR_REPOSITORY)

## Pending Issues

There are a couple of pending issues that I could not resolve during this assignment:

1. **Error Handling**: I still need to implement proper error handling in both the `Send` and `Recv` classes to manage potential exceptions during message sending and receiving.

2. **Documentation**: Further documentation is needed for the code to make it clearer for future users or for anyone reviewing the project.

3. **Unit Tests**: I have not yet completed the unit tests for the `Send` and `Recv` classes, which is crucial for validating their functionality.

## Conclusion

These assignments helped me understand the installation and integration of messaging systems using RabbitMQ, as well as the challenges that can arise when dealing with different programming languages and build systems.
