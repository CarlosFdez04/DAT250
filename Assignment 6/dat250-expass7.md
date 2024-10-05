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

### Repository for Experiment 1
You can find the screenshots of the experiment at the following link: [Experiment 1](https://github.com/CarlosFdez04/DAT250/tree/main/Assignment%206/Experiment_1)

### Pending Issues
- No pending issues related to the installation of RabbitMQ.


## Experiment 2: Technical Problems Encountered

During the completion of Experiment 2, I encountered several technical problems:

1. **Dependency Resolution**: Initially, there were issues with resolving the RabbitMQ client dependency in Gradle. This was resolved by ensuring that the dependency was correctly defined in the `build.gradle.kts` file.

2. **Language Compatibility**: I faced compatibility issues when switching between Kotlin and Java. The Kotlin classes (`Recv.kt` and `Send.kt`) initially created caused some confusion. I had to rewrite them in Java to ensure compatibility with the rest of my project, which included Java-based code.

3. **Gradle Configuration**: I struggled with configuring the `build.gradle.kts` file correctly, particularly when it came to specifying dependencies and ensuring that the Kotlin JVM plugin was set up properly. 

4. **Testing Framework Setup**: Configuring the JUnit testing framework in Gradle posed challenges as well, especially regarding the version compatibility with the other dependencies.

## Code Repository for Experiment 2

You can find the code for Experiments 1-4 in the following repository link:
[Experiment 2](https://github.com/CarlosFdez04/DAT250/tree/main/Assignment%206/Experiment_2/Assignment_6)

# Experiment 3: Technical Problems Encountered

During the completion of Experiment 3, I encountered several technical problems:

1. **RabbitMQ Connection Issues**: I faced difficulties in establishing a connection to RabbitMQ due to incorrect host configurations. This was resolved by verifying the RabbitMQ server settings and ensuring that it was running properly.

2. **Dependency Conflicts**: There were conflicts between the versions of dependencies specified in the `build.gradle.kts` file, especially with the RabbitMQ client. I had to review and adjust the dependency versions to ensure compatibility with the Kotlin version being used.

3. **Gradle Build Failures**: The Gradle build failed multiple times due to incorrect configurations in the `build.gradle.kts` file. I had to carefully follow the documentation to set up the application plugin and specify the main class correctly.

4. **Code Migration Issues**: Transitioning code from Kotlin to Java led to syntax and structural problems, particularly with type declarations and method implementations. I needed to carefully review and modify the code to ensure it adhered to Java standards.

## Code Repository for Experiment 3

You can find the code for Experiments 1-4 in the following repository link:
[Experiment 3](https://github.com/CarlosFdez04/DAT250/tree/main/Assignment%206/Experiment_3/Assignment_6)


## Pending Issues

No pending issues

## Conclusion

These assignments helped me understand the installation and integration of messaging systems using RabbitMQ, as well as the challenges that can arise when dealing with different programming languages and build systems.
