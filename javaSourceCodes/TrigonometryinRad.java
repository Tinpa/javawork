import java.io.*;
import java.util.Scanner;

class TrigonometryinRad

{
public static void main (String[] args) throws IOException
    {
        
        double valuex;
        Scanner scan= new Scanner(System.in);
    System.out.print("input a degree ");

    double degrees= scan.nextDouble();
    
double rad;
double sinx, cosx;
rad = degrees * Math.PI/180;
    sinx=Math.sin(rad);
    cosx=Math.cos(rad);
    
    double sum;
    sum=sinx*sinx+cosx*cosx;

    System.out.println("sine: " + sinx + " cosine: " + cosx + " sum: " + sum );

    }

}
/*
©   TINPA
2013-2019
*/
