import java.lang.*;
import java.io.*;
import java.util.*;
class BankAccount
{
  double balance;
  String name;
  BankAccount()
  {                           // default constructor
    this.name="Unknown";
    this.balance=0;
  }
   BankAccount(String n,double m)
  {                            // parameterized  constructor
    this.name=n;
    this.balance=m;
  }
   BankAccount( BankAccount obj)
  {                           // copy constructor
    this.name=obj.name;
    this.balance=obj.balance;
  }
  void display()
  {
    System.out.println("Name:"+name);
    System.out.println("Balance:"+balance);
  }

}
class BankDemo
{
  public static void main(String []args)
  {
   Scanner sc=new Scanner(System.in);
   System.out.println("***********************************************************************************************");
   System.out.println("Enter the Details:::::::");
   System.out.print("Enter Account holder Name:");
   String hName=sc.nextLine();
   double b;
   while (true)
     {
            System.out.print("Enter Balance:");
             b = sc.nextInt();
             sc.nextLine();
            if (b > 0) break;
            System.out.println("⚠ Enter valid Balance( Balance>0)!!");
     }
     System.out.println("======================================================");
     BankAccount bank1=new BankAccount(); // creating Object for  default constructor
     BankAccount bank2=new BankAccount(hName,b); //creating Object for  parameterized constructor and passing augments
     BankAccount bank3=new BankAccount(bank2);  // creating Object for  copy constructor and passing original class Object as augments
     System.out.println("Default Constructor Account:");
     bank1.display();
      System.out.println("parameterized Constructor Account:");
     System.out.println("======================================================");
     bank2.display();
     System.out.println("======================================================");
      System.out.println("Copy Constructor Account:");
     bank3.display();
   System.out.println("***********************************************************************************************");
  }
  
}
