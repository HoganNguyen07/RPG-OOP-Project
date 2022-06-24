package display;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display 
{
	//Window setup
	private JFrame frame;
		//Setup title, width and height variables for Our Game Frame
	private String title;
	private int width, height;
	//Graphic setup
	private Canvas canvas;
	//Constructor for Display method
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	public void createDisplay()
	{
		frame = new JFrame(title); // Create new Window 
		frame.setSize(width, height); //Setup width and height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Get the Program to stop running when hit the CLOSE button 
		frame.setResizable(false);//Put the Window's size to fixed state
		frame.setLocationRelativeTo(null);//Window appears in the center of the Screen
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		frame.add(canvas);
		frame.pack();//Get Window to fit the canvas's size
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}
