import java.awt.*;
import javax.swing.*;

public class BackgroundPanel extends JPanel
{
   private Color background;
   private Color clockColor;
   private Background clock;

   public BackgroundPanel(Color background, Color clockColor)
   {
      this.background = background;
      this.clockColor = clockColor;
      clock = new Background(this);
      clock.start();
   }

   @Override
   public void paintComponent(Graphics g)
   {
      // TODO: draw the background - set the color and use fillRect
	 g.setColor(background);
	 g.fillRect(100,100,100,100);
	 
	 g.drawString(clock.getTime(), clock.getX(), clock.getY());
	 g.setColor(clockColor);


      // TODO: finish drawing the clock - set the color and use drawString
      g.setFont(new Font("Ink Free", Font.BOLD, 20));  // change the font to one that exists on your computer if needed!
      clock.updateClockSize(g);
      
      

   }
   
   public static void main(String[] args)
   {
      JFrame clockFrame = new JFrame("Time");
      clockFrame.setSize(500, 500);
      BackgroundPanel clockPanel = new BackgroundPanel(Color.BLACK, Color.GREEN);
      clockFrame.add(clockPanel);
      clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      clockFrame.setVisible(true);
   }

}
