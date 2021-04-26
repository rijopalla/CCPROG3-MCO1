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
	
}
