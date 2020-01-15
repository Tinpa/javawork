import java.io.*;
import java.util.Scanner;

class quadratic
{
    public static void main (String[] args) throws IOException
    {

System.out.println("This program evaluates 3X^2 -8X + 4 at different value");
        
        double valuex;
        Scanner scan= new Scanner(System.in);
        

    
    System.out.print("what number you want to check: "); //sta
    valuex = scan.nextDouble();       //wait 4 input
    
    
System.out.println("The x value is " + valuex);
    double result = 3* valuex* valuex- 8* valuex+ 4;

System.out.println("At x is " + valuex + " The result is " + result );
    }
}