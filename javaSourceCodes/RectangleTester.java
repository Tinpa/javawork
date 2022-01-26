class Rectangle
{
    private double width = 10.0;
    private double length = 15.0;

    public Rectangle()
    {
        // do nothing, defaults are fine
    }

    public Rectangle(double width, double length)
    {
        this.width = width;
        this.length = length;
    }

    // create square given just one side
    public Rectangle(double side)
    {
        length = width = side;
    }

    public double getWidth() { return width; }
    public double getLength() { return length; }
    public double getPerim() { return 2 * width + 2 * length; }
    public double getArea() { return width * length; }

}

class RectangleTester
{

   // the tester program
   public static void main(String[] args)
   {
       Rectangle r1 = new Rectangle();
       System.out.println("r1: " + r1.getWidth() + " x " + r1.getLength() +
            "  Perim: " + r1.getPerim() + "  Area: " + r1.getArea() );

       Rectangle r2 = new Rectangle(20.0, 40.0);
       System.out.println("r2: " + r2.getWidth() + " x " + r2.getLength() +
            "  Perim: " + r2.getPerim() + "  Area: " + r2.getArea());


       Rectangle r3 = new Rectangle(10.0);        // pass in one side
       System.out.println("r3: " + r3.getWidth() + " x " + r3.getLength() +
            "  Perim: " + r3.getPerim() + "  Area: " + r3.getArea());

   }

}
