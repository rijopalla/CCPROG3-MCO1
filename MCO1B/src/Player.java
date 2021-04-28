import java.util.ArrayList;
import java.util.Iterator;

public class Player {

	//Properties
	private String playerName; //user defined name
	ArrayList<Character> characterInventory = new ArrayList<Character>(); //array list of characters
	ArrayList<Weapon>    weaponInventory = new ArrayList<Weapon>();   //array list of weapons
	private int resourceAmount; //stores player's resources
	
	//Constructor
	public Player(String inputName) {
		this.playerName = inputName;
		this.resourceAmount = 5400; //player starts with enough resources for 1 multi-pull for characters and weapons
	}
	
	//Methods
	public Character getPlayerCharacter(int index) {
		return this.characterInventory.get(index);
	}
	
	public Weapon getPlayerWeapon(int index) {
		return this.weaponInventory.get(index);
	}
	
	public void addCharacter(Character chara) {
		this.characterInventory.add(chara); //adds chara parameter to the character's inventory
	}
	
	public void addWeapon(Weapon weap) {
		this.weaponInventory.add(weap); //adds weap parameter to the character's inventory
	}
	
	public int addResource(int num) {
		this.resourceAmount += num;
		return this.resourceAmount;
	}
	
	public int subtractResource(int num) {
		this.resourceAmount -= num ;
		return this.resourceAmount;
	}
	
	public int getResourceAmount() {
		return this.resourceAmount;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void displayInventory() {
		//displayInventory() shows every character and weapon the player has and shows some details
		
		//Iterator variables 
		Iterator<Character> charIterate = characterInventory.iterator();
		Iterator<Weapon> weapIterate = weaponInventory.iterator();
		
		System.out.println("Inventory:");
		System.out.printf("\n");
		
		//print out every character the player currently has
		System.out.println("Character: ");
		
		while(charIterate.hasNext()) { //loop lasts until the last character in the ArrayList has been reached
			
			Character tempChar = charIterate.next(); //tempChar stores the next character in the list
			//prints the character's index, name, element, rarity, and level
			System.out.printf("[%d] Name: %s Element: %s Rarity: %d Level: %d\n", characterInventory.indexOf(tempChar), tempChar.getCharacterName(),
					  					     tempChar.getCharacterElement(), tempChar.getCharacterRarity(), tempChar.getCharacterLevel());
			
		}
		
		System.out.printf("\n");
		
		//print out every weapon the player currently has
		System.out.println("Weapon: ");
		while (weapIterate.hasNext()) {
			
			Weapon tempWeap = weapIterate.next();
			
			if (tempWeap.isEquipped()) { //if the weapon is currently equipped on a character:
				//print the weapon's index, name, power, rarity, level, and the name of the character it is currently equipped to
				System.out.printf("[%d] Name: %s Power: %d Rarity: %d Level: %d Equipped on: %s", weaponInventory.indexOf(tempWeap), tempWeap.getWeaponName(), 
						tempWeap.getWeaponPower(), tempWeap.getWeaponRarity(), tempWeap.getWeaponLevel(), tempWeap.getWeaponOwner().getCharacterName());
			}
			else {
				//else, print the above details w/o the weapon's owner
				System.out.printf("[%d] Name: %s Power: %d Rarity: %d Level: %d\n", weaponInventory.indexOf(tempWeap), tempWeap.getWeaponName(), 
															tempWeap.getWeaponPower(), tempWeap.getWeaponRarity(), tempWeap.getWeaponLevel());
			}
		}
   }
		
}
