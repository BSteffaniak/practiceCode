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
						
						int num = 0;
						
						if (choice.equals("X"))
						{
							num = 2;
						}
						else
						{
							num = 1;
						}
						
						array[y - 1][x - 1] = num;
					}
					else
					{
						boolean chose = false;
						
						for(int i = 0; i < array.length; i++)
						{
							for(int d = 0; d < array[i].length; d++)
							{
								if(!chose && array[i][d] == 0)
								{
									array[i][d] = 1;
									
									chose = true;
								}
							}
						}
					}
					

					if (array[0][0] == array[0][1] && array[0][1] == array[0][2] && array[0][2] != 0)
					{
						endGame = true;
					}
					else if (array[1][0] == array[1][1] && array[1][1] == array[1][2] && array[1][2] != 0)
					{
						endGame = true;
					}
					else if (array[2][0] == array[2][1] && array[2][1] == array[2][2] && array[2][2] != 0)
					{
						endGame = true;
					}	
					else if (array[0][0] == array[1][0] && array[1][0] == array[2][0] && array[2][0] != 0)
					{
						endGame = true;
					}
					else if (array[0][1] == array[1][1] && array[1][1] == array[2][1] && array[2][1] != 0)
					{
						endGame = true;
					}
					else if (array[0][2] == array[1][2] && array[1][2] == array[2][2] && array[2][2] != 0)
					{
						endGame = true;
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
					if (d == 0 && i == 0)
					{
						p.drawCircle(g, 250, 100);
					}
					else if (d == 1 && i == 0)
					{
						p.drawCircle(g, 475, 100);
					}
					else if (d == 2 && i == 0)
					{
						p.drawCircle(g, 725, 100);
					}
					// second row
					else if (d == 0 && i == 1)
					{
						p.drawCircle(g, 250, 285);
					}
					else if (d == 1 && i == 1)
					{
						p.drawCircle(g, 475, 285);
					}
					else if (d == 2 && i == 1)
					{
						p.drawCircle(g, 725, 285);
					}
					// third row
					else if (d == 0 && i == 2)
					{
						p.drawCircle(g, 250, 475);
					}
					else if (d == 1 && i == 2)
					{
						p.drawCircle(g, 475, 475);
					}
					else if (d == 2 && i == 2)
					{
						p.drawCircle(g, 725, 475);
					}
				}
				// this is checking for 
				if(array[i][d] == 2)
				{
					// first row
					if (d == 0 && i == 0)
					{
						p.drawX(g, 250, 100);
					}
					else if (d == 1 && i == 0)
					{
						p.drawX(g, 475, 100);
					}
					else if (d == 2 && i == 0)
					{
						p.drawX(g, 725, 100);
					}
					// second row
					else if (d == 0 && i == 1)
					{
						p.drawX(g, 250, 285);
					}
					else if (d == 1 && i == 1)
					{
						p.drawX(g, 475, 285);
					}
					else if (d == 2 && i == 1)
					{
						p.drawX(g, 725, 285);
					}
					// third row
					else if (d == 0 && i == 2)
					{
						p.drawX(g, 250, 475);
					}
					else if (d == 1 && i == 2)
					{
						p.drawX(g, 475, 475);
					}
					else if (d == 2 && i == 2)
					{
						p.drawX(g, 725, 475);
					}
				}
			}
		}
	}
}