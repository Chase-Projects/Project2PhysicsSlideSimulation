import java.awt.*;
import javax.swing.*;

public class BackgroundPanel extends JPanel
{
   private Color backgroundColor;
   private Color clockColor;
   private Background clock;

   public BackgroundPanel(Color background, Color clockColor)
   {
     this.clockColor = clockColor;
     this.backgroundColor = background;

      clock = new Background(this);
      clock.start();
   }

   @Override
   public void paintComponent(Graphics g)
   {
	   	setBackground(Color.BLUE);
		 g.setColor(backgroundColor);
		 g.fillRect(100,100,100,100);
		 
		 g.setColor(clockColor);
		 g.drawString(clock.getTime(), clock.getX(), clock.getY());
		 
		 g.setColor(clockColor);
		 g.fillRect(120,200,90,70);


	      // TODO: finish drawing the clock - set the color and use drawString
	      g.setFont(new Font("Ink Free", Font.BOLD, 20));  // change the font to one that exists on your computer if needed!
	      clock.updateClockSize(g);
      

   }
   
   
   public static void main(String[] args)
   {
      JFrame clockFrame = new JFrame("Time");
      clockFrame.setSize(500, 500);
      
      BackgroundPanel clockPanel = new BackgroundPanel(Color.PINK, Color.GREEN);
      clockFrame.add(clockPanel);
     
      
      clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      clockFrame.setVisible(true);
   }

}
