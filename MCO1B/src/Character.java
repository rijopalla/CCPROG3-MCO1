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
	public void charLevelUp(Resource r, int input) {
		int i;
		
		for (i = 0; i < input; i++) {
			
			//character levels up until loop reaches input
			//only levels up if resource amount > 0 and character level < max level (100)
			if (r.getResourceAmount() > 0 && this.characterLevel <= 100) {
				this.characterLevel++;
				r.subtractResource(1);
			}
		}
		
	}
	
	public void weaponEquip(Weapon wep){
		
		if (this.getCharacterWeapon() != null) //if character has a currently equipped weapon 
			this.getCharacterWeapon().setWeaponOwner(null); //remove character as the owner before assigning a new one
		
		this.characterWeapon = wep;
		wep.setWeaponOwner(this);
	}
	
	public void mergeChar(Character baseChar, Character char2, Character char3) {
		//TBA hehe
	}
	
	public void weaponUnequip() {
		if (this.getCharacterWeapon() != null) //if character has a currently equipped weapon 
			this.getCharacterWeapon().setWeaponOwner(null);
			this.characterWeapon = null; //remove equipped weapon
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
