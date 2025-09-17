import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;
class Calculator 
{
               //Save File nmae as Calculator.java
  
  static BigInteger getBigFactorial(int n) {
    BigInteger result = BigInteger.ONE;
    for (int i = 1; i <= n; i++) { // a method to calculate factorial here used advanced data type BigInteger to avoid overflow 
        result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
}
  static int check(String message)
     {    
       // a Static method which is used to check the input whether it is valid or not 
       Scanner input=new Scanner(System.in);
       int value;
        while(true)
        {
           System.out.print(message);
            value= Integer.parseInt(input.nextLine());
            if(value>0)break;
            System.out.println("Try again!!");
        }
        return value;
     }
    public static void main(String[] args)
    {
       System.out.println("********************************************************************************************");
      System.out.println("\t  Simple Calculator");
         Scanner sc = new Scanner(System.in);
        int choice;
        double num1,num2;
        BigInteger numerator,denominator1,denominator2,result;
        String s;
        do {
            System.out.println("1️⃣  Addition");
            System.out.println("2️⃣ Subtraction");
            System.out.println("3️⃣ Multiplication");
            System.out.println("4️⃣ Division");
            System.out.println("5️⃣ Factorial of n ");
            System.out.println("6️⃣ ncr Evaluator");
            System.out.println("7️⃣ Binary to Decimal");
            System.out.println("8️⃣ Exit");
              choice=Calculator.check("Enter Your Choice:");
                switch (choice)
                {
                    case 1:
                        System.out.print("Enter first number: ");
                        num1 = sc.nextDouble();
                        System.out.print("Enter second number: ");
                         num2 = sc.nextDouble();
                        System.out.printf("✅ %d+%d=%d",num1,num2,(num1 + num2));
                        System.out.println("====================================");
                        break;
                    case 2:
                      System.out.print("Enter first number: ");
                       num1 = sc.nextDouble();
                      System.out.print("Enter second number: ");
                       num2 = sc.nextDouble();
                        System.out.printf("✅ %d+%d=%d",num1,num2,(num1-num2));
                       System.out.println("====================================");
                        break;
                    case 3:
                       System.out.print("Enter first number: ");
                        num1 = sc.nextDouble();
                        System.out.print("Enter second number: ");
                        num2 = sc.nextDouble();
                        System.out.printf("✅ %d+%d=%d",num1,num2,(num1*num2));
                        System.out.println("====================================");
                        break;
                    case 4:
                        System.out.print("Enter first number: ");
                         num1 = sc.nextDouble();
                        System.out.print("Enter second number: ");
                         num2 = sc.nextDouble();
                        if (num2 != 0)
                            System.out.printf("✅ %d+%d=%d",num1,num2,(num1 /num2));
                        else
                            System.out.println("⚠ Cannot divide by zero!");
                       System.out.println("====================================");
                        break;
                    case 5:
                      System.out.print("Enter Value:");
                      int value=Integer.parseInt(sc.nextLine());
                      BigInteger factorial= Calculator.getBigFactorial(value);
                      System.out.print(value+"factorial="+factorial);
                      System.out.println("\n====================================");
                      break;
                    case 6:
                      System.out.print("\nEnter the Expression:");
                      s=sc.nextLine();
                      String temp=s;  // a case that checks the expression valid or not and gives ncr value using mathematics formula used simple logic for to got the idea fastly
                      temp=temp.replaceAll(" ","");
                      String [] substrings=temp.toLowerCase().split("c");
                      int n=Integer.parseInt(substrings[0]);
                      int r=Integer.parseInt(substrings[1]);
                      numerator= (Calculator.getBigFactorial(n));
                      denominator1= Calculator.getBigFactorial(r);
                      denominator2=  Calculator.getBigFactorial(n-r);
                      result=  numerator.divide(denominator1.multiply(denominator2));
                      System.out.print(s+" = "+result);
                      System.out.println("====================================");
                      break;
                     default:
                       System.out.println("⚠ Invalid Choice! Try again.");
                       break;
                     case 8:
                         System.out.println(" Exiting.....");
                         return;
                     case 7:
                       long integerPart=0;
                       double sum=0, fractionPart=0;
                       System.out.println("Enter the binary value:");
                       String binary=sc.nextLine();  //a case that checks the expression valid or not and gives equivalent Decimal value of enterred binary value
                       if(binary.contains("."))
                       {
                       String [] bArray=binary.split("\\.");
                       if(bArray[0].matches("[01]+")&&bArray[1].matches("[01]+"))
                       {          
                         for(int i=0;i<bArray[0].length();i++)
                         {
                            int length=bArray[0].length();
                            int t =bArray[0].charAt(i)-'0';
                             integerPart+=t*Math.pow(2,(length-1-i));
                         }
                         for(int i=0;i<bArray[1].length();i++)
                         {
                            int t =bArray[1].charAt(i)-'0';
                             fractionPart=t*Math.pow(2,-(i+1))+fractionPart;
                         }
                         sum=integerPart+fractionPart;
                         System.out.println(binary+"="+sum);
                         System.out.println("====================================");
                       }
                       }
                       else if(binary.matches("[01]+"))
                       {
                         for(int i=0;i<binary.length();i++)
                         {
                            int length=binary.length();
                            int t =binary.charAt(i)-'0';
                             integerPart+=t*Math.pow(2,(length-1-i));
                         }
                         System.out.println(binary+"="+integerPart);
                         System.out.println("====================================");
                       }
                       else
                         System.out.println("Invalid binary valu1e!!");
                      break;
                }

        } while (choice != 8);
        System.out.println("\n👋 Thank you for using Calculator!");
        System.out.println("*******************************************************************************************");
    }
}
