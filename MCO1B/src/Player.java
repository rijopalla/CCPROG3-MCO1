import java.util.ArrayList;
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
	
	public void displayCharInventory() {
		//displayInventory() shows every character and weapon the player has and shows some details
		
		System.out.println("Inventory:");
		System.out.printf("\n");
		
		//print out every character the player currently has
		System.out.println("Character: ");
		
		for (int i = 0; i < this.characterInventory.size(); i++) { //loop lasts until the size of the arraylist is reached
			//prints the character's index, name, element, rarity, and level
			System.out.printf("[%d] Name: %s Element: %s Rarity: %d Level: %d\n", i, this.characterInventory.get(i).getCharacterName(),
			this.characterInventory.get(i).getCharacterElement(), this.characterInventory.get(i).getCharacterRarity(), this.characterInventory.get(i).getCharacterLevel());
		}
		
		System.out.printf("\n");
		
   }
	
	public void displayWeaponInventory() {
		System.out.println("Weapon Inventory: ");
		
		for (int i = 0; i < this.weaponInventory.size(); i++) {
			if (this.weaponInventory.get(i).isEquipped()) { //if the weapon is currently equipped on a character:
				//print the weapon's index, name, power, rarity, level, and the name of the character it is currently equipped to
				System.out.printf("[%d] Name: %s Power: %d Rarity: %d Level %d Equipped on: %s\n", i, this.weaponInventory.get(i).getWeaponName(),
						this.weaponInventory.get(i).getWeaponPower(), this.weaponInventory.get(i).getWeaponRarity(), this.weaponInventory.get(i).getWeaponLevel(),
						this.weaponInventory.get(i).getWeaponOwner().getCharacterName());
			}
			else {
				//else, print the above details w/o the weapon's owner
				System.out.printf("[%d] Name: %s Power: %d Rarity: %d Level %d\n", i, this.weaponInventory.get(i).getWeaponName(), this.weaponInventory.get(i).getWeaponPower(),
						this.weaponInventory.get(i).getWeaponRarity(), this.weaponInventory.get(i).getWeaponLevel());
			}
			
		}
	}
		
}
