import java.util.Scanner; //says to use the Scanner class from the package java.util.

class CircleArea


{
  public static void main (String[] args)
  
  
  { 
    Scanner scan = new Scanner( System.in );
    int radius;
      double areac; // declare two int variables 
      

    System.out.print("Enter a number for radius:");
    radius = scan.nextInt();
    areac = radius * radius * Math.PI ;  // compute the area 

    System.out.println("if the radius of circle is " + radius + " and the area of the circle is " + areac);
  }
}

/*Math.PI

©Tinpa
*/
