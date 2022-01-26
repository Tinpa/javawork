import java.io.*;
class Numbers
{
  public static void main (String[] args) throws IOException
  {
    BufferedReader stdin =
      new BufferedReader (new InputStreamReader(System.in));
 
    String inData1, inData2;
    int    num1, num2;    // declare two int variables

    System.out.println("Enter Start:");
    inData1 = stdin.readLine();
    num1    = Integer.parseInt( inData1 );
    System.out.println("Enter End:");
    inData2 = stdin.readLine();
    num2    = Integer.parseInt( inData2 );
   
    int counter;
    counter = num1;
   
    while (counter >= num1 && counter <= num2 )
    {
   
    System.out.println(counter);
        counter=counter+1;
    }
   
  }
}
