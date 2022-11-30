package Enemies;

import java.util.HashMap;

import Builders.FrameBuilder;
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

public class CougarEnemy extends Enemy {
	private float gravity = 5.5f;
	private float movementSpeed = 5.5f;
	private Direction startFacingDirection;
	private Direction facingDirection;
	private AirGroundState airGroundState;
	protected Point startLocation;
	protected Point endLocation;

	public CougarEnemy(Point startLocation, Point endLocation, Direction facingDirection) {
		super(startLocation.x, startLocation.y, new SpriteSheet(ImageLoader.load("CougarEnemy.png"), 40, 28),
				"WALK_RIGHT");
		this.startLocation = startLocation;
		this.endLocation = endLocation;
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
		float startBound = startLocation.x;
		float endBound = endLocation.x;

		if (facingDirection == Direction.RIGHT) {
			currentAnimationName = "WALK_RIGHT";
			moveXHandleCollision(movementSpeed);
		} else {
			currentAnimationName = "WALK_LEFT";
			moveXHandleCollision(-movementSpeed);
		}
			// if dinosaur reaches the start or end location, it turns around
			// dinosaur may end up going a bit past the start or end location depending on
			// movement speed
			// this calculates the difference and pushes the enemy back a bit so it ends up
			// right on the start or end location
			if (getX1() + getWidth() >= endBound) {
				float difference = endBound - (getX2());
				moveXHandleCollision(-difference);
				facingDirection = Direction.LEFT;
			} else if (getX1() <= startBound) {
				float difference = startBound - getX1();
				moveXHandleCollision(difference);
				facingDirection = Direction.RIGHT;
			}

			// move bug

		
		

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
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(0, 6, 33, 20).build(),
						new FrameBuilder(spriteSheet.getSprite(0, 1), 100).withScale(2)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(0, 6, 33, 20).build() });

				put("WALK_LEFT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(0, 0), 100).withScale(2).withBounds(0, 6, 33, 20)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(0, 1), 100).withScale(2).withBounds(0, 6, 33, 20)
										.build() });
			}
		};
	}
}