-- Create a new database named Employeedb_springdatajpa

USE springdatajpademo;

CREATE TABLE Department (
    dept_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dept_name VARCHAR(255) NOT NULL
);

CREATE TABLE Employee (
    emp_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(255) NOT NULL,
    dob DATE,
    dept_id BIGINT,
    FOREIGN KEY (dept_id) REFERENCES Department(dept_id)
);


-- Insert some data into Department table
INSERT INTO Department (dept_name) VALUES ('Sales');
INSERT INTO Department (dept_name) VALUES ('Marketing');
INSERT INTO Department (dept_name) VALUES ('HR');
INSERT INTO Department (dept_name) VALUES ('IT');


-- Insert some data into Employee table
INSERT INTO Employee (emp_name, dob, dept_id) VALUES ('John Doe', '1990-05-15', 1);
INSERT INTO Employee (emp_name, dob, dept_id) VALUES ('Jane Doe', '1992-11-20', 2);
INSERT INTO Employee (emp_name, dob, dept_id) VALUES ('Alice', '1992-03-03', 3);
INSERT INTO Employee (emp_name, dob, dept_id) VALUES ('Bob', '1993-04-04', 4);
