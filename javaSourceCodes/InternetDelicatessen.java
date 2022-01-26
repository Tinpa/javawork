
import java.util.Scanner;


class InternetDelicatessen
{
    
  public static void main (String[] args) 
  {
     
Scanner scan = new Scanner( System.in ); 
      //num
      String itemN;
      float price;
      float delivery;
      int YoN;
      
      
      //mainpt
    System.out.println("Enter the item (keep your item-name in one word)");
      
      itemN = scan.next();//in 1
      
    System.out.println();
    System.out.print("Enter the price: ");
      
      price = scan.nextFloat();//in 2
      
    System.out.println();
    System.out.println("Overnight delivery? [ONLY 0(NO) or 1(YES)]");
      
      YoN = scan.nextInt();//in 3
      
      
    if(YoN==0 && price>=10)
     {
        System.out.println();
        System.out.println("Invoice:");
        System.out.print(itemN+": ");
          System.out.println(price);
        System.out.println ("delivery is free for you");
        System.out.println("total: "+ price);
      }
      
      else if(YoN==0 && price<10)
     {
        System.out.println();
        System.out.println("Invoice:");
        System.out.print(itemN+": ");
          System.out.println(price);
    delivery=2;
        System.out.println ("delivery is "+delivery);
        System.out.println("total: "+ (price+delivery));
      }
      
      else if(YoN==1 && price>=10)
     {
          System.out.println();
        System.out.println("Invoice:");
        System.out.print(itemN+": ");
          System.out.println(price);
          delivery=3;
        System.out.println ("delivery is "+delivery);
        System.out.println("total: "+ (price+delivery));
      }
      
      else if(YoN==1 && price<10)
     {
          System.out.println();
        System.out.println("Invoice:");
        System.out.print(itemN+": ");
          System.out.println(price);
          delivery=5;
        System.out.println ("delivery is "+delivery);
        System.out.println("total: "+ (price+delivery));
      }
      
      //error page
      else
      {
          System.out.println ("ERROR HAPPENED");
          System.out.println ("ОШИБКА СЛУЧИЛАСЬ");
          System.out.println ("ERREUR ARRIVÉE");
          System.out.println ("ERROR SUCEDIÓ");
          System.out.println ("FEHLER PASSIERT");
          System.out.println ("حدث خطأ");
          System.out.println ("ERRO ACONTECIDO");
          System.out.println ("错误发生");
          System.out.println ("エラーが発生");
      }
      
      System.out.println();
      System.out.println("---Suport-by-TINPA-SOFTWARE---");
      
  }
}
    
    
    /* 
    You have been asked to write a program for the Sam and Ella Delicatessen. The program takes deli orders from the Internet. It asks for the item, its price in cents, and if express delivery is wanted. The program writes out the order and the charges. Regular delivery for items under $10 is $2.00; for items $10 or more delivery is free. For express delivery add $3.00.

Enter the item: Tuna Salad
Enter the price: 4.50
Overnight delivery (0==no, 1==yes): 1

Invoice:
  Tuna Salad    4.50
  delivery      5.00
  total         9.50
  
  */
