package dalialevel2;

import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	final int width = 500;
	final int height = 800;
	GamePanel GamePanel = new GamePanel();

	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
	}

	public LeagueInvaders() {
		this.frame = frame;
		this.GamePanel = GamePanel;
		setup();
	}

	void setup() {
		frame.addKeyListener(GamePanel);
		frame.add(GamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		GamePanel.startGame();
	}

}

class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer = new Timer((1000 / 60), this);
	GameObject GameObject = new GameObject();

	public GamePanel() {
		this.timer = timer;
		this.GameObject = GameObject;
	}

	public void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		GameObject.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		GameObject.update();
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("c");
	}
}

class GameObject {
	int x;
	int y;
	int width;
	int height;

	void GameObject() {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
x = x+1;
y = y+1;
	}

	void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}
}
