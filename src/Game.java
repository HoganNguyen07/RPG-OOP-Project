import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import display.Display;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import states.GameState;
import states.MenuState;
import states.State;

public class Game implements Runnable
{
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	//States
	private State gameState;
	private State menuState;
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() // Initialize all the Game's Graphics
	{
		display = new Display(title, width, height);
		Assets.init();
		gameState = new GameState();
		menuState = new MenuState();
		State.setState(gameState);
	}
	

	
	private void tick() // Update everything
	{
		if(State.getState() != null)
		{
			State.getState().tick();
		}
	} 
	
	private void render() // Render everything on the Screen
	{
		bs = display.getCanvas().getBufferStrategy(); // Draw Buffer on the Canvas
		if(bs == null)// Create new Buffer if we haven't got it Before 
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		 
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		init();
		
		int fps = 60; // The amount of Time we want to call tick() and render() method per second
		double timePerTick = 1000000000 / fps;// The maximum amount of time we want tick() and render() method to execute
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1) 
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				System.out.println("Ticks ans Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public synchronized void start() // Start up Thread
	{
		if(running)
			return;
		running  = true;
		thread = new Thread(this);
		thread.start(); // Call run method
	}
	
	public synchronized void stop() // Stop Thread
	{
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
