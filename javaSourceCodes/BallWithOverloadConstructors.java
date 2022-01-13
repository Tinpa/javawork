import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Ball
{
    // private state variables
   private int radius = 15;
   private int xLocation = 100;
   private int yLocation = 150;
   private int xVelocity = 9;
   private int yVelocity = 4;

    // default constructor uses current state
   public Ball()
   {
   }

    /* overloaded constructor to allow creation of balls with different sizes at different locations with different starting velocities*/
   
   public Ball(
       int radius,
       int xLocation,
       int yLocation,
       int xVelocity,
       int yVelocity)
   {
      this.radius = radius;
      this.xLocation = xLocation;
      this.yLocation = yLocation;
      this.xVelocity = xVelocity;
      this.yVelocity = yVelocity;
   }

   public void move(Graphics g)
   {
      erase(g);
      xLocation += xVelocity;
      yLocation += yVelocity;
      // draw happens after move and after collision detection
      // draw(g);
   }

    // overloaded to take an elasticity factor
   public void bounceOffVertical(double elasticity)
   {
      // change the sign of xVelocity
      xVelocity = (int)(-(xVelocity * elasticity));
   }

   public void bounceOffVertical()
   {
      // use the overloaded function to do the math
      bounceOffVertical(1.0);
   }

   public void bounceOffHorizontal(double elasticity)
   {
      // change the sign of yVelocity
      yVelocity = (int)(-(yVelocity * elasticity));
   }

   public void bounceOffHorizontal()
   {
      // use the overloaded function to do the math
      bounceOffHorizontal(1.0);
   }

   public int getX()
   {
      return xLocation;
   }

   public int getY()
   {
      return yLocation;
   }

   public void setX(int newX)
   {
      xLocation = newX;
   }

   public void setY(int newY)
   {
      yLocation = newY;
   }

   public int getRadius()
   {
      return radius;
   }

   // We have to take a g parameter because
   // you can only draw on a Graphics context.
   public void draw(Graphics g)
   {
      g.setColor(Color.red);
      g.fillOval(xLocation - radius, yLocation - radius, 2 * radius, 2 * radius);
   }

   public void erase(Graphics g)
   {
      // erase the old ball
      g.setColor(Color.white);
      g.fillOval(xLocation - radius, yLocation - radius, 2 * radius, 2 * radius);
   }
}

// Horizontal "wall" (floor or ceiling).
// When you create a horizontal wall you can set the
// elasticity. This allows you to make the floor "dead."
// Overload the constructor so that the elasticity is
// an optional parameter.
class HWall
{
   private int position;
   private double elasticity = 1.0;

   public HWall(int wallPosition)
   {
      position = wallPosition;
   }

   public HWall(int wallPosition, double wallElasticity)
   {
      position = wallPosition;
      elasticity = wallElasticity;
   }

   public boolean bounceIfColliding(Ball b)
   {
      int topEdge = b.getY() - b.getRadius();
      int bottomEdge = b.getY() + b.getRadius();
      if ((topEdge <= position) && (position <= bottomEdge))
      {
         // make sure the ball isn't interpenetrating the wall
         if ( b.getY() > position )
         {
            b.setY(position + b.getRadius());
         }
         else
         {
            b.setY(position - b.getRadius());
         }
         // now bounce
         b.bounceOffHorizontal(elasticity);
         return true;
      }
      else
      {
         return false;
      }
   }
}

// this is a vertical wall (left or right)
class VWall
{
   private int position;
   public VWall(int wallPosition)
   {
      position = wallPosition;
   }

   public boolean bounceIfColliding(Ball b)
   {
      int leftEdge = b.getX() - b.getRadius();
      int rightEdge = b.getX() + b.getRadius();
      if ( (leftEdge <= position) && (position <= rightEdge) )
      {
         // make sure the ball isn't interpenetrating the wall
         if ( b.getX() > position )
         {
            b.setX(position + b.getRadius());
         }
         else
         {
            b.setX(position - b.getRadius());
         }
         // now bounce
         b.bounceOffVertical();
         return true;
      }
      else
      {
         return false;
      }
   }
}

public class BallWithOverloadConstructors extends JApplet
{
   Ball ball1 = new Ball();

   final int radius = 20;
   final int startX = 12;
   final int startY = 20;
   final int startXVelocity = 15;
   final int startYVelocity = 15;

   Ball ball2 = new Ball(
        radius,
        startX,
        startY,
        startXVelocity,
        startYVelocity );

   HWall floor = new HWall(300, 0.5);
   HWall ceiling = new HWall(0);
   VWall left = new VWall(0);
   VWall right = new VWall(350);

   public void start()
   {
      System.out.println("firing start...");

      Timer timer;
      final int FREQ = 33; // time in mSec between frames
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
      ball1.move(g);
      ball2.move(g);

      //now we check all the walls
      floor.bounceIfColliding(ball1);
      ceiling.bounceIfColliding(ball1);
      left.bounceIfColliding(ball1);
      right.bounceIfColliding(ball1);

      floor.bounceIfColliding(ball2);
      ceiling.bounceIfColliding(ball2);
      left.bounceIfColliding(ball2);
      right.bounceIfColliding(ball2);

      // now that we've moved it, draw it
      ball1.draw(g);
      ball2.draw(g);
   }
}
