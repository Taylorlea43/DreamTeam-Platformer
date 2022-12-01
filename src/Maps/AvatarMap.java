package Maps;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import SpriteFont.SpriteFont;
import Tilesets.CommonTileset;
import Utils.Colors;
import Utils.Direction;
import Utils.Point;

import java.awt.*;

public class AvatarMap extends Map {

	private Sprite girl, boy;
	private SpriteFont zooMania;

	public AvatarMap() {
		super("title_screen_map.txt", new CommonTileset());
		Point girlLocation = getMapTile(13, 7).getLocation().subtractX(24).subtractY(6);
		girl = new Sprite(ImageLoader.loadSubImage("girlNoLines.png", Colors.MAGENTA, 0, 0, 55, 85));
		girl.setScale(2);
		girl.setLocation(girlLocation.x, girlLocation.y);
		
		Point boyLocation = getMapTile(13, 7).getLocation().subtractX(-175).subtractY(14);
		boy = new Sprite(ImageLoader.loadSubImage("boyFinal.png", Colors.MAGENTA, 0, 0, 55, 85));
		boy.setScale(2);
		boy.setLocation(boyLocation.x, boyLocation.y);

		// add game title
		zooMania = new SpriteFont("ZOO MANIA", Config.GAME_WINDOW_WIDTH/2-150, 100, "Impact", 62, new Color(0, 0, 0));

		
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		super.draw(graphicsHandler);
		girl.draw(graphicsHandler);
		boy.draw(graphicsHandler);
		zooMania.draw(graphicsHandler);
	}

}
