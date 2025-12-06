# Bookmark Manager

A simple backend project to exercise the concepts of REST aplications, understanding how they communicate and how data traverses the layers of the API.

## Elements

As this is a simple project solely for the purpose of exercising and getting a visual panorama of the entire architecture, I planned to keep it simple. I'll use PostgreSQL as database, as I'm yet to interact with this tech, and Java's Springboot. I'll try and use Postman's tools as well.

## Steps
1. Decided that a useful bookmark should have a title, its URL and a category, to easily organise them. I always like checking when things were created, so I added a timestamp as well. This makes the SQL database creation:
```SQL
CREATE TABLE bookmark(
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    url TEXT NOT NULL,
    category VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
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
