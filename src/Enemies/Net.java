package Enemies;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.Player;
import Utils.Direction;
import Utils.Point;
import Utils.Stopwatch;

public class Net extends Enemy {
	private float movementSpeed;
	private Stopwatch existenceTimer = new Stopwatch();

	public Net(Point location, float movementSpeed, int existenceTime) {
		super(location.x, location.y, new SpriteSheet(ImageLoader.load("Net.png"), 7, 29), "DEFAULT");
		this.movementSpeed = movementSpeed;

		existenceTimer.setWaitTime(existenceTime);

		isRespawnable = false;

		initialize();
	}

	@Override
	public void update(Player player) {
		// if timer is up, set map entity status to REMOVED
		// the camera class will see this next frame and remove it permanently from the
		// map
		if (existenceTimer.isTimeUp()) {
			this.mapEntityStatus = MapEntityStatus.REMOVED;
		} else {
			moveXHandleCollision(movementSpeed);
			super.update(player);
		}
	}

	@Override
	public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
		if (hasCollided) {
			this.mapEntityStatus = MapEntityStatus.REMOVED;
		}
	}

	@Override
	public void touchedPlayer(Player player) {
		super.touchedPlayer(player);
		this.mapEntityStatus = MapEntityStatus.REMOVED;
	}

	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("DEFAULT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(0, 0)).withScale(3).withBounds(3, 2, 9, 29).build() });

			}
		};
	}
}