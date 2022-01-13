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

   public void move()
   {
      xLocation += xVelocity;
      yLocation += yVelocity;
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
/*------------******-------************************-----------------------------*/

public class BallBouncerApplet extends JApplet
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
      // erase the old
      myBall.erase(g);

      // let the first part of the 'physics' happen
      myBall.move();

   // bounce it off some imaginary walls
   // here are the right and left walls
   if ( (myBall.xLocation > 350) || (myBall.xLocation < 50) )
   {
      myBall.xVelocity = -myBall.xVelocity;
   }

   // here are the top and bottom walls
   if ( (myBall.yLocation > 250) || (myBall.yLocation < 50) )
   {
      myBall.yVelocity = -myBall.yVelocity;
   }

      // now that we've moved it, draw it
      myBall.draw(g);
   }
}
