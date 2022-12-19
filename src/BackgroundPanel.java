import java.awt.*;

import javax.swing.*;

public class BackgroundPanel extends JPanel
{
   private Background slide;
   


   public BackgroundPanel(Color background, Color clockColor)
   {

      slide = new Background(this);
      slide.start();
   }

   public void setAngle(int angle) {
	   slide.setAngle(angle);
	   
   }
   
   public void setLength(double length) {
	   slide.setSlideLength(length);
   }
   
   public void setHeight(int height) {
	   slide.setSlideHeight(height);
   }
   
   public void setbaseX() {
	   slide.setX(50);
   }
   public void setbaseY() {
	   slide.setY(slide.getFloor() - (10 * slide.getSlideHeight()));
   }
   @Override
   public void paintComponent(Graphics g)
   {
	    setBackground(Color.BLUE);
		
	   	// Set the ground
	   	 Color ground = new Color(111, 86, 57);
	  	 g.setColor(ground);
		 g.fillRect(0,slide.getFloor(),400,200);
		 
		 //Set the groundMaterial Level
		 g.setColor(Color.GREEN);
		 g.fillRect(0,slide.getFloor(),400,30);
		 
		 //create slide
		 g.setColor(Color.WHITE);
		 g.drawLine(50, slide.getFloor() - (10 * slide.getSlideHeight()) , (int)Math.round(50 + 10 * slide.getSlideLength()
), slide.getFloor());
		 //create ladder
		 g.setColor(Color.WHITE);
		 g.drawLine(50, slide.getFloor() - (10 * slide.getSlideHeight()), 50, slide.getFloor());
		 
		 //Create ball
		 g.setColor(Color.RED);
	     g.fillOval(slide.getX(),slide.getY(), 15, 15);

		 
		 //Create Speed Lister
		 
		 g.setColor(Color.WHITE);
		 g.drawString(slide.getTime(), slide.getX() - 10 , slide.getY() - 10);
		 
		


	      // TODO: finish drawing the clock - set the color and use drawString
	      g.setFont(new Font("Ink Free", Font.BOLD, 20));  // change the font to one that exists on your computer if needed!
	      slide.updateSpeedSize(g);
      

   }
   
   
   public static void main(String[] args)
   {
      JFrame slidePanel = new JFrame("Time");
      slidePanel.setSize(500, 500);
      
      BackgroundPanel slide = new BackgroundPanel(Color.PINK, Color.GREEN);
      slidePanel.add(slide);
     
      
      slidePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      slidePanel.setVisible(true);
   }

}
