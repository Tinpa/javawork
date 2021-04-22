import java.awt.*;         // for graphics
import javax.swing.*;      // for applet
import java.awt.event.*;   // for mouse events

public class MouseApplet extends JApplet implements MouseListener
{

  private int evenType;
  private int downX;
  private int downY;
  private int upX;
  private int upY;

  public void init()
    {
    addMouseListener(this);
    return;
    }
  public void paint(Graphics g)
        {
            if (evenType==3)
                {
                g.setColor(Color.red);
                g.fillOval(downX-5,downY-5,20,20); 
                }
        
            if(evenType==4)
                {
                g.setColor(Color.blue);
                g.fillRect(downX-5,downY-5,20,20);
                }
        return;
        }
        public void mouseEntered(MouseEvent me)
        {
        return;
        }
    
        public void mouseExited(MouseEvent me)
        {
        return;
        }
    
        public void mousePressed(MouseEvent me)
        {
            downX=me.getX();
            downY=me.getY();
            evenType=3;
            repaint();
            return;
        }
        public void mouseReleased(MouseEvent me) 
        {
            upX=me.getX();
            upY=me.getY();
            evenType=4;
            repaint();
            return;
        }

        public void mouseClicked(MouseEvent me)
        {
        return;
        }

}