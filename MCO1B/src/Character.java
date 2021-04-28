public class Character {
	
	//Properties
	private String characterName; 	 //Name
	private int characterRarity; 	 //Rarity
	private String characterElement; //Element
	private int characterLevel; 	 //Level
	private Weapon characterWeapon;	 //Weapon
	
	//Constructor
	public Character(String charName, int charRarity, String charElement) {
		this.characterName = charName;
		this.characterRarity = charRarity;
		this.characterElement = charElement;
		this.characterLevel = 20;
	}

	//Methods
	public void charLevelUp(int resourceNum) {
		//takes the allotted resources as an input
		//TODO: make sure that resourceNum is subtracted to the player's no. of resources in driver class
		
		//character only levels up if resource amount > 0 and character level < max level (100)
		if (resourceNum > 0 && this.characterLevel < 100) {
			
			//character levels up until loop reaches input
			for (int i = 0; i < resourceNum; i++) 
				this.characterLevel++;
		}
		
	}
	
	public void weaponEquip(Weapon wep){
		
		if (this.getCharacterWeapon() != null) //if character has a currently equipped weapon 
			this.getCharacterWeapon().setWeaponOwner(null); //remove character as the owner before assigning a new one
		
		this.characterWeapon = wep;
		wep.setWeaponOwner(this);
		wep.setIsEquipped(true);
	}
		
	public void weaponUnequip() {
		if (this.getCharacterWeapon() != null) //if character has a currently equipped weapon 
			this.getCharacterWeapon().setWeaponOwner(null); 
			this.characterWeapon = null; //remove equipped weapon
	}
	
	public void mergeChar(Character char1, Character char2) {
		/*mergeCharacter() takes two other characters and merges them into the character
		* that's calling the method
		*/
		
		//baseCharacter = this character
		
		//1. check if all characters have the same name
		if (this.characterName.equals(char1.getCharacterName()) && this.characterName.equals(char2.getCharacterName())) {
			
			//2. check if all characters have the same rarity
			if (this.characterRarity == char1.getCharacterRarity() && this.characterRarity == char2.getCharacterRarity()) {
				
				//a. if char1 and char2 have weapons equipped, unequip their weapons first before merging
				if (char1.getCharacterWeapon() != null || char2.getCharacterWeapon() != null) {
					char1.weaponUnequip();
					char2.weaponUnequip();
				}
				
				//3. merge characters
				if (this.characterRarity < 5) { //checks if Rarity is not maxed (character rarity would have to be 1-4)
					this.characterRarity++; //adds +1 rarity to character
					char1 = null; //delete char 1
					char2 = null; //delete char 2
				}
				else
					System.out.println("Cannot be merged! Character is already at maximum rarity"); //print error message when character's rarity is already 5
			}
			else
				System.out.println("Cannot be merged! Characters must have the same rarity!"); //print error message when characters don't have the same rarity
		}
		else
			System.out.println("Cannot be merged! Characters must have the same name!"); //print error message when characters don't have the same name
			
	}
	
	//Getters
	public String getCharacterName() {
		return this.characterName;
	}
	
	public int getCharacterRarity() {
		return this.characterRarity;
	}
	
	public String getCharacterElement() {
		return this.characterElement;
	}
	
	public int getCharacterLevel() {
		return this.characterLevel;  
	}
	
	public Weapon getCharacterWeapon() {
		return this.characterWeapon;
	}
	
}