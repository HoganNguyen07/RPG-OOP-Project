package states;

import java.awt.Graphics;

import entity.creatures.Player;
import entity.statics.Tree;
import game.Game;
import game.Handler;
import gfx.Assets;
import tiles.Tile;
import world.World;

public class GameState extends State
{
	private World world;
	private Tree tree;
	
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler, "res/world/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() 
	{
		world.tick();
	}

	@Override
	public void render(Graphics g) 
	{
		world.render(g);
	}
	
}
