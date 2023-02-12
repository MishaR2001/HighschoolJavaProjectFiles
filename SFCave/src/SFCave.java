import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * version 2.0
 * 
 * Project created by: Mr Ruth .. Niles North High School .. Skokie, IL ..
 * www.MrRuth.com
 * 
 * ~~~~~~~~~~~~~~~~~~~~~ Strict Clone of SF Cave ~~~~~~~~~~~~~~~~~~~~~<br>
 * See https://www.youtube.com/watch?v=AWB1juhC-gE for a video of the gameplay.
 * 
 * PIXEL INFORMATION (thank you mspaint!) I recommend a width of 384 and height
 * of 480 for the window (384x384 square for the cave and 384x96 for the score
 * board area) You will notice there are 32 actual bars that make up each of the
 * cave top and bottom. These bars will have a 12 pixel width. The green
 * obstacles (also 12 pixels wide) are 48 pixels tall and occur every 10 bars
 * (120 pixels) and the initial distance between the top and bottom of the cave
 * is 324. The worm should be 9 pixels thick. The head of the worm should be at
 * pixel 102.
 * 
 * The game animates with a ?? ms delay (?? fps) and will move all bars 12
 * pixels each frame. The acceleration up and down as well as the max / min
 * velocity you may have to tweak when you have a working prototype.
 * 
 * This game is implemented as a simple JPanel embedded in a JFrame with a Timer
 * for animation. This implementation uses the SPACE BAR instead of the
 * mouse-click.
 * 
 * <xmp><code><pre>
 * compile and run SFCave.
 * 
 */
public class SFCave extends JPanel implements KeyListener, ActionListener {

	// YOUR CODE GOES HERE..
	// initialize instance variables here

	private int caveHeight = 312; // distance between caveTop and caveBottom
	private int caveIncr = -4; // cave increment
	private int caveDur = 10; // cave increment duration .. not used until step
								// V
	private ArrayList<Rectangle> caveTop; // cave top
	private ArrayList<Rectangle> caveBottom; // cave bottom
	private ArrayList<Rectangle> blocks; // blocks (i.e. obstacles)

	public static final Rectangle BORDER = new Rectangle(0, 0, 384, 480);
	private int frameCount;// used for the score
	private Timer timer;// handles animation
	private int delay = 100; // milliseconds between frames.. 1000/delay == fps
	private static Image offScreenBuffer;// needed for double buffering graphics
	private Graphics offScreenGraphics;// needed for double buffering graphics

	private Rectangle wormHead;
	private boolean spacePressed = false;
	private ArrayList<Rectangle> worm; // worm
	private int upForce = 1; // thrust
	private int downForce = 1; // gravity
	private int velocity = 0; // change in y
	private int maxVelocity = 20; // ?? we will have to tweak this value
	private int minVelocity = -20;// ?? we will have to tweak this value

	private int explodeCount = -1;

	private int score = 0; // score, incremented by 1 every other frame
	private int hiScore = 0; //
	private Font scoreFont; // will be initialized in initRound

	/**
	 * initializes all fields needed for each round of play (i.e. restart)
	 */
	public void initRound() {
		frameCount = 1;
		caveHeight = 312;
		caveIncr = -4;
		caveDur = 10;

		// caveTop1 = new caveTop ();
		caveTop = new ArrayList<Rectangle>();
		caveBottom = new ArrayList<Rectangle>();
		blocks = new ArrayList<Rectangle>();
		wormHead = new Rectangle(90, 144, 12, 12);
		worm = new ArrayList<Rectangle>();

		upForce = 3; // thrust
	    downForce = 3; // gravity
	    velocity = 0; // change in y
	    maxVelocity = 20; 
	    minVelocity = -20;

		scoreFont = new Font("TimesRoman", Font.BOLD, 20);
		score = 0;

		for (int i = 0; i < 32; i++) {
			caveTop.add(new Rectangle((12 * i), 0, 12, 36));
			caveBottom.add(new Rectangle((12 * i), 348, 12, 36));
		}

		repaint();
	}

