import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class Snake {
	/**
	 * Current direction of the Snake will always be either 8, 2, 4, or 6 … which is
	 * up, down, left, right taken from the orientation of numpad keys on keyboard
	 */
	private int currentDirection;

	/** The number of tail pieces that need to be added to the end of body */
	private int amountToGrow;

	/** The head of the Snake */
	private Rectangle head;

	/** The List of Rectangle objects that are the body of the Snake */
	private ArrayList<Rectangle> body;

	/**
	 * The List of integer directions stored from keyboard input that the Snake will
	 * turn based on the order in which they were inputted from the keyboard
	 */
	private ArrayList<Integer> directionQ;

	/** The object the Snake will intersect with to grow */
	private Rectangle nibble = new Rectangle(200, 300, 20, 20);

	public Snake(int curDir, int amtGro) {
		head = new Rectangle(200, 200, 20, 20);
		nibble = new Rectangle(200, 300, 20, 20);
		directionQ = new ArrayList<Integer>();
		body = new ArrayList<Rectangle>();
		currentDirection = curDir;
		amountToGrow = amtGro;
	}

	public void render(Graphics2D g) {
		g.draw(head);
		g.fill(nibble);
		for (int i = 0; i < body.size(); i++) {
			g.draw(body.get(i));
		}
	}

	public void addDirection(int d) {
		int len = directionQ.size();
		if (len == 0 && d != currentDirection && d + currentDirection != 10) {
			directionQ.add(d);
		}
		if (len >= 1 && d != directionQ.get(len - 1) && d + directionQ.get(len - 1) != 10) {
			directionQ.add(d);
		}
	}

	public void updateDirection() {
		if (directionQ.size() >= 1) {
			currentDirection = directionQ.get(0);
			directionQ.remove(0);
		}

	}

	public void updatePosition() {
		Rectangle temp = new Rectangle(head);
		body.add(0, temp);
		if (currentDirection == 8) {
			head.translate(0, -20);
		} else if (currentDirection == 2) {
			head.translate(0, 20);
		} else if (currentDirection == 4) {
			head.translate(-20, 0);
		} else if (currentDirection == 6) {
			head.translate(20, 0);
		}
	}

	public void moveNibble() {
		int randX = (int) ((Math.random()) * 20) * 20;
		int randY = (int) ((Math.random()) * 20) * 20;
		boolean valid = false;
		Rectangle nibbleTemp = null; // new Rectangle(randX, randY, 20, 20);
		while (!valid) {
			valid = true;
			nibbleTemp = new Rectangle((int) ((Math.random()) * 20) * 20, (int) ((Math.random()) * 20) * 20, 20, 20);
			if (nibbleTemp.intersects(head)) {
				valid = false;
				for (int i = 0; i < body.size(); i++) {
					if (nibbleTemp.intersects(body.get(i))) {
						randX = (int) ((Math.random()) * 20) * 20;
						randY = (int) ((Math.random()) * 20) * 20;

					}
				}

			}

		}
		nibble = nibbleTemp;
	}

	public void eatNibble() {
		if (head.intersects(nibble)) {
			amountToGrow += 5;
			moveNibble();
		}
	}

	public void eraseTail() {
		int len = body.size();
		if (amountToGrow == 0) {
			body.remove(len - 1);
		} else {
			amountToGrow--;
		}

	}

	public boolean isDead() {
		Rectangle Border = new Rectangle(0, 0, 400, 400);
		for (int i = 0; i < body.size(); i++) {
			if (head.intersects(body.get(i)) || !head.intersects(Border)) {
				return true;
			}
		}

		return false;
	}
}

public class SnakeGameAP extends JPanel implements KeyListener, ActionListener {

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~
	// UNCOMMENT after Question 1
	private Snake snake = new Snake(8, 5);
	// UNCOMMENT after Question 1
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~

	private int frameCount;
	private Timer timer;
	private Image offScreenBuffer;// double buffering
	private Graphics offScreenGraphics;// double buffering

	/**
	 * initializes all fields needed for each round of play (i.e. restart)
	 */
	public void initRound() {
		frameCount = 0;

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~
		// UNCOMMENT after Question 1
		snake = new Snake(8, 5);
		// UNCOMMENT after Question 1
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~

	}

	/**
	 * renders all objects to Graphics g (i.e. the window)
	 */
	public void draw(Graphics2D g) {
		if (g == null)
			return;
		super.paint(g);// refresh the background
		g.setColor(Color.BLACK);
		g.drawString("frameCount: " + frameCount, 40, 40);
		if (!timer.isRunning()) {
			g.drawString("PRESS SPACE TO START", 130, 140);
		}

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~
		// UNCOMMENT after Question 1
		snake.render(g);
		// UNCOMMENT after Question 1
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~

	}

	/**
	 * Update all game objects .. called automatically when the timer fires<br>
	 */
	public void actionPerformed(ActionEvent e) {

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~
		// UNCOMMENT after Question 2
		snake.updateDirection();
		snake.updatePosition();
		// UNCOMMENT after Question 2
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~
		// UNCOMMENT after Question 3
		snake.eatNibble();
		snake.eraseTail();
		// UNCOMMENT after Question 3
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~
		// UNCOMMENT after Question 4
		if (snake.isDead())
			timer.stop();
		// UNCOMMENT after Question 4
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~

		frameCount++;// keep track of how many frames in the round
		repaint();// needed to refresh the animation
	}

	/**
	 * handles key pressed events and updates the snake's direction
	 */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~
		// UNCOMMENT after Question 2
		if (keyCode == KeyEvent.VK_UP)
			snake.addDirection(8);
		else if (keyCode == KeyEvent.VK_DOWN)
			snake.addDirection(2);
		else if (keyCode == KeyEvent.VK_LEFT)
			snake.addDirection(4);
		else if (keyCode == KeyEvent.VK_RIGHT)
			snake.addDirection(6);
		// UNCOMMENT after Question 2
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~

	}

	/**
	 * handles key released events and restarts the game on 'space' event
	 */
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE && !timer.isRunning()) {
			timer.start();
			initRound();
		}
	}

	/**
	 * you should write all necessary initialization code in initRound() THIS METHOD
	 * SHOULD ONLY BE MODIFIED IF ADDING SOUNDS OR IMAGES! .. <br>
	 */
	public void init() {
		offScreenBuffer = createImage(getWidth(), getHeight());// should be 400x400
		offScreenGraphics = offScreenBuffer.getGraphics();
		initRound();
		timer = new Timer(100, this);
		// timer fires every 100 milliseconds.. and invokes method actionPerformed()
	}

	/**
	 * main method needed for initialize the game window .. <br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! .. <br>
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Snake Game Clone");
		window.setBounds(100, 100, 400 + 6, 400 + 28);// inside JFrame will be 600x600
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		SnakeGameAP game = new SnakeGameAP();
		game.setBackground(Color.WHITE);
		window.getContentPane().add(game);
		window.setVisible(true);
		game.init();
		window.addKeyListener(game);
	}

	/**
	 * Called automatically after a repaint request<br>
	 * .. THIS METHOD SHOULD NOT BE MODIFIED! .. <br>
	 */
	public void paint(Graphics g) {
		draw((Graphics2D) offScreenGraphics);
		g.drawImage(offScreenBuffer, 0, 0, this);
	}

	/**
	 * leave empty.. needed for implementing interface KeyListener<br>
	 * .. THIS METHOD SHOULD NOT BE MODIFIED! .. <br>
	 */
	public void keyTyped(KeyEvent e) {
	}
}// end class SnakeGameAP
