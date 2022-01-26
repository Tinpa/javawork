import java.util.Scanner;

public class LoopWhile
{
public static void main (String[] args)
{
Scanner scan = new Scanner( System.in );
    int counter;
System.out.println("Enter a number:"); 
counter = scan.nextInt(); 

while (counter < 10000)
{
System.out.println("Counter is: " + counter); 
counter++;
}
}
}
