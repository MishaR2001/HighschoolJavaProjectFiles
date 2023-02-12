
/** 
 * Project made by Misha R and Grayson
 * 
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class LightsOutPanel extends JPanel implements MouseListener {
	private boolean[][] lights;

	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Lights Out!");
		frame.setResizable(false);
		frame.setVisible(true);

		LightsOutPanel panel = new LightsOutPanel();
		if (panel.lights == null) {
			System.out.println("You did not initialize your light array!  It's still null...");
			System.exit(-1);
		}
		panel.addMouseListener(panel);
		panel.setPreferredSize(new Dimension(601, 501));
		panel.setMinimumSize(new Dimension(601, 501));

		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel, BorderLayout.CENTER);

		frame.pack();
	}

	public LightsOutPanel() {
		lights = new boolean[5][6];
		for (int r = 0; r < lights.length; r++) {
			for (int c = 0; c < lights[0].length; c++) {
				lights[r][c] = true;
			}
		}

	}

	// unused methods
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void paint(Graphics g) {
		int boxWidth = 600 / 6;
		int boxHeight = 500 / 5;

		int y = 0;
		for (int row = 0; row < 5; row++) {
			int x = 0;
			for (int col = 0; col < 6; col++) {
				if (lights[row][col])
					g.setColor(Color.YELLOW);
				else
					g.setColor(Color.BLACK);
				g.fillRect(x, y, boxWidth, boxHeight);

				g.setColor(Color.BLUE);
				g.drawRect(x, y, boxWidth, boxHeight);
				x += boxWidth;
			}
			y += boxHeight;
		}
	}

	// called when the mouse is pressed - determines what row/column the user has
	// clicked
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();

		int panelWidth = getWidth();
		int panelHeight = getHeight();

		int boxWidth = panelWidth / lights[0].length;
		int boxHeight = panelHeight / lights.length;

		int col = mouseX / boxWidth;
		int row = mouseY / boxHeight;

		toggle(row, col);
		repaint();
	}

	// called to "toggle" the selected row and column, as well as the four adjacent
	// lights
	public void toggle(int row, int col) {
		lights[row][col] = !lights[row][col];
		if (col + 1 < lights[row].length) {
			lights[row][col + 1] = !lights[row][col + 1];
		}
		if (row + 1 < lights.length) {
			lights[row + 1][col] = !lights[row + 1][col];
		}
		if (col - 1 >= 0) {
			lights[row][col - 1] = !lights[row][col - 1];
		}
		if (row - 1 >= 0) {
			lights[row - 1][col] = !lights[row - 1][col];
		}

	}
}