CREATE TABLE bookmark(
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    url TEXT NOT NULL,
    category VARCHAR(50) NOT NULL,
    timeStamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO bookmark (title, url, category) VALUES
('Spring Boot Official Docs', 'https://spring.io/projects/spring-boot', 'Programming'),
('PostgreSQL Documentation', 'https://www.postgresql.org/docs/', 'Database'),
('JUnit 5 User Guide', 'https://junit.org/junit5/docs/current/user-guide/', 'Testing'),
('REST API Tutorial', 'https://restfulapi.net/', 'Web Development'),
('GitHub', 'https://github.com', 'Tools');
