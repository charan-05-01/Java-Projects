```markdown
# 🧮 Advanced Java Calculator

A comprehensive command-line calculator built in Java that supports arithmetic operations, advanced computations, and number system conversions. Designed to demonstrate core Java concepts and handle large numbers efficiently.

## ✨ Features

### 1. Basic Arithmetic Operations
- **Addition** (`+`)
- **Subtraction** (`-`)
- **Multiplication** (`*`)
- **Division` (`/`) with divide-by-zero protection

### 2. Advanced Computations
- **Factorial Calculation** (Uses `BigInteger` to handle very large numbers)
- **nCr (Combinations) Evaluator** (Uses formula: `n! / (r! * (n-r)!)`)

### 3. Number System Conversion
- **Binary to Decimal Conversion** (Supports both integer and fractional binary values)

### 4. User-Friendly Interface
- Menu-driven console interface with emojis
- Input validation for all operations
- Loop until explicit exit

## 🛠️ Technical Implementation

### 🔧 Key Java Concepts Used
- **Object-Oriented Programming**: Modular design with static methods
- **Exception Handling**: Robust input validation
- **BigInteger Class**: Handles factorial calculations beyond `long` limits
- **Regular Expressions**: Validates binary input patterns
- **String Manipulation**: Splits and processes binary decimal values

### 📊 Supported Input Formats
- **Binary Input**: `1010` or `101.101` (with decimal point)
- **nCr Expressions**: `5c2`, `10C3` (case-insensitive)
- **Numbers**: Integers and floating-point values

## 🚀 How to Run

1. **Compile**:
   ```bash
   javac Calculator.java
```

1. Execute:
   ```bash
   java Calculator
   ```
2. Follow Menu Prompts:
   · Choose operation (1-8)
   · Enter required values
   · View results instantly

📝 Example Usage

```
************************************
      Simple Calculator
************************************
1️⃣  Addition
2️⃣  Subtraction
3️⃣  Multiplication
4️⃣  Division
5️⃣  Factorial of n
6️⃣  nCr Evaluator
7️⃣  Binary to Decimal
8️⃣  Exit

Enter Your Choice: 7
Enter the binary value: 101.11
101.11=5.75
```

⚙️ Code Structure

```java
class Calculator {
    // Static methods:
    // - getBigFactorial(int n)
    // - check(String message)
    
    // Main method with switch-case menu
    // Handles 8 operations with input validation
}
```

💡 Key Highlights

· Memory Efficient: Uses iterative factorial calculation instead of recursion
· Precision: Handles fractional binary values accurately
· Error Resilient: Validates inputs before processing
· Scalable: Easy to add new operations and features

🎯 Learning Outcomes

This project demonstrates:

· Advanced menu-driven programming
· Number theory implementations
· Large number handling with BigInteger
· String manipulation and regex validation
· Professional code organization

👨💻 Author

Built with passion and ☕ by [Your Name]!

---

⭐ Pro Tip: Excellent project for learning Java fundamentals and preparing for technical interviews!

```

---
