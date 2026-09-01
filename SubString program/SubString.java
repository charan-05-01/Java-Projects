import java.lang.*;
import java.io.*;
import java.util.*;
class SubString
{
  public static void main(String[]args)
  {
     System.out.println("***********************************************************************************************");
    Scanner sc=new Scanner(System.in);
    System.out.print(" Enter the String:");
    String string=sc.nextLine();// getting string as input from user 
    string = string.replaceAll("\\s", "");// avoiding spaces 
    int n;
    while (true)
     {
            System.out.print("Enter SubString size:");
              n = sc.nextInt();
             sc.nextLine();          //getting SubString size  as input from user 
            if (n > 0) break;
            System.out.println("⚠ Enter valid size( size>0)!!");
     }
     ArrayList<String> substrings=new ArrayList<>();
     for(int i=0;i<string.length();i+=n)// dividing  sting into substrings
     {
       int end=Math.min(i+n,string.length());
       substrings.add(string.substring(i,end));
     }
     Collections.sort(substrings);// sorting the substrings lexographically
      System.out.println("======================================================");
     System.out.println("Sorted substrings:");
     for(String s: substrings)
        System.out.println(s);// displaying the substrings
     System.out.println("***********************************************************************************************");
  }
}
