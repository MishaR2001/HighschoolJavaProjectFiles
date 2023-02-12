import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

/**
 * <xmp><code>
 * 
 * <pre>
 * Project created by: Mr Ruth .. Niles North High School .. Skokie, IL ..
 * www.MrRuth.com modified for 2018
 * 
 * ... INSTRUCTIONS ...
 * 
 * You are to create several different modes of animation...
 * 
 * Step 0 : in method actionPerformed: write code to execute the following if
 * mode is 0 ~ increment x and y by 1 (i.e. x++) ~ Run your program and notice
 * the square move diagonally ~
 * 
 * 
 * NOTE: g.fillRect(x,y,size,size) ... the point (x,y) on the screen is the
 * upper left corner of the solid rectangle and size, size are the width and
 * height respectively ~
 * 
 * 
 * Step 1 : notice the instance variables: private int xVelocity, yVelocity ~
 * NOW... in method actionPerformed: add xVelocity to x and yVelocity to y ~
 * write conditionals to change the sign of xVelocity if the Rectangle reaches
 * the edge of the screen (i.e. left edge is 0, right edge is bounds.width) ~
 * and similarly for yVelocity ~ you should the the rectangle bouncing off the
 * edges ~
 * 
 * Fun challenge.. make the square move faster :)
 * 
 * 
 * Step 2: in method actionPerformed: write code to execute the following: if
 * mode is 1, generate random integers using Math.random() and assign to x and y
 * so the rectangle is placed at a random position on the screen ~ Make sure
 * your squares are random colors ~ Run your program and press the space bar to
 * change animation modes ~
 * 
 * Fun challenge.. instead of squares.. draw circles.. Fun challenge 2.. make
 * sure the entire screen is eventually covered (no blank spots)
 * 
 * 
 * Step 3: in method actionPerformed: write code to create your own animation
 * for when mode equals 2 .. BE AS CREATIVE AND ARTISTIC AS YOU WISH!!
 * 
 * NOTICE that toggling to mode 2 does not work correctly ~ search for variable
 * numModes and try to fix the logical error ~
 * 
 */

public class FunWithGraphics2018 extends JPanel implements ActionListener, KeyListener {

	private int x, y; // x and y coordinates for rectangle
	private int size = 200; // width and height of rectangle
	private int mode = 0; // current animation mode number
	private int numModes = 3; // number of animation modes available
	private int xVelocity = 10;
	private int yVelocity = 10;

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// YOUR CODE GOES HERE..
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// declare instance variables here for different modes
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void draw(Graphics2D g) {
		// g.clearRect(bounds.x, bounds.y, bounds.width, bounds.height);

		// generate a random color every frame
		int red = (int) (Math.random() * 256);// random int from 0 to 255
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		g.setColor(new Color(red, green, blue));

		if (mode == 0) {
			g.fillRect(x, y, size, size);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("AP Comp Sci", x + 20, y + 100);

		}

		else if (mode == 1) {
			g.fillOval(x, y, size, size);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("AP Comp Sci", x + 20, y + 100);

		} else if (mode == 2) {
			g.fillOval(x, y, size, size);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("AP Comp Sci", x + 20, y + 100);

		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// YOUR CODE GOES HERE..
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//
	// draw as many objects here as you want, any color you want
	// .. fillRect, fillOval, drawLine, drawString, and more
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void actionPerformed(ActionEvent e) {

		if (mode == 0) {
			x = x + xVelocity;
			y = y + yVelocity;
			if (x + size >= bounds.width) {
				xVelocity = (xVelocity) * -1;

			}
			if (y + size >= bounds.height) {
				yVelocity = (yVelocity) * -1;

			}
			if (x <= 0) {
				xVelocity = (xVelocity) * -1;

			}
			if (y <= 0) {
				yVelocity = (yVelocity) * -1;

			}
		} else if (mode == 1) {
			x = (int) (((Math.random()) * bounds.width) - 100);
			y = (int) (((Math.random()) * bounds.height) - 100);
		} else if (mode == 2) {
			x = x + xVelocity;
			y = y + yVelocity;
			if (x + size >= bounds.width) {
				xVelocity = (xVelocity) * -1;
			}
			if (y + size >= bounds.height) {
				yVelocity = (yVelocity) * -1;
			}
			if (x <= 0) {
				xVelocity = (xVelocity) * -1;
			}
			if (y <= 0) {
				yVelocity = (yVelocity) * -1;
			}
		}

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// YOUR CODE GOES HERE..
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//
		// update all instance variables here for all animation modes
		// ..note use if statements to determine which mode
		// the program is currently in...
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		frameCount++;// update the frameCount
		repaint();// needed to refresh the animation
	}

	public void changeMode() {
		mode++;
		mode %= numModes;
		x = 0;
		y = 0;
	}

	// !!!!!!!! WARNING.. DO NOT MODIFY CODE BELOW THIS LINE !!!!!!!!
	// !!!!!!!! WARNING.. DO NOT MODIFY CODE BELOW THIS LINE !!!!!!!!

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// !!!!!!!! WARNING.. DO NOT MODIFY CODE BELOW THIS LINE !!!!!!!!
	// !!!!!!!! WARNING.. DO NOT MODIFY CODE BELOW THIS LINE !!!!!!!!

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	private int frameCount;
	private Timer timer;// handles animation
	private static Image offScreenBuffer;// needed for double buffering graphics
	private Graphics offScreenGraphics;// needed for double buffering graphics
	private static Rectangle bounds;
	private static Insets screenInsets;

	/**
	 * Called automatically after a repaint request<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! ..
	 */
	public void paint(Graphics g) {
		draw((Graphics2D) offScreenGraphics);
		g.drawImage(offScreenBuffer, 0, 0, this);
	}

	/**
	 * init method needed to initialize non-static fields<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! ..
	 */
	public void init() {
		offScreenBuffer = createImage(getWidth(), getHeight());// should be 1016x736
		offScreenGraphics = offScreenBuffer.getGraphics();
		timer = new Timer(20, this);
		// timer fires every 20 milliseconds.. invokes method actionPerformed()

		frameCount = 0;
		// offScreenGraphics.clearRect(0, 0, 800, 600);
		offScreenGraphics.clearRect(bounds.x, bounds.y, bounds.width, bounds.height);
		timer.start();
		repaint();
	}

	/**
	 * main() is needed to initialize the window.<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! .. <br>
	 * you should write all necessary initialization code in initRound()
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fun With Graphics!");
		frame.setBounds(100, 100, 100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		FunWithGraphics2018 fwg = new FunWithGraphics2018();
		frame.getContentPane().add(fwg);
		frame.setBackground(Color.WHITE);
		frame.setUndecorated(true);
		frame.setVisible(true);

		// make fullscreen
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		// bounds = graphicsEnvironment.getMaximumWindowBounds();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		bounds = gd.getDefaultConfiguration().getBounds();
		screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(gd.getDefaultConfiguration());
		frame.setBounds(bounds);
		frame.setVisible(true);
		fwg.init();
		frame.addKeyListener(fwg);

		// hide mouse cursor
		Toolkit tk = Toolkit.getDefaultToolkit();
		frame.setCursor(
				tk.createCustomCursor(new BufferedImage(32, 32, BufferedImage.TYPE_4BYTE_ABGR), new Point(0, 0), ""));

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (keyCode == KeyEvent.VK_SPACE) {
			offScreenBuffer.getGraphics().clearRect(bounds.x, bounds.y, bounds.width, bounds.height);
			changeMode();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}// end class FunWithGraphics2018
