# Bookmark Manager

A simple backend project to exercise the concepts of REST aplications, understanding how they communicate and how data traverses the layers of the API.

## Elements

As this is a simple project solely for the purpose of exercising and getting a visual panorama of the entire architecture, I planned to keep it simple. The base project was downloaded from https://start.spring.io/. Techs used:
 - Architecture: REST API
 - Java 21 + Maven
 - Springboot 3.5.6 (Spring Web, Spring Data JPA, Spring DevTools)
 - PostgreSQL + DBeaver
 - Postman

## API Endpoints
 - GET "/bookmarks" - Get all bookmarks
 - GET "/bookmarks/{category}" - Get all bookmarks under a specific category
 - POST "/bookmarks" - Create a new bookmark
 - PUT "/bookmarks/{id}" - Updates an existing bookmark
 - DELETE "/bookmarks/{id}" - Deletes an existing bookmark

An example of GET request returning a JSON:
```JSON
{
    "id": 1,
    "title": "Spring Boot Official Docs",
    "url": "https://spring.io/projects/spring-boot",
    "category": "Programming",
    "timeStamp": "2025-12-12T16:28:27.576+00:00"
}
```

## Points of interest
1. Decided that a useful bookmark should have a title, its URL and a category, to easily organise them. I always like checking when things were created, so I added a timestamp as well. This makes the SQL database creation:
```SQL
CREATE TABLE bookmark(
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    url TEXT NOT NULL,
    category VARCHAR(50) NOT NULL,
    timeStamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
And then populated the database with some inserts:
```SQL
INSERT INTO bookmark (title, url, category) VALUES
('Spring Boot Official Docs', 'https://spring.io/projects/spring-boot', 'Programming'),
('PostgreSQL Documentation', 'https://www.postgresql.org/docs/', 'Database'),
('JUnit 5 User Guide', 'https://junit.org/junit5/docs/current/user-guide/', 'Testing'),
('REST API Tutorial', 'https://restfulapi.net/', 'Web Development'),
('GitHub', 'https://github.com', 'Tools');
```

2. Service will use the repository methods extended from the JPA Repository. Is interesting to point that Springboot will help you with custom methods, for instance this method where I want to filter the search by Category:
```Java
List<Bookmark> findByCategory(String category);
```
Springboot will understand the structure 'findBy + PropertyName + Operator' and setup the method.

3. By using the @RestController annotation instead of only @Controller annotation in the Controller package, Springboot will add @ResponseBody to all the methods. This annotation will tell Spring to convert objects to JSON.

4. Had an error when trying to Post a JSON, this happened because I did not use the @GeneratedValue in the ID variable in the Entity class, unabling the auto creation of an ID for a new DB registry. Annotation added and lesson learned.

## How to Run
1. Clone the repository
2. Set up PostgreSQL database named `bookmarks`
3. Run the SQL from point 1 to create table
4. Update `application.properties` with your database information
5. Run `BookmarksApplication.java`
6. Access API at `http://localhost:8080/bookmarks`
