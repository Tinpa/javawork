import java.util.Scanner;

class NumberTester
{
  public static void main (String[] args) 
  {
    Scanner scan = new Scanner( System.in );
    int num;

    System.out.println("Enter an integer:");
    num = scan.nextInt();
    
    if ( num < 0 )                
      System.out.println("The number " + num + " is negative"); 
    else
      System.out.println("The number " + num + " is zero or positive"); 
    
    System.out.println("Good-bye for now"); 
  }
}
