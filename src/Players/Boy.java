package Players;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;

import java.util.HashMap;

public class Boy extends Player
{
	public Boy(float x, float y, int level)
	{
		 super(new SpriteSheet(ImageLoader.load("boyFinal.png"), 45, 85), x, y, "STAND_RIGHT", false, level);
	        gravity = .5f;
	        terminalVelocityY = 6f;
	        jumpHeight = 14.5f; //14.5
	        jumpDegrade = .5f;
	        walkSpeed = 10.3f; //3.3f
	        momentumYIncrease = .5f;
	        health = 100;
	}

	public void update() {
		super.update();
	}

	public void draw(GraphicsHandler graphicsHandler) {
		super.draw(graphicsHandler);
	}

	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("STAND_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(0, 0)).withScale(1).withBounds(1, 1, 40, 80).build() });

				put("STAND_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(0, 0)).withScale(1)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build() });

				put("WALK_RIGHT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(1, 0), 200).withScale(1).withBounds(1, 1, 40, 80)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(1, 1), 200).withScale(1).withBounds(1, 1, 40, 80)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(1, 2), 200).withScale(1).withBounds(1, 1, 40, 80)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(1, 3), 200).withScale(1).withBounds(1, 1, 40, 80)
										.build() });

				put("WALK_LEFT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(1, 0), 200).withScale(1)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 1), 200).withScale(1)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 2), 200).withScale(1)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 3), 200).withScale(1)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build() });

				put("JUMP_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(2, 0)).withScale(1).withBounds(1, 1, 40, 80).build() });

				put("JUMP_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(2, 0)).withScale(1)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build() });

				put("FALL_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(3, 0)).withScale(1).withBounds(1, 1, 40, 80).build() });

				put("FALL_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(3, 0)).withScale(1)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build() });

				put("CROUCH_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(4, 0)).withScale(1).withBounds(8, 12, 8, 6).build() });

				put("CROUCH_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(4, 0)).withScale(1)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 12, 8, 6).build() });

				put("DEATH_RIGHT",
						new Frame[] { new FrameBuilder(spriteSheet.getSprite(5, 0), 100).withScale(1).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 1), 100).withScale(1).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 1), -1).withScale(1).build() });

				put("DEATH_LEFT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(5, 0), 100).withScale(1)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 1), 100).withScale(1)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 1), -1).withScale(1)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build() });

				put("DAMAGE_STAND_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(6, 0)).withScale(1).withBounds(1, 1, 40, 80).build() });

				put("DAMAGE_STAND_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(6, 0)).withScale(1)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build() });

				put("SWIM_STAND_RIGHT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(7, 0), 200).withScale(1).withBounds(1, 1, 40, 80)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(7, 1), 200).withScale(1).withBounds(1, 1, 40, 80)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(7, 2), 200).withScale(1).withBounds(1, 1, 40, 80)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(7, 3), 200).withScale(1).withBounds(1, 1, 40, 80)
										.build() }); // same as walk

				put("SWIM_STAND_LEFT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(7, 0), 200).withScale(1)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build(),
						new FrameBuilder(spriteSheet.getSprite(7, 1), 200).withScale(1)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build(),
						new FrameBuilder(spriteSheet.getSprite(7, 2), 200).withScale(1)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build(),
						new FrameBuilder(spriteSheet.getSprite(7, 3), 200).withScale(1)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 40, 80).build() }); // same
																													// as
																													// walk
			}
		};
	}
}
