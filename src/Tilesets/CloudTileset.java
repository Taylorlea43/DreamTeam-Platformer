package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class CloudTileset extends Tileset {

	public CloudTileset() {
		super(ImageLoader.load("CloudTileset.png"), 16, 16, 3);
	}

	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

		Frame skyFrame = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder skyTile = new MapTileBuilder(skyFrame);

		mapTiles.add(skyTile);

		Frame skyFrame2 = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder skyTile2 = new MapTileBuilder(skyFrame2).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(skyTile2);

		Frame skyFrame3 = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder skyTile3 = new MapTileBuilder(skyFrame3);

		mapTiles.add(skyTile3);

		Frame skyFrame4 = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder skyTile4 = new MapTileBuilder(skyFrame4);

		mapTiles.add(skyTile4);

		Frame skyFrame5 = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

		MapTileBuilder skyTile5 = new MapTileBuilder(skyFrame5);

		mapTiles.add(skyTile5);

		Frame skyFrame6 = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

		MapTileBuilder skyTile6 = new MapTileBuilder(skyFrame6);

		mapTiles.add(skyTile6);

		Frame skyFrame7 = new FrameBuilder(getSubImage(1, 2)).withScale(tileScale).build();

		MapTileBuilder skyTile7 = new MapTileBuilder(skyFrame7);

		mapTiles.add(skyTile7);

		Frame skyFrame8 = new FrameBuilder(getSubImage(1, 3)).withScale(tileScale).build();

		MapTileBuilder skyTile8 = new MapTileBuilder(skyFrame8);

		mapTiles.add(skyTile8);

		Frame skyFrame9 = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale).build();

		MapTileBuilder skyTile9 = new MapTileBuilder(skyFrame9);

		mapTiles.add(skyTile9);

		Frame skyFrame10 = new FrameBuilder(getSubImage(2, 1)).withScale(tileScale).build();

		MapTileBuilder skyTile10 = new MapTileBuilder(skyFrame10);

		mapTiles.add(skyTile10);

		return mapTiles;

	}

}
