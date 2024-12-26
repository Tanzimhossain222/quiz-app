## Create table

```sql
CREATE TABLE question (
    id SERIAL PRIMARY KEY,
    question_title VARCHAR(255) NOT NULL,
    option1 VARCHAR(255) NOT NULL,
    option2 VARCHAR(255) NOT NULL,
    option3 VARCHAR(255) NOT NULL,
    option4 VARCHAR(255) NOT NULL,
    correct_answer VARCHAR(255) NOT NULL,
    difficulty_level VARCHAR(50),
    category VARCHAR(100)
);

```

## Insert Data
-- Insert Data

```sql

INSERT INTO question (question_title, option1, option2, option3, option4, correct_answer, difficulty_level, category)
VALUES 
('What does JVM stand for?', 'Java Virtual Machine', 'Java Version Manager', 'Java Variable Module', 'Java Visualization Model', 'Java Virtual Machine', 'Easy', 'Java'),
('Which company developed TypeScript?', 'Google', 'Microsoft', 'Facebook', 'Apple', 'Microsoft', 'Easy', 'TypeScript'),
('What is the time complexity of quicksort in the average case?', 'O(n)', 'O(n log n)', 'O(n^2)', 'O(log n)', 'O(n log n)', 'Medium', 'Algorithms'),
('Which data structure is FIFO?', 'Stack', 'Queue', 'Deque', 'Graph', 'Queue', 'Easy', 'Data Structures'),
('What is the default access modifier in Java?', 'Public', 'Private', 'Package-private', 'Protected', 'Package-private', 'Medium', 'Java'),
('Which keyword is used to inherit a class in Java?', 'extend', 'extends', 'inherit', 'inherits', 'extends', 'Easy', 'Java'),
('What is the time complexity of binary search?', 'O(n)', 'O(log n)', 'O(n^2)', 'O(1)', 'O(log n)', 'Easy', 'Algorithms'),
('Which programming language is known as the "language of the web"?', 'Python', 'JavaScript', 'C++', 'PHP', 'JavaScript', 'Easy', 'Programming Basics'),
('Which HTTP method is used to update data?', 'GET', 'POST', 'PUT', 'DELETE', 'PUT', 'Medium', 'Web Development'),
('Which design pattern is used to ensure a class has only one instance?', 'Factory', 'Singleton', 'Prototype', 'Adapter', 'Singleton', 'Hard', 'Design Patterns');
