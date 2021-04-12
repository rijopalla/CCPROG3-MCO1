public class Weapon {
	
	//Properties
	private String weaponName; //Name
	private int weaponPower;   //Power
	private int weaponRarity;  //Rarity
	private int weaponLevel;   //Level
	private Character weaponOwner; //stores which character the weapon is equipped to
	private float weapRarityMultiplier;
	
	//Constructor
	public Weapon(String weapName, int weapPower, int weapRarity) {
		this.weaponName = weapName;
		this.weaponPower = weapPower;
		this.weaponRarity = weapRarity;
		this.weaponLevel = 1;
		
		switch(weapRarity) {
		case 1:
			this.weapRarityMultiplier = (float) 0.7;
			break;
		
		case 2:
			this.weapRarityMultiplier = (float) 0.8;
			break;
		
		case 3:
			this.weapRarityMultiplier = (float) 0.9;
			break;
			
		case 4:
			this.weapRarityMultiplier = (float) 1.0;
			break;
			
		case 5:
			this.weapRarityMultiplier = (float) 1.2;
			break;
		}
	}
	
	//Methods
	public void weapLevelUp(Resource r, int input) {
		int i;
		
		//weapon levels up until loop reaches input
		//only levels up if resource amount > 0 and character level < max level (100)
		
		for (i = 0; i < input; i++) {
			
			if (r.getResourceAmount() > 0 && this.weaponLevel <= 100) {
				this.weaponLevel++;
				r.subtractResource(1);
			}
		}
		
	}
	
	public void mergeWeap(Weapon baseWeap, Weapon weapon2, Weapon weapon3) {
		//TBA 
	}
	
	//Getters
	public String getWeaponName() {
		return this.weaponName;
	}
	
	public int getWeaponPower() {
		return this.weaponPower;
	}
	
	public int getWeaponRarity() {
		return this.weaponRarity;
	}
	
	public int getWeaponLevel() {
		return this.weaponLevel;
	}
	
	public Character getWeaponOwner() {
		return this.weaponOwner;
	}
	
	public float getWeapRarityMultiplier() {
		return this.weapRarityMultiplier;
	}
	
	//Setters
	public void setWeaponOwner(Character chara) {
		this.weaponOwner = chara;
	}

}
