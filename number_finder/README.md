# 🎯 Number Finder Game — V1.0

A console-based number guessing game developed using **Java** as part of my **Java Development Internship at Oasis Infobyte**.

The game generates a hidden number between **1 and 100**. The player must find the number within the allowed attempts while using dynamically generated hints.

---

## 🎮 About the Game

The game generates a random hidden number between **1 and 100**.

The player enters guesses and receives feedback such as:

* 📈 The hidden number is higher
* 📉 The hidden number is lower
* 💡 Dynamic hints about the hidden number

The game also tracks the player's guesses and score.

---

## ✨ Features

* 🎲 Random hidden number generation
* 🔢 Number range from 1 to 100
* 💡 Dynamic hint system
* 🔢 Even/Odd hints
* 🔢 Position-based Even/Odd hints
* 🔢 Prime number detection
* 🔢 Prime number position hints
* 🔢 Multiple of 2 or 3 hints
* ➕ Addition-based hints
* ✖️ Multiplication-based hints
* ➖ Subtraction-based hints
* 📈 Higher/Lower guess feedback
* ⭐ Score tracking
* 🔁 Guess counter
* 🔄 Replay option
* ⚠️ Input validation
* 🛡️ Exception handling for invalid input
* 🚫 Range validation for numbers outside 1–100

---

## 💡 Hint Examples

The game can generate different hints depending on the hidden number.

### Example 1 — Even/Odd Hint

```text
💡 Hint: The Hidden number is ODD.
```

### Example 2 — Prime Position Hint

```text
💡 Hint: Hidden number is the 4th prime number.
```

### Example 3 — Addition Hint

```text
💡 Hint: 3 + HN = 10
```

Where `HN` represents the hidden number.

---

## 🛠️ Technologies & Concepts Used

* **Java**
* Object-Oriented Programming
* Methods
* Conditional Statements
* Loops
* Random Number Generation
* Exception Handling
* Scanner for User Input
* Input Validation

---

## 🚀 How to Run

### Prerequisites

* Java JDK installed
* IntelliJ IDEA or any Java IDE

### Steps

1. Clone the repository.

2. Open the project in IntelliJ IDEA or another Java IDE.

3. Navigate to:

```text
Java-Projects/number_finder
```

4. Compile and run:

```text
NumberFinder.java
```

5. Enter your guesses and use the hints to find the hidden number.

---

## 🎯 Game Rules

1. The game generates a random number between **1 and 100**.
2. The player has a limited number of valid guesses.
3. Each valid incorrect guess provides feedback and a hint.
4. Numbers outside the range **1–100** are rejected.
5. Non-numeric input is handled without crashing the program.
6. The game ends when:

   * The player finds the hidden number, or
   * The maximum number of valid guesses is reached.
7. The player can choose to play another round.

---

## 📊 Example Gameplay

```text
=========================================
        🎯 NUMBER FINDER GAME 🎯
=========================================
🚀 Game Started! Guess a number between 1 and 100.
-----------------------------------------

Enter Number : 50
📉 Too Low!
💡 Hint: The Hidden number is ODD.

Enter Number : 75
📈 Too High!
💡 Hint: Hidden number is a multiple of 3.

Enter Number : 63
🎉 Congratulations! You found the hidden number.
⭐ Score: 8
```

---

## 📌 Version Information

### V1.0 — Console Version

Current version includes:

* Console-based gameplay
* Random number generation
* Dynamic hint system
* Higher/Lower feedback
* Score tracking
* Guess tracking
* Replay functionality
* Input validation
* Exception handling

### 🔜 Future Improvements

The current internship version intentionally focuses on the **core Java console implementation**.

Future development may include:

* 🌐 Web-based user interface
* 🏆 Leaderboard
* 👤 Player profiles
* 💾 Persistent score storage
* ☁️ Deployment

---

## 📂 Project Structure

```text
number_finder/
│
├── NumberFinder.java
└── README.md
```

---

## 🎓 Internship Project

This project was developed as part of the:

**Java Development Internship — Oasis Infobyte**

---

## 👨‍💻 Author

**Charan Kumar**

Java Developer | CSE Student

GitHub: `charan-05-01`
