package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.TileType;
import Sounds.AudioPlayer;
import Utils.Point;

import java.util.HashMap;

// This class is for the end level gold box tile
// when the player touches it, it will tell the player that the level has been completed
public class EndLevelBox extends EnhancedMapTile {
    public EndLevelBox(Point location, String name) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load(name), 24, 24), TileType.PASSABLE);
    }
 
    @Override
    public void update(Player player) {
        super.update(player);
        if (intersects(player)) 
        {
            player.completeLevel();
            
            try
			{
				AudioPlayer LevelCompleteSound = new AudioPlayer (false, "C:/Users/emili/OneDrive/Desktop/SER225_GAME/"
						+ "DreamTeam-Platformer/Resources/LevelComplete_Sound.wav");
				LevelCompleteSound.play();
			}
			
			catch(Exception e)
			{
				System.out.println("Error with sound");
			}
        }
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("DEFAULT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 500)
                        .withScale(3)
                        .withBounds(1, 1, 14, 14)
                        .build(),
            });
        }};
    }
}
