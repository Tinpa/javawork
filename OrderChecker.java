/*A correct order must have at least as many nuts as bolts and at least twice as many washers as blots, otherwise the order has an error.

For an error the program writes out "Check the Order: too few nuts" or "Check the Order: too few washers" as appropriate. Both error messages are written if the order has both errors. If there are no errors the program writes out "Order is OK." In all cases the total price in cents (of the specified number of items) is written out.*/

import java.util.Scanner;


class OrderChecker
{
    
  public static void main (String[] args)
  {
     //         5 cents per bolt | 3 cents per nut | 1 cent per washer
      Scanner scan = new Scanner( System.in );
      int Blt;
      int Nut;
      int Whr;
      int Pce;
      
      System.out.println( "New order for Bolt");
      Blt = scan.nextInt();
      
      System.out.println( "New order for Nut");
      Nut = scan.nextInt();
      
      System.out.println( "New order for Washer"); 
      Whr = scan.nextInt();
      
      
      if(Nut >= Blt && (Whr/2)>=Blt  )
      {System.out.println("Order is OK.");
          Pce = Nut*3+Blt*5+Whr*1;
          System.out.println( "Total cost: "+Pce);
      }
      else if(Nut< Blt && (Whr/2)>=Blt)
    {
       Pce = Nut*3+Blt*5+Whr*1;
       System.out.println("Check the Order: too few nuts.");
       System.out.println("Total cost: "+Pce);   
    }
      else if (Nut>= Blt && (Whr/2)<Blt)
      {
          Pce = Nut*3+Blt*5+Whr*1;
       System.out.println("Check the Order: too few washers.");
       System.out.println("Total cost: "+Pce); 
      }

      else if(Nut < Blt && (Whr/2)<Blt )
      {
          Pce = Nut*3+Blt*5+Whr*1;
       System.out.println("Check the Order: too few washers.");
       System.out.println("Check the Order: too few nuts.");
       System.out.println("Total cost: "+Pce);
          
      }
      
      System.out.println(" ");
    System.out.println("*****TINPA SOFTWARE MMXX*****");
    }
    
}

