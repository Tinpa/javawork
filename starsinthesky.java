import java.util.Scanner;
public class starsinthesky
{  
  public static void main (String[] args) 
  {
    Scanner scan = new Scanner( System.in );   
    int answer;  
    String stars="*";  
    System.out.print("How many lines of stars do you want: ");   
    answer = scan.nextInt();       
    int i = 1;  int j = 1;   
    while (i<=answer)  
     {
      while (j==i)     
      {
        System.out.println(stars);
        stars = stars + "*";
        j++;        
      }   
    i++;    
    }  
  }
}
