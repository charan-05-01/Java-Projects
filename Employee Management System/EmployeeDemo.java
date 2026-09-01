import java.lang.*;
import java.io.*;
import java.util.*;
 abstract class Employee //Abstract Class
{
  String name,type;
  int id,b;
  double salary;
  double bonus;
  abstract double calculateBonus();//Abstract method 
  void displayDetails()
  {
    System.out.println("Employee Name:"+name);// displaying details using abstract class method
    System.out.println("Employee ID:"+id);
    System.out.println("Employee Salary:"+salary);
    System.out.println("Bonus:"+bonus);
  }
}
class Bonus extends Employee // Extending(inheriting) Abstract Class
{
  Scanner sc =new Scanner(System.in);
  void inputDetails()
  {
    while (true)
     {
           System.out.print("Enter  Employee Position(Developer/Manager/Intern):");
             type = sc.nextLine();// Getting input details and checking there it self whether they are valid or invalid
             type=type.toLowerCase();
            if (type.equals("developer")||type.equals("intern")||type.equals("manager")) break;
            System.out.println("⚠ Enter valid Position (Developer/Manager/Intern)!!");
     }
     System.out.print("Enter Employee Name:");
     name=sc.nextLine();
     System.out.print("Enter Employee ID:");
     id=sc.nextInt();
     while (true)
     {
            System.out.print("Enter Salary:");
              salary = sc.nextInt();
             sc.nextLine();          //getting Salary  as input from user and checking it is valid or not
            if (salary > 0) break;
            System.out.println("⚠ Enter valid Salary( Salary>0)!!");
     }
     System.out.println("----------------------------------------------------");//dividing after taking each employee details for better and clean output
  }
  double calculateBonus()
  {
    if(type.equals("developer"))
      bonus=salary*(20/100.0);// method to calculate Bonus here the bonuses are hardcoded ( if you want you can change according to your use) 
    else if(type.equals("intern"))
      bonus=salary*(10/100.0);
    else if(type.equals("manager"))
      bonus=salary*(30/100.0);
    return bonus;
  }
}
class EmployeeDemo
{
  public static void main(String[]args)
  {
    System.out.println("***********************************************************************************************");
    System.out.println("\t\t\t  !!WELCOME!!  \t\t\t");
    Scanner sc =new Scanner(System.in);
    ArrayList<Employee> Employees=new ArrayList<>();// A ArrayList which is accepting objects
    int n;
    while (true)
     {
            System.out.print("Enter How Many Employees??..");
             n = sc.nextInt();
             sc.nextLine();         
            if (n > 0) break;
            System.out.println("⚠ Enter valid Number of Employees(n>0)!!");
     }
    for(int i=0;i<n;i++)
    {
       Bonus obj =new Bonus();
       obj.inputDetails();
       Employees.add(obj);
    }
     System.out.println("======================================================");
    for(Employee e : Employees)
    {
      e.calculateBonus();
      e.displayDetails();
       System.out.println("======================================================");//dividing after displaying each employee details for better and clean output
       System.out.println("\t\t\t!!THANK YOU!! \t\t\t");
    }
    System.out.println("***********************************************************************************************");
  }
}
