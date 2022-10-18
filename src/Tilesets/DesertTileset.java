package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class DesertTileset extends Tileset {
	public DesertTileset() {
		super(ImageLoader.load("DesertTileset.png"), 16, 16, 3);
	}

	@Override
	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

		// sand
		Frame[] sandFrames = new Frame[] { new FrameBuilder(getSubImage(1, 0), 500).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(1, 1), 500).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(1, 2), 500).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(1, 3), 500).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(1, 4), 500).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(1, 3), 500).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(1, 2), 500).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(1, 1), 500).withScale(tileScale).build(), };

		MapTileBuilder sandTile = new MapTileBuilder(sandFrames).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(sandTile);
		Frame sandyGround = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder sandyGroundTile = new MapTileBuilder(sandyGround).withTileType(TileType.NOT_PASSABLE);

		// sky
		mapTiles.add(sandyGroundTile);
		Frame nightSkyFrame = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder nightSkyTile = new MapTileBuilder(nightSkyFrame);

		mapTiles.add(nightSkyTile);

		Frame cactus1 = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder cactus1Tile = new MapTileBuilder(cactus1).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(cactus1Tile);

		Frame cactus2 = new FrameBuilder(getSubImage(0, 4)).withScale(tileScale).build();

		MapTileBuilder cactus2Tile = new MapTileBuilder(cactus2).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(cactus2Tile);
		Frame pyramid1 = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale).build();

		MapTileBuilder pyramid1Tile = new MapTileBuilder(pyramid1);

		mapTiles.add(pyramid1Tile);
		Frame pyramid2 = new FrameBuilder(getSubImage(2, 1)).withScale(tileScale).build();

		MapTileBuilder pyramid2Tile = new MapTileBuilder(pyramid2);

		mapTiles.add(pyramid2Tile);
		Frame pyramid3 = new FrameBuilder(getSubImage(2, 2)).withScale(tileScale).build();

		MapTileBuilder pyramid3Tile = new MapTileBuilder(pyramid3);

		mapTiles.add(pyramid3Tile);
		Frame pyramid4 = new FrameBuilder(getSubImage(2, 3)).withScale(tileScale).build();

		MapTileBuilder pyramid4Tile = new MapTileBuilder(pyramid4);

		mapTiles.add(pyramid4Tile);
		Frame pyramid5 = new FrameBuilder(getSubImage(2, 4)).withScale(tileScale).build();

		MapTileBuilder pyramid5Tile = new MapTileBuilder(pyramid5);

		mapTiles.add(pyramid5Tile);
		return mapTiles;

	}
}
