package Enemies;

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
import Utils.Stopwatch;

import java.util.HashMap;

public class cowboyZookeeperEnemy extends Enemy {
    private float gravity = 2f;
    private float movementSpeed = .5f;
    private Direction startFacingDirection;
    private Direction facingDirection;
    private AirGroundState airGroundState;
    protected Stopwatch shootTimer = new Stopwatch();

    protected ZookeeperState zookeperState;
    protected ZookeeperState previousZookeperState;

    public cowboyZookeeperEnemy(Point location, Direction facingDirection) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("cowboyZookeeperEnemy.png"), 27, 58), "WALK_LEFT");
        this.startFacingDirection = facingDirection;
        this.initialize();
    }

    @Override
    public void initialize() {
        super.initialize();
        zookeperState = ZookeeperState.WALK;
        previousZookeperState = zookeperState;
        facingDirection = startFacingDirection;
        if (facingDirection == Direction.RIGHT) {
            currentAnimationName = "WALK_RIGHT";
        } else if (facingDirection == Direction.LEFT) {
            currentAnimationName = "WALK_LEFT";
        }
        airGroundState = AirGroundState.GROUND;

        // every 2 seconds, the net will be shot out
        shootTimer.setWaitTime(2000);
    }

    @Override
    public void update(Player player) {
        float moveAmountX = 0;
        float moveAmountY = 0;
        moveAmountY += gravity;

        if (shootTimer.isTimeUp() && zookeperState != ZookeeperState.SHOOT) {
            zookeperState = ZookeeperState.SHOOT;
        }
        super.update(player);

        // if on ground, walk forward based on facing direction
        if (airGroundState == AirGroundState.GROUND) {
            if (facingDirection == Direction.RIGHT) {
                moveAmountX += movementSpeed;
            } else {
                moveAmountX -= movementSpeed;
            }

        }
        if (zookeperState == ZookeeperState.WALK) {
            if (facingDirection == Direction.RIGHT) {
                currentAnimationName = "WALK_RIGHT";
                moveXHandleCollision(movementSpeed);
            } else {
                currentAnimationName = "WALK_LEFT";
                moveXHandleCollision(-movementSpeed);
            }
        } else if (zookeperState == ZookeeperState.SHOOT) {
            if (previousZookeperState == ZookeeperState.WALK) {
                shootTimer.setWaitTime(1000);
                currentAnimationName = facingDirection == Direction.RIGHT ? "SHOOT_RIGHT" : "SHOOT_LEFT";
            } else if (shootTimer.isTimeUp()) {

                int netX;
                float movementSpeed;
                if (facingDirection == Direction.RIGHT) {
                    netX = Math.round(getX()) + getWidth();
                    movementSpeed = 4.5f;
                } else {
                    netX = Math.round(getX());
                    movementSpeed = -4.5f;
                }

                int netY = Math.round(getY() + 5);

                // create net enemy
                Net net = new Net(new Point(netX, netY), movementSpeed, 1000);

                map.addEnemy(net);

                zookeperState = ZookeeperState.WALK;
                shootTimer.setWaitTime(2000);
            }


        }
        moveYHandleCollision(moveAmountY);
        moveXHandleCollision(moveAmountX);

        super.update(player);
        previousZookeperState = zookeperState;

    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
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
                put("WALK_LEFT",
                        new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 0), 200).withScale(2).withBounds(1, 1, 24, 56)
                                        .build(),
                                new FrameBuilder(spriteSheet.getSprite(0, 1), 200).withScale(2).withBounds(1, 1, 24, 56)
                                        .build(),
                                new FrameBuilder(spriteSheet.getSprite(0, 2), 200).withScale(2).withBounds(1, 1, 24, 56)
                                        .build(),

                        });

                put("WALK_RIGHT",
                        new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 0), 200).withScale(2)
                                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 24, 56).build(),
                                new FrameBuilder(spriteSheet.getSprite(0, 1), 200).withScale(2)
                                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 24, 56).build(),
                                new FrameBuilder(spriteSheet.getSprite(0, 2), 200).withScale(2)
                                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 24, 56).build(),

                        });
                put("SHOOT_LEFT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(1, 0)).withScale(2).withBounds(1, 1, 24, 56).build(), });

                put("SHOOT_RIGHT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(1, 0)).withScale(2)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(1, 1, 24, 56).build(), });
            }
        };
    }

    public enum ZookeeperState {
        WALK, SHOOT
    }

}