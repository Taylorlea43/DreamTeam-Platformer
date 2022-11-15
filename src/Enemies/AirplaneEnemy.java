package Enemies;

import java.util.HashMap;

import Builders.FrameBuilder;
import Enemies.FlyingEnemy2.BirdState;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.MapEntity;
import Level.Player;
import Utils.AirGroundState;
import Utils.Direction;
import Utils.Point;
import Utils.Stopwatch;

public class AirplaneEnemy extends Enemy {

	private float gravity = 10f;
	private float movementSpeed = 2.0f;
	private Direction startFacingDirection;
	private Direction facingDirection;
	private AirGroundState airGroundState;
	protected Stopwatch shootTimer = new Stopwatch();

	protected BirdState birdState;
	protected BirdState previousBirdState;

	public AirplaneEnemy(Point location, Direction facingDirection) {
		super(location.x, location.y, new SpriteSheet(ImageLoader.load("AirplaneEnemy.png"), 24, 18), "WALK_LEFT");

		this.startFacingDirection = facingDirection;
		this.initialize();
	}

	@Override
	public void initialize() {
		super.initialize();
		facingDirection = startFacingDirection;
		if (facingDirection == Direction.RIGHT) {
			currentAnimationName = "WALK_RIGHT";
		} else if (facingDirection == Direction.LEFT) {
			currentAnimationName = "WALK_LEFT";
		}
		airGroundState = AirGroundState.GROUND;
	}

	@Override
	public void update(Player player) {
		float moveAmountX = 0;
		float moveAmountY = 0;

		// add gravity (if in air, this will cause bug to fall)
		if (shootTimer.isTimeUp() && birdState != BirdState.SHOOT) {
			birdState = BirdState.SHOOT;
		}

		if ((player.getX() < getX()) && (airGroundState == AirGroundState.AIR)) {
			currentAnimationName = "WALK_LEFT";

			if (facingDirection == Direction.RIGHT) {
				moveAmountX += movementSpeed;
			} else {
				moveAmountX -= movementSpeed;
			}
		}
		if ((player.getX() > getX()) && (airGroundState == AirGroundState.AIR)) {
			currentAnimationName = "WALK_RIGHT";

			if (facingDirection == Direction.LEFT) {
				moveAmountX += movementSpeed;
			} else {
				moveAmountX -= movementSpeed;
			}
		}
		if (shootTimer.isTimeUp()) {

			// define where fireball will spawn on map (x location) relative to dinosaur
			// enemy's location
			// and define its movement speed
			int eggX;
			float movementSpeed;
			if (facingDirection == Direction.RIGHT) {
				eggX = Math.round(getX()) - getWidth();
				movementSpeed = 10.5f;
			} else {
				eggX = Math.round(getX());
				movementSpeed = -10.5f;
			}

			// define where fireball will spawn on the map (y location) relative to dinosaur
			// enemy's location
			int eggY = Math.round(getY()) - 4;

			// create Fireball enemy
			Egg egg = new Egg(new Point(eggX, eggY), movementSpeed, 1000);

			// add fireball enemy to the map for it to offically spawn in the level
			map.addEnemy(egg);

			// change dinosaur back to its WALK state after shooting, reset shootTimer to
			// wait another 2 seconds before shooting again
			shootTimer.setWaitTime(2000);
		}

		// move bug
		moveYHandleCollision(moveAmountY);
		moveXHandleCollision(moveAmountX);

		super.update(player);
	}

	@Override
	public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
		// if bug has collided into something while walking forward,
		// it turns around (changes facing direction)
		if (hasCollided) {
			if (direction == Direction.RIGHT) {
				facingDirection = Direction.LEFT;
				currentAnimationName = "WALK_LEFT";
			} else {
				facingDirection = Direction.RIGHT;
				currentAnimationName = "WALK_RIGHT";
			}
		}
	}

	@Override
	public void onEndCollisionCheckY(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
		// if bug is colliding with the ground, change its air ground state to GROUND
		// if it is not colliding with the ground, it means that it's currently in the
		// air, so its air ground state is changed to AIR
		if (direction == Direction.DOWN) {
			if (hasCollided) {
				airGroundState = AirGroundState.GROUND;
			} else {
				airGroundState = AirGroundState.AIR;
			}
		}
	}

	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("WALK_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(0, 0), 100).withScale(2)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(6, 6, 12, 7).build(),
						new FrameBuilder(spriteSheet.getSprite(0, 1), 100).withScale(2)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(6, 6, 12, 7).build() });

				put("WALK_LEFT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(0, 0), 100).withScale(2).withBounds(6, 6, 12, 7)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(0, 1), 100).withScale(2).withBounds(6, 6, 12, 7)
										.build() });
			}
		};
	}

	public enum BirdState {
		WALK, SHOOT
	}
}
