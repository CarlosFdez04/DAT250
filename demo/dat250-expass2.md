# Project Report: Poll App REST API Development
_By Carlos Fernández Calderón_

## Introduction
The purpose of this project is to implement a REST API for a Poll application using Spring Boot. The API supports basic CRUD (Create, Read, Update, Delete) operations for managing **Users**, **Polls**, **VoteOptions**, and **Votes**. Additionally, it handles serialization challenges due to association cycles in the domain model.

## Step-by-Step Progress

### Step 0: Setting Up an HTTP Client for Testing
- Installed and configured an HTTP client (such as Bruno, IntelliJ IDEA HTTP Client, VS Code REST Client, HTTPie, or curl) to test the REST API endpoints during development.
- Opted for **Bruno**, since it’s the easiest to start with.

### Step 1: Set Up Spring Project Repository
- Created a new repository on GitHub for the Spring Boot project.
    - Navigated to GitHub and created a public repository.
    - Initialized a local Git repository in the project's root folder.
    - Added all project files to the repository using `git add` and committed the changes.
    - Linked the local repository to the remote GitHub repository and pushed the initial commit.

### Step 2: Implement Domain Model
- Implemented the first draft of the domain model in Java based on the provided diagram. This includes creating Java Beans for the main entities: **User**, **Poll**, **VoteOption**, and **Vote**.
    - Added public getters and setters for each entity's properties and created a parameterless constructor.
    - Developed a `PollManager` class to manage domain objects in memory using a HashMap.
    - Annotated `PollManager` with `@Component` to enable dependency injection into controller classes.

### Step 3: Implement Test Scenarios
- Designed test scenarios to follow a Test-Driven Development (TDD) approach.
- Created a sequence of HTTP requests to test the API functionalities using the chosen HTTP client.
    - Example test scenarios include:
        1. Create a new user and verify its creation.
        2. List all users and ensure the new user is displayed.
        3. Add another user and confirm both users are listed.
        4. Create a new poll by the first user and check if it appears in the list.
        5. Have the second user vote on the poll, change the vote, and validate the correct votes are shown.
        6. Delete the poll and verify that the votes list is empty.

### Step 4: Implement Controllers
- Created controller classes annotated with `@RestController` for handling CRUD operations.
- Defined endpoints using `@GetMapping`, `@PostMapping`, `@PutMapping`, and `@DeleteMapping` annotations for each resource: **User**, **Poll**, **VoteOption**, and **Vote**.
- Developed logic for resource identification using appropriate URL paths (e.g., `/users/{id}`, `/polls/{id}`).
- Applied JSON serialization and deserialization strategies using annotations like `@JsonIgnore`, `@JsonIdentityInfo`, `@JsonManagedReference`, and `@JsonBackReference` to handle circular references and avoid buffer overflow errors during serialization.

## Challenges and Next Steps

### Challenges Faced:
- Handling association cycles in the domain model to prevent serialization issues.
- Designing appropriate paths and identifiers for different resources in the REST API.

### Next Steps:
- Review the domain model and aggregate design to optimize resource representation.
- Refine and test the API further by implementing additional scenarios and edge cases.
- Implement proper error handling and validation for all endpoints.
- Write documentation for the API, including endpoint descriptions and usage examples.
- Deploy the API to a test environment and conduct end-to-end testing.

## Conclusion
At this stage, a basic REST API for the Poll application has been developed, covering the foundational CRUD operations and initial test scenarios. The next steps involve refining the API, implementing comprehensive test cases, and addressing edge cases to ensure robust functionality. Progress was halted due to unfamiliarity with **Bruno** and other API testing tools, which presented challenges in fully testing the application.
