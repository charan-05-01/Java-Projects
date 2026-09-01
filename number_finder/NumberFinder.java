package projects.number_finder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberFinder {

    int num = getRandomNumber();
    int score = 10;
    int numOfGuesses = 0;
    Scanner s = new Scanner(System.in);
    Random random = new Random();

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    // ================= HINT SYSTEM =================

    public void checkEven_Odd(int num) {
        if (num % 2 == 0)
            System.out.println("💡 Hint: The Hidden number is EVEN.");
        else
            System.out.println("💡 Hint: The Hidden number is ODD.");
    }

    public void countOf_even_odd(int num) {
        int eCount = 1;
        int oCount = 1;
        if (num % 2 == 0) {
            for (int i = 0; i <= 10; i += 2) {
                if (num == i) {
                    System.out.printf("💡 Hint: Hidden number is the %dth even number (starting from 0).\n", eCount);
                    break;
                }
                eCount++;
            }
        } else {
            for (int i = 1; i <= 10; i += 2) {
                if (num == i) {
                    System.out.printf("💡 Hint: Hidden number is the %dth odd number (starting from 1).\n", oCount);
                    break;
                }
                oCount++;
            }
        }
    }

    public void isPrime(int num) {
        HashSet<Integer> set = new HashSet<>();
        set.add(2); set.add(3); set.add(5); set.add(7);

        if (set.contains(num)) {
            System.out.println("💡 Hint: The Hidden number is a PRIME number.");
        } else {
            System.out.println("💡 Hint: The Hidden number is NOT a prime number.");
        }
    }

    public void countOfPrime(int num) {
        List<Integer> set = new ArrayList<>();
        set.add(2); set.add(3); set.add(5); set.add(7);

        if (set.contains(num)) {
            int position = set.indexOf(num) + 1;
            System.out.printf("💡 Hint: Hidden number is the %dth prime number.\n", position);
        } else {
            System.out.println("💡 Hint: The Hidden number is not a prime number.");
        }
    }

    public void multipleOfTwo_Three(int num) {
        if (num != 0 && num % 2 == 0)
            System.out.println("💡 Hint: The Hidden number is a multiple of 2.");
        else if (num != 0 && num % 3 == 0)
            System.out.println("💡 Hint: The Hidden number is a multiple of 3.");
        else
            System.out.println("💡 Hint: The Hidden number is NOT a multiple of 2 or 3.");
    }

    public void add(int num) {
        int ran = (int) (Math.random() * 10);
        System.out.printf("💡 Hint: %d + HN = %d\n", ran, (num + ran));
    }

    public void product(int num) {
        int ran = (int) (Math.random() * 10);
        System.out.printf("💡 Hint: %d * HN = %d\n", ran, (num * ran));
    }

    public void subtract(int num) {
        int ran = (int) (Math.random() * 10);
        if (ran > num)
            System.out.printf("💡 Hint: %d - HN = %d\n", ran, (ran - num));
        else
            System.out.printf("💡 Hint: HN - %d = %d\n", ran, (num - ran));
    }

    // ================= SINGLE HINT ROUTER =================

    public void getHint() {
        int hintChoice = random.nextInt(8) + 1;

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
        // If 3-strike input retries failed or invalid input penalty triggered
        if (n == -1) {
            System.out.println("❌ Turn forfeited due to invalid entries.\n");
            numOfGuesses++;
            if (numOfGuesses % 2 == 0) {
                score--;
            }
            return false;
        }

        if (num == n) {
            System.out.println("🎉 Number Found!");
            return true;
        } else {
            getHint();
        }

        numOfGuesses++;
        if (numOfGuesses % 2 == 0) {
            score--;
        }
        return false;
    }

    public int checkInput(int n) {
        int invalidAttempts = 1;
        int inputNum = n;

        while ((inputNum > 10 || inputNum < 0) && invalidAttempts < 3) {
            int remaining = 3 - invalidAttempts;
            System.out.println("⚠️ Invalid entry! You have " + remaining + " retry chance(s) left.");
            System.out.print("Again Enter the Number (0-10): ");

            try {
                inputNum = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("⚠️ String input detected! Only whole numbers allowed.");
                s.next(); // Flush the bad token from buffer
                inputNum = -1; // Force retry or loop continuation
            }
            invalidAttempts++;
        }

        if (inputNum > 10 || inputNum < 0) {
            return -1;
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

        printHeader();
        System.out.println("🚀 Game Started! Guess a number between 0 and 10.");
        System.out.println("-----------------------------------------\n");

        NumberFinder nm = new NumberFinder();
        boolean result = false;

        while (!result) {
            System.out.print("Enter Number : ");
            try {
                int num = sc.nextInt();
                result = nm.checkNum(nm.checkInput(num));
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Invalid input! Please enter a whole number.\n");
                sc.next(); // Flush bad string token from scanner
            }
        }

        System.out.println("\n-----------------------------------------");
        System.out.println("🏁 GAME OVER 🏁");
        System.out.println("Final Score   : " + nm.score);
        System.out.println("Total Guesses : " + nm.numOfGuesses);
        System.out.println("=========================================");
    }
}