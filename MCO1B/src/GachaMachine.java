import java.util.Random;
import java.util.ArrayList;

public class Random

public class GachaMachine {
	
	//Properties 
	int pullRarity; //temporary value to passs arraylist index
	Random roll = new Random; // for the pulling function
	ArrayList<Character> characterList = new ArrayList<Character>(); //Arraylist of Objects
	ArrayList<Weapon>weaponList = new ArrayList<Weapon>();
	
	
	//Constructor
	public GachaMachine() {
		
		//Characters
		//1 star
		characterList.add(new Character("Jekyll",1,"Joker")); 
		characterList.add(new Character("Earl Robert",1,"Trigger")); 
		characterList.add(new Character("Count d'Artagnan",1,"Metal")); 
		characterList.add(new Character("Stede",1,"Cyclone")); 
		characterList.add(new Character("Kaguya",1,"Luna")); 
		characterList.add(new Character("Van Helmont",1,"Heat")); 
		
		//2 star
		characterList.add(new Character("Gray",2,"Joker")); 
		characterList.add(new Character("Bonney",2,"Trigger")); 
		characterList.add(new Character("Sir William Marshal",2,"Metal")); 
		characterList.add(new Character("Teach ",2,"Cyclone")); 
		characterList.add(new Character("Jeanne",2,"Luna")); 
		characterList.add(new Character("Paracelsus",2,"Heat")); 
		
		//3 star
		characterList.add(new Character("Faust",3,"Joker")); 
		characterList.add(new Character("Clyde",3,"Trigger")); 
		characterList.add(new Character("Masamune",3,"Metal")); 
		characterList.add(new Character("Avery",3,"Cyclone")); 
		characterList.add(new Character("Arthur",3,"Luna")); 
		characterList.add(new Character("Hermes",3,"Heat"));
		
		
		//Weapons
		//1 star
		weaponList.add(new Weapon("Knife ",130,1));
		weaponList.add(new Weapon("Rapier",140,1));
		weaponList.add(new Weapon("Revolver",150,1));
		weaponList.add(new Weapon("Mermaid Tears",160,1));
		weaponList.add(new Weapon("Clarent",170,1));
		weaponList.add(new Weapon("English Longbow ",180,1));
		
		//2 star
		weaponList.add(new Weapon("Circe Staff",150,2));
		weaponList.add(new Weapon("Vorpal sword",160,2));
		weaponList.add(new Weapon("Merlin’s Staff",170,2));
		weaponList.add(new Weapon("Five-cross Sword",180,2));
		weaponList.add(new Weapon("Bashosen",190,2));
		weaponList.add(new Weapon("Golden Cudgel",200,2));
		
		//3 star
		weaponList.add(new Weapon("Philosopher’s stone",180,3));
		weaponList.add(new Weapon("Magic Bullets ",190,3));
		weaponList.add(new Weapon("Fragarach",200,3));
		weaponList.add(new Weapon("Honjo Masamune ",210,3));
		weaponList.add(new Weapon("Excalibur ",220,3));
		weaponList.add(new Weapon("Scythe of Father Time",230,3)); 
	}	
	
	
	
	//Methods
	public void charSinglePull(Player player) {
		player.subtractResource(300);
		pullRarity = 1+roll.nextInt(10);  // chooses a random number from 1-10 in order to get rarity
				
		characterList.get(pull);
		add
	}
	
	public void charMultiPull(Player player) {
		player.subtractResource(2700);
	}
	
	public void weapSinglePull(Player player) {
		player.subtractResource(300);
	}
	
	public void weapMultiPull(Player player) {
		player.subtractResource(2700);
		return 
	}
	
	
}