	/**
	 * renders all objects to Graphics g
	 */
	public void draw(Graphics2D g) {
		super.paint(g);// refresh the background

		Color lightBlue = new Color(129, 135, 249);
		g.setColor(lightBlue);
		g.fillRect(0, 384, 384, 96);
		g.setColor(Color.BLUE);
		g.setFont(scoreFont);
		g.drawString("score : " + frameCount, 160, 430); // render the score
		((Graphics2D) g).drawString(String.valueOf(score),
				(BORDER.width + 16) / 2, (BORDER.height + 39) / 2);
		((Graphics2D) g).drawString(String.valueOf(hiScore),
				(BORDER.width + 16) / 2, (BORDER.height + 39) / 2);

		// YOUR CODE GOES HERE..
		// render all game objects here
		new Color(128, 128, 255);
		for (Rectangle o : blocks) {
			((Graphics2D) g).draw(o);
		}
		new Color(128, 128, 255);
		((Graphics2D) g).draw(wormHead);
		for (Rectangle y : worm) {
			((Graphics2D) g).draw(y);
		}
		// ?????
		for (int l = 0; l < worm.size(); l++) {
			((Graphics2D) g).drawLine(worm.get(l).x + 12, worm.get(l).y,
					worm.get(l).x + 12, worm.get(l).y);
		}
		for (int k = 0; k < explodeCount; k++) {
			new Color(255, 0, 0);
			g.drawOval(3 * k, 3 * k, 6 * k, 6 * k);
		}

		// FOR DEBUGGING WINDOW SIZE...
		g.setColor(Color.RED);
		g.drawRect(BORDER.x, BORDER.y, BORDER.width - 1, BORDER.height - 1);

	}

	/**
	 * Called when the timer fires<br>
	 * this is where all the instance variables will be updated
	 */
	public void update() {

		// YOUR CODE GOES HERE..
		// update all instance variables
		if (explodeCount < 0) {
			updateCave();
			updateBlocks();
			updateWorm();
		} else if (explodeCount < 30) {
			explodeCount++;
		} else {
			timer.stop();
		}
	}

	public void updateCave() {
		if (Math.random() < 0.1) {
			caveIncr = (int) (Math.random() * 10 - 5) * 3;
		}
		if (frameCount % 10 == 0) {
			caveHeight -= 3;
		}
		if (caveIncr < 0
				&& caveTop.get(caveTop.size() - 1).getHeight() + caveIncr < 0) {
			caveIncr = -1 * caveIncr;
		}
		if (caveIncr > 0
				&& caveTop.get(caveTop.size() - 1).getHeight() + caveIncr
						+ caveHeight > 384) {
			caveIncr = -1 * caveIncr;
		}
		caveTop.add(new Rectangle(384, 0, 12, ((int) caveTop.get(
				caveTop.size() - 1).getHeight() + caveIncr)));
		caveTop.remove(0);
		shiftLeft(caveTop);
		caveBottom
				.add(new Rectangle(384, ((int) caveTop.get(caveTop.size() - 1)
						.getHeight() + caveHeight), 12, 384 - ((int) caveTop
						.get(caveTop.size() - 1).getHeight() + caveHeight)));
		int y = caveTop.get(caveTop.size() - 1).height + caveHeight;
		caveBottom.add(new Rectangle(384, y, 12, 384 - y));
		caveBottom.remove(0);
		shiftLeft(caveBottom);

	}

	public void shiftLeft(ArrayList<Rectangle> rects) {
		for (int i = 0; i < rects.size(); i++) {
			rects.get(i).x -= 12;

		}
		if (rects.size() > 0 && rects.get(0).x < -24) {
			rects.remove(0);
		}

	}

