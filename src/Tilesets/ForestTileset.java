package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

public class ForestTileset extends Tileset {
	public ForestTileset() {
		super(ImageLoader.load("ForestTileSet.png"), 16, 16, 3);
	}

	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

		Frame grassFrame = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

		MapTileBuilder grassTile = new MapTileBuilder(grassFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(grassTile);
		Frame dirtFrame = new FrameBuilder(getSubImage(1, 2)).withScale(tileScale).build();

		MapTileBuilder dirtTile = new MapTileBuilder(dirtFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(dirtTile);

		Frame tree = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder treeTile = new MapTileBuilder(tree);

		mapTiles.add(treeTile);

		Frame treeReverse = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale)
				.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

		MapTileBuilder treeTileReverse = new MapTileBuilder(treeReverse);

		mapTiles.add(treeTileReverse);

		Frame tree2 = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder treeTile2 = new MapTileBuilder(tree2);

		mapTiles.add(treeTile2);
		Frame treeReverse2 = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale)
				.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

		MapTileBuilder treeTileReverse2 = new MapTileBuilder(treeReverse2);

		mapTiles.add(treeTileReverse2);

		Frame tree3 = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder treeTile3 = new MapTileBuilder(tree3);

		mapTiles.add(treeTile3);

		Frame tree4 = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder treeTile4 = new MapTileBuilder(tree4);

		mapTiles.add(treeTile4);

		Frame tree5 = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

		MapTileBuilder treeTile5 = new MapTileBuilder(tree5);

		mapTiles.add(treeTile5);

		Frame branch1 = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale).withBounds(2,6,16,6).build();

		MapTileBuilder branchTile1 = new MapTileBuilder(branch1).withTileType(TileType.JUMP_THROUGH_PLATFORM);

		mapTiles.add(branchTile1);

		Frame reverseBranch1 = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale)
				.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(2,6,16,6).build();

		MapTileBuilder reverseBranchTile1 = new MapTileBuilder(reverseBranch1).withTileType(TileType.JUMP_THROUGH_PLATFORM);

		mapTiles.add(reverseBranchTile1);

		Frame branch2 = new FrameBuilder(getSubImage(2, 1)).withScale(tileScale).withBounds(0,6,16,6).build();

		MapTileBuilder branchTile2 = new MapTileBuilder(branch2).withTileType(TileType.JUMP_THROUGH_PLATFORM);

		mapTiles.add(branchTile2);

		Frame reverseBranch2 = new FrameBuilder(getSubImage(2, 1)).withBounds(0,6,16,6).withScale(tileScale)
				.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

		MapTileBuilder reverseBranchTile2 = new MapTileBuilder(reverseBranch2).withTileType(TileType.JUMP_THROUGH_PLATFORM);

		mapTiles.add(reverseBranchTile2);

		Frame branch3 = new FrameBuilder(getSubImage(2, 2)).withScale(tileScale).withBounds(0,6,16,6).build();

		MapTileBuilder branchTile3 = new MapTileBuilder(branch3).withTileType(TileType.JUMP_THROUGH_PLATFORM);

		mapTiles.add(branchTile3);

		Frame forestSky = new FrameBuilder(getSubImage(1, 3)).withScale(tileScale).build();

		MapTileBuilder forestSkyTile = new MapTileBuilder(forestSky);

		mapTiles.add(forestSkyTile);

		return mapTiles;
	}
}
