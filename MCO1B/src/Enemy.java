public class Enemy {
	
	//Properties
	private String enemyName;
	private int enemyPower;
	
	//Constructor
	public Enemy(String name, int power) {
		this.setEnemyName(name);
		this.setEnemyPower(power);
	}
	
	//Methods
	
	//Getters
	public String getEnemyName() {
		return this.enemyName;
	}
	
	public int getEnemyPower() {
		return this.enemyPower; 
	}
	
	//Setters
	public void setEnemyName(String name) {
		this.enemyName = name;
	}
	
	public void setEnemyPower(int power) {
		this.enemyPower = power;
	}

}
