package projects.number_finder;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberFinder {

    int num = getRandomNumber();
    int score = 10;
    int numOfGuesses = 0;
    static Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(100) + 1;
    }

    // Reset game state for "Play Again"
    public void resetGame() {
        this.num = getRandomNumber();
        this.score = 10;
        this.numOfGuesses = 0;
    }

    // ================= HINT SYSTEM =================

    public void checkEven_Odd(int num) {
        if (num % 2 == 0)
            System.out.println("💡 Hint: The Hidden number is EVEN.");
        else
            System.out.println("💡 Hint: The Hidden number is ODD.");
    }

    public void countOf_even_odd(int num) {
        if (num % 2 == 0) {
            int position = num / 2;
            System.out.printf("💡 Hint: Hidden number is the %dth even number.\n", position);
        } else {
            int position = (num + 1) / 2;
            System.out.printf("💡 Hint: Hidden number is the %dth odd number.\n", position);
        }
    }

    private boolean checkPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void isPrime(int num) {
        if (checkPrime(num)) {
            System.out.println("💡 Hint: The Hidden number is a PRIME number.");
        } else {
            System.out.println("💡 Hint: The Hidden number is NOT a prime number.");
        }
    }

    public void countOfPrime(int num) {
        if (!checkPrime(num)) {
            System.out.println("💡 Hint: The Hidden number is not a prime number.");
            return;
        }

        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (checkPrime(i)) {
                count++;
            }
        }
        System.out.printf("💡 Hint: Hidden number is the %dth prime number.\n", count);
    }

    public void multipleOfTwo_Three(int num) {
        if (num % 2 == 0 && num % 3 == 0)
            System.out.println("💡 Hint: The Hidden number is a multiple of both 2 and 3.");
        else if (num % 2 == 0)
            System.out.println("💡 Hint: The Hidden number is a multiple of 2.");
        else if (num % 3 == 0)
            System.out.println("💡 Hint: The Hidden number is a multiple of 3.");
        else
            System.out.println("💡 Hint: The Hidden number is NOT a multiple of 2 or 3.");
    }

    public void add(int num) {
        int ran = random.nextInt(10) + 1;
        System.out.printf("💡 Hint: %d + Hidden Number = %d\n", ran, (num + ran));
    }

    public void product(int num) {
        int ran = random.nextInt(10) + 1;
        System.out.printf("💡 Hint: %d * Hidden Number = %d\n", ran, (num * ran));
    }

    public void subtract(int num) {
        int ran = random.nextInt(10) + 1;
        if (ran > num)
            System.out.printf("💡 Hint: %d - Hidden Number = %d\n", ran, (ran - num));
        else
            System.out.printf("💡 Hint: Hidden Number - %d = %d\n", ran, (num - ran));
    }

    // ================= SINGLE HINT ROUTER =================

    public void getHint() {
        int hintChoice = 0;

        if (numOfGuesses == 1 || numOfGuesses == 2) {
            hintChoice = random.nextInt(2) + 1;
        }
        else if (numOfGuesses == 3 || numOfGuesses == 4) {
            hintChoice = random.nextInt(3) + 3;
        }
        else {
            hintChoice = random.nextInt(3) + 6;
        }

        switch (hintChoice) {
            case 1 -> checkEven_Odd(num);
            case 2 -> countOf_even_odd(num);
            case 3 -> isPrime(num);
            case 4 -> countOfPrime(num);
            case 5 -> multipleOfTwo_Three(num);
            case 6 -> add(num);
            case 7 -> product(num);
            case 8 -> subtract(num);
        }
    }

    // ================= GAMEPLAY LOGIC =================

    public boolean checkNum(int n) {
        if (n == -1) {
            return true; // Exit loop on validation failure
        }

        // 1. Increment guess count FIRST
        numOfGuesses++;
        if (numOfGuesses % 2 == 0) {
            score--;
        }

        // 2. Check Win
        if (num == n) {
            System.out.println("🎉 Number Found!");
            return true;
        }

        // 3. Print High/Low feedback
        if (n < num) {
            System.out.println("📉 Too Low!");
        } else {
            System.out.println("📈 Too High!");
        }

        // 4. Check Loss (7 attempts limit) BEFORE giving hint
        if (numOfGuesses >= 7) {
            System.out.println("\n💥 You Lost! You used all 7 guesses.");
            System.out.println("The Hidden Number was: " + num);
            return true; // Ends game loop
        }

        // 5. Show hint only if guesses are remaining
        getHint();
        return false;
    }

    public int checkInput(int n, Scanner sc) {
        int invalidAttempts = 0;
        int inputNum = n;

        while (inputNum > 100 || inputNum < 1) {
            invalidAttempts++;
            int remaining = 3 - invalidAttempts;

            if (remaining > 0) {
                System.out.println("⚠️ Invalid entry! Range is 1-100. You have " + remaining + " retry chance(s) left.");
                System.out.print("Again Enter the Number (1-100): ");

                try {
                    inputNum = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("⚠️ Invalid input! Please enter a whole number.");
                    sc.next(); // Flush bad token
                    inputNum = -1;
                }
            } else {
                System.out.println("❌ Out of chances! Application quitting due to too many invalid entries.");
                return -1; // Sentinel value to signify total validation failure
            }
        }

        return inputNum;
    }

    public static void printHeader() {
        System.out.println("=========================================");
        System.out.println("        🎯 NUMBER FINDER GAME 🎯         ");
        System.out.println("=========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberFinder nm = new NumberFinder();
        char playAgainChoice;

        do {
            printHeader();
            System.out.println("🚀 Game Started! Guess a number between 1 and 100.");
            System.out.println("-----------------------------------------\n");

            nm.resetGame();
            boolean result = false;
            int validatedInput = 0;

            while (!result) {
                System.out.print("Enter Number : ");
                try {
                    int input = sc.nextInt();
                    validatedInput = nm.checkInput(input, sc);
                    result = nm.checkNum(validatedInput);
                } catch (InputMismatchException e) {
                    System.out.println("⚠️ Invalid input! Please enter a whole number.\n");
                    sc.next();
                }wqwq
            }

            // Only display scores if the game ended normally (not via validation failure)
            if (validatedInput != -1) {
                System.out.println("\n-----------------------------------------");
                System.out.println("🏁 GAME OVER 🏁");
                System.out.println("Final Score   : " + nm.score);
                System.out.println("Total Guesses : " + nm.numOfGuesses);
                System.out.println("=========================================");
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgainChoice = sc.next().toLowerCase().charAt(0);
            System.out.println();

        } while (playAgainChoice == 'y');

        System.out.println("Thanks for playing Number Finder! Goodbye! 👋");
    }
}