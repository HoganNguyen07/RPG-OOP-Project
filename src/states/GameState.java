package states;

import java.awt.Graphics;

import entity.creatures.Player;
import game.Game;
import gfx.Assets;
import tiles.Tile;
import world.World;

public class GameState extends State
{
	private Player player;
	private World world;
	public GameState(Game game)
	{
		super(game);
		player = new Player(game, 100, 100);
		world = new World(game, "res/world/world1.txt");
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
