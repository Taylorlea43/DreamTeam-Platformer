package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class SavannahTileset extends Tileset {
	public SavannahTileset() {
		super(ImageLoader.load("SavannaTileset.png"), 16, 16, 3);
	}

	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

		Frame savannahFrame = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder savannahTile = new MapTileBuilder(savannahFrame);

		mapTiles.add(savannahTile);

		Frame savannahFrame2 = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder savannahTile2 = new MapTileBuilder(savannahFrame2);

		mapTiles.add(savannahTile2);
		
		Frame savannahFrame3 = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder savannahTile3 = new MapTileBuilder(savannahFrame3);

		mapTiles.add(savannahTile3);
		
		Frame savannahFrame4 = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder savannahTile4 = new MapTileBuilder(savannahFrame4);

		mapTiles.add(savannahTile4);
		
		Frame savannahFrame5 = new FrameBuilder(getSubImage(0, 4)).withScale(tileScale).build();

		MapTileBuilder savannahTile5 = new MapTileBuilder(savannahFrame5).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(savannahTile5);
		
		Frame savannahFrame6 = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

		MapTileBuilder savannahTile6 = new MapTileBuilder(savannahFrame6);

		mapTiles.add(savannahTile6);
		
		Frame savannahFrame7 = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

		MapTileBuilder savannahTile7 = new MapTileBuilder(savannahFrame7);

		mapTiles.add(savannahTile7);
		
		Frame savannahFrame8 = new FrameBuilder(getSubImage(1, 2)).withScale(tileScale).build();

		MapTileBuilder savannahTile8 = new MapTileBuilder(savannahFrame8);

		mapTiles.add(savannahTile8);
		
		Frame savannahFrame9 = new FrameBuilder(getSubImage(1, 3)).withScale(tileScale).build();

		MapTileBuilder savannahTile9 = new MapTileBuilder(savannahFrame9);

		mapTiles.add(savannahTile9);
		
		Frame savannahFrame10 = new FrameBuilder(getSubImage(1, 4)).withScale(tileScale).build();

		MapTileBuilder savannahTile10 = new MapTileBuilder(savannahFrame10);

		mapTiles.add(savannahTile10);
		
		Frame savannahFrame11 = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale).build();

		MapTileBuilder savannahTile11 = new MapTileBuilder(savannahFrame11);

		mapTiles.add(savannahTile11);
		
		Frame savannahFrame12 = new FrameBuilder(getSubImage(2, 1)).withScale(tileScale).build();

		MapTileBuilder savannahTile12 = new MapTileBuilder(savannahFrame12);

		mapTiles.add(savannahTile12);
		
		Frame savannahFrame13 = new FrameBuilder(getSubImage(2, 2)).withScale(tileScale).build();

		MapTileBuilder savannahTile13 = new MapTileBuilder(savannahFrame13);

		mapTiles.add(savannahTile13);
		
		Frame savannahFrame14 = new FrameBuilder(getSubImage(2, 3)).withScale(tileScale).build();

		MapTileBuilder savannahTile14 = new MapTileBuilder(savannahFrame14);

		mapTiles.add(savannahTile14);
		
		Frame savannahFrame15 = new FrameBuilder(getSubImage(2, 4)).withScale(tileScale).build();

		MapTileBuilder savannahTile15 = new MapTileBuilder(savannahFrame15);

		mapTiles.add(savannahTile15);
		
		
		
		return mapTiles;
	}
}
