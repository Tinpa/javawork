import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Ball
{
   private int radius = 15;
   private int xLocation = 100;
   private int yLocation = 150;
   protected int xVelocity = 9;
   protected int yVelocity = 4;
   protected Color ballColor = Color.red;

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
      //draw happens after move and after collision detection
      //draw(g);
   }

   public void bounceOffVertical(double elasticity)
   {
      xVelocity = (int)(-(xVelocity * elasticity));
      System.out.println("bov e: " + elasticity + " xv: " + xVelocity);
   }

   public void bounceOffVertical()
   { bounceOffVertical(1.0); }

   public void bounceOffHorizontal(double elasticity)
   {
      yVelocity = (int)(-(yVelocity * elasticity));
      System.out.println("boh e: " + elasticity + " yv: " + yVelocity);
   }

   public void bounceOffHorizontal()
   { bounceOffHorizontal(1.0); }

   public int getX() { return xLocation; }
   public int getY() { return yLocation; }
   public void setX(int newX) { xLocation = newX; }
   public void setY(int newY) { yLocation= newY; }
   public int getRadius() { return radius; }

   public void draw(Graphics g)
   {
      g.setColor(ballColor);
      g.fillOval(xLocation-radius, yLocation-radius, 2*radius, 2*radius);
   }

   public void erase(Graphics g)
   {
      g.setColor(Color.white);
      g.fillOval(xLocation-radius, yLocation-radius, 2*radius, 2*radius);
   }
}

class DeadBall extends Ball
{
    private double ballElasticity;

    public DeadBall()
    {
        ballElasticity = 0.4;
        ballColor = Color.blue;
    }

    public Color getColor()
    { return ballColor; }

    public void bounceOffVertical(double elasticity)
    { xVelocity = (int)(-(xVelocity * elasticity * ballElasticity)); }

    public void bounceOffHorizontal(double elasticity)
    { yVelocity = (int)(-(yVelocity * elasticity * ballElasticity)); }
}

// Abstract Base Class defines the properties
// and methods of every Wall
abstract class Wall
{
   protected int position;
   protected double elasticity = 1.0;

   public Wall(int wallPosition, double wallElasticity)
   {
       position = wallPosition;
       elasticity = wallElasticity;
   }

    // overloaded constructor allows elasticity
    // to be an optional parameter
   public Wall(int wallPosition)
   { position = wallPosition; }

    // every wall must implement this method
   abstract public boolean bounceIfColliding(Ball b);
}

// Horizontal "wall" (floor or ceiling)
class HWall extends Wall
{
    // derived class calls super class's constructor
    // passing up the parameters
   public HWall(int wallPosition)
   { super(wallPosition); }

   public HWall(int wallPosition, double wallElasticity)
   { super(wallPosition, wallElasticity); }

   public boolean bounceIfColliding(Ball b)
   {
      int topEdge = b.getY() - b.getRadius();
      int bottomEdge = b.getY() + b.getRadius();
      if ((topEdge <= position) && (position <= bottomEdge))
      {
         // make sure the ball isn't interpenetrating the wall
         if (b.getY() > position)
         {
            b.setY(position + b.getRadius());
         }
         else
         {
            b.setY(position - b.getRadius());
         }
         // now bounce
         b.bounceOffHorizontal(1.0);
         return true;
      }
      else
      {
         return false;
      }
   }
}

// This is a vertical wall (left or right)
class VWall extends Wall
{
   public VWall(int wallPosition)
   { super(wallPosition); }

   public VWall(int wallPosition, double wallElasticity)
   { super(wallPosition, wallElasticity); }

   public boolean bounceIfColliding(Ball b)
   {
      int leftEdge = b.getX() - b.getRadius();
      int rightEdge = b.getX() + b.getRadius();
      if ((leftEdge <= position) && (position <= rightEdge))
      {
         // make sure the ball isn't interpenetrating the wall
         if (b.getX() > position)
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

public class BallWithBaseWallClass extends JApplet
{
   Ball ball;

    // create Wall referneces
    // make sure you instantiate
    // concrete derived classes.
   Wall floor = new HWall(300, 0.5);
   Wall ceiling = new HWall(0);
   Wall left = new VWall(0);
   Wall right = new VWall(350);

   public void start()
   {
      if (java.lang.Math.random() > 0.5)    // coin flip
      { ball = new Ball(); }
      else
      { ball = new DeadBall(); }

      Timer timer;
      final int FREQ = 33; // time in mSec between frames
      timer = new Timer(FREQ, new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         { repaint(); }
      });

      timer.start();
   }

   public void paint(Graphics g)
   {
      ball.move(g);

      // polymorphic walls taking
      // polymorphic balls
      floor.bounceIfColliding(ball);
      ceiling.bounceIfColliding(ball);
      left.bounceIfColliding(ball);
      right.bounceIfColliding(ball);

      // now that we've moved it, draw it
      ball.draw(g);
   }
}
