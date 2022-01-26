import java.awt.*;         // for graphics
import javax.swing.*;      // for applet
import java.awt.event.*;   // for mouse events

public class MouseClick extends JApplet implements MouseListener
{
   // initialize to coordinates off the screen
   int myX = -100;
   int myY = -100;

   static final int MY_RADIUS = 10;

   // register the object as a mouse listener at startup
   public void init()
   {
      addMouseListener(this);
   }

   // paint the oval at the current location
   public void paint(Graphics g)
   {
      
      g.setColor(Color.RED);
      g.fillOval(
         myX - MY_RADIUS,
         myY - MY_RADIUS,
         MY_RADIUS * 2,
         MY_RADIUS * 2);
   }

   // In order to listen to a mouse, we have to implement all five of these
   // methods. The only one we care about, however, is mouseClicked.
   public void mouseClicked(MouseEvent e)
   {
      myX = e.getX();
      myY = e.getY();
      repaint();
   }

   // these are not used but have to be here to implement the MouseListener
   public void mouseEntered(MouseEvent e) { }
   public void mouseExited(MouseEvent e) { }
   public void mousePressed(MouseEvent e) { }
   public void mouseReleased(MouseEvent e) { }
}


