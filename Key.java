import java.lang.*;
import java.io.*;
import java.util.*;
class Student1
{
   String name;
   int rollno;
  static int count=0;
  static ArrayList<String> register =new ArrayList<>();
  Student1(String n,int r)
  {
    count++;
    name=n;
    rollno=r;
    register.add(n);
    
  }
   static Student1 inputDetails(Scanner sc)
  {
    System.out.println(" Enter name:");
     String name=sc.nextLine();
    System.out.println(" Enter Roll Number:");
     int rollno=sc.nextInt();
      sc.nextLine();
    return new Student1 (name,rollno);
  }
  void display()
  {
    System.out.print("Student name:"+name+"\t");
     System.out.println("Roll Number:"+rollno);
  }
   static void getRegister()
  {
    System.out.println("Registered Students are:::\n"+register);
    System.out.println("Total Count:"+count);
  }
}
class Key
{
  public static void main(String[]args)
  {
    Scanner sc =new Scanner(System.in);
    int n;
     System.out.println("==========================================================================================");
     while (true)
     {
            System.out.println("Enter Number of Students:::");
             n = sc.nextInt();
             sc.nextLine();
            if (n > 0) break;
            System.out.println("⚠ Enter valid number( n>0)");
        
     }
     for(int i=0;i<n;i++)
        {
           Student1 s=Student1.inputDetails(sc);
           s.display();
            System.out.println("--------------------------------------------------------------------------------------------");
        }
   Student1.getRegister();
   System.out.println("=============================================================================================");
  }
  
}