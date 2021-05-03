/*
 * main/driver class
 * 
 * Group 10: Opalla, Rijan & Tipan, Loben Klien
 *
 * Latest edit: 5/1/2021
 * 
 */ 

import java.util.Scanner;

import com.mco1.classes.GachaMachine;
import com.mco1.classes.Map;
import com.mco1.classes.Player;

import java.util.ArrayList;

public class GachaSimulator {
	
	static Scanner input = new Scanner(System.in); //scanner variable that takes string inputs
	static int userChoice; //int variable for user actions 
	static boolean isActive = true; //used in main loop
	
	//int variables that store the index of chosen character (based on user input):
	static int charIndex1 = 0;
	static int charIndex2 = 0;
	static int charIndex3 = 0;
	
	//int variables that store the index of chosen weapon (based on user input):
	static int weapIndex1 = 0; 
	static int weapIndex2 = 0; 
	static int weapIndex3 = 0;
	
	static GachaMachine machine = new GachaMachine(); //create new gacha machine object
	
	//Interface functions
	private static void playerAdventure(Player player, ArrayList<Map> mapList) {
		System.out.println("-----------Adventure-----------");
		System.out.println("Select two characters: ");
		
		//Show player's character inventory
		player.displayCharInventory();
		
		//store following input to charIndex variables
		charIndex1 = Integer.parseInt(input.nextLine());
		charIndex2 = Integer.parseInt(input.nextLine());
		
		//Check if both characters have weapons equipped
		if (player.getCharInventory().get(charIndex1).getCharacterWeapon() == null && player.getCharInventory().get(charIndex2).getCharacterWeapon() == null)
			System.out.println("Your characters must have a weapon equipped before going on an adventure!");
		else {
			if (player.getCharInventory().get(charIndex1) == player.getCharInventory().get(charIndex2))
				System.out.println("Error! Choose another character!");
		
			System.out.println("Choose a map: ");
		
			for (int j = 0; j < mapList.size(); j++) { //displays map names
				System.out.printf("[%d] %s\n", j, mapList.get(j).getMapName());
			}
		
			int mapChoice = Integer.parseInt(input.nextLine());
		
			switch(mapChoice) {
			case 0: //underground caverns
				//player gets resources from the map and the total no. of resources is increased
				player.addResource(mapList.get(mapChoice).adventure(player.getPlayerCharacter(charIndex1), player.getPlayerCharacter(charIndex2)));
				break;
			case 1: //forest of enchantments
				player.addResource(mapList.get(mapChoice).adventure(player.getPlayerCharacter(charIndex1), player.getPlayerCharacter(charIndex2)));
				break;
			case 2: //sea of hope
				player.addResource(mapList.get(mapChoice).adventure(player.getPlayerCharacter(charIndex1), player.getPlayerCharacter(charIndex2)));
				break;
			case 3: //tower of ether
				player.addResource(mapList.get(mapChoice).adventure(player.getPlayerCharacter(charIndex1), player.getPlayerCharacter(charIndex2)));
				break;
			case 4: //celestial plane
				player.addResource(mapList.get(mapChoice).adventure(player.getPlayerCharacter(charIndex1), player.getPlayerCharacter(charIndex2)));
				break;
			}
		}
	}
	
