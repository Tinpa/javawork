 import java.awt.Color;
 import java.awt.Graphics;
 
class Ball {
 private int radius = 15;
   private int xLocation = 100;
  private int yLocation = 150;
  protected int xVelocity = 9;
 protected int yVelocity = 4;
   protected Color ballColor = Color.red;
   public Ball() {}
   public Ball(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    this.radius = paramInt1;
     this.xLocation = paramInt2;
     this.yLocation = paramInt3;
     this.xVelocity = paramInt4;
     this.yVelocity = paramInt5;
   }
   public void move(Graphics paramGraphics) {
     erase(paramGraphics);
    this.xLocation += this.xVelocity;
    this.yLocation += this.yVelocity;
   }
   
   public void bounceOffVertical(double paramDouble) {
     this.xVelocity = (int)-(this.xVelocity * paramDouble);
  System.out.println("bov e: " + paramDouble + " xv: " + this.xVelocity);
  }
  
  public void bounceOffVertical() {
     bounceOffVertical(1.0D);
  }
  
   public void bounceOffHorizontal(double paramDouble) {
    this.yVelocity = (int)-(this.yVelocity * paramDouble);
    System.out.println("boh e: " + paramDouble + " yv: " + this.yVelocity);
 }
  public void bounceOffHorizontal() {
    bounceOffHorizontal(1.0D);
  }
   public int getX() {
     return this.xLocation;
   }
   public int getY() {
    return this.yLocation;
   }
  
  public void setX(int paramInt) {
     this.xLocation = paramInt;
  }
   public void setY(int paramInt) {
this.yLocation = paramInt;
  }

   public int getRadius() {
    return this.radius;
  }
  public void draw(Graphics paramGraphics) {
    paramGraphics.setColor(this.ballColor);
    paramGraphics.fillOval(this.xLocation - this.radius, this.yLocation - this.radius, 2 * this.radius, 2 * this.radius);
} 
   public void erase(Graphics paramGraphics) {
     paramGraphics.setColor(Color.white);
     paramGraphics.fillOval(this.xLocation - this.radius, this.yLocation - this.radius, 2 * this.radius, 2 * this.radius);
   }
 }

