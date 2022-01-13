import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// base class is unchanged from previous version
class Ball
{
   private int radius = 15;
   private int xLocation = 100;
   private int yLocation = 150;
   protected int xVelocity = 9;
   protected int yVelocity = 4;

   public Ball()
   {
   }

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
   }

   public void bounceOffVertical(double elasticity)
   { xVelocity = (int)(-(xVelocity * elasticity)); }

   public void bounceOffVertical()
   { bounceOffVertical(1.0); }

   public void bounceOffHorizontal(double elasticity)
   { yVelocity = (int)(-(yVelocity * elasticity)); }

   public void bounceOffHorizontal()
   { bounceOffHorizontal(1.0); }

   public int getX() { return xLocation; }
   public int getY() { return yLocation; }
   public void setX(int newX) { xLocation = newX; }
   public void setY(int newY) { yLocation= newY; }
   public int getRadius() { return radius; }

   public void draw(Graphics g)
   {
      g.setColor(Color.red);
      g.fillOval(xLocation-radius, yLocation-radius, 2*radius, 2*radius);
   }

   public void erase(Graphics g)
   {
      g.setColor(Color.white);
      g.fillOval(xLocation-radius, yLocation-radius, 2*radius, 2*radius);
   }
}

// DeadBall is a new class that extends Ball
class DeadBall extends Ball
{
    // Each DeadBall manages its own elasticity.
    // As the ball bounces, it loses speed
    // based on its elasticity.
    private double ballElasticity;

    public DeadBall()
    {
        // 70% elasticity implies
        // each bounce loses 30% of speed
        ballElasticity = 0.7;
    }

    // override the bounceOffVertical method to use
    // the ball's elasticity
    public void bounceOffVertical(double elasticity)
    {
        // change the sign of xVelocity
        xVelocity = (int)(-(xVelocity * elasticity * ballElasticity));
    }

    // override the bounceOffHorizontal method to use
    // the ball's elasticity
    public void bounceOffHorizontal(double elasticity)
    {
        // change the sign of yVelocity
        yVelocity = (int)(-(yVelocity * elasticity * ballElasticity));
    }
}


class HWall
{
   private int position;
   private double elasticity = 1.0;

   public HWall(int wallPosition)
   { position = wallPosition; }

   public HWall(int wallPosition, double wallElasticity)
   {
      position = wallPosition;
      elasticity = wallElasticity;
   }

   // this method is unchanged and will take
   // either a Ball (base class) or a
   // DeadBall (derived class)
   public boolean bounceIfColliding(Ball b)
   {
      int topEdge = b.getY() - b.getRadius();
      int bottomEdge = b.getY() + b.getRadius();
      if ( (topEdge <= position) && (position <= bottomEdge) )
      {
         if ( b.getY() > position )
         { b.setY(position + b.getRadius()); }
         else
         { b.setY(position - b.getRadius()); }
         b.bounceOffHorizontal(elasticity);
         return true;
      }
      else
      { return false; }
   }
}

class VWall
{
   private int position;
   public VWall(int wallPosition)
   { position = wallPosition; }

    // this method is unchanged and will take
    // either a Ball (base class) or a
    // DeadBall (derived class)
   public boolean bounceIfColliding(Ball b)
   {
      int leftEdge = b.getX() - b.getRadius();
      int rightEdge = b.getX() + b.getRadius();
      if ( (leftEdge <= position) && (position <= rightEdge) )
      {
         if ( b.getX() > position )
         { b.setX(position + b.getRadius()); }
         else
         { b.setX(position - b.getRadius()); }
         b.bounceOffVertical();
         return true;
      }
      else
      { return false; }
   }
}

public class BallWithInheritance extends JApplet
{
    // create an instance of the base class
   Ball ball1 = new Ball();

   // create an instance of the derived class
   DeadBall ball2 = new DeadBall();

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
         { repaint();}
      });

      timer.start();
   }

   public void paint(Graphics g)
   {
   
      ball1.move(g);
      ball2.move(g);

      floor.bounceIfColliding(ball1);
      ceiling.bounceIfColliding(ball1);
      left.bounceIfColliding(ball1);
      right.bounceIfColliding(ball1);


        // The call to bounceIfColliding
        // is identical. The DeadBall
        // is a Ball.
      floor.bounceIfColliding(ball2);
      ceiling.bounceIfColliding(ball2);
      left.bounceIfColliding(ball2);
      right.bounceIfColliding(ball2);

      // draw both balls
      ball1.draw(g);
      ball2.draw(g);
   }
}
