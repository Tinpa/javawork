import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BallBounceEventsNoActionListener extends JApplet
    // implements ActionListener
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
      timer = new Timer(FREQ, new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            repaint();
         }
      } );

      timer.start();
   }

   public void paint(Graphics g)
   {
      // System.out.print1n("firing paint...");

      // run for a while, but stop eventually
      // for ( int i = 0; i < 20000; i++ )
      // {
         // erase the old ball
         g.setColor(Color.white);
         g.fillOval(x, y, 30, 30);
         
         // move the ball
         x += xVelocity;
         y += yVelocity;

         // Bounce it off some imaginary walls.
         // We use a condition for each wall.
         // Here's the right wall.
         if ( x > 350 )
         {
            xVelocity = -xVelocity;
         }

         // here's the left wall
         if ( x < 50 )
         {
            xVelocity = -xVelocity;
         }

         // We can combine those tests into one.
         // Short-circuit: If the first test succeeds,
         // the second test never happens.
         if ( (y > 250) || (y < 50) )
         {
            yVelocity = -yVelocity;
         }

         // and draw it again
         g.setColor(Color.red);
         g.fillOval(x, y, 30, 30);
      //}   
	 
     }
}

