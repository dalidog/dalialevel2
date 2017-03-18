package dalialevel2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer = new Timer((1000 / 60), this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	Font font = new Font("Papyrus", Font.PLAIN, 48);
	Font font2 = new Font("Papyrus", Font.PLAIN, 30);
	int currentState = MENU_STATE;
	Rocketship rocketship = new Rocketship(50, 50, 250, 700, 5);
	ObjectManager objectmanager = new ObjectManager();

	public GamePanel() {
		objectmanager.addObject(rocketship);

	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		objectmanager.update();
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, 500, 800);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("League Invaders!", 80, 150);
		g.setFont(font2);
		g.drawString("Press ENTER to start.", 100, 250);
		g.drawString("Press SPACE for instructions.", 50, 400);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		// System.out.println("HAAAAAAA");
		objectmanager.draw(g);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER!", 100, 100);
		g.setFont(font2);
		g.drawString("You killed 0 aliens.", 130, 300);
		g.drawString("Press BACKSPACE to Restart.", 50, 500);
	}

	public void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("a");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("b");
		if (e.getKeyCode() == 10) {
			currentState += 1;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Rocketship.up = true;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Rocketship.down = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Rocketship.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Rocketship.left = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("c");
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Rocketship.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Rocketship.down = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Rocketship.right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Rocketship.left = false;
		}
	}
}
