import java.util.Random;
import java.util.ArrayList;

public class Random

public class GachaMachine {
	
	//Properties 
	int pull_chance; //for the pulling function
	Random roll = new Random; // for the pulling function
	ArrayList<Character>characterList = new ArrayList<Character>(); //Arraylist of Objects
	
		characterList.add(new Character("Jekyll",1,"Joker"));
		characterList.add(new Character("Earl Robert",1,"Trigger "));
		characterList.add(new Character("Count d'Artagnan",1,"Metal"));
		characterList.add(new Character("Stede",1,"Cyclone"));
		characterList.add(new Character("Kaguya",1,"Luna"));
		characterList.add(new Character("Van Helmont",1,"Heat");
		characterList.add(new Character("Gray",2,"Joker"));
		characterList.add(new Character("Bonney",2,"Trigger"));
		characterList.add(new Character("Sir William Marshal",2,"Metal"));
		characterList.add(new Character("Teach ",2,"Cyclone"));
		characterList.add(new Character("Jeanne",2,"Luna"));
		characterList.add(new Character("Paracelsus",2,"Heat"));
		characterList.add(new Character("Faust",3,"Joker"));
		characterList.add(new Character("Clyde",3,"Trigger"));
		characterList.add(new Character("Masamune",3,"Metal"));
		characterList.add(new Character("Avery",3,"Cyclone"));
		characterList.add(new Character("Arthur",3,"Luna"));
		characterList.add(new Character("Hermes",3,"Heat"));
		
	ArrayList<Weapon>weaponList = new ArrayList<Weapon>();
		
		weaponList.add(new Weapon("Knife ",130,1));
		weaponList.add(new Weapon("Rapier",140,1));
		weaponList.add(new Weapon("Revolver",150,1));
		weaponList.add(new Weapon("Mermaid Tears ",160,1));
		weaponList.add(new Weapon("Clarent",170,1));
		weaponList.add(new Weapon("English Longbow ",180,1));
		weaponList.add(new Weapon("Circe Staff",150,2));
		weaponList.add(new Weapon("Vorpal sword ",160,2));
		weaponList.add(new Weapon("Merlin’s Staff",170,2));
		weaponList.add(new Weapon("Five-cross Sword",180),2);
		weaponList.add(new Weapon("Bashosen ",190),2);
		weaponList.add(new Weapon("Golden Cudgel ",200),2);
		weaponList.add(new Weapon("Philosopher’s stone",,180)3);
		weaponList.add(new Weapon("Magic Bullets ",190),3);
		weaponList.add(new Weapon("Fragarach ",200,3));
		weaponList.add(new Weapon("Honjo Masamune ",210,3));
		weaponList.add(new Weapon("Excalibur ",220,3));
		weaponList.add(new Weapon("Scythe of Father Time ",230,3));
	
	
	//Methods
	public void charSinglePull(Player player) {
		subtractResource(300);
		pull_chance = 
		characterList.get(pull);
		add
	}
	
	public void charMultiPull(Player player) {
		subtractResource(2700)
	}
	
	public void weapSinglePull(Player player) {
		subtractResource(300)
	}
	
	public void weapMultiPull(Player player) {
		subtractResource(2700)
		return 
	}
	
}
