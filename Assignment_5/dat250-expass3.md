# Update the report content to include the actual image names based on the inspection

report_with_images = """
# DAT250: Software Technology Experiment - Task 6  
## Spring Boot REST API - Setup and Testing

### Project Setup and Installation  
The setup of the Spring Boot environment for the survey API was completed successfully. All required dependencies were included in the `pom.xml` file, and the project compiled without any issues. The application is running locally on port 8080.

![Screenshot 1: Application running on localhost:8080](Assignment_5/Screenshot_1.png)  
_Screenshot of the Spring Boot application startup log_

---

## Experiment 1: CRUD Operations for Polls  
In this experiment, I implemented the basic CRUD (Create, Read, Update, and Delete) operations for the survey API. Below are the key operations and their corresponding screenshots.

### 1. Create Polls  
This operation allows users to create new polls with associated vote options. The `POST /polls` endpoint was used for this.

**Example: Creating a new poll**  
![Screenshot: Postman - Poll Creation Request](Assignment_5/Screenshot_2.png)  
![Screenshot: Database - New Poll Entry](Assignment_5/Screenshot_2_1.png)

### 2. Query Polls  
The `GET /polls` endpoint retrieves all existing polls from the database. The `findAll()` method was used in the repository layer to fetch all polls.

**Example: Querying all polls**  
![Screenshot: Postman - Poll Query Response](Assignment_5/Screenshot_2_2.png)  
![Screenshot: Database - Poll Records](Assignment_5/Screenshot_2_3.png)

### 3. Update Polls  
The `PUT /polls/{id}` endpoint updates an existing poll. The `save()` method in the repository was used to persist the updated entity.

**Example: Updating a poll**  
![Screenshot: Postman - Poll Update Request](Assignment_5/Screenshot_2_4.png)  
![Screenshot: Database - Updated Poll Record](Assignment_5/Screenshot_2_5.png)

### 4. Delete Polls  
The `DELETE /polls/{id}` endpoint removes a poll from the database.

**Example: Deleting a poll**  
![Screenshot: Postman - Poll Deletion Request](Assignment_5/Screenshot_3.png)  
![Screenshot: Database - Poll Record Deleted](Assignment_5/Screenshot_3_1.png)

---

## Experiment 2: Voting Feature  
In this experiment, I tested the functionality of voting on polls using the `POST /polls/{id}/vote` endpoint. This feature allows users to vote for specific options within a poll.

### 1. Vote on Polls  
The `POST /polls/{id}/vote` endpoint was successfully tested, allowing votes to be registered.

![Screenshot: Postman - Voting Request](Assignment_5/Screenshot_3_2.png)  
![Screenshot: Database - Vote Record](Assignment_5/Screenshot_3_3.png)

### 2. Retrieve Poll Results  
The `GET /polls/{id}/results` endpoint returns the voting results for a specific poll.

![Screenshot: Postman - Poll Results](Assignment_5/Screenshot_3_4.png)  
![Screenshot: Database - Poll Results](Assignment_5/Screenshot_4.png)

---

## Pending Issues  
While the majority of the CRUD and voting operations were completed successfully, there are some areas that need further attention:  

- **User Authentication**: Currently, any user can create or vote on a poll without authentication. Adding user roles and authentication will be a future task.  
- **Error Handling**: More detailed error messages need to be implemented for invalid requests.

"""

# Save the updated report with image paths
updated_report_path = "/mnt/data/SpringBoot_REST_API_Report_with_Images.md"
with open(updated_report_path, "w") as file:
    file.write(report_with_images)

updated_report_path
