package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class UnderwaterTileset extends Tileset {
	public UnderwaterTileset() {
		super(ImageLoader.load("UnderwaterTileset.png"), 16, 16, 3);
	}

	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
		Frame sandFrame = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder sandTile = new MapTileBuilder(sandFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(sandTile);
		Frame sand2Frame = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder sand2Tile = new MapTileBuilder(sand2Frame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(sand2Tile);
		Frame waterFrame = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder waterTile = new MapTileBuilder(waterFrame);

		mapTiles.add(waterTile);
		Frame coralFrame = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder coralTile = new MapTileBuilder(coralFrame);

		mapTiles.add(coralTile);
		Frame seaweedFrame = new FrameBuilder(getSubImage(0, 4)).withScale(tileScale).build();

		MapTileBuilder seaweedTile = new MapTileBuilder(seaweedFrame);

		mapTiles.add(seaweedTile);
		Frame coral2Frame = new FrameBuilder(getSubImage(0, 5)).withScale(tileScale).build();

		MapTileBuilder coral2Tile = new MapTileBuilder(coral2Frame);

		mapTiles.add(coral2Tile);
		Frame seastoneFrame = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

		MapTileBuilder seastoneTile = new MapTileBuilder(seastoneFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(seastoneTile);
		Frame seastone2Frame = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

		MapTileBuilder seastone2Tile = new MapTileBuilder(seastone2Frame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(seastone2Tile);
		Frame coral3Frame = new FrameBuilder(getSubImage(1, 2)).withScale(tileScale).build();

		MapTileBuilder coral3Tile = new MapTileBuilder(coral3Frame);

		mapTiles.add(coral3Tile);
		Frame backgroundFrame = new FrameBuilder(getSubImage(1, 3)).withScale(tileScale).build();

		MapTileBuilder backgroundTile = new MapTileBuilder(backgroundFrame);

		mapTiles.add(backgroundTile);
		Frame seastone3Frame = new FrameBuilder(getSubImage(1, 4)).withScale(tileScale).withBounds(0,0,9,5).build();

		MapTileBuilder seastone3Tile = new MapTileBuilder(seastone3Frame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(seastone3Tile);
		Frame seastone4Frame = new FrameBuilder(getSubImage(1, 5)).withScale(tileScale).withBounds(0,14,8,2).build();

		MapTileBuilder seastone4Tile = new MapTileBuilder(seastone4Frame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(seastone4Tile);
		return mapTiles;
	}

}
