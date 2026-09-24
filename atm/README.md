# 🏦 ATM Management System — Java

A console-based **ATM Management System built with Core Java and Object-Oriented Programming (OOP)**.

This project simulates essential ATM operations such as account creation, secure login, deposits, withdrawals, money transfers, balance checking, account details, and transaction history.

The project was developed as a **Java internship project**, with a focus on understanding Java fundamentals, OOP, exception handling, collections, and real-world application flow.

---

## 🚀 Features

### 👤 Account Management

* Create a new bank account
* Automatically generate a unique 6-digit Bank ID
* Store account holder details
* Display account information without exposing the PIN

### 🔐 Login & Validation

* Login using Bank ID and PIN
* Validate account credentials
* Validate account holder name
* Validate 10-digit mobile number
* Validate numeric Bank ID and PIN
* Handle invalid inputs using exception handling
* Give users a second chance for invalid name/mobile input

### 💰 ATM Operations

* Check account balance
* Deposit money
* Withdraw money
* Prevent negative or zero-value transactions
* Prevent withdrawal when the balance is insufficient

### 💸 Money Transfer

* Transfer money from one account to another
* Verify the receiver's Bank ID and PIN
* Prevent transferring money to the same account
* Check sender's available balance
* Automatically update both sender and receiver balances

### 📜 Transaction History

Every successful financial transaction is recorded.

The system records:

* Transaction type
* Transaction amount
* Remaining balance
* Date and time

Supported transaction types:

```text
DEPOSIT
WITHDRAW
TRANSFER OUT
TRANSFER IN
```

Example:

```text
[2026-09-24 18:30:15] DEPOSIT    | Amount: ₹5000     | Balance: ₹5000
[2026-09-24 18:35:21] WITHDRAW   | Amount: ₹1000     | Balance: ₹4000
[2026-09-24 18:40:08] TRANSFER OUT | Amount: ₹500     | Balance: ₹3500
```

---

## 🧠 Key Strengths of the Project

This project is more than a simple menu-driven Java program. It demonstrates several important Core Java concepts working together.

### 1. Object-Oriented Design

The project separates responsibilities into different classes:

```text
Account
   ↓
Stores account information

ATMService
   ↓
Handles ATM operations and application logic

AccountsInformation
   ↓
Manages accounts using HashMap

Transaction
   ↓
Represents individual transactions

Main
   ↓
Controls the application flow
```

This makes the project easier to understand, maintain, and extend.

---

### 2. Encapsulation

Account data is kept private inside the `Account` class.

For example:

```text
private long balance;
private int pin;
private long bankId;
```

Access is controlled through getters and setters instead of directly exposing the fields.

The PIN is also intentionally excluded from displayed account details and `toString()` output.

---

### 3. Custom Exception Handling

The project uses custom exceptions for validation:

```text
InvalidNameException
InvalidMobileException
```

For example:

```text
InvalidNameException
        ↓
Name contains invalid characters
        ↓
Exception thrown
        ↓
ATMService catches it
        ↓
User receives an error message
```

This demonstrates how application-specific validation can be separated from normal program flow.

---

### 4. Java Collections

Accounts are stored using a `HashMap`:

```text
Map<Long, Account>
```

The Bank ID acts as the key:

```text
Bank ID → Account
```

This allows the system to quickly locate an account during login and money transfer.

Transaction history is maintained separately for each account using a list.

---

### 5. Transaction Tracking

Instead of only changing the account balance, the system records every successful transaction.

For example:

```text
Deposit ₹5000
       ↓
Balance updated to ₹5000
       ↓
Transaction recorded
```

This allows the user to view the account's transaction history later.

---

### 6. Two-Sided Money Transfer

A transfer affects **two accounts**.

For example:

```text
Sender
₹5000
  │
  │ Transfer ₹1000
  ↓
₹4000

Receiver
₹2000
  │
  ↓
₹3000
```

The system also records both sides:

```text
Sender   → TRANSFER OUT
Receiver → TRANSFER IN
```

This gives both accounts an independent transaction history.

---

## 🏗️ Project Structure

```text
src/
└── projects/
    └── atm/
        ├── Account.java
        ├── ATMService.java
        ├── AccountsInformation.java
        ├── Main.java
        ├── Transaction.java
        │
        └── exceptions/
            ├── InvalidNameException.java
            └── InvalidMobileException.java
```

