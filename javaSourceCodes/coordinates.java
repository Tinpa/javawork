import java.util.Scanner;
public class coordinates
{  
public static void main (String[] args) 
{   
Scanner scan = new Scanner( System.in );   
int answer1;  
int answer2;
//String stars="*" 
System.out.print("How many lines of stars do you want of x: ");   
answer1 = scan.nextInt();  
System.out.print("How many lines of stars do you want of y: ");
answer2 = scan.nextInt(); 
int i = 0;
int j = 0;   
int k = 0;
while (i<=answer1)  
{    k=j;
while (j<=answer2)  
{          
System.out.println("("+i+","+j+")");

j++;        
}   
j=k;
System.out.println("");
i++;
}  
}
}
