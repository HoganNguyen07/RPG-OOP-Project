package gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, grass, stone, tree;
	public static BufferedImage[] player_up, player_down, player_left, player_right;

	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet player_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player_sheet1.png"));
		
		player_up = new BufferedImage[4];
		player_down = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		
		player_down[0] = player_sheet.crop(0, 0, 64, 64);
		player_down[1] = player_sheet.crop(64, 0, 64, 64);
		player_down[2] = player_sheet.crop(64 * 2, 0, 64, 64);
		player_down[3] = player_sheet.crop(64 * 3, 0, 64, 64);
		player_up[0] = player_sheet.crop(0, 64 * 3, 64, 64);
		player_up[1] = player_sheet.crop(64, 64 * 3, 64, 64);
		player_up[2] = player_sheet.crop(64 * 2, 64 * 3, 64, 64);
		player_up[3] = player_sheet.crop(64 * 3, 64 * 3, 64, 64);
		player_left[0] = player_sheet.crop(0, 64, 64, 64);
		player_left[1] = player_sheet.crop(64, 64, 64, 64);
		player_left[2] = player_sheet.crop(64 * 2, 64, 64, 64);
		player_left[3] = player_sheet.crop(64 * 3, 64, 64, 64);
		player_right[0] = player_sheet.crop(0, 64 * 2, 64, 64);
		player_right[1] = player_sheet.crop(64, 64 * 2, 64, 64);
		player_right[2] = player_sheet.crop(64 * 2, 64 * 2, 64, 64);
		player_right[3] = player_sheet.crop(64 * 3, 64 * 2, 64, 64);
		
		
		dirt = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		tree = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width, height, width, height);
	}
}
