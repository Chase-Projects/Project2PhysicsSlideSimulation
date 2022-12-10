import java.awt.Dimension;
import java.awt.Graphics;
import java.time.ZonedDateTime;

public class Background extends Thread
{
	private BackgroundPanel clockPanel;
	private int locationX = 100, locationY = 100;
	private int directionX = 1, directionY = 1;
	private int clockHeight;
	private int clockWidth;
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
		locationX += directionX;
		locationY += directionY;

		// TODO: if ball hits left wall or the right wall, change the x
		// direction
		if (locationX == leftWall || locationX == rightWall)
		{
			directionX *= -1;

		}

		// TODO: if ball hits top or bottom walls, change the y direction
		if (locationY == topWall || locationY == bottomWall)
		{
			directionY *= -1;

		}

	}

	public String getTime()
	{
		ZonedDateTime time = ZonedDateTime.now();
		String timeString = time.getMonthValue() + "-" + time.getDayOfMonth()
				+ "-" + time.getYear() + " " + time.getHour() + ":"
				+ time.getMinute() + ":"
				+ String.format("%02d", time.getSecond());
		return timeString;
	}

	public void run()
	{
		for (int i = 0; i < 1000; i++)
		{
			move();
			clockPanel.repaint();
			try
			{
				Thread.sleep(10);
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


