 /*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ class Ball {
/*  7 */   private int radius = 15;
/*    */   
/*  8 */   private int xLocation = 100;
/*    */   
/*  9 */   private int yLocation = 150;
/*    */   
/* 10 */   protected int xVelocity = 9;
/*    */   
/* 11 */   protected int yVelocity = 4;
/*    */   
/* 12 */   protected Color ballColor = Color.red;
/*    */   
/*    */   public Ball() {}
/*    */   
/*    */   public Ball(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 25 */     this.radius = paramInt1;
/* 26 */     this.xLocation = paramInt2;
/* 27 */     this.yLocation = paramInt3;
/* 28 */     this.xVelocity = paramInt4;
/* 29 */     this.yVelocity = paramInt5;
/*    */   }
/*    */   
/*    */   public void move(Graphics paramGraphics) {
/* 34 */     erase(paramGraphics);
/* 35 */     this.xLocation += this.xVelocity;
/* 36 */     this.yLocation += this.yVelocity;
/*    */   }
/*    */   
/*    */   public void bounceOffVertical(double paramDouble) {
/* 43 */     this.xVelocity = (int)-(this.xVelocity * paramDouble);
/* 44 */     System.out.println("bov e: " + paramDouble + " xv: " + this.xVelocity);
/*    */   }
/*    */   
/*    */   public void bounceOffVertical() {
/* 48 */     bounceOffVertical(1.0D);
/*    */   }
/*    */   
/*    */   public void bounceOffHorizontal(double paramDouble) {
/* 52 */     this.yVelocity = (int)-(this.yVelocity * paramDouble);
/* 53 */     System.out.println("boh e: " + paramDouble + " yv: " + this.yVelocity);
/*    */   }
/*    */   
/*    */   public void bounceOffHorizontal() {
/* 57 */     bounceOffHorizontal(1.0D);
/*    */   }
/*    */   
/*    */   public int getX() {
/* 59 */     return this.xLocation;
/*    */   }
/*    */   
/*    */   public int getY() {
/* 60 */     return this.yLocation;
/*    */   }
/*    */   
/*    */   public void setX(int paramInt) {
/* 61 */     this.xLocation = paramInt;
/*    */   }
/*    */   
/*    */   public void setY(int paramInt) {
/* 62 */     this.yLocation = paramInt;
/*    */   }
/*    */   
/*    */   public int getRadius() {
/* 63 */     return this.radius;
/*    */   }
/*    */   
/*    */   public void draw(Graphics paramGraphics) {
/* 67 */     paramGraphics.setColor(this.ballColor);
/* 68 */     paramGraphics.fillOval(this.xLocation - this.radius, this.yLocation - this.radius, 2 * this.radius, 2 * this.radius);
/*    */   }
/*    */   
/*    */   public void erase(Graphics paramGraphics) {
/* 73 */     paramGraphics.setColor(Color.white);
/* 74 */     paramGraphics.fillOval(this.xLocation - this.radius, this.yLocation - this.radius, 2 * this.radius, 2 * this.radius);
/*    */   }
/*    */ }


/* Location:              /Users/student/Desktop/javawork/!/Ball.class
 * Java compiler version: 9 (53.0)
 * JD-Core Version:       1.1.3
 */
