🏦 SmartBankApp
Banking Application using Java + Hibernate + PostgreSQL
SmartBankApp is a console-based banking backend application built from scratch using Java, Hibernate ORM, and PostgreSQL.
The project focuses on real-world backend design, ORM mastery, and transaction-safe banking operations, rather than simple CRUD demos.
This application simulates core banking features while following clean architectural principles.

🚀 Tech Stack
Java (Core Java, OOP)
Hibernate ORM (JPA)
PostgreSQL
Maven

IntelliJ IDEA
🧠 What This Project Demonstrates
✅ Entity Relationship Modeling (Real-World Design)

Customer → Account (One-to-Many)
Account → Transaction (One-to-Many)
Account → ATM Card (One-to-One)
Correct usage of:

@OneToMany

@ManyToOne

@OneToOne

mappedBy

Owning vs Inverse side

✅ Hibernate & Transaction Management

Proper Session and Transaction lifecycle handling

Safe commit / rollback logic for:

Deposit

Withdraw

Transfer

Atomic money transfers using a single DB transaction

✅ Clean Architecture
UI (Main)
   ↓
Service Layer (Business Logic)
   ↓
Hibernate ORM
   ↓
PostgreSQL Database


UI handles only input/output

Services handle business rules

Entities map directly to database tables

No database queries inside UI

💼 Core Features

Create Customer

Open Bank Account

Deposit Money

Withdraw Money

Transfer Money (Debit + Credit)

View Transaction History

Issue ATM Card

Change ATM PIN

Block ATM Card

All operations are fully persisted and validated in the database.

🗄️ Database Highlights

Auto-generated primary keys

Foreign key relationships

Transaction history linked via object mapping (no manual SQL joins)

Balance consistency guaranteed via Hibernate transactions

🎯 Learning Objectives

This project was built to:

Understand Hibernate deeply (not just annotations)

Learn real banking transaction flow

Practice backend architecture used in industry

Bridge DSA + Backend Development for placements

🔗 Future Improvements

DAO layer abstraction
Exception handling hierarchy
Logging (SLF4J)
Spring Boot migration
REST API layer

📌 Note

This is a learning-focused backend project, designed to simulate real banking systems and prepare for interviews and real-world backend roles.
