import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Ball
{
   private final int RADIUS = 15;
   public int xLocation = 100;
   public int yLocation = 150;
   public int xVelocity = 3;
   public int yVelocity = 1;

   public void move(Graphics g)
   {
      erase(g);
      xLocation += xVelocity;
      yLocation += yVelocity;
      draw(g);
   }

   public void draw(Graphics g)
   {
      g.setColor(Color.red);

      // We want the position of the ball to be
      // its center, so we have to compensate by
      // subtracting the radius.
      g.fillOval(
         xLocation - RADIUS,
         yLocation - RADIUS,
         RADIUS * 2,
         RADIUS * 2);
   }

   public void erase(Graphics g)
   {
      // erase the old ball
      g.setColor(Color.white);
      g.fillOval(
         xLocation - RADIUS,
         yLocation - RADIUS,
         RADIUS * 2,
         RADIUS * 2);
   }
}// end Ball class

public class BallBouncerWithEncapsulatedBall extends JApplet
{
   Ball myBall = new Ball();

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
      });

      timer.start();
   }

   public void paint(Graphics g)
   {
      //erase, move and draw in one simple method call
      myBall.move(g);

      // bounce it off some imaginary walls
      // here's the right and left hand wall
      if ( (myBall.xLocation > 350) || (myBall.xLocation < 50) )
      {
         myBall.xVelocity = -myBall.xVelocity;
      }

    // here’s the top and bottom walls
      if ( (myBall.yLocation > 250) || (myBall.yLocation < 50) )
      {
         myBall.yVelocity = -myBall.yVelocity;
      } 
   }
}
