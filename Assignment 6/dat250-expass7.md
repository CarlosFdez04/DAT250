# DAT250 - Experiment Report

## Experiment 1: Installation

For the installation of RabbitMQ, I followed the instructions outlined in the official RabbitMQ documentation. Below are the commands I used to set up RabbitMQ using Docker on my system:

```bash
sudo apt update
sudo apt install docker.io
sudo systemctl enable docker
sudo systemctl start docker
sudo docker --version
sudo docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management
```

### Technical Problems Encountered
- None during the installation process. The Docker installation and RabbitMQ setup went smoothly.

![Screenshot_1](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment%206/Experiment_1/Screenshot3_Experiment_1.png)
![Screenshot_2](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment%206/Experiment_1/Screenshot2_Experiment_1.png)
![Screenshot_3](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment%206/Experiment_1/Screenshot_Experiment_1.png)

### Repository for Experiments 1
You can find the screenshots of the experiment at the following link: [GitHub Repository](https://github.com/CarlosFdez04/DAT250/tree/main/Assignment%206/Experiment_1)

### Pending Issues
- No pending issues related to the installation of RabbitMQ.


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
