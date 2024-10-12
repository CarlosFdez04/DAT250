# DAT250 - Experiment Report

## Experiment 1: Docker and PostgreSQL

### Installation of Docker and PostgreSQL
To familiarize myself with Docker, I ensured that Docker was installed on my system. I verified the installation and the operational status of Docker using the command:

```bash
docker system info
```

After confirming Docker was running without errors, I proceeded to work with PostgreSQL.

### Using a Dockerized Application: PostgreSQL
To set up PostgreSQL, I pulled the official PostgreSQL Docker image from Docker Hub using the following command:

```bash
docker pull postgres
```

Next, I ran the PostgreSQL container, configuring the necessary port exposure and environment variables:

```bash
docker run -p 5432:5432 \
 -e POSTGRES_USER=jpa_client \
 -e POSTGRES_PASSWORD=secret \
 -d --name my-postgres --rm postgres
```

After starting the container, I checked its status with:

```bash
docker ps
```

I also inspected the startup logs to ensure everything was functioning correctly:

```bash
docker logs my-postgres
```

Once confirmed, I connected to the PostgreSQL database using my preferred SQL client, DBeaver, with the credentials defined in the environment variables.

### Creating a New User
After successfully logging in, I executed the following command to create a new user for my JPA client:

```sql
CREATE USER jpa_client WITH PASSWORD 'secret';
```

### Modifying the Java Project
I updated my Java project to transition from the embedded H2 database to PostgreSQL. This included adding the PostgreSQL JDBC driver dependency to the `build.gradle.kts` file:

```kotlin
implementation("org.postgresql:postgresql:42.7.4")
```

### Original `persistence.xml` File
Here’s the original `persistence.xml` file before modifications:

![Original persistence.xml](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment%206/Experiment_1/original_persistence.xml.png)

### Modified `persistence.xml` File
After modifying the file for PostgreSQL, it looks like this:

![Modified persistence.xml](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment%206/Experiment_1/modified_persistence.xml.png)

I modified the `persistence.xml` file to change the connection parameters from H2 to PostgreSQL:

```xml
<property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
<property name="hibernate.connection.driver_class" value="org.postgresql.Driver"/>
<property name="hibernate.connection.url" value="jdbc:postgresql://127.0.0.1:5432/postgres"/>
<property name="hibernate.connection.username" value="jpa_client"/>
<property name="hibernate.connection.password" value="secret"/>
```

### Running Unit Tests
I attempted to run my Unit tests; however, they failed due to the absence of the expected tables in the new PostgreSQL database. Here’s a screenshot of the project execution when it didn’t work:

![Execution Failed](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment%206/Experiment_1/execution_failed.png)

To resolve this, I considered enabling automatic schema generation by adding the following lines to `persistence.xml`:

```xml
<property name="jakarta.persistence.schema-generation.scripts.action" value="drop-and-create"/>
<property name="jakarta.persistence.schema-generation.scripts.create-target" value="schema.up.sql"/>
<property name="jakarta.persistence.schema-generation.scripts.drop-target" value="schema.down.sql"/>
```

This configuration generated `schema.up.sql` and `schema.down.sql`, containing the necessary `CREATE TABLE` statements.

### Applying Migrations
I could apply the generated SQL statements manually via a SQL client or use the `/docker-entrypoint-initdb.d/` directory to initialize the database during startup.

After making the necessary adjustments and running the project again, it worked successfully:

![Execution Successful](https://github.com/CarlosFdez04/DAT250/blob/main/Assignment%206/Experiment_1/execution_successful.png)

### Technical Problems Encountered
- **Database Connection Errors**: Encountered difficulties connecting to PostgreSQL due to incorrect parameters in `persistence.xml`.
- **Schema Generation Issues**: Faced errors related to missing tables expected by JPA, requiring adjustments to the schema generation settings.