	private static void manageInventory(Player player) {
		//lets player manage (merge, equip/unequip, level up) their characters and weapons
		System.out.println("---------Management-------------");
		System.out.println("Enter 1 to manage Characters or Enter 2 to manage Weapons");
		userChoice = Integer.parseInt(input.nextLine());
		
			if (userChoice == 1) { //Character
				System.out.println("---------Character Management-------------");
				player.displayCharInventory(); // display Character Inventory
				System.out.println("Enter the number of the action you wish to execute");
				System.out.println("1. Merge characters");
				System.out.println("2. Level up character");
				System.out.println("3. Equip a weapon on a character");
				userChoice = Integer.parseInt(input.nextLine()); //take user input
				
				switch(userChoice) {
				case 1: //Merge characters
					System.out.println("Enter the number of the (3) characters you wish to merge");
					charIndex1 = Integer.parseInt(input.nextLine()); //store index of first character
					charIndex2 = Integer.parseInt(input.nextLine()); //store index of second character
					charIndex3 = Integer.parseInt(input.nextLine()); //store index of third character
					
					//calls the merge method 
					player.getPlayerCharacter(charIndex1).mergeChar(player.getPlayerCharacter(charIndex2),player.getPlayerCharacter(charIndex3));
				case 2: //Level up characters
					System.out.println("Enter the number of the character you wish to level up");
					charIndex1 = Integer.parseInt(input.nextLine());
					System.out.println("Enter the Amount of Resource you wish to spend");
					userChoice = Integer.parseInt(input.nextLine());
					if (player.getResourceAmount() > 0) { //if player has any resources (>0)
						player.getPlayerCharacter(charIndex1).charLevelUp(userChoice); //Levels up the character based on amount of resource
						player.subtractResource(userChoice); //player's amount of resources will be subtracted by the amount they input
					}
					else
						System.out.println("Insufficient resources!");
					break;
				case 3: //Equip weapon on a character
					player.displayWeaponInventory();
					System.out.println("Enter the number of the weapon you wish to equip ");
					userChoice = Integer.parseInt(input.nextLine()); //stores the weapon's index
					System.out.println("Enter the number of the character you wish to equip the weapon on");
					charIndex1 = Integer.parseInt(input.nextLine());
					
					//Equips the weapon to the corresponding character
					player.getPlayerCharacter(charIndex1).weaponEquip(player.getPlayerWeapon(userChoice));
					break;
				}
				
			}
			else { //Weapon
				System.out.println("---------Weapon Management-------------");
				player.displayWeaponInventory(); // displays Weapon Inventory
				System.out.println("Enter the number of the action you wish to execute");
				System.out.println("1. Merge weapon");
				System.out.println("2. Level up weapon");
				System.out.println("3. Equip weapon to character");
				
				userChoice = Integer.parseInt(input.nextLine()); //take the next integer input from user
				
				switch(userChoice) {
				case 1: //Merge weapons
					System.out.println("Enter the number of the (3) weapons you wish to merge");
					weapIndex1 = Integer.parseInt(input.nextLine()); //store index of first wep
					weapIndex2 = Integer.parseInt(input.nextLine()); //store index of second wep
					weapIndex3 = Integer.parseInt(input.nextLine()); //store index of third wep
					
					//calls the merge method 
					player.getPlayerWeapon(weapIndex1).mergeWeap(player.getPlayerWeapon(weapIndex2),player.getPlayerWeapon(weapIndex3));
				case 2: //Level up weapon
					System.out.println("Enter the number of the weapon you wish to levelup");
					weapIndex1 = Integer.parseInt(input.nextLine());
					System.out.println("Enter the Amount of Resource you wish to spend");
					userChoice = Integer.parseInt(input.nextLine());
					player.subtractResource(userChoice); //player's amount of resources will be reduced
					if (player.getResourceAmount() > 0) { //if player has any resources (>0)
						player.getPlayerWeapon(weapIndex1).weapLevelUp(userChoice); //Levels up the weapon based on amount of resource
						player.subtractResource(userChoice); //player's amount of resources will be subtracted by the amount they input
					}
					else
						System.out.println("Insufficient resources!");
					break;
				case 3: //Equip weapon on a character
					System.out.println("Enter the number of the weapon you wish to equip ");
					weapIndex1 = Integer.parseInt(input.nextLine()); //stores the weapon's index
					player.displayCharInventory();
					System.out.println("Enter the number of the character you wish to equip the weapon on");
					charIndex1 = Integer.parseInt(input.nextLine());
					
					//Equips the weapon to the corresponding character
					player.getPlayerCharacter(charIndex1).weaponEquip(player.getPlayerWeapon(userChoice));
					break;
					}
				}			
	}
	
