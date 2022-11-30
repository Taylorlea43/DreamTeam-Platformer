package Enemies;

import java.awt.print.Printable;
import java.util.HashMap;

import javax.security.sasl.SaslException;

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

public class JellyFishEnemy3 extends Enemy {
	private float movementSpeed = 1.5f;
	private Direction startFacingDirection;
	private Direction facingDirection;
	protected Point startLocation;
	protected Point secondLocation;
	protected Point thirdLocation;
	protected Point endLocation;
	protected JellyState jellyState;
	protected JellyState previousJellyState;
	static int cases = 0;

	public JellyFishEnemy3(Point startLocation, Point secondLocation, Point thirdLocation, Point endLocation,
			Direction facingDirection) {
		super(startLocation.x, startLocation.y, new SpriteSheet(ImageLoader.load("JellyFishEnemy (1).png"), 23, 29),
				"WALK_LEFT");
		this.startLocation = startLocation;
		this.secondLocation = secondLocation;
		this.thirdLocation = thirdLocation;
		this.endLocation = endLocation;
		this.startFacingDirection = facingDirection;
		this.initialize();
	}

	@Override
	public void initialize() {
		super.initialize();
		jellyState = JellyState.WALK;
		previousJellyState = jellyState;
		facingDirection = startFacingDirection;
		if (facingDirection == Direction.RIGHT) {
			currentAnimationName = "WALK_RIGHT";
		} else if (facingDirection == Direction.LEFT) {
			currentAnimationName = "WALK_LEFT";
		}
	}

	@Override
	public void update(Player player) {
		float startBound = startLocation.x;
		float secondBound = secondLocation.y;
		float thirdBound = thirdLocation.x;
		float endBound = endLocation.y;
		float moveAmountX = 0;
		float moveAmountY = 0;

		if (cases == 0) {
			if ((getY() <= startBound) && (getY() <= secondBound)) {
				moveAmountY += movementSpeed;
			}
		}
		if ((getY() >= secondBound)) {

			moveAmountX -= movementSpeed;
			cases = 1;

		}
		if ((cases == 1) && (getX() <= thirdBound)) {
			moveAmountY -= movementSpeed;
		}
		if ((cases == 1) && (getY() < endBound)) {
			moveAmountX += movementSpeed;

		}
		if (getX() == startBound) {
			cases = 0;
		}

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

	}

	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("WALK_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(0, 0), 100).withScale(2)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(0, 6, 25, 20).build(),
						new FrameBuilder(spriteSheet.getSprite(0, 1), 100).withScale(2)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(0, 6, 25, 20).build() });

				put("WALK_LEFT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(0, 0), 100).withScale(2).withBounds(0, 6, 25, 20)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(0, 1), 100).withScale(2).withBounds(0, 6, 25, 20)
										.build() });
			}
		};
	}

	public enum JellyState {
		WALK
	}
}