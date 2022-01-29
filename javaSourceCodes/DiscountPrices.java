/*During a sale at a store, a 10% discount is applied to purchases over $10.00. 
Write a program that asks for the amount of a purchase, then calculates the discounted price. 
The purchase amount will be input in cents (as an integer):*/
import java.io.*;
import java.util.Scanner;

class DiscountPrices
{    
  public static void main (String[] args) throws IOException
  {    
   Scanner scan = new Scanner( System.in );
   int OriPrice;
   int FinPrice;
      
   System.out.println( "Enter amount of purchases(in cents): ");
    OriPrice = scan.nextInt();
    FinPrice = (int) (OriPrice*0.9);
      if(OriPrice<=1000)
          System.out.println( "Your price is :"+OriPrice);
      else 
        {
         System.out.println("Your discounted price (cents) is: "+FinPrice);
        }
        System.out.println("THANK FOR YOUR PURCHASES!");
        System.out.println("*****TINPA STORE MMXX*****");
  }
}
