---

📑 SubString Program in Java

📌 Overview

This Java program takes a string and splits it into substrings of user-defined size.
It then sorts those substrings lexicographically <dictionary> order and displays them.

✨ Features:

Removes all spaces from the input string before processing

Allows dynamic substring size input

Validates user inputs (ensures substring size > 0)

Uses ArrayList and Collections.sort() for flexible handling

Clean formatted output



---

🛠️ Code Explanation

1. Input

User enters a string

Spaces are removed using:

string = string.replaceAll("\\s", "");

User enters substring size



2. Processing

The string is divided into substrings of given size using substring(i, end)

Stored in an ArrayList

Sorted lexicographically using Collections.sort()



3. Output

Displays the sorted substrings clearly





---

▶️ Example Run

Input

Enter the String: hello world
 Enter SubString size: 2

Output

Sorted substrings:
he, ld, ll, or, ow

---
🚀 How to Run

1. Save the file as SubString.java

2. Compile:

javac SubString.java

3. Run:

java SubString
---
