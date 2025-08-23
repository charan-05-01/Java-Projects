import java.lang.*;
import java.io.*;
import java.util.*;
class Anagrams
{
  public static void main(String[]args)
  {
    System.out.println("***********************************************************************************************");
    Scanner sc =new Scanner(System.in);
    String string1,string2;
    while (true)
     {
            System.out.print("Enter String 1:");
              string1=sc.nextLine();
             int n1=string1.length();    // getting strings as input from user
            if (n1 > 2) break;
              System.out.println("⚠ Enter valid String( String length should be greater than 2!!!");
     }
      while (true)
     {
            System.out.print("Enter String 2:");
              string2=sc.nextLine();
             int n2=string2.length();            // getting strings as input from user
            if (n2 > 2) break;
              System.out.println("⚠ Enter valid String( String length should be greater than 2!!!");
     }
    System.out.println("======================================================");
    System.out.println("The Strings are:"+string1+"\t"+string2);
    string1=string1.toLowerCase();
    string2=string2.toLowerCase();// converting strings into lower or higher case for checking
    if(string1.length()==string2.length()) /* checking two strings  length if same then only we can procced other wise strings are not Anagrams */
    {
      char [] array1=string1.toCharArray();
      char [] array2=string2.toCharArray();
      Arrays.sort(array1);  // sorting strings by converting them into array to check the are Anagrams are not 
      Arrays.sort(array2);
      if(Arrays.equals(array1,array2))
         System.out.println(" Both Strings are Anagrams:::");
      else
        System.out.println("Both Stringa are not Anagrams!!!");
    }
    else 
      System.out.println("Both Stringa are not Anagrams!!!");
    System.out.println("***********************************************************************************************");
  }
}
