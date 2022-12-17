import java.awt.*;

import javax.swing.*;

public class BackgroundPanel extends JPanel
{
   private Color backgroundColor;
   private Color clockColor;
   private Background clock;
   private Color colorTestForRectangle;
   


   public BackgroundPanel(Color background, Color clockColor)
   {
     this.clockColor = clockColor;
     this.backgroundColor = background;

      clock = new Background(this);
      clock.start();
   }

   public void setAngle(int angle) {
	   clock.setAngle(angle);
	   
   }
   
   public void setNewColor(Color colorTestForRectangle) {
	   
	   this.colorTestForRectangle = colorTestForRectangle;
   }
   
   public void setLength(double length) {
	   clock.setSlideLength(length);
   }
   
   public void setHeight(int height) {
	   clock.setSlideHeight(height);
   }
   
   public void setbaseX() {
	   clock.setX(50);
   }
   public void setbaseY() {
	   clock.setY(clock.getFloor() - (10 * clock.getSlideHeight()));
   }
   @Override
   public void paintComponent(Graphics g)
   {
	    setBackground(Color.BLUE);
		
	   	// Set the ground
	   	 Color ground = new Color(111, 86, 57);
	  	 g.setColor(ground);
		 g.fillRect(0,clock.getFloor(),400,200);
		 
		 //Set the groundMaterial Level
		 g.setColor(Color.GREEN);
		 g.fillRect(0,clock.getFloor(),400,30);
		 
		 //create slide
		 g.setColor(Color.WHITE);
		 g.drawLine(50, clock.getFloor() - (10 * clock.getSlideHeight()) , (int)Math.round(50 + 10 * clock.getSlideLength()
), clock.getFloor());
		 //create ladder
		 g.setColor(Color.WHITE);
		 g.drawLine(50, clock.getFloor() - (10 * clock.getSlideHeight()), 50, clock.getFloor());
		 
		 //Create ball
		 g.setColor(Color.RED);
	     g.fillOval(clock.getX(),clock.getY(), 15, 15);

		 
		 //Create Speed Lister
		 
		 g.setColor(Color.WHITE);
		 g.drawString(clock.getTime(), clock.getX() - 10 , clock.getY() - 10);
		 
		


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
