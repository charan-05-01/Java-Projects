
---

🧮 Advanced Java Calculator

A feature-rich command-line calculator built in Java that handles everything from basic arithmetic to advanced combinatorial mathematics with precision.

✨ Features

🔢 Basic Operations

· Addition - Precision handling for integers and decimals
· Subtraction - Clean output formatting
· Multiplication - Large number support
· Division - Zero division protection

🧠 Advanced Operations

· Factorial Calculator - Uses BigInteger for massive number support (no overflow!)
· nCr Calculator - Combinatorial mathematics with formula: n! / (r! * (n-r)!)
· Binary to Decimal Converter - Supports both integer and fractional binary numbers

🚀 Technical Highlights

💾 Smart Memory Management

· BigInteger Integration - Handles factorial values beyond long capacity
· Type-Safe Operations - Prevents arithmetic overflow errors

🎯 Intelligent Output Formatting

```java
// Automatic integer/decimal detection
10 + 20 = 30          // Clean integer output
10.5 + 20.25 = 30.75  // Decimal output when needed
```

⚡ Efficient Algorithms

· Optimized nCr Calculation - avoids redundant factorial computations
· Binary Conversion - handles both integer and fractional binary values
· Input Validation - robust error handling and user feedback

🛠️ Code Architecture

📦 Class Structure

```java
class Calculator {
    // Static utility methods
    static BigInteger getBigFactorial(int n)
    static int check(String message)
    static void performOperation(double num1, double num2, char operator)
    
    // Main method with menu-driven interface
    public static void main(String[] args)
}
```

🔧 Key Methods

· getBigFactorial() - Calculates factorials of any size using BigInteger
· check() - Validates user input with positive number checks
· performOperation() - Handles all arithmetic with smart formatting

📋 Usage Examples

🔢 Basic Arithmetic

```
Enter Your Choice: 1
Enter first number: 15
Enter second number: 25
✅ 15 + 25 = 40
```

❌ Error Handling

```
Enter Your Choice: 4
Enter first number: 10
Enter second number: 0
⚠ Cannot divide by zero!
```

🧮 Advanced Mathematics

```
Enter Your Choice: 5
Enter Value: 100
100 factorial = 9332621544398917323846264338327950288419716939937510582097...

Enter Your Choice: 6
Enter the Expression: 10C3
10C3 = 120
```

🔁 Binary Conversion

```
Enter Your Choice: 7
Enter the binary value: 1101.101
1101.101 = 13.625
```

🎯 Technical Stack

· Java SE - Core programming language
· BigInteger - Arbitrary-precision integers
· Scanner Class - User input handling
· Regex Validation - Input pattern matching

📊 Performance Features

· ♻️ Memory Efficient - No redundant object creation
· ⚡ Fast Computation - Optimized mathematical operations
· 🛡️ Error Resilient - Comprehensive input validation
· 📱 User Friendly - Intuitive menu interface

🔮 Future Enhancements

· Graphical User Interface (GUI)
· Scientific functions (trigonometry, logarithms)
· Calculation history persistence
· Unit conversion features
· File I/O for saving results

---

👨💻 Developer

Your Name
Java Developer & Mathematics Enthusiast
💡 Passionate about combining mathematical rigor with clean code architecture

---

⭐ Star this repo if you found it useful!

---
