import java.util.ArrayList;

public class Player {

	//Behaviors
	ArrayList<Character> characterInventory = new ArrayList<Character>(); //array list of characters
	ArrayList<Weapon>    weaponInventory = new ArrayList<Weapon>();   //array list of weapons
	private int resourceAmount = 0;
	
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
	
}
