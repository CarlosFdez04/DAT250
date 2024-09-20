# Project Report: Banking/Credit Card Domain Model Implementation
_Carlos Fernández Calderón_

## Introduction
The purpose of this project was to implement a banking/credit card domain model using the Java Persistence Architecture (JPA). This assignment aimed to explore object-relational mapping by creating entities such as `Customer`, `CreditCard`, `Bank`, `Address`, and `Pincode`, and persisting these objects in a database.

## Step-by-Step Progress

### Step 1: Setting Up the Project
- Forked the template project from GitHub and initialized the Java application with Gradle.
- Ensured that the application runs without errors by executing the `Main` class.

### Step 2: Implementing the Domain Model
- Created entity classes for the domain model based on the provided UML class diagram.
- Established bidirectional relationships between entities such as `Customer` and `Address`, and `Customer` and `CreditCard`.

### Step 3: Persisting Objects with JPA
- Implemented the `CreditCardsMain` class to handle the persistence of objects.
- Used `EntityManager` to manage transactions and persist instances of `Customer`, `CreditCard`, `Bank`, `Address`, and `Pincode`.

### Step 4: Testing the Implementation
- Developed unit tests in the `CreditCardsMainTest` class to ensure that the persistence operations work as expected.
- Verified that the tests run successfully without any modifications to the provided test case.

## Technical Problems Encountered

- **Database Configuration**: Configuring the in-memory H2 database required adjustments in the `persistence.xml` file to ensure proper connection settings.
- **Entity Relationships**: Understanding and correctly implementing the bidirectional relationships in JPA introduced some complexities, particularly with the `ManyToMany` annotations.
- **Inspecting the Database**: Using the H2 console to inspect the database schema and tables was initially confusing, but it became clearer after reviewing the H2 documentation.

## Link to Code
The code for this assignment can be found in the following repository:  

