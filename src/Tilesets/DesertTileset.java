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

		Frame sphinx = new FrameBuilder(getSubImage(3, 0)).withScale(tileScale).build();

		MapTileBuilder sphinxTile = new MapTileBuilder(sphinx);
		mapTiles.add(sphinxTile);

		Frame sphinx2 = new FrameBuilder(getSubImage(3, 1)).withScale(tileScale).build();

		MapTileBuilder sphinxTile2 = new MapTileBuilder(sphinx2);
		mapTiles.add(sphinxTile2);

		Frame sphinx3 = new FrameBuilder(getSubImage(3, 2)).withScale(tileScale).build();

		MapTileBuilder sphinxTile3 = new MapTileBuilder(sphinx3);
		mapTiles.add(sphinxTile3);

		Frame sphinx4 = new FrameBuilder(getSubImage(3, 3)).withScale(tileScale).build();

		MapTileBuilder sphinxTile4 = new MapTileBuilder(sphinx4);
		mapTiles.add(sphinxTile4);

		Frame sphinx5 = new FrameBuilder(getSubImage(3, 4)).withScale(tileScale).build();

		MapTileBuilder sphinxTile5 = new MapTileBuilder(sphinx5);
		mapTiles.add(sphinxTile5);

		Frame sphinx6 = new FrameBuilder(getSubImage(4, 0)).withScale(tileScale).build();

		MapTileBuilder sphinxTile6 = new MapTileBuilder(sphinx6);
		mapTiles.add(sphinxTile6);

		Frame sphinx7 = new FrameBuilder(getSubImage(4, 1)).withScale(tileScale).build();

		MapTileBuilder sphinxTile7 = new MapTileBuilder(sphinx7);
		mapTiles.add(sphinxTile7);

		Frame sphinx8 = new FrameBuilder(getSubImage(4, 2)).withScale(tileScale).build();

		MapTileBuilder sphinxTile8 = new MapTileBuilder(sphinx8);
		mapTiles.add(sphinxTile8);

		Frame sphinx9 = new FrameBuilder(getSubImage(4, 3)).withScale(tileScale).build();

		MapTileBuilder sphinxTile9 = new MapTileBuilder(sphinx9);
		mapTiles.add(sphinxTile9);

		Frame sphinx10 = new FrameBuilder(getSubImage(4, 4)).withScale(tileScale).build();

		MapTileBuilder sphinxTile10 = new MapTileBuilder(sphinx10);
		mapTiles.add(sphinxTile10);

		Frame sphinx11 = new FrameBuilder(getSubImage(5, 0)).withScale(tileScale).build();

		MapTileBuilder sphinxTile11 = new MapTileBuilder(sphinx11);
		mapTiles.add(sphinxTile11);

		Frame sphinx12 = new FrameBuilder(getSubImage(5, 1)).withScale(tileScale).build();

		MapTileBuilder sphinxTile12 = new MapTileBuilder(sphinx12);
		mapTiles.add(sphinxTile12);

		Frame sphinx13 = new FrameBuilder(getSubImage(5, 2)).withScale(tileScale).build();

		MapTileBuilder sphinxTile13 = new MapTileBuilder(sphinx13);
		mapTiles.add(sphinxTile13);

		Frame sphinx14 = new FrameBuilder(getSubImage(5, 3)).withScale(tileScale).build();

		MapTileBuilder sphinxTile14 = new MapTileBuilder(sphinx14);
		mapTiles.add(sphinxTile14);

		Frame sphinx15 = new FrameBuilder(getSubImage(5, 4)).withScale(tileScale).build();

		MapTileBuilder sphinxTile15 = new MapTileBuilder(sphinx15);
		mapTiles.add(sphinxTile15);

		Frame sphinx16 = new FrameBuilder(getSubImage(6, 0)).withScale(tileScale).build();

		MapTileBuilder sphinxTile16 = new MapTileBuilder(sphinx16);
		mapTiles.add(sphinxTile16);

		Frame sphinx17 = new FrameBuilder(getSubImage(6, 1)).withScale(tileScale).build();

		MapTileBuilder sphinxTile17 = new MapTileBuilder(sphinx17);
		mapTiles.add(sphinxTile17);

		Frame sphinx18 = new FrameBuilder(getSubImage(6, 2)).withScale(tileScale).build();

		MapTileBuilder sphinxTile18 = new MapTileBuilder(sphinx18);
		mapTiles.add(sphinxTile18);

		Frame sphinx19 = new FrameBuilder(getSubImage(6, 3)).withScale(tileScale).build();

		MapTileBuilder sphinxTile19 = new MapTileBuilder(sphinx19);
		mapTiles.add(sphinxTile19);

		Frame sphinx20 = new FrameBuilder(getSubImage(6, 4)).withScale(tileScale).build();

		MapTileBuilder sphinxTile20 = new MapTileBuilder(sphinx20);
		mapTiles.add(sphinxTile20);

		Frame sphinx21 = new FrameBuilder(getSubImage(7, 0)).withScale(tileScale).build();

		MapTileBuilder sphinxTile21 = new MapTileBuilder(sphinx21);
		mapTiles.add(sphinxTile21);

		Frame sphinx22 = new FrameBuilder(getSubImage(7, 1)).withScale(tileScale).build();

		MapTileBuilder sphinxTile22 = new MapTileBuilder(sphinx22);
		mapTiles.add(sphinxTile22);

		Frame sphinx23 = new FrameBuilder(getSubImage(7, 2)).withScale(tileScale).build();

		MapTileBuilder sphinxTile23 = new MapTileBuilder(sphinx23);
		mapTiles.add(sphinxTile23);

		Frame sphinx24 = new FrameBuilder(getSubImage(7, 3)).withScale(tileScale).build();

		MapTileBuilder sphinxTile24 = new MapTileBuilder(sphinx24);
		mapTiles.add(sphinxTile24);

		Frame sphinx25 = new FrameBuilder(getSubImage(7, 4)).withScale(tileScale).build();

		MapTileBuilder sphinxTile25 = new MapTileBuilder(sphinx25);
		mapTiles.add(sphinxTile25);

		Frame sphinx26 = new FrameBuilder(getSubImage(8, 0)).withScale(tileScale).build();

		MapTileBuilder sphinxTile26 = new MapTileBuilder(sphinx26);
		mapTiles.add(sphinxTile26);

		Frame sphinx27 = new FrameBuilder(getSubImage(8, 1)).withScale(tileScale).build();

		MapTileBuilder sphinxTile27 = new MapTileBuilder(sphinx27);
		mapTiles.add(sphinxTile27);

		Frame sphinx28 = new FrameBuilder(getSubImage(8, 2)).withScale(tileScale).build();

		MapTileBuilder sphinxTile28 = new MapTileBuilder(sphinx28);
		mapTiles.add(sphinxTile28);

		Frame sphinx29 = new FrameBuilder(getSubImage(8, 3)).withScale(tileScale).build();

		MapTileBuilder sphinxTile29 = new MapTileBuilder(sphinx29);
		mapTiles.add(sphinxTile29);

		Frame sphinx30 = new FrameBuilder(getSubImage(8, 4)).withScale(tileScale).build();

		MapTileBuilder sphinxTile30 = new MapTileBuilder(sphinx30);
		mapTiles.add(sphinxTile30);

		Frame sphinx31 = new FrameBuilder(getSubImage(9, 0)).withScale(tileScale).build();

		MapTileBuilder sphinxTile31 = new MapTileBuilder(sphinx31);
		mapTiles.add(sphinxTile31);

		Frame sphinx32 = new FrameBuilder(getSubImage(9, 1)).withScale(tileScale).build();

		MapTileBuilder sphinxTile32 = new MapTileBuilder(sphinx32);
		mapTiles.add(sphinxTile32);

		Frame sphinx33 = new FrameBuilder(getSubImage(9, 2)).withScale(tileScale).build();

		MapTileBuilder sphinxTile33 = new MapTileBuilder(sphinx33);
		mapTiles.add(sphinxTile33);

		Frame sphinx34 = new FrameBuilder(getSubImage(9, 3)).withScale(tileScale).build();

		MapTileBuilder sphinxTile34 = new MapTileBuilder(sphinx34);
		mapTiles.add(sphinxTile34);

		Frame sphinx35 = new FrameBuilder(getSubImage(9, 4)).withScale(tileScale).build();

		MapTileBuilder sphinxTile35 = new MapTileBuilder(sphinx35);
		mapTiles.add(sphinxTile35);

		return mapTiles;

	}
}
