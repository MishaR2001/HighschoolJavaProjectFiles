
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Astronaut {
	/** The physical representation of the Astronaut */
	private Rectangle body;

	/** The motion state of the Astronaut */
	private int xVelocity, yVelocity, direction;
	private int jcountCap = 2; // jump count cap
	private int ccount = 0; // current jump counter
	public final int terminalVelocity = 8;

	/** The List of attacking alien Rectangle objects */
	private ArrayList<Rectangle> aliens;

	public Astronaut() {
	}

	public Astronaut(int xCoord, int yCoord) {
		body = new Rectangle(xCoord, yCoord, 20, 40);
		aliens = new ArrayList<Rectangle>();
	}

	public void render(Graphics2D g) {
		for (int i = 0; i < aliens.size(); i++) {
			g.draw(aliens.get(i));
		}
		g.fill(body);
	}

	public int getDirection() {

		return direction;
	}

	public void setDirection(int d) {
		direction = d;
	}

	public void update() {
		if (direction == 1 && xVelocity < terminalVelocity) {
			xVelocity++;
		}
		if (direction == -1 && xVelocity > -terminalVelocity) {
			xVelocity--;
		}
		if (direction == 0) {
			if (xVelocity < 0) {
				xVelocity++;
			}
			if (xVelocity > 0) {
				xVelocity--;
			}
		}
		if (body.getY() < 360) {
			yVelocity--;
		}
		body.translate(xVelocity, -yVelocity);
	}

	public void constrain() {
		if (body.getX() < 0) {
			body.setLocation(0, (int) body.getY());
		}
		if (body.getX() > 780) {
			body.setLocation(780, (int) body.getY());
		}
		if (body.getY() > 360) {
			body.setLocation((int) body.getX(), 360);
		}
	}

	public void jump() {
		if (ccount >= jcountCap && body.getY() == 360) {
			ccount = 0;
		}

		if (ccount < jcountCap) {
			yVelocity = 15;
			body.translate(0, -15);
			ccount++;
		}

	}

	public void updateAliens() {
		double r = Math.random();
		int y = (int) ((Math.random()) * 40) + 321;
		int w = (int) ((Math.random()) * 15) + 1;
		if (r < 0.05) {
			aliens.add(new Rectangle(800, y, w, 20));
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).translate((int) aliens.get(i).getWidth() * -1, 0);
		}
	}

	public boolean isGameOver() {
		for (int i = 0; i < aliens.size(); i++) {
			if (body.intersects(aliens.get(i))) {
				return true;
			}
		}
		return false;
	}
}

/**
 * ~~~~~~~~~~~~~~~~~~~~~ Escape from Rectangulus ~~~~~~~~~~~~~~~~~~~~~<br>
 * 
 * you do NOT need to modify any of the code below
 */
public class EscapeFromRectangulusAP extends JPanel implements KeyListener, ActionListener {

	/**
	 * initializes all fields needed for each round of play (i.e. restart)
	 */
	public void initRound() {
		frameCount = 0;
		jan = new Astronaut(390, 360);
	}

	/**
	 * renders all objects to Graphics g
	 */
	public void draw(Graphics2D g) {
		if (g == null)
			return;
		g.setColor(Color.WHITE);// background color
		g.fillRect(0, 0, 800, 400);// refresh the background

		g.setColor(Color.BLACK); // title color
		g.drawString(title, 100, 20);// draw the title towards the top
		g.drawRect(0, 0, 799, 399); // draw the game bounds
		g.drawString("score:  " + frameCount, 380, 100);// approximate middle

		jan.render(g);
	}

	/**
	 * Called automatically when the timer fires<br>
	 * this is where all the game fields will be updated
	 */
	public void actionPerformed(ActionEvent e) {
		frameCount++;// used for the score
		jan.update();
		jan.constrain();
		jan.updateAliens();
		if (jan.isGameOver()) {
			timer.stop();
			try {
				String url = "http://vikingcomputerscience.com/mrruth/cabIP.php?";
				url += "usr=" + System.getProperty("user.name") + "&scr=" + frameCount;
				URL leaderboard = new URL(url);
				BufferedReader in = new BufferedReader(new InputStreamReader(leaderboard.openStream()));
				in.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		repaint();// needed to refresh the animation
	}

	/**
	 * handles any key pressed events and updates the player's direction by setting
	 * their direction to either 1 or -1 for right or left respectively and updates
	 * their jumping status by invoking jump()
	 */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT) {
			jan.setDirection(-1);
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			jan.setDirection(1);
		} else if (keyCode == KeyEvent.VK_UP) {
			jan.jump();
		}
	}

	/**
	 * handles any key released events and updates the player's direction by setting
	 * their direction to 0 if they need to stop and restarts the game if the Timer
	 * is not running and user types 'r'
	 */
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT && jan.getDirection() == -1) {
			jan.setDirection(0);
		} else if (keyCode == KeyEvent.VK_RIGHT && jan.getDirection() == 1) {
			jan.setDirection(0);
		}
		if (keyCode == KeyEvent.VK_R) {
			if (!timer.isRunning()) {
				timer.start();
				initRound();
			}
		}
	}

	private Astronaut jan = new Astronaut();
	private int frameCount;// used for the score
	private String title = "~~ Escape From Rectangulus ~~  " + "CONTROLS: arrows = move, up arrow = jump, r = restart ";
	private Timer timer;// handles animation
	private static Image offScreenBuffer;// needed for double buffering graphics
	private Graphics offScreenGraphics;// needed for double buffering graphics

	/**
	 * main() is needed to initialize the window.<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! .. <br>
	 * you should write all necessary initialization code in initRound()
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Escape From Rectangulus");
		window.setBounds(100, 100, 806, 428);// updated for Windows 10
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		EscapeFromRectangulusAP game = new EscapeFromRectangulusAP();
		window.getContentPane().add(game);
		window.setVisible(true);
		game.init();
		window.addKeyListener(game);
	}

	/**
	 * init method needed to initialize non-static fields<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! ..
	 */
	public void init() {
		offScreenBuffer = createImage(getWidth(), getHeight());// should be 800x400
		offScreenGraphics = offScreenBuffer.getGraphics();
		timer = new Timer(30, this);
		// timer fires every 30 milliseconds.. invokes method actionPerformed()
		initRound();
	}

	/**
	 * Called automatically after a repaint request<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! ..
	 */
	public void paint(Graphics g) {
		draw((Graphics2D) offScreenGraphics);
		g.drawImage(offScreenBuffer, 0, 0, this);
	}

	/**
	 * this method is needed for implementing interface KeyListener<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! ..
	 */
	public void keyTyped(KeyEvent e) {
	}

}// end class EscapeFromRectangulusAP
