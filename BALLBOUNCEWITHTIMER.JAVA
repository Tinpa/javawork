import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BallBounceWithTimer extends JApplet
   implements ActionListener
{
   int x = 100;
   int y = 150;
   int xVelocity = 1;
   int yVelocity = 1;


   public void start()
   {
      System.out.println("firing start...");

      Timer timer;
      final int FREQ = 33;
      timer = new Timer(FREQ, this);
      timer.start();
   }

   public void actionPerformed (ActionEvent evt)
   {
      repaint();
   }

   public void paint(Graphics g)
   {

      // run for a while, but stop eventually
      // for ( int i = 0; i < 20000; i++ )
      // {
         // erase the old ball
         g.setColor(Color.white);
         g.fillOval(x, y, 30, 30);
         // move the ball
         x += xVelocity;
         y += yVelocity;

         // the left wall
         if ( x > 350 )
         {
            xVelocity = -xVelocity;
         }

         // the left wall
         if ( x < 50 )
         {
            xVelocity = -xVelocity;
         }

         // The top and bottom walls
         // use short-circuit evaluation.
         // If the first test succeeds, 
         // the second test never happens.
         if ( (y > 250) || (y < 50) )
         {
            yVelocity = -yVelocity;
         }

         // and draw it again
         g.setColor(Color.red);
         g.fillOval (x, y, 30, 30);
         // for ( int j = 0; j < 2000000; j++ )
         //   ;

         //}// end for
     }// end paint method
}// end class


