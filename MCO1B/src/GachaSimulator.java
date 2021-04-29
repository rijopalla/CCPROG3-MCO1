// main/driver class
import java.util.Scanner;
import java.util.ArrayList;

public class GachaSimulator {

	public static void main(String[] args) {
		
		Scanner stringInput = new Scanner(System.in); //takes strings as inputs
		Scanner numInput    = new Scanner(System.in); //takes integers as inputs
		int userChoice; // int variable for user actions 
		boolean isActive = true; //used in main loop
		
		//Maps
		ArrayList<Map> mapList = new ArrayList<Map>(); //stores the different maps
		mapList.add(new Map("underground caverns"));
		mapList.add(new Map("forest of enchantments"));
		mapList.add(new Map("sea of hope"));
		mapList.add(new Map("tower of ether"));
		mapList.add(new Map("celestial plane"));
		
		//Intro message
		System.out.println("Welcome to the Gacha Simulator!");
		System.out.printf("\n");
		System.out.println("Please enter your username: ");
		
		String playerName = stringInput.nextLine(); //take user input as player name
		stringInput.close();
		
		Player player = new Player(playerName); //create a new player
		GachaMachine machine = new GachaMachine(); //create new gacha machine object
		
		//Perform 1 multiroll for characters, store it to player inventory
		machine.charMultiPull(player);
		
		//Perform 1 multiroll for weapons, store it to player inventory
		machine.weapMultiPull(player);  
		
		System.out.printf("\n");
		
		System.out.println("------------------------------------");
		System.out.printf("Hello %s!\n", player.getPlayerName());
		System.out.println("Before you start adventuring, you'll need characters and weapons!");
		System.out.println("Fortunately for you, you already start with 10 of each!");
		System.out.println("Here are the characters and weapons you currently have: ");
		System.out.println("------------------------------------");
		
		System.out.printf("\n");
		
		//Display player inventory (both character & weapons)
		player.displayInventory();
		System.out.printf("\n");
		
		//TODO: ask player what they want to do next (Manage characters/weapons [this includes merging characters/weap, level up, equip/unequip], or go on an adventure)
		//TODO: implement main loop
		while (isActive) {
			
			System.out.println("What action do you want do to next?(Enter 1 or 2)");
			System.out.println("1. Go on an adventure");
			System.out.println("2. Manage Characters/Weapons");
			userChoice = numInput.nextInt();
			numInput.close();
			
			if (userChoice == 1) {
				//TODO:adventures here
				System.out.println("-----------Adventure-----------");
			}
			else {
				//TODO: More options for managing characters/weapon
			}
		}
		
	}

}