---

## 🔄 Application Flow

```text
              START
                │
                ▼
          Display ATM Rules
                │
                ▼
            Main Menu
          /      |       \
         /       |        \
        ▼        ▼         ▼
     Create    Login      Exit
     Account     │
        │        ▼
        │    Verify Bank ID
        │        +
        │       PIN
        │        │
        │        ▼
        │     ATM Menu
        │        │
        │   ┌────┼───────────────┐
        │   │    │      │        │
        │   ▼    ▼      ▼        ▼
        │ Balance Deposit Withdraw Transfer
        │                         │
        │                         ▼
        │                 Transaction History
        │
        └──────────────► Account Created
```

---

## 🛡️ Validation & Error Handling

The application handles common invalid inputs such as:

* Empty account holder name
* Name containing numbers or special characters
* Invalid mobile number
* Mobile number with fewer/more than 10 digits
* Non-numeric Bank ID
* Non-numeric PIN
* Invalid menu choices
* Invalid deposit amount
* Invalid withdrawal amount
* Insufficient balance
* Invalid receiver credentials
* Attempt to transfer money to the same account
* Invalid transfer amount

The project uses both **standard Java exceptions** such as `NumberFormatException` and custom validation exceptions.

---

## 🛠️ Technologies Used

| Technology          | Purpose                     |
| ------------------- | --------------------------- |
| Java                | Core programming language   |
| OOP                 | Application structure       |
| HashMap             | In-memory account storage   |
| ArrayList           | Transaction history         |
| Exception Handling  | Input and validation errors |
| LocalDateTime       | Transaction timestamps      |
| Regular Expressions | Name and mobile validation  |
| IntelliJ IDEA       | Development environment     |
| Git & GitHub        | Version control             |

---

## ▶️ How to Run

### Prerequisites

* Java JDK 17 or later
* IntelliJ IDEA or any Java-compatible IDE

### Steps

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure the project uses JDK 17 or later.
4. Run:

```text
Main.java
```

5. Follow the instructions displayed in the console.

---

## 🧪 Example Usage

```text
========== ATM RULES ==========
-> You must create an account before logging in.
-> Keep your Bank ID and PIN secure.
-> Deposit amount must be greater than ₹0.
-> Withdrawal amount must be greater than ₹0.
-> You cannot withdraw more than your balance.
===============================

========== MAIN MENU ==========
1. Create Account
2. Login Account
3. Exit
```

After successful login:

```text
========== ATM MENU ==========
1. Check Balance
2. Deposit Amount
3. Withdraw Amount
4. Transfer Amount
5. Transaction History
6. Account Details
7. Logout
```

---

## 📌 Current Limitations

This version intentionally uses **in-memory storage**.

Accounts and transaction history are stored using Java collections:

```text
HashMap
ArrayList
```

Therefore, data will be lost when the application terminates.

There is currently no:

* Database persistence
* JDBC integration
* Real bank/payment gateway
* Multi-user authentication system
* Persistent transaction storage

These limitations are intentional for this **Core Java V1 implementation**.

---

## 🔮 Future Enhancement — V2

A future version can extend this project into a database-backed banking application.

Planned improvements include:

```text
Java Application
       │
       ▼
      JDBC
       │
       ▼
     MySQL
       │
       ├── Accounts
       ├── Transactions
       └── Transfer Records
```

Possible V2 features:

* MySQL database integration
* JDBC
* Persistent accounts
* Persistent transaction history
* Transaction IDs
* Improved authentication
* Account statements
* Transaction search/filtering
* Better separation of service and data-access layers

---

## 🎯 Learning Outcomes

Through this project, I practiced:

* Java classes and objects
* Encapsulation
* Constructors
* Getters and setters
* Method design
* Collections Framework
* `HashMap`
* `ArrayList`
* Exception handling
* Custom exceptions
* Regular expressions
* Date and time APIs
* Input validation
* OOP-based application structure
* Git and GitHub version control
* Designing a small real-world console application

---

## 👨‍💻 Project Purpose

This project was developed to strengthen **Core Java and OOP skills through practical implementation** rather than only learning concepts theoretically.

The project represents **V1 — a Core Java in-memory ATM system**, with the possibility of extending it into a **database-backed V2** using JDBC and MySQL.

---

## 📄 License

This project is created for educational and learning purposes.
