import java.lang.*;
import java.io.*;
import java.util.*;
class Person
{
  // this class represents person with age and name
  Scanner sc = new Scanner(System.in);
 String name; 
 int age;
 void inputDetails()
 {
   // Taking details from user 
   System.out.print("Enter name:");
   this.name=sc.nextLine();
  while (true)
     {
            System.out.print("Enter Age:");
             this.age = sc.nextInt();
             sc.nextLine();
            if (age > 0) break;
            System.out.println("⚠ Enter valid Age( age>0)!!");
     }
 }
 void display()
 {
   System.out.println("Name:"+name);
   System.out.println("Age:"+age);
 }
}
class Student extends Person
{
  // This class represents student with roll number ,course and inherited age and name from its parent class
  String course;
  int rollno;
  void studentDetails()
  {
    System.out.print("Enter cousre or branch:");
    course=sc.nextLine();
    while (true)
     {
            System.out.print("Enter Roll Number:");
             rollno = sc.nextInt();
             sc.nextLine();
            if (rollno > 0) break;
            System.out.println("⚠ Enter valid Roll Number( R.no>0)!!");
     }
  }
  void display()
  {
    System.out.println("Student Details ::");
    super.display();
    System.out.println("Course :"+course);
    System.out.println("Roll Number :"+rollno);
  }
}
class Teacher extends Person
{
  // This class represents Teacher with salary ,subject and inherited age and name from its parent class
  double salary;
  String subject;
  void teacherDetails()
  {
     System.out.print("Enter the subject:");
     subject=sc.nextLine();
    while (true)
     {
            System.out.print("Enter Salary:");
             salary = sc.nextDouble();
             sc.nextLine();
            if (salary > 0) break;
            System.out.println("⚠ Enter valid Salary(Salary>0)!!");
     }
  }
   void display()
  {
    System.out.println("Teacher Details ::");
    super.display();
    System.out.println("Subject :"+subject);
    System.out.println("Salary :"+salary);
  }
}
class InheritanceDemo
{
  // the programing demonstrating Inheritence and single level Inheritence
  public static void main(String[]args)
  {
      System.out.println("==========================================================================================");
     System.out.println("Enter  Student Details:::::");
    Student s=new Student();
    s.inputDetails();
    s.studentDetails();
     System.out.println("--------------------------");
    s.display();
    System.out.println("--------------------------------------------------------------------------------------------");
    System.out.println("Enter  Teacher Details:::::");
    Teacher t=new Teacher();
    t.inputDetails();
    t.teacherDetails();
    System.out.println("--------------------------");
    t.display();
      System.out.println("==========================================================================================");
  }
}