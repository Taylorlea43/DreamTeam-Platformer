package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class JungleTileset extends Tileset {
	public JungleTileset() {
		super(ImageLoader.load("JungleTileSet.png"), 16, 16, 3);
	}

	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
		Frame jungleWall = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder jungleWallTile = new MapTileBuilder(jungleWall).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(jungleWallTile);

		Frame jungleWall2 = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder jungleWallTile2 = new MapTileBuilder(jungleWall2).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(jungleWallTile2);
		
		
		
		
		Frame leafPlatform = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).withBounds(4, 14, 16, 4).build();

		MapTileBuilder leafPlatformTile = new MapTileBuilder(leafPlatform).withTileType(TileType.JUMP_THROUGH_PLATFORM);;

		mapTiles.add(leafPlatformTile);

		
		Frame leafPlatform2 = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).withBounds(4, 14, 16, 4).build();

		MapTileBuilder leafPlatformTile2 = new MapTileBuilder(leafPlatform2).withTileType(TileType.JUMP_THROUGH_PLATFORM);;

		mapTiles.add(leafPlatformTile2);
		Frame leafPlatform3 = new FrameBuilder(getSubImage(0, 4)).withScale(tileScale).withBounds(4, 14, 16, 4).build();

		MapTileBuilder leafPlatformTile3 = new MapTileBuilder(leafPlatform3).withTileType(TileType.JUMP_THROUGH_PLATFORM);;

		mapTiles.add(leafPlatformTile3);

		
		
		
		Frame vine = new FrameBuilder(getSubImage(0, 5)).withScale(tileScale).withBounds(8, 16, 16, 4).build();

		MapTileBuilder vineTile = new MapTileBuilder(vine).withTileType(TileType.JUMP_THROUGH_PLATFORM);

		mapTiles.add(vineTile);

		return mapTiles;

	}
}