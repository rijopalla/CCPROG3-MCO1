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
	public void charLevelUp(Player player, int input) {
		int i;
		
		for (i = 0; i < input; i++) {
			
			//character levels up until loop reaches input
			//only levels up if resource amount > 0 and character level < max level (100)
			if (player.getResourceAmount() > 0 && this.characterLevel <= 100) {
				this.characterLevel++;
				player.subtractResource(1);
			}
		}
		
	}
	
	public void charLevelUp(int num) {
		this.characterLevel += num;
	}
	
	public void weaponEquip(Weapon wep){
		
		if (this.getCharacterWeapon() != null) //if character has a currently equipped weapon 
			this.getCharacterWeapon().setWeaponOwner(null); //remove character as the owner before assigning a new one
		
		this.characterWeapon = wep;
		wep.setWeaponOwner(this);
	}
		
	public void weaponUnequip() {
		if (this.getCharacterWeapon() != null) //if character has a currently equipped weapon 
			this.getCharacterWeapon().setWeaponOwner(null);
			this.characterWeapon = null; //remove equipped weapon
	}
	
	public void mergeChar(Character baseChar, Character char2, Character char3) {
		if (baseChar.equals(char2.getCharacterRarity()) && char2.equals(char3.getCharacterRarity()) 
		   && baseChar.equals(char2.getCharacterName()) && char2.equals(char3.getCharacterName()))  { //uses Equals() class to compare internal value
			
			if (baseChar.getCharacterWeapon()!=null || char2.getCharacterWeapon()!=null) { //checks if baseChar or char2 has weapons equipped
				baseChar.weaponUnequip();
				char2.weaponUnequip();
				}
		
			if (char3.characterRarity != 3) {  // checks if Rarity is not maxed;
				char3.characterRarity =+ 1; //adds 1 rarity to Character
				}
		
			baseChar = null; // Deletes baseChar
			char2 = null; //deletes Char2
			}
		}else system.out.println("Can not be merged!");
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
