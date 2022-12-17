import java.awt.Dimension;
import java.awt.Graphics;
import java.time.ZonedDateTime;

public class Background extends Thread
{
	private BackgroundPanel clockPanel;
	private int locationX = 50, locationY = 100;
	private int directionX, directionY;
	private int clockHeight;
	private int clockWidth;
	
	
	
	
	//New things to add
	private final int floor = 220;
	private int SlideHeight;
	private double SlideLength;
	private int angle;
	private final double gravity = 0.9;
	private double acceleration = 1;
	
	
	
	
	
	//
	//private Dimension sizeOfAnimation;
	
//	@Override
//	public Dimension setPerferredSize() {
//			
//		Dimension sizeOfAnimation = new Dimension(200, 200);
//		return sizeOfAnimation;
//	}
//	
//
//	public Dimension setPerferredSize(Dimension sizeOfAnimation) {
//		
//		return sizeOfAnimation;
//	}
	
	
	
	
	public Background(BackgroundPanel clockPanel)
	{
		this.clockPanel = clockPanel;
	}
	
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public int getAngle() {
		return angle;
	}
	
	public Background(BackgroundPanel clockPanel,int height, double length, int angle)
	{
		this.clockPanel = clockPanel;
		
		this.SlideHeight = height;
		this.SlideLength = length;
		this.angle = angle;
	}

	
	

	
	public int getFloor() {
		
		return floor;
	}
	
	public int getSlideHeight() {
		 

  return SlideHeight;

	}
	
	public double getSlideLength() {
		return SlideLength;
	}
	
	
	
	public void setSlideHeight(int height) {
		

		this.SlideHeight = height;
		directionY = (int)(SlideHeight * acceleration);
		locationY = floor - (10 * SlideHeight);

		
	}
	
	public void setSlideLength(double length) {
		

		this.SlideLength = length;
		directionX = (int)Math.round(SlideLength * acceleration);

		
	}
	
	private void setClockHeight(int height)
	{
		clockHeight = height;
	}

	private void setClockWidth(int width)
	{
		clockWidth = width;
	}

	public void updateClockSize(Graphics g)
	{
		// calculate the clock height and width
		clockHeight = g.getFontMetrics().getAscent();
		clockWidth = g.getFontMetrics().stringWidth(getTime());
	}

	
	public void setX(int x )
	{
		
		 locationX = x;
	}

	public void setY(int y)
	{
		 locationY = y;
	}

	

	public int getX()
	{
		
		return locationX;
	}

	public int getY()
	{
		return locationY;
	}

	public void move()
	{

		// define the boundaries
		int rightWall = clockPanel.getWidth() - clockWidth;
		int leftWall = 0;
		int topWall = 0 + clockHeight;
		int bottomWall = clockPanel.getHeight();

		// TODO: Calculate a new location (Hint: the ball should move by
		// directionX and directionY)
		

		
		if(locationX <=  rightWall && locationY <= floor ) {
			
			locationX += directionX;
			locationY += directionY;

			
		}

		
		
		
		// TODO: if ball hits left wall or the right wall, change the x
		// direction
//		if (locationX == leftWall || locationX == rightWall)
//		{
//			directionX *= -1;
//
//		}
//
//		// TODO: if ball hits top or bottom walls, change the y direction
//		if (locationY == topWall || locationY == bottomWall)
//		{
//			directionY *= -1;
//
//		}

	}
	
	

	public String getTime()
	{
		String timeString = "Speed = " + (directionX + directionY) + " m/s";
		
//		ZonedDateTime time = ZonedDateTime.now();
//		String timeString = time.getMonthValue() + "-" + time.getDayOfMonth()
//				+ "-" + time.getYear() + " " + time.getHour() + ":"
//				+ time.getMinute() + ":"
//				+ String.format("%02d", time.getSecond());
		return timeString;
	}

	public void run()
	{
		while(true) {
			move();
			clockPanel.repaint();

			try
			{
				//acceleration += 0;
//System.out.println(acceleration);

				Thread.sleep(100);
				// while sleeping the clock is running
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();

			}
		}
		// TODO: Forever, move the clock, repaint clockPanel, then sleep for
		// some amount of time

	}
	

}


