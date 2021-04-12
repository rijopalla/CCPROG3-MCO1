public class Map {
	
	//Properties
	private String mapName;
	private int mapBaseAmount;
	private Enemy[] mapEnemyList;
	
	//Adventure variables
	private float elementComboMultiplier;
	private float totalFinalWeaponPower;
	private float totalCharacterInfluence;
	private int   totalResource;
	private float characterSuperiority;
	private int   enemySuperiority;
	
	//Constructor
	public Map(String name, int amount) {
		this.mapName = name;
		this.mapBaseAmount = amount;
	}
	
	//Methods
	private float calculateTotalFinalWeaponPower(Weapon char1Weapon, Weapon char2Weapon) {
		
		float finalWeaponPower1;
		float finalWeaponPower2;
		float totalFinalWeaponPower;
		
		int weaponPower1 = char1Weapon.getWeaponPower();
		int weaponPower2 = char2Weapon.getWeaponPower();
		
		int weaponLevel1 = char1Weapon.getWeaponLevel();
		int weaponLevel2 = char2Weapon.getWeaponLevel();
		
		float rarityMultiplier1 = char1Weapon.getWeapRarityMultiplier();
		float rarityMultiplier2 = char2Weapon.getWeapRarityMultiplier();
		
		finalWeaponPower1 = (float) weaponPower1 * rarityMultiplier1 + (float) weaponLevel1;
		finalWeaponPower2 = (float) weaponPower2 * rarityMultiplier2 + (float) weaponLevel2;
		
		totalFinalWeaponPower = finalWeaponPower1 + finalWeaponPower2;
		
		return totalFinalWeaponPower;
	}
	
	private float calculateTotalCharacterInfluence(Character char1, Character char2) {
		
		float charInfluence1;
		float charInfluence2;
		float totalCharInfluence;
		
		int charLevel1 = char1.getCharacterLevel();
		int charLevel2 = char2.getCharacterLevel();
		
		int charRarity1 = char1.getCharacterRarity();
		int charRarity2 = char2.getCharacterRarity();
		
		charInfluence1 = (float) charLevel1 * (1 + ((charRarity1 - 1)/5));
		charInfluence2 = (float) charLevel2 * (1 + ((charRarity2 - 1)/5));
		
		totalCharInfluence = charInfluence1 + charInfluence2;
		
		return totalCharInfluence;
	}
	
	public void adventure(Map map, Character char1, Character char2) {
		//TBA hehe
	}

}
