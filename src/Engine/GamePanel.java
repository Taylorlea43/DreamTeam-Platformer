package Engine;

import GameObject.Rectangle;
import Screens.PlayLevelScreen;
import SpriteFont.SpriteFont;
import Utils.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/*
 * This is where the game loop starts
 * The JPanel uses a timer to continually call cycles of update and draw
 */
public class GamePanel extends JPanel {
	// loads Screens on to the JPanel each screen has its own update and draw methods defined to handle a "section" of the game.
	private ScreenManager screenManager;

	// used to create the game loop and cycle between update and draw calls
	private Timer timer;

	// used to draw graphics to the panel
	private GraphicsHandler graphicsHandler;

	private boolean doPaint = false;
	private boolean isGamePaused = false;
	private boolean isGameFullscreen = false;

	private SpriteFont pauseLabel;
	private KeyLocker keyLocker = new KeyLocker();
	private final Key pauseKey = Key.P;
	private final Key FULLSCREEN_KEY = Key.F;

	BufferedImage tempScreen;
	Graphics2D g2;
	int screenwidth2 = Config.GAME_WINDOW_WIDTH;
	int screenheight2 = Config.GAME_WINDOW_HEIGHT;

	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

	/*
	 * The JPanel and various important class instances are setup here
	 */
	public GamePanel() 
	{
		super();
		this.setDoubleBuffered(true);

		// attaches Keyboard class's keyListener to this JPanel
		this.addKeyListener(Keyboard.getKeyListener());

		graphicsHandler = new GraphicsHandler();

		screenManager = new ScreenManager();

		pauseLabel = new SpriteFont("PAUSE", Config.GAME_WINDOW_WIDTH/2-50, 200, "Comic Sans", 24, Color.white);
		pauseLabel.setOutlineColor(Color.black);
		pauseLabel.setOutlineThickness(2.0f);

		// Every timer "tick" will call the update method as well as tell the JPanel to repaint
		// Remember that repaint "schedules" a paint rather than carries it out immediately
		// If the game is really laggy/slow, I would consider upping the FPS in the Config file.
		timer = new Timer(1000 / Config.FPS, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePause();
				updateFullscreen();

				if (!isGameFullscreen) {
					repaint();
				}
				if (isGameFullscreen) {
					 //drawToTemp();
					// drawToScreen();
					repaint();
				}

			}
		});
		timer.setRepeats(true);
	}

	// this is called later after instantiation, and will initialize screenManager
	// this had to be done outside of the constructor because it needed to know the
	// JPanel's width and height, which aren't available in the constructor
	public void setupGame() {
		setBackground(Colors.CORNFLOWER_BLUE);
		screenManager.initialize(new Rectangle(getX(), getY(), getWidth(), getHeight()));
		doPaint = true;
		tempScreen = new BufferedImage(Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT,
				BufferedImage.TYPE_INT_ARGB);
		g2 = (Graphics2D) tempScreen.getGraphics();
		// setFullscreen();
	}

	public void setFullscreen() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
//		gd.setFullScreenWindow(GameWindow.gameWindow);
		GameWindow.gameWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);

		screenwidth2 = GameWindow.gameWindow.getWidth();
		screenheight2 = GameWindow.gameWindow.getHeight();
	}

	// this starts the timer (the game loop is started here
	public void startGame() 
	{
		timer.start();
	}

	public ScreenManager getScreenManager() 
	{
		return screenManager;
	}

	public void updatePause() {
		if (Keyboard.isKeyDown(pauseKey) && !keyLocker.isKeyLocked(pauseKey)) {
			isGamePaused = !isGamePaused;
			keyLocker.lockKey(pauseKey);
			PlayLevelScreen.timer.toggle();
		}

		if (Keyboard.isKeyUp(pauseKey)) 
		{
			keyLocker.unlockKey(pauseKey);
		}

		if (!isGamePaused) 
		{
			screenManager.update();
		}
	}

	public void updateFullscreen() 
	{
		if (Keyboard.isKeyDown(FULLSCREEN_KEY) && !keyLocker.isKeyLocked(FULLSCREEN_KEY)) {
			isGameFullscreen = !isGameFullscreen;
			keyLocker.lockKey(FULLSCREEN_KEY);
		}

		if (Keyboard.isKeyUp(FULLSCREEN_KEY)) {
			keyLocker.unlockKey(FULLSCREEN_KEY);
		}
	}

	public void draw() {
		screenManager.draw(graphicsHandler);

		// if game is paused, draw pause gfx over Screen gfx
		if (isGamePaused) {
			pauseLabel.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(),
					new Color(0, 0, 0, 100));
		}
		if (isGameFullscreen) {
			// setFullscreen();
//			GameWindow.gameWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
			GameWindow.gameWindow.setSize(Config.FULL_GAME_WINDOW_WIDTH, Config.FULL_GAME_WINDOW_HEIGHT);
			GameWindow.gameWindow.setLocationRelativeTo(null);

			// device.setFullScreenWindow(GameWindow.gameWindow);

		} else if (!isGameFullscreen) {

			GameWindow.gameWindow.setSize(Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT);

		}
	}

	public void drawToScreen() 
	{
		Graphics g = getGraphics();
		g.drawImage(tempScreen, 0, 0, screenwidth2, screenheight2, null);
		g.dispose();
	}

	public void drawToTemp() 
	{
		graphicsHandler.setGraphics((Graphics2D) g2);
		if (doPaint) 
		{
			draw();
		}
	}

	@Override
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		// every repaint call will schedule this method to be called when called, it will setup the graphics handler and then call this class's draw method
		graphicsHandler.setGraphics((Graphics2D) g);
		if (doPaint) {
			draw();
		}
	}
}
