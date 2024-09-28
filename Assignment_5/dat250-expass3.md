# DAT250: Software Technology Experiment – Task 5  
## MongoDB Configuration and Execution

### MongoDB Installation  
I successfully installed MongoDB 4.4 Community Edition, following the documented steps precisely. The validation of the installation package using the SHA-256 checksum was also completed without any complications.

**Screenshot 1: Package Validation Process**    
![Document Validation](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/ValidationScreenshot.png?raw=true)


### Experiment 1: CRUD Operations  
This experiment involved conducting basic CRUD (Create, Read, Update, Delete) actions within a MongoDB environment. Below is a breakdown of the operations executed, alongside their respective screenshots:

1. **Inserting Documents**  
The `insertMany()` function was used to add multiple documents into a MongoDB collection.  

**Screenshot: Documents Added**  
![Insert_many](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment_5/Images/Insert_many.png)

The collection was then queried to confirm successful insertion:

**Screenshot: Query Collection**  
![Consulta_collecion]

2. **Retrieving Documents**  
To retrieve documents, I used the `find()` function.  

**Screenshot: Retrieved Documents**  
![Insert_many_2]

A compound query was performed to fetch all documents with a status of "A," and where the quantity was less than 30 or the item name began with the letter "p."

**Screenshot: Compound Query**  
![status_A_and_qty_less_than_($lt)_30_or_starts_p]

3. **Updating Documents**  
For updates, I used the `updateOne()` function to alter specific documents in the collection.

**Screenshot: Insert and Update**  
![Insert_many_and_update1]

Additionally, I used the `updateMany()` and `replaceOne()` functions to handle bulk updates and replacements.

**Screenshot: Update and Replace**  
![update_many_replace1]

4. **Deleting Documents**  
Document deletions were handled using the `deleteOne()` function for individual removals, followed by a batch deletion using `deleteMany()`.

**Screenshot: Insert and Delete**  
![Insert_many_delete_many]

5. **Bulk Write Operations**  
Multiple write operations, including inserts, updates, deletions, and replacements, were efficiently executed using `bulkWrite()`.

**Screenshot: Bulk Write**  
![Insert_many_bulkwrite]

### Experiment 2: Aggregation Using Map-Reduce  
The focus of this experiment was to explore the Map-Reduce aggregation mechanism in MongoDB. This process is valuable for summarizing and analyzing large datasets by applying map and reduce functions.

**Screenshot: Map-Reduce Example**  
![experimento2]

**Screenshot: Map-Reduce Results**  
![Experiment2_result]

### Advantages of Map-Reduce  
Map-Reduce provides an efficient way to handle and aggregate vast amounts of data by breaking down complex tasks into smaller, manageable operations. It enhances MongoDB’s ability to perform large-scale data analysis in a much more effective manner compared to executing individual queries.

### Remaining Issues  
There are no outstanding issues regarding this task. All operations were performed successfully without encountering any errors.
