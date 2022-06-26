package states;

import java.awt.Graphics;

import entity.creatures.Player;
import game.Game;
import game.Handler;
import gfx.Assets;
import tiles.Tile;
import world.World;

public class GameState extends State
{
	private Player player;
	private World world;
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler, "res/world/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 0, 0);
	}
	
	@Override
	public void tick() 
	{
		player.tick();
		world.tick();
	}

	@Override
	public void render(Graphics g) 
	{
		world.render(g);
		player.render(g);
		
	}
	
}
