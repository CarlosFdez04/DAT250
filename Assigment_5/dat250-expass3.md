
# DAT250: Software Technology Experiment - Task 6  
## Spring Boot REST API - Setup and Testing

### Project Setup and Installation  
The setup of the Spring Boot environment for the survey API was completed successfully. All required dependencies were included in the `pom.xml` file, and the project compiled without any issues. The application is running locally on port 8080.

![Screenshot 1: Application running on localhost:8080](#)  
_Screenshot of the Spring Boot application startup log_

---

## Experiment 1: CRUD Operations for Polls  
In this experiment, I implemented the basic CRUD (Create, Read, Update, and Delete) operations for the survey API. Below are the key operations and their corresponding screenshots.

### 1. Create Polls  
This operation allows users to create new polls with associated vote options. The `POST /polls` endpoint was used for this.

**Example: Creating a new poll**  
![Screenshot: Postman - Poll Creation Request](#)  
![Screenshot: Database - New Poll Entry](#)

### 2. Query Polls  
The `GET /polls` endpoint retrieves all existing polls from the database. The `findAll()` method was used in the repository layer to fetch all polls.

**Example: Querying all polls**  
![Screenshot: Postman - Poll Query Response](#)  
![Screenshot: Database - Poll Records](#)

### 3. Update Polls  
The `PUT /polls/{id}` endpoint updates an existing poll. The `save()` method in the repository was used to persist the updated entity.

**Example: Updating a poll**  
![Screenshot: Postman - Poll Update Request](#)  
![Screenshot: Database - Updated Poll Record](#)

### 4. Delete Polls  
The `DELETE /polls/{id}` endpoint removes a poll from the database.

**Example: Deleting a poll**  
![Screenshot: Postman - Poll Deletion Request](#)  
![Screenshot: Database - Poll Record Deleted](#)

---

## Experiment 2: Voting Feature  
In this experiment, I tested the functionality of voting on polls using the `POST /polls/{id}/vote` endpoint. This feature allows users to vote for specific options within a poll.

### 1. Vote on Polls  
The `POST /polls/{id}/vote` endpoint was successfully tested, allowing votes to be registered.

![Screenshot: Postman - Voting Request](#)  
![Screenshot: Database - Vote Record](#)

### 2. Retrieve Poll Results  
The `GET /polls/{id}/results` endpoint returns the voting results for a specific poll.

![Screenshot: Postman - Poll Results](#)  
![Screenshot: Database - Poll Results](#)

---

## Pending Issues  
While the majority of the CRUD and voting operations were completed successfully, there are some areas that need further attention:  

- **User Authentication**: Currently, any user can create or vote on a poll without authentication. Adding user roles and authentication will be a future task.  
- **Error Handling**: More detailed error messages need to be implemented for invalid requests.
