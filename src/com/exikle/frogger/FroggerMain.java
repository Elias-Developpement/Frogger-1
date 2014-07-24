package com.exikle.frogger;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import com.exikle.frogger.entites.Car;
import com.exikle.frogger.entites.Direction;
import com.exikle.frogger.entites.Frog;
import com.exikle.frogger.graphics.Hud;

/**
 * @author Dixon D'Cunha
 *         Starts the frogger applet
 */
@SuppressWarnings("serial")
public class FroggerMain extends Applet implements Runnable {

	@SuppressWarnings("unused")
	private final String TAG = "MAIN";

	/**
	 * Path of the images
	 */
	private final String PIC_PATH = "";

	/**
	 * The thread sleep time constant, how much it usually sleeps for.
	 */
	private int THREAD_SLEEP_TIME = 18;

	/**
	 * The board/background/area the frog is hopping on
	 */
	private Image bgImage;

	/**
	 * The current image that is displayed on the screen
	 */
	private Frog player;

	/**
	 * The double buffered Image;
	 */
	private Image dbImage;

	private Graphics dbg;

	private Car cars = new Car();

	private Board board;

	/**
	 * Initializes the objects
	 * 
	 * @param none
	 */
	public void init() {
		board = new Board(this);
		setSize(board.APPLET_WIDTH, board.APPLET_HEIGHT);
		player = new Frog();
		initImages();
		initCars();
	}

	private void initCars() {
		cars.newCar(createImage("car1.png"));
		// cars.setX(-480);
		cars.setX(0);
		cars.setY(360);
	}

	/**
	 * Initializes the images separately due to excess amounts.
	 */
	private void initImages() {
		bgImage = createImage("frogboard.png");

		Image[] frog = new Image[4];
		frog[0] = createImage("frogU.png");
		frog[1] = createImage("frogD.png");
		frog[2] = createImage("frogL.png");
		frog[3] = createImage("frogR.png");
		player.newFrog(frog);

		initCars();

	}

	private Image createImage(String picString) {
		return getImage(getCodeBase(), PIC_PATH + picString);
	}

	/**
	 * Starts the game thread
	 * 
	 * @param none
	 */
	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	/**
	 * TODO
	 */
	@Override
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while (true) {
			new ThreadSleeper(THREAD_SLEEP_TIME);
			moveObjects();
			checkCollision();

			repaint();
		}
	}

	/**
	 * Creates a double buffered image of the screen and displays it
	 */
	public void update(Graphics g) {
		if (dbImage == null) { // initialize buffer
			dbImage = createImage(board.APPLET_WIDTH,
					board.APPLET_HEIGHT);
			dbg = dbImage.getGraphics();
		}
		// clear screen in background
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width,
				this.getSize().height);
		// draw elements in background
		dbg.setColor(getForeground());
		paint(dbg);

		// draw image on the screen
		g.drawImage(dbImage, 0, 0, this);
	}

	/**
	 * Paints the screen
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(bgImage, 0, 0, board.APPLET_WIDTH,
				board.APPLET_HEIGHT, this);
		Hud.drawHud(g, board);
		player.draw(g, this);
		cars.draw(g, this);
	}

	/**
	 * Handles the keyboard input.
	 */
	public boolean keyDown(Event e, int key) {
		switch (key) {
			case Event.UP:
				player.changeDirection(Direction.UP);
				player.changeCoordinates(0, -32);
				break;
			case Event.DOWN:
				player.changeDirection(Direction.DOWN);
				player.changeCoordinates(0, 32);
				break;
			case Event.LEFT:
				player.changeDirection(Direction.LEFT);
				player.changeCoordinates(-32, 0);
				break;
			case Event.RIGHT:
				player.changeDirection(Direction.RIGHT);
				player.changeCoordinates(32, 0);
				break;
		}
		return true;
	}

	private void checkCollision() {
		// TODO
	}

	private void moveObjects() {
		cars.moveX(cars.getSpeed());
	}

	/**
	 * Stops the game.
	 */
	public void stop() {}

	/**
	 * Disposes of used resources
	 */
	public void destroy() {}

	public Frog getPlayer() {
		return player;
	}

}
