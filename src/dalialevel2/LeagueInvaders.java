package dalialevel2;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Normalizer.Form;

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
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	Font font = new Font("Papyrus", Font.PLAIN, 48);
	int currentState = MENU_STATE;
	public GamePanel() {
		this.timer = timer;
		
	}
	public void updateMenuState(){
		
	}
	public void updateGameState(){
		
	}
	public void updateEndState(){
		
	}
	public void drawMenuState(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, 500, 800);
		g.setFont(font); 
		g.setColor(Color.black);
		g.drawString("League Invaders!", 100, 100);
	}
	public void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
	}
	public void drawEndState(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
	}
	public void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();

		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
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
		if(e.getKeyCode()==10){
			currentState += 1;
			 if(currentState >  END_STATE){
				currentState = MENU_STATE;
			}


		}
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
