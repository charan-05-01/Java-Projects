🔤 Anagram Checker in Java
This simple Java program checks whether two strings entered by the user are Anagrams of each other.

👉 Anagrams are words or phrases made by rearranging the letters of another (e.g., listen and silent).

📌 Features
✅ Takes two string inputs from the user

✅ Ensures string length is greater than 2 characters
✅ Converts all characters to lowercase for comparison

✅ Uses character arrays + sorting to check anagram status

✅ Prints whether the strings are Anagrams or Not Anagrams

🖥️ Sample Input/Output
***********************************************************************************************
Enter String 1: Listen
Enter String 2: Silent
======================================================
The Strings are: Listen    Silent
 Both Strings are Anagrams:::
***********************************************************************************************
***********************************************************************************************
Enter String 1: hello
Enter String 2: world
======================================================
The Strings are: hello    world
Both Strings are not Anagrams!!!
***********************************************************************************************
🛠️ How It Works
Reads two input strings using Scanner

Validates that both strings have length > 2

Converts them to lowercase (string.toLowerCase()) for case-insensitive comparison

Converts each string into a character array

Sorts both arrays using Arrays.sort()

Checks if both sorted arrays are equal

✅ If yes → Strings are Anagrams

❌ If no → Strings are Not Anagrams
🚀 How to Run
Save the file as Anagrams.java

Compile the program:

javac Anagrams.java

Run the program:

java Anagrams

📚 Concepts Used
Scanner for user input

String methods (length(), toLowerCase(), toCharArray())

Arrays.sort() and Arrays.equals()

Loops for input validation (while(true) with break)
