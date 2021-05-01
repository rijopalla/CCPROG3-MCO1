public class Weapon {
	
	//Properties
	private String weaponName; //Name
	private int weaponPower;   //Power
	private int weaponRarity;  //Rarity
	private int weaponLevel;   //Level
	private Character weaponOwner; //stores which character the weapon is equipped to
	private boolean isEquipped; //determines if the weapon is equipped to a character or not
	private float weapRarityMultiplier; //stores weapon rarity multiplier
	
	//Constructor
	public Weapon(String weapName, int weapPower, int weapRarity) {
		this.weaponName = weapName;
		this.weaponPower = weapPower;
		this.weaponRarity = weapRarity;
		this.weaponLevel = 1;
		this.isEquipped = false;
	
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
	public void weapLevelUp(int resourceNum) {
		//takes the allotted resources as an input
		
		//weapon only levels up if resource amount > 0 and weapon's level < max level (50)
		if (resourceNum > 0 && this.weaponLevel < 50) {
			
			//character levels up until loop reaches input
			for (int i = 0; i < resourceNum; i++) 
				this.weaponLevel++;
		}
		
	}
	
	public void mergeWeap(Weapon weapon1, Weapon weapon2) {
		/*mergeWeapon() takes two other weapons and merges them into the weapon
		* that's calling the method
		*/
		
		//1. check if all weapons have the same name
		if (this.weaponName.equals(weapon1.getWeaponName()) && this.weaponName.equals(weapon2.getWeaponName())) {
			//2. check if all weapons have the same rarity
			if (this.weaponRarity == weapon1.getWeaponRarity() ) {
				
				//a. if weapon1 and weapon2 are equipped, unequip them from their characters first before merging
				if (weapon1.getWeaponOwner() != null || weapon2.getWeaponOwner() != null) {
					weapon1.weaponOwner = null;
					weapon2.weaponOwner = null;
				}
				
				//3. merge weapons
				if (this.weaponRarity < 5) {
					this.weaponRarity++;
					weapon1 = null; //deletes weapon1
					weapon2 = null; //deletes weapon2
				}
				else
					System.out.println("Cannot be merged! Weapon is already at maximum rarity!"); //print error message when weapon's rarity is already 5
			}
			else
				System.out.println("Cannot be merged! Weapons must have the same rarity!"); //print error message when weapons don't have the same rarity
		}
		else
			System.out.println("Cannot be merged! Weapons must have the same name!"); //print error message when weapons don't have the same name
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
	
	public boolean isEquipped() {
		return this.isEquipped;
	}
	
	//Setters
	public void setWeaponOwner(Character chara) {
		this.weaponOwner = chara;
	}
	
	public void setIsEquipped(boolean equipCheck) {
		this.isEquipped = equipCheck;
	}
}