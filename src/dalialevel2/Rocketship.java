package dalialevel2;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	static boolean up;
	static boolean down;
	static boolean right;
	static boolean left;
	public Rocketship(int width, int height, int x, int y, int speed) {
		this.width = width;
		this.height = height;
		this.x=x;
		this.y=y;
		this.speed = speed;
	}

	void update(){
		if(up == true){
			y=y-speed;
		}
		if(down == true){
			y=y+speed;
		}
		if(right == true){
			x=x+speed;
		}
		if(left == true){
			x=x-speed;
		}
	}
	void draw(Graphics g){
		g.setColor(Color.CYAN);
		
		g.fillRect(x, y, width, height);
	}
}