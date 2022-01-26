import java.io.*;
class NamePlay
{
  public static void main (String[] args) throws IOException
  {
    BufferedReader stdin =
      new BufferedReader (new InputStreamReader(System.in));
 
    String inData1, inData2;
    int     num2;    // declare two int variables

    System.out.println("Enter name: ");
    inData1 = stdin.readLine();
    System.out.println("How many times to display: ");
    inData2 = stdin.readLine();
    num2    = Integer.parseInt( inData2 );
   
    int counter;
    counter = 1;
   
    while (counter <= num2 )
    {
   
    System.out.println(inData1);
        counter=counter+1;
    }
   
  }
}
