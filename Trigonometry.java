/*
To compute the sine of a double precision value use this method:

Math.sin( value )
The value is in radians (not degrees.) The cosine is computed using

Math.cos( value )
Again, value is in radians. Write a program that:

Computes the sine of 0.5236 radians and saves it in a variable.
Computes the cosine of 0.5236 radians and saves it in another variable.
Computes the square of each those two values (use the variables), adds the two squares, and saves the result (in a third variable.)
Writes out the three variables.
The output statement should be something like:

System.out.println("sine: " + sinx + " cosine: " + cosx + " sum: " + sum );
Try a few other values besides 0.5236.
*/

class Trigonometry

{
public static void main (String[] args)
    {

double sinx, cosx;
    
    sinx=Math.sin(0.5236);
    cosx=Math.cos(0.5236);
    
    double sum;
    sum=sinx*sinx+cosx*cosx;

    System.out.println("sine: " + sinx + " cosine: " + cosx + " sum: " + sum );

    }

}