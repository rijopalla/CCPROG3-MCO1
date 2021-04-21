import java.util.ArrayList;

public class Map {
	
	//Properties
	private String mapName;
	private int baseAmount;
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	
	
	//Constructor
	public Map(String name) {
	
		this.mapName = name;
		
		//generating enemy list per map
		//Underground Caverns
		if (this.mapName.equalsIgnoreCase("underground caverns")){
			enemyList.add(new Enemy("Elf", 224)); //adds 1 elf
			
			for (int i = 0; i < 6; i++) {
				enemyList.add(new Enemy("Slime", 73)); //adds 6 slimes
			}
			
			this.baseAmount = 53; //map's base amount of resources
		}
		
		//Forest of Enchantments
		if (this.mapName.equalsIgnoreCase("forest of enchantments")){
			
			for (int i = 0; i < 5; i++) { //adds 5 slimes and orcs
				enemyList.add(new Enemy("Slime", 73)); 
				enemyList.add(new Enemy("Orc", 84));
			}
			
			for (int i = 0; i < 3; i++) { //adds 3 familiars and fairies
				enemyList.add(new Enemy("Familiar", 144));
				enemyList.add(new Enemy("Faerie", 175));
			}
			
			for (int i = 0; i < 2; i++) { //adds 2 elves
				enemyList.add(new Enemy("Elf", 224));
			}
			
			enemyList.add(new Enemy("Sorcerer", 313));
			
			this.baseAmount = 77; //map's base amount of resources
		}
		
		//Sea of Hope
		if (this.mapName.equalsIgnoreCase("sea of hope")) {
			
			for (int i = 0; i < 75; i++) { //adds 75 slimes
				enemyList.add(new Enemy("Slime", 73));
			}
			
			for (int i = 0; i < 20; i++) { //adds 20 sorcerers
				enemyList.add(new Enemy("Sorcerer", 313));
			}
			
			for (int i = 0; i < 5; i++) { //adds 5 hydras
				enemyList.add(new Enemy("Hydra", 360));
			}
			
			this.baseAmount = 85; //map's base amt of resources
		}
		
		//Tower of Ether
		if (this.mapName.equalsIgnoreCase("tower of ether")) {
			
			for (int i = 0; i < 20; i++) { //adds 20 basilisks
				enemyList.add(new Enemy("Basilisk", 499));
			}
			
			for (int i = 0; i < 7; i++) { //adds 7 harpies
				enemyList.add(new Enemy("Harpy", 639));
			}
			
			for (int i = 0; i < 5; i++) { //adds 5 lokis
				enemyList.add(new Enemy("Loki", 740)); 
			}
			
			this.baseAmount = 91; //map's base amount of resources
		}
		
		//Celestial Plane
		if (this.mapName.equalsIgnoreCase("celestial plane")) {
			
			for (int i = 0; i < 50; i++) { //adds 50 faries
				enemyList.add(new Enemy("Faerie", 175));
			}
			
			for (int i = 0; i < 20; i++) { //adds 20 hydras
				enemyList.add(new Enemy("Hydra", 360));
			}
			
			for (int i = 0; i < 10; i++) { //adds 10 lokis
				enemyList.add(new Enemy("Loki", 740));
			}
			
			this.baseAmount = 100; //base amount of resources
		}
	}
	
	//Methods

	//Getters
	public int getBaseAmount() {
		return this.baseAmount;
	}
	
	public String getMapName() {
		return this.mapName;
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

		//calculate final weapon power based on formula:
		finalWeaponPower1 = (float) weaponPower1 * rarityMultiplier1 + (float) weaponLevel1; 
		finalWeaponPower2 = (float) weaponPower2 * rarityMultiplier2 + (float) weaponLevel2; 
		
		//add the two weapon power variables to get total final weapon power
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
		
		
		if (charElement1.equals(charElement2)) //if elements are the same:
			multiplier = normalPair;			
		else if (charElement1.equals("joker")) { //if the first element is joker:
			
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
		else if (charElement1.equals("trigger")) { //if the first element is trigger:
			
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
		else if (charElement1.equals("metal")) { //if the first element is metal:
			
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
		else if (charElement1.equals("cyclone")) { //if the first element is cyclone:
			
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
		else if (charElement1.equals("luna")) { //if the first element is luna:
			
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
		else if (charElement1.equals("heat")) { //if the first element is heat:
			
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
									  char2.getCharacterWeapon()); //assumes char1 and char2 already have a weapon equipped
		
		//calculate total char influence
		float totalCharacterInfluence = this.calculateTotalCharacterInfluence(char1, char2);
		
		//calculate character superiority
		float characterSuperiority = totalFinalWeaponPower * (totalCharacterInfluence / 10);
		
		return characterSuperiority;
	}
	
	private int getEnemySuperiority (ArrayList<Enemy> enemyList) { 
		
		int sum = 0;
		
		for (Enemy enemy : enemyList) //goes through every enemy in list and adds power
			sum += enemy.getEnemyPower();
		
		return sum;
	}
	
	public int adventure(Map map, Character char1, Character char2) {
		
		float elementComboMultiplier = getElementComboMultiplier(char1, char2);
		float totalFinalWeaponPower = calculateTotalFinalWeaponPower(char1.getCharacterWeapon(), char2.getCharacterWeapon());
		float totalCharacterInfluence = calculateTotalCharacterInfluence(char1, char2);
		float characterSuperiority = getCharacterSuperiority(char1, char2);
		int   enemySuperiority = getEnemySuperiority(map.enemyList);
		int   totalResource = 0;
		
		totalResource = (int)(map.baseAmount + (int)(totalFinalWeaponPower/24) * (int)(totalCharacterInfluence/36)  
						* elementComboMultiplier); //calculate total resources the player would get (based on formula given in the specs)
		
		//check if character superiority is greater than enemy superiority
		if (characterSuperiority > enemySuperiority) {
			//if character superiority is at least greater than 50% of enemy superiority
			if (characterSuperiority >= 1.5 * enemySuperiority) {
				char1.charLevelUp(2); //characters level up by 2
				char2.charLevelUp(2);
				System.out.println("Excellent adventure!"); //print excellent adventure
			}
			else { //successful adventure
				char1.charLevelUp(1); //characters only level up by 1
				char2.charLevelUp(1);
				System.out.println("Successful adventure!");
			}
		}
		else 
			System.out.println("Failed adventure!");
		
		return totalResource;
	}
	
}
