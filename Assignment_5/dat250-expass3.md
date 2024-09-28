# DAT250: Software Technology Experiment – Task 5

_By Carlos Fernández Calderón_

## MongoDB Configuration and Execution

### MongoDB Installation  
I successfully installed MongoDB 4.4 Community Edition, following the documented steps precisely. The validation of the installation package using the SHA-256 checksum was also completed without any complications.

**Screenshot 1: Package Validation Process**    
![Document Validation](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/ValidationScreenshot.png?raw=true)


### Experiment 1: CRUD Operations  
This experiment involved conducting basic CRUD (Create, Read, Update, Delete) actions within a MongoDB environment. Below is a breakdown of the operations executed, alongside their respective screenshots:

1. **Inserting Documents**
![Insert](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/1_Insert.png) 
The `insertMany()` function was used to add multiple documents into a MongoDB collection.  

**Screenshot: Documents Added**
![Insert_many](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/Insert_many.png)

The collection was then queried to confirm successful insertion:

**Screenshot: Query Collection**  
![Consulta_collecion](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/query.png)

2. **Retrieving Documents**  
To retrieve documents, I used the `find()` function.  

**Screenshot: Retrieved Documents**  
![find](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/find.png)

A compound query was performed to fetch all documents with a status of "A," and where the quantity was less than 30 or the item name began with the letter "p."

**Screenshot: Compound Query**  
![find_2](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/find_2.png)

3. **Updating Documents**  
For updates, I used the `updateOne()` function to alter specific documents in the collection.

**Screenshot: Insert and Update**  
![Insert_many_and_update1](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/Update_One.png)

Additionally, I used the `updateMany()` and `replaceOne()` functions to handle bulk updates and replacements.

**Screenshot: Update and Replace**  
![update_many_replace1](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/Update_Many.png)

4. **Deleting Documents**  
Document deletions were handled using the `deleteOne()` function for individual removals, followed by a batch deletion using `deleteMany()`.

**Screenshot: Insert and Delete**  
![Insert_many_delete_many](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/Delete_Many.png)

5. **Bulk Write Operations**  
Multiple write operations, including inserts, updates, deletions, and replacements, were efficiently executed using `bulkWrite()`.

**Screenshot: Bulk Write**  
![Insert_many_bulkwrite](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/BulkWrite.png)

### Experiment 2: Aggregation Using Map-Reduce  
The focus of this experiment was to explore the Map-Reduce aggregation mechanism in MongoDB. This process is valuable for summarizing and analyzing large datasets by applying map and reduce functions.

**Screenshot: Map-Reduce Example**  
![experimento2](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/Experiment_2_1.png)

**Screenshot: Map-Reduce Results**  
![Experiment2_result](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/Experiment_2_2.png)

### Advantages of Map-Reduce  
Map-Reduce provides an efficient way to handle and aggregate vast amounts of data by breaking down complex tasks into smaller, manageable operations. It enhances MongoDB’s ability to perform large-scale data analysis in a much more effective manner compared to executing individual queries.
