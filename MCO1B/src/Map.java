public class Map {
	
	//Properties
	private String mapName;
	private int mapBaseAmount;
	private Enemy[] mapEnemyList;
	
	
	//Constructor
	public Map(String name, int amount) {
		this.mapName = name;
		this.mapBaseAmount = amount;
	}
	
	//Methods
	
	//Getters
	public int getBaseAmount() {
		return this.mapBaseAmount;
	}
	
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
	
	private float getElementComboMultiplier(Character char1, Character char2) {
		
		String charElement1 = char1.getCharacterElement().toLowerCase(); //turns char1's element to lowercase characters
		String charElement2 = char2.getCharacterElement().toLowerCase(); //turns char2's element to lowercase characters
		
		float multiplier = 0;
		float normalPair = (float) 0.1;
		float perfectPair = (float) 0.75;
		float nicePair = (float) 0.5;
		float decentPair = (float) 0.25;
		float noEffect = 0;
		float badPair = (float) -0.25;
		
		
		if (charElement1.equalsIgnoreCase(charElement2)) //if elements are the same
			multiplier = normalPair;
		else if (charElement1.equalsIgnoreCase("joker")) { //if the first element is joker:
			
			switch (charElement2) {
			case "trigger":
				multiplier = decentPair;
				break;
			case "metal":
				multiplier = decentPair;
				break;
			case "cyclone":
				multiplier = perfectPair;
				break;
			case "luna":
				multiplier = nicePair;
				break;
			case "heat":
				multiplier = nicePair;
				break;
			}
		}
		else if (charElement1.equalsIgnoreCase("trigger")) { //if the first element is trigger:
			
			switch (charElement2) {
			case "joker":
				multiplier = decentPair;
				break;
			case "metal":
				multiplier = noEffect;
				break;
			case "cyclone":
				multiplier = noEffect;
				break;
			case "luna":
				multiplier = perfectPair;
				break;
			case "heat":
				multiplier = noEffect;
				break;
			}
		}
		else if (charElement1.equalsIgnoreCase("metal")) { //if the first element is metal:
			
			switch (charElement2) {
			case "joker":
				multiplier = decentPair;
				break;
			case "trigger":
				multiplier = noEffect;
				break;
			case "cyclone":
				multiplier = decentPair;
				break;
			case "luna":
				multiplier = decentPair;
				break;
			case "heat":
				multiplier = perfectPair;
				break;
			}
		}
		else if (charElement1.equalsIgnoreCase("cyclone")) { //if the first element is cyclone:
			
			switch (charElement2) {
			case "joker":
				multiplier = decentPair;
				break;
			case "trigger":
				multiplier = decentPair;
				break;
			case "metal":
				multiplier = perfectPair;
				break;
			case "luna":
				multiplier = nicePair;
				break;
			case "heat":
				multiplier = nicePair;
				break;
			}
		}
		else if (charElement1.equalsIgnoreCase("luna")) { //if the first element is luna:
			
			switch (charElement2) {
			case "joker":
				multiplier = nicePair;
				break;
			case "trigger":
				multiplier = perfectPair;
				break;
			case "metal":
				multiplier = decentPair;
				break;
			case "cyclone":
				multiplier = badPair;
				break;
			case "heat":
				multiplier = badPair;
				break;
			}
		}
		else if (charElement1.equalsIgnoreCase("heat")) { //if the first element is heat:
			
			switch (charElement2) {
			case "joker":
				multiplier = nicePair;
				break;
			case "trigger":
				multiplier = noEffect;
				break;
			case "metal":
				multiplier = perfectPair;
				break;
			case "cyclone":
				multiplier = badPair;
				break;
			case "luna":
				multiplier = badPair;
				break;
			}
		}
		
		return multiplier;
		
	}
	
	private float getCharacterSuperiority(Character char1, Character char2) {
										
		//calculate total final weapon power
		float totalFinalWeaponPower = this.calculateTotalFinalWeaponPower(char1.getCharacterWeapon(),
									  char2.getCharacterWeapon()); //assumes char1 and 2 already have a weapon equipped
		
		//calculate total char influence
		float totalCharacterInfluence = this.calculateTotalCharacterInfluence(char1, char2);
		
		//calculate character superiority
		float characterSuperiority = totalFinalWeaponPower * (totalCharacterInfluence / 10);
		
		return characterSuperiority;
	}
	
	public void adventure(Map map, Character char1, Character char2, Resource resourceNum) {
		//TBA hehe
		//Adventure variables
		
		float elementComboMultiplier;
		float totalFinalWeaponPower;
		float totalCharacterInfluence;
		int   totalResource;
		float characterSuperiority;
		int   enemySuperiority;
	}
	


}
