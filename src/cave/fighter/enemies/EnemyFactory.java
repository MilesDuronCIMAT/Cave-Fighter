package cave.fighter.enemies;


import java.util.ArrayList;

import cave.fighter.character.MainCharacter;
import cave.fighter.utilities.Constants;

public class EnemyFactory {

	// Holds a list of co-ordinates that are good for spawning enemies
	// 3 combos for each # of enemies
	private final static int[][] possibleSpawnsX = { { 400 }, { 200 }, { 400 },
			{ 200, 650 }, { 550, 320 }, { 150, 660 }, { 230, 400, 580 },
			{ 470, 410, 350 }, { 270, 650, 650 }, { 150, 680, 150, 680 },
			{ 412, 412, 350, 470 }, { 275, 375, 475, 575 },
			{ 150, 680, 150, 680, 400 }, { 275, 415, 540, 415, 415 },
			{ 285, 530, 415, 285, 530 } };
	private final static int[][] possibleSpawnsY = { { 240 }, { 120 }, { 200 },
			{ 160, 350 }, { 250, 250 }, { 350, 160 }, { 250, 250, 250 },
			{ 300, 250, 300 }, { 250, 160, 380 }, { 150, 150, 360, 360 },
			{ 215, 300, 250, 250 }, { 260, 260, 260, 260 },
			{ 150, 150, 360, 360, 260 }, { 260, 260, 260, 180, 340 },
			{ 320, 320, 260, 200, 200 } };

	public static ArrayList<Enemy> getEnemyList(int difficulty) {

		ArrayList<Enemy> enemies = new ArrayList<Enemy>();

		// Randomizes the amount of enemies in the current room
		// Easy: 1 - 3
		// Medium: 2 - 4
		// Hard: 3 - 5
		int numEnemies = (int) (difficulty + (3 * Math.random()));

		int randomNum = (int) ((Math.random() + numEnemies - 1) * 3);

		for (int i = 0; i < numEnemies; i++) {

			int rand = (int) (Math.random() * Constants.NUM_ENEMY_TYPE);

			int speed;
			int health;
			int damage;

			switch (rand) {

			case 0:
				speed = 1;
				health = (int) (Math.random() * difficulty * 2) + difficulty
						* 3;
				damage = difficulty;
				enemies.add(new GreenSlime(possibleSpawnsX[randomNum][i],
						possibleSpawnsY[randomNum][i], speed, health, damage));
				break;
			case 1:
				speed = 1;
				health = (int) (Math.random() * difficulty * 2) + difficulty
						* 3;
				damage = difficulty + 2;
				enemies.add(new BlueSlime(possibleSpawnsX[randomNum][i],
						possibleSpawnsY[randomNum][i], speed, health, damage));
				break;
			case 2:
				speed = 1;
				health = (int) (Math.random() * difficulty * 2) + difficulty
						* 3;
				damage = difficulty;
				enemies.add(new YellowSlime(possibleSpawnsX[randomNum][i],
						possibleSpawnsY[randomNum][i], speed, health, damage));
				break;
			case 3:
				speed = 1;
				health = (int) (Math.random() * difficulty * 2) + difficulty
						* 3 + 2;
				damage = difficulty + 1;
				enemies.add(new RedSlime(possibleSpawnsX[randomNum][i],
						possibleSpawnsY[randomNum][i], speed, health, damage));
				break;
			}
		}
		return enemies;
	}

	public static Enemy spawnEnemy(int difficulty) {

		int speed;
		int health;
		int damage;

		// randomizes enemy indexes
		int rand = (int) (Math.random() * Constants.NUM_ENEMY_TYPE);

		switch (rand) {

		// Spawns green slime
		case 0:
			speed = 1;
			health = (int) (Math.random() * difficulty * 2) + difficulty * 3;
			damage = difficulty;
			return (new GreenSlime(400, 140, speed, health, damage));
			// Spawns blue slime
		case 1:
			speed = 1;
			health = (int) (Math.random() * difficulty * 2) + difficulty * 3;
			damage = difficulty + 2;
			return (new BlueSlime(400, 140, speed, health, damage));
			// Spawns yellow slime
		case 2:
			speed = 1;
			health = (int) (Math.random() * difficulty * 2) + difficulty * 3;
			damage = difficulty;
			return (new YellowSlime(400, 140, speed, health, damage));
			// Spawns red slime
		case 3:
			speed = 1;
			health = (int) (Math.random() * difficulty * 2) + difficulty * 3
					+ 2;
			damage = difficulty + 1;
			return (new RedSlime(400, 140, speed, health, damage));
		}
		return null;
	}

	public static Enemy spawnTentacle() {
		int speed = 0;
		int health = 7;
		int damage = 2;
		return (new Tentacle(MainCharacter.getCharacterInstance().getX(), MainCharacter.getCharacterInstance().getY(), speed, health, damage));
	}

	private EnemyFactory() {/* Utility Class */
	}

}
