class WhileCounter
{
   public void count()
   {
      // initialize the counter
      int counter = 1;

      // display while counter < 11
      while (counter < 11)
      {
         System.out.print(counter + "*");
         counter++;
      }
   }

   public static void main(String[] args)
   {
      WhileCounter c = new WhileCounter();
      c.count();
   }
}
