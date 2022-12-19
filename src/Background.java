import java.awt.Dimension;
import java.awt.Graphics;
import java.time.ZonedDateTime;

public class Background extends Thread
{
	private BackgroundPanel slidePanel;
	private int locationX = 50, locationY = 100;
	private int directionX, directionY;
	private int speedHeight;
	private int speedWidth;

	private final int floor = 220;
	private int SlideHeight;
	private double SlideLength;
	private int angle;
//	private final double gravity = 0.9;
	private double acceleration = 1;

	/**
	 * 
	 * @param slidePanel
	 */
	public Background(BackgroundPanel slidePanel)
	{
		this.slidePanel = slidePanel;
	}
	
	
//	/**
//	 * 
//	 * @param slide Panel, height, length
//	 * This sets the angle value used in length calculations	
//	 */
//	public Background(BackgroundPanel slidePanel, int height, double length,
//			int angle)
//	{
//		this.slidePanel = slidePanel;
//		this.SlideHeight = height;
//		this.SlideLength = length;
//		this.angle = angle;
//	}
	
	/**
	 * 
	 * @param angle
	 * This sets the angle value used in length calculations	
	 */
	public void setAngle(int angle)
	{
		this.angle = angle;
	}

	/**
	 * 
	 * returns the angle
	 */
	public int getAngle()
	{
		return angle;
	}

	/**
	 * 
	 * returns the floor value	
	 */
	public int getFloor()
	{

		return floor;
	}

	/**
	 * 
	 * returns the height of the slide
	 */
	public int getSlideHeight()
	{

		return SlideHeight;

	}

	
	public double getSlideLength()
	{
		return SlideLength;
	}

	public void setSlideHeight(int height)
	{

		this.SlideHeight = height;
		directionY = (int) (SlideHeight * acceleration);
		locationY = floor - (10 * SlideHeight);

	}

	public void setSlideLength(double length)
	{

		this.SlideLength = length;
		directionX = (int) Math.round(SlideLength * acceleration);

	}

	private void setslideHeight(int height)
	{
		speedHeight = height;
	}

	private void setslideWidth(int width)
	{
		speedWidth = width;
	}

	public void updateSpeedSize(Graphics g)
	{
		// calculate the clock height and width
		speedHeight = g.getFontMetrics().getAscent();
		speedWidth = g.getFontMetrics().stringWidth(getTime());
	}

	public void setX(int x)
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
		int rightWall = slidePanel.getWidth() - speedWidth;
//		int leftWall = 0;
//		int topWall = 0 + speedHeight;
//		int bottomWall = slidePanel.getHeight();

	

		if (locationX <= rightWall && locationY <= floor)
		{

			locationX += directionX;
			locationY += directionY;

		}

	}

	public String getTime()
	{
		String timeString = "Speed = " + (directionX + directionY) + " m/s";

		// ZonedDateTime time = ZonedDateTime.now();
		// String timeString = time.getMonthValue() + "-" + time.getDayOfMonth()
		// + "-" + time.getYear() + " " + time.getHour() + ":"
		// + time.getMinute() + ":"
		// + String.format("%02d", time.getSecond());
		return timeString;
	}

	public void run()
	{
		while (true)
		{
			move();
			slidePanel.repaint();

			try
			{
				// acceleration += 0;
				// System.out.println(acceleration);

				Thread.sleep(100);
				// while sleeping the clock is running
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();

			}
		}
		// TODO: Forever, move the clock, repaint slidePanel, then sleep for
		// some amount of time

	}

}
