package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class ArticTileset extends Tileset {

	public ArticTileset() {
		super(ImageLoader.load("ArticTileset.png"), 16, 16, 3);
	}

	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
		Frame snowFrame = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder snowTile = new MapTileBuilder(snowFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(snowTile);
		Frame deepsnowFrame = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder deepsnowTile = new MapTileBuilder(deepsnowFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(deepsnowTile);
		
		Frame skyFrame = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder skyTile = new MapTileBuilder(skyFrame);

		mapTiles.add(skyTile);
		
		Frame sky2Frame = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

		MapTileBuilder sky2Tile = new MapTileBuilder(sky2Frame);

		mapTiles.add(sky2Tile);
		
		
		Frame sky3Frame = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

		MapTileBuilder sky3Tile = new MapTileBuilder(sky3Frame);

		mapTiles.add(sky3Tile);
		
		
		Frame sky4Frame = new FrameBuilder(getSubImage(1, 2)).withScale(tileScale).build();

		MapTileBuilder sky4Tile = new MapTileBuilder(sky4Frame);

		mapTiles.add(sky4Tile);
		
		Frame sky5Frame = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale).build();

		MapTileBuilder sky5Tile = new MapTileBuilder(sky5Frame);

		mapTiles.add(sky5Tile);
		
		Frame icebergFrame = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder icebergTile = new MapTileBuilder(icebergFrame);

		mapTiles.add(icebergTile);
		
		Frame icebergFrame2 = new FrameBuilder(getSubImage(0, 4)).withScale(tileScale).build();

		MapTileBuilder icebergTile2 = new MapTileBuilder(icebergFrame2);

		mapTiles.add(icebergTile2);
		
		Frame icebergFrame3 = new FrameBuilder(getSubImage(0, 5)).withScale(tileScale).build();

		MapTileBuilder icebergTile3 = new MapTileBuilder(icebergFrame3);

		mapTiles.add(icebergTile3);
		
		Frame icebergFrame4 = new FrameBuilder(getSubImage(1, 3)).withScale(tileScale).build();

		MapTileBuilder icebergTile4 = new MapTileBuilder(icebergFrame4);

		mapTiles.add(icebergTile4);
		
		Frame icebergFrame5 = new FrameBuilder(getSubImage(1, 4)).withScale(tileScale).build();

		MapTileBuilder icebergTile5 = new MapTileBuilder(icebergFrame5);

		mapTiles.add(icebergTile5);
		Frame icebergFrame6 = new FrameBuilder(getSubImage(1, 5)).withScale(tileScale).build();

		MapTileBuilder icebergTile6 = new MapTileBuilder(icebergFrame6);

		mapTiles.add(icebergTile6);
		
		
		
		
		
		
		return mapTiles;

	}

}
