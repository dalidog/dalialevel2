package dalialevel2;

import java.awt.Graphics;
import java.awt.Rectangle;

class GameObject{
	int x;
	int y;
	int width;
	int height;
	public boolean isAlive = true;
	public Rectangle collisionBox = new Rectangle();
	void GameObject() {      
		this.isAlive=true;
		this.collisionBox= new Rectangle(x,y,width,height);
	}

	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {

	}
}