	public void updateBlocks() {
		// frameCount++;
		if (frameCount < 10) {
			shiftLeft(blocks);
		}
		if (frameCount % 10 == 0) {
			frameCount = 1;
			Rectangle last = caveTop.get(caveTop.size() - 1);
			int yRand = (int) (Math.random() * (caveHeight - 48 - 24))
					+ last.height + 12;
			blocks.add(new Rectangle(384, yRand, 12, 48));
		}

	}

	public void updateWorm() {
		score += 3;
		if (score > hiScore) {
			score = hiScore;
		}
		if (spacePressed == true) {
			velocity += upForce;
			if (velocity > maxVelocity) {
				maxVelocity = velocity;
			}
		}
		if (spacePressed == false) {
			velocity -= downForce;
			if (velocity < minVelocity) {
				minVelocity = velocity;
			}
		}
		wormHead.y -= velocity;
		shiftLeft(worm);
		worm.add((new Rectangle(90, wormHead.y, 12, 12)));
		Rectangle hitBox = new Rectangle(wormHead.x, wormHead.y, 1, 4);
		for (Rectangle r : caveTop) {
			if (hitBox.intersects(r))
				explodeCount++;

		}
		for (Rectangle r : caveBottom) {
			if (hitBox.intersects(r))
				explodeCount++;

		}
		for (Rectangle r : blocks) {
			if (hitBox.intersects(r))
				explodeCount++;

		}

	}

	/**
	 * handles any key pressed events and updates the player's direction by
	 * setting their direction to either 1 or -1 for right or left respectively
	 * and updates their jumping status by invoking jump()
	 */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE) {
			// worm accelerates up
			spacePressed = true;
		}
	}

	/**
	 * main() is needed to initialize the window.<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! .. <br>
	 * you should write all necessary initialization code in initRound()
	 */
	public static void main(String[] args) { // give me a Unresolved compilation
												// problem here at this line
		JFrame window = new JFrame("Clone of SFCave");
		window.setBounds(100, 100, BORDER.width + 16, BORDER.height + 39);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		SFCave game = new SFCave();
		game.setBackground(Color.WHITE);
		window.getContentPane().add(game);
		window.setVisible(true);
		game.init();
		window.addKeyListener(game);
	}

	/**
	 * init method needed to initialize non-static fields<br>
	 * THIS METHOD NEED NOT BE MODIFIED! ..
	 */
	public void init() {
		offScreenBuffer = createImage(getWidth(), getHeight());// should be
																// 384x480
		offScreenGraphics = offScreenBuffer.getGraphics();
		timer = new Timer(delay, this);
		// timer fires every delay milliseconds.. invokes method
		// actionPerformed()
		initRound();
	}

	/**
	 * Called automatically after a repaint request<br>
	 * THIS METHOD NEED NOT BE MODIFIED! ..
	 */
	public void paint(Graphics g) {
		new Color(0, 255, 128);
		draw((Graphics2D) offScreenGraphics);
		g.drawImage(offScreenBuffer, 0, 0, this);
		Color darkGreen = new Color(0, 255, 128);
		Color lightBlue = new Color(128, 128, 255);
		g.setColor(darkGreen);
		for (Rectangle r : caveTop) {
			((Graphics2D) g).fill(r);
		}
		for (Rectangle p : caveBottom) {
			((Graphics2D) g).fill(p);
		}

	}

	/**
	 * Called automatically after a repaint request<br>
	 * THIS METHOD NEED NOT BE MODIFIED! ..
	 */
	public void actionPerformed(ActionEvent e) {

		update();
		frameCount++;// used for the score
		repaint();// needed to refresh the animation
	}

	/**
	 * handles any key released events .. restarts the game if the Timer is not
	 * running and user types SPACE THIS METHOD NEED NOT BE MODIFIED! ..
	 */
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE) {
			spacePressed = false;
			if (!timer.isRunning()) {
				timer.start();
				initRound();
			}
		}
	}

	/**
	 * this method is needed for implementing interface KeyListener<br>
	 * THIS METHOD NEED NOT BE MODIFIED! ..
	 */
	public void keyTyped(KeyEvent e) {
	}

}// end class SFCave
