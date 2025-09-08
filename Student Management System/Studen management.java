import java.io.*;
import java.lang.*;
import java.util.*;
 class Student
 {                   // save file name as StudentManagement.java
    String name;
    int a[];
    int rollnumber,total,count;
    double avg;
   static Scanner sc=new Scanner (System.in);
 	void inputDetails()
     {
      System.out.print("Enter Student Name :");
      name =sc.nextLine();
      rollnumber=Student.check("Enter Student RollNumber:");//Getting Student details
      count=Student.check("Enter How many Subjects?:");
      a=new int [count];
     System.out.println("Enter Student marks :");   
     for(int i=0;i<count;i++)
            a[i]=Integer.parseInt(sc.nextLine());
     }
     void display ( )
     {
     	System.out.println("\nStudent Name:"+name);
      System.out.println("Student Roll Number:"+rollnumber);//a method to diplay details of Student
      System.out.print("Student Marks:");
      for(int b: a)
      {
        System.out.print(b+" ");
        total+=b;
      }
      System.out.println("\nTotal marks:"+total);
      avg=(double)total/count;
      System.out.println("Average:"+avg);
     }
      static int check(String message)
     {        // a Static method which is used to check the input whether it is valid or not 
       int value;
        while(true)
        {
           System.out.print(message);
            value= Integer.parseInt(sc.nextLine());
            if(value>0)break;
            System.out.println("Try again!!");
        }
        return value;
     }
 }
 class UG_Student extends Student  //derived class of Student which defines student tyoe
 {                         
   String IpCompany;        // Getting additional details of student 
   void inputDetails()
   {
     System.out.print("\nEnter InternShip Company:");
     IpCompany=sc.nextLine();
     super.inputDetails();
   }
   void display()
   {
     super.display();
     System.out.print("InternShip Company:"+IpCompany);
   }
 }
 class PG_Student extends Student //derived class of Student which defines student tyoe
 {
   String RStopic;
   void inputDetails()
   {                            // Getting additional details of student 
     System.out.print("\nEnter Research topic:");
     RStopic=sc.nextLine();
     super.inputDetails();
   }
   void display()
   {
     super.display();
     System.out.print("Research topic:"+RStopic);
   }
 }
class StudentManagement
{
     public static void main(String [] args )
     {
       System.out.println("\n****************************************************************************************");
       System.out.println("\t\t=====>WELCOME TO STUDENT MANAGEMENT<======\t\t");
       Scanner input=new Scanner(System.in);
       Student obj;
       char option;
       String temp;
       ArrayList<Student> objlist=new ArrayList<>(); // Student type ArrayList used to store the objects
       do
       {
          System.out.println("1.UG_Student\n2.PG_Student\n3.Display All Students\n4.Search\n5.Exit");
          System.out.print("Enter your choice:");
          int choice=Integer.parseInt(input.nextLine());
         if(choice == 1)
         {
           UG_Student u=new UG_Student();
           u.inputDetails();
           System.out.println("-----------------------------------------");
           objlist.add(u);
         }
         else if(choice==2)
         {
            PG_Student p=new PG_Student();
            p.inputDetails();
             System.out.println("-----------------------------------------");
            objlist.add(p);
         }
         else if(choice==3)
         {
            for(int i=0;i<objlist.size();i++)
            {
              System.out.println("\n-----------------------------------------");
              obj=objlist.get(i);
              obj.display();   // logic to Display objects stored in ArrayList
               System.out.println("\n-----------------------------------------");
            }
         }
         else if(choice==4)
         {
           int search = Student.check("Enter RollNumber to Search:");
           int flag=0;
           for(int i=0;i<objlist.size();i++)
            {
              obj=objlist.get(i);
              if(obj.rollnumber==search)
                {
                  flag=1;
                  System.out.println("\n-----------------------------------------");
                  System.out.println("RollNumber is found!"); // // logic to search objects stored in ArrayList through RollNumber
                   obj.display();
                  System.out.println("\n-----------------------------------------");
                 }
                
            }
            if(flag==0)
                    System.out.println("RollNumber is not found!");
         }
         else if(choice==5)
         {
           System.out.println("Exiting...............");
           return;
         }
         else
            System.out.println("Invalid choice:");
         System.out.print("\nEnter 'y'or'Y'to continue:");//Getting option to continue or Exit the programm
        temp=input.nextLine();
        option=temp.charAt(0);
       }while(option=='y'||option=='Y');
       System.out.println("\t\t=====>THANK YOU<======\t\t");
      System.out.println("*****************************************************************************************");
     }
}
