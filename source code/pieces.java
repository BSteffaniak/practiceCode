package Cat;
import java.awt.Graphics;

public class pieces
{
	public void paint(Graphics h)
	{
		
	}
	int guess = getGuess();
	public void drawCircle(Graphics g, int x, int y)
	{
		g.drawOval(x, y, 125, 125);
	}
	public void drawX(Graphics g, int a, int b)
	{
		g.drawLine(a, b, a + 125, b + 125);
		g.drawLine(a, b + 125, a + 125, b);
	}
	
	public int getGuess()
	{
		return (int)(Math.random() * 9);
	}
}