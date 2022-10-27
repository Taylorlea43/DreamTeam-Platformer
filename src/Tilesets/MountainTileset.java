package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class MountainTileset extends Tileset {
	public MountainTileset() {
		super(ImageLoader.load("MountainTileset.png"), 16, 16, 3);
	}

	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
		Frame sky = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder skyTile = new MapTileBuilder(sky);

		mapTiles.add(skyTile);
		Frame mountainLedgeFrame = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder mountainLedgeTile = new MapTileBuilder(mountainLedgeFrame);

		mapTiles.add(mountainLedgeTile);
		Frame mountainTop1Frame = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder mountainTop1Tile = new MapTileBuilder(mountainTop1Frame);

		mapTiles.add(mountainTop1Tile);
		Frame mountainTop2Frame = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder mountainTop2Tile = new MapTileBuilder(mountainTop2Frame);

		mapTiles.add(mountainTop2Tile);
		Frame mountainTop3Frame = new FrameBuilder(getSubImage(0, 4)).withScale(tileScale).build();

		MapTileBuilder mountainTop3Tile = new MapTileBuilder(mountainTop3Frame);

		mapTiles.add(mountainTop3Tile);
		Frame mountainMain1Frame = new FrameBuilder(getSubImage(0, 5)).withScale(tileScale).build();

		MapTileBuilder mountainMain1Tile = new MapTileBuilder(mountainMain1Frame);

		mapTiles.add(mountainMain1Tile);
		Frame mountainSide1Frame = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

		MapTileBuilder mountainSide1Tile = new MapTileBuilder(mountainSide1Frame);

		mapTiles.add(mountainSide1Tile);
		Frame mountainMain2Frame = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

		MapTileBuilder mountainMain2Tile = new MapTileBuilder(mountainMain2Frame);

		mapTiles.add(mountainMain2Tile);
		Frame mountainPlatformFrame = new FrameBuilder(getSubImage(1, 2)).withScale(tileScale).withBounds(3,6,12,5).build();

		MapTileBuilder mountainPlatformTile = new MapTileBuilder(mountainPlatformFrame).withTileType(TileType.JUMP_THROUGH_PLATFORM);

		mapTiles.add(mountainPlatformTile);
		Frame mountainTopFrame = new FrameBuilder(getSubImage(1, 3)).withScale(tileScale).build();

		MapTileBuilder mountainTopTile = new MapTileBuilder(mountainTopFrame);

		mapTiles.add(mountainTopTile);
		Frame mountainSide2Frame = new FrameBuilder(getSubImage(1, 4)).withScale(tileScale).build();

		MapTileBuilder mountainSide2Tile = new MapTileBuilder(mountainSide2Frame);

		mapTiles.add(mountainSide2Tile);
		Frame mountainMain3Frame = new FrameBuilder(getSubImage(1, 5)).withScale(tileScale).build();

		MapTileBuilder mountainMain3Tile = new MapTileBuilder(mountainMain3Frame);

		mapTiles.add(mountainMain3Tile);
		Frame groundFrame = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale).withBounds(0,12,15,16).build();

		MapTileBuilder groundTile = new MapTileBuilder(groundFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(groundTile);
		Frame ground2Frame = new FrameBuilder(getSubImage(2, 1)).withScale(tileScale).withBounds(0,12,15,16).build();

		MapTileBuilder ground2Tile = new MapTileBuilder(ground2Frame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(ground2Tile);
		Frame mountainMain4Frame = new FrameBuilder(getSubImage(2, 2)).withScale(tileScale).build();

		MapTileBuilder mountainMain4Tile = new MapTileBuilder(mountainMain4Frame);

		mapTiles.add(mountainMain4Tile);
		
		Frame mountainMain5Frame = new FrameBuilder(getSubImage(2, 3)).withScale(tileScale).build();

		MapTileBuilder mountainMain5Tile = new MapTileBuilder(mountainMain5Frame);

		mapTiles.add(mountainMain5Tile);
		
		Frame mountainMain6Frame = new FrameBuilder(getSubImage(2, 4)).withScale(tileScale).build();

		MapTileBuilder mountainMain6Tile = new MapTileBuilder(mountainMain6Frame);

		mapTiles.add(mountainMain6Tile);
		return mapTiles;
	}
}
