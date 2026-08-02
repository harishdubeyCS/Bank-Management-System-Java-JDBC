# Bank Management System (Java + JDBC + MySQL)

A console-based **Bank Management System** built using **Core Java, JDBC, and MySQL**. This project demonstrates the implementation of **OOP concepts**, **JDBC database connectivity**, and **CRUD (Create, Read, Update, Delete)** operations through a menu-driven console application.

## Features

* Create a new bank account
* View all accounts
* Deposit money
* Withdraw money
* Check account balance
* Delete an account
* Account existence validation before operations

## Technologies Used

* Java
* JDBC
* MySQL
* IntelliJ IDEA / Eclipse

## OOP Concepts Used

* Classes and Objects
* Encapsulation
* Constructors
* Method Calling
* Exception Classes
* Separation of Concerns (Main, Bank, Account, DBConnection)

## Project Structure

```
BankManagementSystem/
└── src/
    ├── Account.java
    ├── Bank.java
    ├── DBConnection.java
    ├── Main.java
    ├── InvalidAmountException.java
    ├── InsufficientBalanceException.java
    └── AccountNotFoundException.java
```

## Database Setup

Create the database:

```sql
CREATE DATABASE bankdb;
USE bankdb;
```

Create the accounts table:

```sql
CREATE TABLE accounts (
    account_number INT PRIMARY KEY,
    account_holder_name VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL
);
```

Update your database credentials in `DBConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
private static final String USERNAME = "root";
private static final String PASSWORD = "your_password";
```

## Database Structure

### Database: `bankdb`

### Table: `accounts`

| Column Name         | Data Type    | Constraint  |
| ------------------- | ------------ | ----------- |
| account_number      | INT          | PRIMARY KEY |
| account_holder_name | VARCHAR(100) | NOT NULL    |
| balance             | DOUBLE       | NOT NULL    |

## Menu

```text
===== Bank Management System =====
1. Create Account
2. View All Accounts
3. Deposit In Account
4. Withdraw From Account
5. Check Account Balance
6. Delete Account
7. Exit
```

## CRUD Operations

### Create

Inserts a new account into the database.

### Read

Displays all accounts using:

```sql
SELECT * FROM accounts;
```

### Update

Deposit:

```sql
UPDATE accounts
SET balance = balance + amount
WHERE account_number = ?;
```

Withdraw:

```sql
UPDATE accounts
SET balance = balance - amount
WHERE account_number = ?;
```

### Delete

Deletes an account from the database.

```sql
DELETE FROM accounts
WHERE account_number = ?;
```

## JDBC Concepts Covered

* Database Connection
* Statement
* executeUpdate()
* executeQuery()
* ResultSet
* try-catch-finally
* Closing JDBC resources

## Current Limitations

* Uses `Statement` instead of `PreparedStatement`
* Basic input validation
* No transaction management
* Withdraw does not validate insufficient balance from the database

## Future Improvements

* PreparedStatement
* Custom exception handling with JDBC
* Savings Account and Current Account
* Inheritance and Polymorphism
* Transaction Management
* File Handling
* Servlet and JSP Integration
* Spring Boot REST API
* Authentication and Login

## Author

**Harish Dubey**

Java Full Stack Developer Learner

 
