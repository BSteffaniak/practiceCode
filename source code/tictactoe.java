package Cat;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

import java.awt.Graphics;
import java.awt.Color;

public class tictactoe extends JApplet
{
	int x, y;
	
	boolean endGame;
	boolean playersTurn;
	
	String choice;
	private pieces p;
	private int[][] array;
	
	@Override
	public void init()
	{
		super.init();
		
		p = new pieces();
		array = new int[3][3];
	}
	
	@Override
	public void start()
	{
		super.start();
		choice = "";
		int item  = 2;
		while(!choice.contains("X") && !choice.contains("O"))
		{
			choice = JOptionPane.showInputDialog(null, "Do you want to be X's or O's?");
			choice = choice.toUpperCase();
			
			if (!choice.contains("X") && !choice.contains("O"))
			{
				JOptionPane.showMessageDialog(null, "Please Enter either X or O.");
			}
		}
		
			
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while(endGame == false)
				{
					
					
					if (playersTurn == true)
					{
						String yPlacement= JOptionPane.showInputDialog("What row do you want to place your piece in?");
						String xPlacement = JOptionPane.showInputDialog("What column do you want to place your piece in?");
						x = Integer.valueOf(xPlacement);
						y = Integer.valueOf(yPlacement);
						
					}
					else
					{
						for(int i = 0; i < array.length; i++)
						{
							for(int d = 0; d < array[i].length; d++)
							{
								if(array[i][d] == 0)
								{
									array[i][d] = 1;
								}
							}
						}
					}
					
					playersTurn = !playersTurn;
					
					validate();
					repaint();
				}
			}
		}).start();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.blue);
		// the boards vertical lines
		g.drawLine(400, 100, 400, 600);
		g.drawLine(700, 100, 700, 600);
		// the boards horizontal lines 
		g.drawLine(250, 250, 850, 250);
		g.drawLine(250, 450, 850, 450);
		
		p.paint(g);
		
		
		
		for(int i = 0; i < array.length; i++)
		{
			for(int d = 0; d < array[i].length; d++)
			{
				if(array[i][d] == 1)
				{
					// first row
					if (i == 0 && d == 0)
					{
						p.drawCircle(g, 250, 100);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 475, 100);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 725, 100);
					}
					// second row
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 250, 285);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 475, 285);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 725, 285);
					}
					// third row
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 250, 475);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 475, 475);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 725, 475);
					}
				}
				// this is checking for 
				if(array[i][d] == 2)
				{
					// first row
					if (i == 0 && d == 0)
					{
						p.drawCircle(g, 250, 100);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 475, 100);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 725, 100);
					}
					// second row
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 250, 285);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 475, 285);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 725, 285);
					}
					// third row
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 250, 475);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 475, 475);
					}
					else if (i == 0 && d == 0)
					{
						p.drawCircle(g, 725, 475);
					}
				}
			}
			//while(array[i][d] )
			{
	
			}
		}
	}
}