# Exercise Progression Tracker

This Java Spring Boot application allows users to track their exercise progressions. Users can add exercises, update their current level, add progressions to exercises, and track their progress over time.

## Features

- **Add New Exercise**: Users can add a new exercise with a name and current level.
- **View All Exercises**: Users can view a list of all exercises.
- **View Exercise by ID**: Users can view details of a specific exercise by providing its ID.
- **Update Exercise**: Users can update an exercise's details, such as its name or current level.
- **Delete Exercise**: Users can delete an exercise by providing its ID.
- **Increase Exercise Level**: Users can increase an exercise's current level.
- **Add Progression**: Users can add a new progression to an exercise.
- **View All Progressions for an Exercise**: Users can view all progressions for a specific exercise.
- **View Current Progression for an Exercise**: Users can view the current progression for a specific exercise.
- **Update Progression**: Users can update a progression's details.
- **Delete Progression**: Users can delete a progression.

## Usage

1. Clone the repository:
   ```sh
   git clone https://github.com/hergottwilliam/progressions.git
2. Create a MySQL database and update the application.properties file to configure the database connection
3. Navigate to the repository:
   ```sh
   cd progressions
4. Build the project with maven:
   ```sh
   mvn clean install
5. Run the application
   ```sh
   mvn spring-boot:run
6. Utilize the API endpoints to create, read, update, or delete data (port 8080).

## Dependencies

This project has the following dependencies:

- **Spring Boot Starter Data JPA**: Provides a Spring Data JPA with Hibernate implementation.
- **Spring Boot Starter Web**: Provides a web development support, including RESTful applications.
- **MySQL Connector/J**: MySQL JDBC driver for connecting to MySQL databases.
- **Spring Boot Starter Test**: Provides testing support for Spring Boot applications.

