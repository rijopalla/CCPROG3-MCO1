package Classes;

public class Enemy {
	
	//Properties
	private String enemyName;
	private int enemyPower;
	
	//Constructor
	public Enemy(String name, int power) {
		this.enemyName = name;
		this.enemyPower = power;
	}
	
	//Methods
	
	//Getters
	public String getEnemyName() {
		return this.enemyName;
	}
	
	public int getEnemyPower() {
		return this.enemyPower; 
	}
	
}