	private static void gacha(Player player) {
		//lets player pull for a character or a weapon, provided they have the necessary resources
		System.out.println("-------------Gacha------------");
		System.out.println("What do you want to pull for? (Enter 1 or 2)");
		System.out.println("1. Character");
		System.out.println("2. Weapon");
		userChoice = Integer.parseInt(input.nextLine());
		
		if (userChoice == 1) {
			System.out.println("What do you want to do next?");
			System.out.println("1. Single pull (Costs 300 resources)");
			System.out.println("2. Multi pull (Costs 2700 resources)");
			System.out.println("3. Go back");
			userChoice = Integer.parseInt(input.nextLine());
			
			switch(userChoice) {
			case 1: //Single Pull (Char)
				if (player.getResourceAmount() >= 300) { //if player has enough resources to pull (300)
					player.addCharacter(machine.charSinglePull()); //pull for one character and add it to the player's inventory
				    player.subtractResource(300); //subtract 300 resources from player
				    player.displayCharInventory(); //show player's character inventory
				}
				else
					System.out.println("You don't have enough resources!");
				break;
			case 2: //Multi Pull (Char)
				if (player.getResourceAmount() >= 2700) {  //if player has enough resources to pull (2700)
					player.getCharInventory().addAll(machine.charMultiPull()); //pull for ten characters and add it to the player's inventory
					player.subtractResource(2700); //subtract 2700 resources from player
					player.displayCharInventory(); //show player's character inventory
				}
				else
					System.out.println("You don't have enough resources!");
				break;
			case 3: //Go back
				break;
			}
		}
		else {
			System.out.println("What do you want to do next?");
			System.out.println("1. Single pull (Costs 300 resources)");
			System.out.println("2. Multi pull (Costs 2700 resources)");
			System.out.println("3. Go back");
			userChoice = Integer.parseInt(input.nextLine());
			
			switch(userChoice) {
			case 1: //Single Pull (Weapon)
				if (player.getResourceAmount() >= 300) { //if player has enough resources to pull (300)
					player.addWeapon(machine.weapSinglePull());
				    player.subtractResource(300); //subtract 300 resources from player
				    player.displayWeaponInventory(); //show player's weapon inventory
				}
				else
					System.out.println("You don't have enough resources!");
				break;
			case 2: //Multi Pull (Weapon)
				if (player.getResourceAmount() >= 2700) {  //if player has enough resources to pull (2700)
					player.getWepInventory().addAll(machine.weapMultiPull()); //pull for ten characters and add it to the player's inventory
					player.subtractResource(2700); //subtract 2700 resources from player
					player.displayWeaponInventory(); //show player's weapon inventory
				}
				else
					System.out.println("You don't have enough resources!");
				break;
			}
		}	
	}
	
	private static void actionMenu(Player player, ArrayList<Map> mapList) {
		
		System.out.println("-------------------------------------------------");
		System.out.println("Current Resources: " + player.getResourceAmount());
		System.out.println("-------------------------------------------------");
		
		System.out.println("------------------------------------");
		System.out.println("What action do you want do to next?(Enter 1, 2, or 3)");
		System.out.println("1. Go on an adventure");
		System.out.println("2. Manage Characters/Weapons");
		System.out.println("3. Gacha");
		System.out.println("4. Quit");
		System.out.println("-------------------------------------------------");
		userChoice = Integer.parseInt(input.nextLine());
		
		if (userChoice == 1)
			playerAdventure(player, mapList); //brings up interface for Adventure
		else if (userChoice == 2)
			manageInventory(player);
		else if (userChoice == 3)
			gacha(player);
		else if (userChoice == 4)
			isActive = false;
		else if (userChoice >= 4 || userChoice <= 1)
			System.out.println("Invalid input!");
	}

	public static void main(String[] args) {
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
		
		String playerName = input.nextLine(); //take user input as player name
		
		Player player = new Player(playerName); //create a new player
		
		System.out.printf("\n");
		
		//Tutorial message
		System.out.println("------------------------------------");
		System.out.printf("Hello %s!\n", player.getPlayerName());
		System.out.println("Before you start adventuring, you'll need characters and weapons!");
		System.out.println("You can get characters and weapons when you pull for them in the gacha! (Option 3)");
		System.out.println("When you're done, don't forget to equip your new weapons to your characters!");
		System.out.println("You can equip weapons to your characters in the Manage characters/weapons option! (Option 2)");
		System.out.println("------------------------------------");
		
		//ask player what they want to do next (Manage characters/weapons [this includes merging characters/weap, level up, equip/unequip], or go on an adventure)
		while (isActive) { //main loop	
			actionMenu(player, mapList); //brings up Menu for next action
		 }
		
		System.out.println("Thank you for playing!");
		input.close();
		System.exit(0);
  }
}
