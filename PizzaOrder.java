import java.util.*;
import java.io.*;
import java.lang.*;
class Pizza
{
    String size, toppings;
    double price;
    Scanner sc = new Scanner(System.in);

    // Constructor 1: Only size
    Pizza(String size)
    {
        this.size = size;
    }

    // Constructor 2: Size + Toppings
    Pizza(String s, String t)
    {
        this(s); // Calls Constructor 1
        this.toppings = t;
    }

    // Constructor 3: Size + Toppings + Price
    Pizza(String s, String t, double p)
    {
        this(s, t); // Calls Constructor 2
        this.price = p;
    }

    // Method: Apply discount and return updated object
    Pizza applyDiscount(double d)
    {
        if (d >= 0 && d < 100) {
            price = price - (price * d / 100);
        } else {
            System.out.println("\n⚠ Invalid discount! Please enter again.");
            System.out.print("Enter Discount Percentage: ");
            double discount = sc.nextDouble();
            applyDiscount(discount);
        }
        return this;
    }

    // Method: Display pizza details
    void displayDetails()
    {
        System.out.println("----------------------------");
        System.out.println("🍕 Pizza Details:");
        System.out.println("Size: " + size);
        System.out.println("Toppings: " + toppings);
        System.out.printf("Price: ₹%.2f%n", price);
        System.out.println("----------------------------");
    }

    // Order process
    void order()
    {
        System.out.print("\nEnter Discount Percentage: ");
        double discount = sc.nextDouble();

        System.out.println("\n📌 Before Discount:");
        displayDetails();

        applyDiscount(discount);

        System.out.println("\n✅ After " + discount + "% Discount:");
        displayDetails();

        System.out.println(".....Thank You for Ordering.....");
    }
}

class PizzaOrder
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Welcome banner
        System.out.println("======================================================");
        System.out.println("   🍕 Welcome to Java Pizza Order System 🍕");
        System.out.println("======================================================");

        // Taking order details
        System.out.print("Enter Pizza Size: ");
        String size = sc.nextLine();

        System.out.print("Enter Toppings: ");
        String toppings = sc.nextLine();

        double price;
        while (true) {
            System.out.print("Enter Price: ₹");
            price = sc.nextDouble();
            if (price > 0) break;
            System.out.println("⚠ Enter valid price!!");
        }

        // Creating pizza and processing order
        Pizza obj1 = new Pizza(size, toppings, price);
        obj1.order();

        System.out.println("======================================================");
        System.out.println("          🍴 Enjoy Your Pizza! 🍴");
        System.out.println("======================================================");
    }
}