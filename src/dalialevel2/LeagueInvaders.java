package dalialevel2;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	final int width = 500;
	final int height = 800;
	GamePanel GamePanel = new GamePanel();

	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
	}

	public LeagueInvaders() {
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




