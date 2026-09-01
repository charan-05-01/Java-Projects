import java.lang.*;
import java.io.*;
import java.util.*;
class Book
{
  String authorname,bookname;
  double price;
  Book(String name,String book,double p)
  {
    authorname=name;
    bookname=book;
    price=p;
  }
  void display()
  {
     System.out.println("📌📚Book details:::");
     System.out.println("Bookname :"+bookname);
     System.out.println("Author name:"+authorname);
     System.out.println("price:"+price);
  }
 
}
class Library
{
   String book,author;
   double cost;
  Scanner sc=new Scanner(System.in);
  Book getExpensive(Book b1,Book b2)
  {
    if(b1.price>b2.price)
     return b1;
    else
      return b2;
  }
    Book bookDetails()
  {
     System.out.print(" 📚Enter book name :");
     book=sc.nextLine();
     System.out.print(" 🖋️ Enter Authot name:") ;
     author=sc.nextLine();
      while (true) {
            System.out.print("💲Enter Price: ₹");
            cost = sc.nextDouble();
            if (cost > 0) break;
            System.out.println("⚠ Enter valid price!!");
        }
       sc.nextLine(); 
     return new Book(author,book,cost);
  }
}
class Books
{
  
  public static void main(String[]args)
  {
     System.out.println("======================================================");
     Library lib=new Library();
     System.out.println("📘 Enter book 1 details::");
     Book b1 =lib.bookDetails();
     b1.display();
     System.out.println();
          System.out.println("📗 Enter book 2 details::");
      Book b2 =lib.bookDetails();
     b2.display();
     System.out.println();
     Book expensive=lib.getExpensive(b1,b2);
      System.out.println("📘📗The more expensive Book is::");
      expensive.display();
       System.out.println("======================================================");
  }
}
