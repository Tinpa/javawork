// package HW;

/*

    Very good.  Look for comments marked by xxx

*/
public class HW4 {
    public static void main(String[]  args) {
    int RainfallforApril = 12;
    int RainfallforMay = 14;
    int RainfallforJune = 8;

    // xxx what happens if the values of the above varialbes   change. 
    // double Value = (12+14+8)/3.0;
    
    // xxx correction  
    double Value = (RainfallforApril + RainfallforMay + RainfallforJune )/3.0;

    System.out.println( "Rainfall for April: " + '\t' + RainfallforApril);
    System.out.println( "Rainfall for May: " + '\t' + RainfallforMay);
    System.out.println( "Rainfall for June: " + '\t' + RainfallforJune);
    System.out.println( "Average rainfall: " + '\t' + Value);
        
    }
}

// If the "beginner's error" was not putting in the line of code for the main method
// OR not putting in a floating point value in for calculating the average
// then I did not fall victim to the "beginner's error".`k


/*

Exercise 1 — Average Rain Fall

Write a program that averages the rain fall for three months, April, May, and June. 

Declare and initialize a variable to the rain fall for each month. 
Compute the average, and write out the results, something like:

Rainfall for April:  12
Rainfall for May  :  14
Rainfall for June:   8
Average rainfall:    11.333333

To get the numerical values to line up use the tabulation character '\t' 
as part of the character string in the output statements. 

Check that your program prints the correct results. 

There is a beginner's error lurking in this program too! Did you fall victim to it?


*/
