package cave.fighter.enemies;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import animation.framework.Animation;

public abstract class Enemy {

	private int speed;
	private boolean alive = true;
	private boolean spawning;
	private int x;
	private int y;
	private int health;
	private int damage;
	private float alpha = .01f;
	private int counter = 0;
	private Animation enemyAnimation;
	private Image image;
	private Image canvasImage;
	public Rectangle enemyHitBox;
	
	public Enemy(int x, int y, int speed, int health, int damage) {
		
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.health = health;
		this.damage = damage;
		this.setSpawning(spawning);
		canvasImage = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
		enemyAnimation = new Animation();
		enemyHitBox = new Rectangle(0,0,0,0);
	}
	
	public abstract void update();

	public void fade() {
		Graphics2D g2d = (Graphics2D) canvasImage.getGraphics();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));
		g2d.drawImage(image, 0, 0, null);
		enemyAnimation.setFrame(canvasImage, 100, 0);
		counter++;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void damageEnemy(int dmg){
		health -= dmg;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Animation getEnemyAnimation() {
		return enemyAnimation;
	}

	public void setEnemyAnimation(Animation enemyAnimation) {
		this.enemyAnimation = enemyAnimation;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isSpawning() {
		return spawning;
	}

	public void setSpawning(boolean spawning) {
		this.spawning = spawning;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}