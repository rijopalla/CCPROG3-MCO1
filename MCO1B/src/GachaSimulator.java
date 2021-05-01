/*
 * main/driver class
 * 
 * Group 10: Opalla, Rijan & Tipan, Loben Klien
 *
 * Latest edit: 5/1/2021
 * 
 */ 

import java.util.Scanner;
import java.util.ArrayList;

public class GachaSimulator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //scanner variable that takes string inputs
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
		
		String playerName = input.nextLine(); //take user input as player name
		
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
		player.displayCharInventory();
		player.displayWeaponInventory();
		
		System.out.printf("\n");
		
		//TODO: ask player what they want to do next (Manage characters/weapons [this includes merging characters/weap, level up, equip/unequip], or go on an adventure)
		while (isActive) { //main loop
			
			System.out.println("What action do you want do to next?(Enter 1 or 2)");
			System.out.println("1. Go on an adventure");
			System.out.println("2. Manage Characters/Weapons");
			userChoice = Integer.parseInt(input.nextLine());
			
			if (userChoice == 1) {
				System.out.println("-----------Adventure-----------");
				System.out.println("Select two characters: ");
				
				//Show player's character inventory
				player.displayCharInventory();
				
				//int variables that store the index of chosen character (based on user input):
				int charIndex1 = Integer.parseInt(input.nextLine());
				int charIndex2 = Integer.parseInt(input.nextLine());
					
				if (player.characterInventory.get(charIndex1) == player.characterInventory.get(charIndex2))
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
			else {
				//TODO: More options for managing characters/weapon
				System.out.println("---------Management-------------");
				System.out.println("Enter 1 to manage Characters or Enter 2 to manage Weapons");
				userChoice = Integer.parseInt();
				
					if (userChoice == 1) {
						System.out.println("---------Character Management-------------");
						player.displayCharInventory(); // displays Character Inventory
						System.out.println("Enter the number of the action you wish to execute");
						System.out.println("1. Merge characters");
						System.out.println("2. Level up character");
						System.out.println("3. Equip a weapon on a character");
						userChoice = Integer.parseInt();
						
						switch(userChoice) {
						case 1: //Merge characters
							System.out.println("Enter the number of the (3) characters you wish to merge");
							charIndex1 = Integer.parseInt(); //stores index of first character
							charindex2 = Integer.parseInt(); 
							int charIndex3 = Integer.parseInt();
							
							//calls the merge method 
							player.getPlayerCharacter(charIndex1).mergeChar(player.getPlayerCharacter(charindex2),player.getPlayerCharacter(charIndex3));
						case 2: //Level up characters
							System.out.println("Enter the number of the character you wish to levelup");
							charIndex1 = Integer.parseInt();
							System.out.println("Enter the Amount of Resource you wish to spend");
							userChoice = Integer.parseInt();
							
							//Levels up the character based on amount of resource
							player.getPlayerCharacter(charIndex1).charLevelUp(userChoice);
							break;
						case 3: //Equip weapon on a character
							player.displayWeaponInventory();
							System.out.println("Enter the number of the weapon you wish to equip ");
							userChoice = Integer.parseInt(); //stores the weapon's index
							System.out.println("Enter the number of the character you wish to equip the weapon on");
							charIndex1 = Integer.parseInt();
							
							//Equips the weapon to the corresponding character
							player.getPlayerCharacter(charIndex1).weaponEquip(player.getPlayerWeapon(userChoice));
							break;
						}
						
					}
					else {
						System.out.println("---------Weapon Management-------------");
						player.displayWeaponInventory(); // displays Weapon Inventory
						System.out.println("Enter the number of the action you wish to execute");
						System.out.println("1. Merge weapon");
						System.out.println("2. Level up weapon");
						System.out.println("3. Equip weapon to character");
						
						userChoice = Integer.parseInt();
						
						switch(userChoice) {
						case 1: //Merge weapons
							System.out.println("Enter the number of the (3) weapons you wish to merge");
							int weapIndex1 = Integer.parseInt(); //stores index of first character
							int weapindex2 = Integer.parseInt(); 
							int weapIndex3 = Integer.parseInt();
							
							//calls the merge method 
							player.getPlayerCharacter(charIndex1).mergeChar(player.getPlayerCharacter(charindex2),player.getPlayerCharacter(charIndex3));
						case 2: //Level up weapon
							System.out.println("Enter the number of the character you wish to levelup");
							weapIndex1 = Integer.parseInt();
							System.out.println("Enter the Amount of Resource you wish to spend");
							userChoice = Integer.parseInt();
							
							//Calls levelup method and Levels up the character based on amount of resource
							player.getPlayerWeapon(weapIndex1).weapLevelUp(userChoice);
							break;
						case 3: //Equip weapon on a character
							player.displayCharacterInventory();
							System.out.println("Enter the number of the weapon you wish to equip ");
							weapIndex1 = Integer.parseInt(); //stores the weapon's index
							System.out.println("Enter the number of the character you wish to equip the weapon on");
							charIndex1 = Integer.parseInt();
							
							//Equips the weapon to the corresponding character
							player.getPlayerCharacter(charIndex1).weaponEquip(player.getPlayerWeapon(userChoice));
							break;
					}
			}
		}
		input.close();
		
	}
}
