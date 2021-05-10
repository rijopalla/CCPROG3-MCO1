package com.mco1.classes;

import java.util.Scanner;
import java.util.ArrayList;

public class GachaSimulator {
	
	private static Scanner input = new Scanner(System.in); //scanner variable that takes string inputs
	private static int userChoice; //int variable for user actions 
	private static boolean isActive = false; //used in main loop
	
	//int variables that store the index of chosen character (based on user input):
	private static int charIndex1 = 0;
	private static int charIndex2 = 0;
	private static int charIndex3 = 0;
	
	//int variables that store the index of chosen weapon (based on user input):
	private static int weapIndex1 = 0; 
	private static int weapIndex2 = 0; 
	private static int weapIndex3 = 0;
	
	static GachaMachine machine = new GachaMachine(); //create new gacha machine object
	
	//Interface functions
	private void playerAdventure(Player player, ArrayList<Map> mapList) {
		
		boolean start = true;
		String quit = "quit";
		
		System.out.println("-----------Adventure-----------");
		while(start) {
			System.out.println("Current inventory: ");
			//Show player's character inventory
			player.displayCharInventory();
			
			System.out.println("Enter 'continue' to proceed with adventure");
			System.out.println("Enter 'quit' to go back to menu");
			if (quit.equals(input.nextLine()))
				start = false;
			else
				System.out.println("Select two characters: ");
				//store following input to charIndex variables
				charIndex1 = Integer.parseInt(input.nextLine());
				charIndex2 = Integer.parseInt(input.nextLine());
				
				//Check if both characters have weapons equipped
				if (player.getCharInventory().get(charIndex1).getCharacterWeapon() == null && player.getCharInventory().get(charIndex2).getCharacterWeapon() == null) {
					System.out.println("Error: Your characters must have a weapon equipped before going on an adventure!");
					start = false;
				}
				else if (charIndex1 > player.getCharInventory().size() || charIndex2 > player.getCharInventory().size()) {
					System.out.println("Error! Out of bounds!");
				}
				else {
					if (player.getCharInventory().get(charIndex1) == player.getCharInventory().get(charIndex2))
						System.out.println("Error: Choose another character!");
					else {
						System.out.println("Choose a map: ");
				
						for (int j = 0; j < mapList.size(); j++) //displays map names
							System.out.printf("[%d] %s\n", j, mapList.get(j).getMapName());
					
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
						System.out.println("Current Resources: " + player.getResourceAmount());
						System.out.println("Do you want to do another adventure?");
						System.out.println("Input 'continue' or 'quit'");
						if (quit.equalsIgnoreCase(input.nextLine()))
							start = false;
						else
							continue;
			   }
		    }
		  }
		}
	
	private void manageInventory(Player player) {
		//lets player manage (merge, equip/unequip, level up) their characters and weapons
		boolean isRunning = true;
		int resourceNum = 0; //stores user input for resources (used in level up)
		while (isRunning) {
			
			System.out.println("---------Management-------------");
			System.out.println("Enter 1 to manage Characters or Enter 2 to manage Weapons or Enter 3 to go back");
			userChoice = Integer.parseInt(input.nextLine());
		
			if (userChoice == 1 && player.getCharInventory().isEmpty() == false) { //Character
				System.out.println("---------Character Management-------------");
				player.displayCharInventory(); // display Character Inventory
				System.out.println("Enter the number of the action you wish to execute");
				System.out.println("1. Merge characters");
				System.out.println("2. Level up character");
				System.out.println("3. Equip a weapon on a character");
				System.out.println("4. Unequip a weapon");
				System.out.println("5. Go back");
				userChoice = Integer.parseInt(input.nextLine()); //take user input
				
				switch(userChoice) {
				case 1: //Merge characters
					System.out.println("Enter the number of the (3) characters you wish to merge");
					charIndex1 = Integer.parseInt(input.nextLine()); //store index of first character
					charIndex2 = Integer.parseInt(input.nextLine()); //store index of second character
					charIndex3 = Integer.parseInt(input.nextLine()); //store index of third character
					
					//check if user input is valid
					if (charIndex1 > player.getCharInventory().size() || charIndex2 > player.getCharInventory().size() || charIndex3 > player.getCharInventory().size() ||
						charIndex1 < player.getCharInventory().size() || charIndex2 < player.getCharInventory().size() || charIndex3 < player.getCharInventory().size()) {
						System.out.println("Error! Out of bounds!");
					}
					else {
						//calls the merge method 
						if (player.getPlayerCharacter(charIndex1).mergeChar(player.getPlayerCharacter(charIndex2),player.getPlayerCharacter(charIndex3))) {
							//if merging is successful, remove characters from player's inventory
							System.out.println("Merging successful");
							player.getCharInventory().remove(charIndex2); 
							player.getCharInventory().remove(charIndex3-1);
							player.getCharInventory().trimToSize();
							player.displayCharInventory();
						}
					}
					break;
				case 2: //Level up characters
					System.out.println("Enter the number of the character you wish to level up");
					charIndex1 = Integer.parseInt(input.nextLine());
					if (charIndex1 > player.getCharInventory().size() || charIndex1 < player.getCharInventory().size())
						System.out.println("Error! Out of bounds!");
					else {
						System.out.println("Enter the amount of resources you wish to spend (Max: 100)");
						resourceNum = Integer.parseInt(input.nextLine());
						//check if player has any resources (>0), userInput is within resource bounds, and character's level < maximum
						if (player.getResourceAmount() > 0 && resourceNum <= player.getResourceAmount() && player.getPlayerCharacter(charIndex1).getCharacterLevel() < 100) { 
							player.getPlayerCharacter(charIndex1).charLevelUp(resourceNum); //Levels up the character based on amount of resource
							System.out.printf("Level up! %s's level is now: %d!\n", player.getPlayerCharacter(charIndex1).getCharacterName(),
									player.getPlayerCharacter(charIndex1).getCharacterLevel());
							player.subtractResource(resourceNum); //player's amount of resources will be subtracted by the amount they input
							System.out.println("Current Resources: " + player.getResourceAmount()); //show player's resources
						}
						else if (player.getPlayerCharacter(charIndex1).getCharacterLevel() >= 100)
							System.out.println("Character has already reached maximum level!");
						else if (player.getResourceAmount() > 0 && resourceNum <= player.getResourceAmount())
							System.out.println("Error: Insufficient resources!");
					}
					break;
				case 3: //Equip weapon on a character
					player.displayWeaponInventory();
					if(player.getCharInventory().isEmpty() == false && player.getWepInventory().isEmpty() == false) { //if player has weapons and characters:
						System.out.println("Enter the number of the weapon you wish to equip ");
						weapIndex1 = Integer.parseInt(input.nextLine()); //stores the weapon's index
						System.out.println("Enter the number of the character you wish to equip the weapon on");
						charIndex1 = Integer.parseInt(input.nextLine());
						if (charIndex1 > player.getCharInventory().size() || weapIndex1 > player.getWepInventory().size()
							|| charIndex1 < player.getCharInventory().size() || weapIndex1 < player.getWepInventory().size())
							System.out.println("Error! Out of bounds!");
						else {
							//Equips the weapon to the corresponding character
							player.getPlayerCharacter(charIndex1).weaponEquip(player.getPlayerWeapon(weapIndex1));
							System.out.printf("%s is now equipped with %s!\n", player.getPlayerCharacter(charIndex1).getCharacterName(), 
															player.getPlayerCharacter(charIndex1).getCharacterWeapon().getWeaponName());
						}
					}
					break;
				case 4: //Unequip a weapon
					//show player inventory
					player.displayCharInventory();
					//Ask for user input
					System.out.println("Enter the number of the character with a weapon you wish to unequip: ");
					charIndex1 = Integer.parseInt(input.nextLine());
					if (player.getPlayerCharacter(charIndex1).getCharacterWeapon() != null) {
						//unequip
						player.getPlayerCharacter(charIndex1).weaponUnequip();
						System.out.println("Weapon unequipped!");
					}
					else if (charIndex1 > player.getCharInventory().size() || charIndex1 < player.getCharInventory().size())
						System.out.println("Error! Out of bounds!");
					else 
						System.out.println("Error! This character doesn't have a weapon equipped!");
					break;
				case 5:
					break;
					}
				}
				else if (userChoice == 2 && player.getWepInventory().isEmpty() == false) { //Weapon
					System.out.println("---------Weapon Management-------------");
					player.displayWeaponInventory(); // displays Weapon Inventory
					System.out.println("Enter the number of the action you wish to execute");
					System.out.println("1. Merge weapon");
					System.out.println("2. Level up weapon");
					System.out.println("3. Go back");
					
					userChoice = Integer.parseInt(input.nextLine()); //take the next integer input from user
					
					switch(userChoice) {
					case 1: //Merge weapons
						System.out.println("Enter the number of the (3) weapons you wish to merge");
						weapIndex1 = Integer.parseInt(input.nextLine()); //store index of first wep
						weapIndex2 = Integer.parseInt(input.nextLine()); //store index of second wep
						weapIndex3 = Integer.parseInt(input.nextLine()); //store index of third wep
						
						if (weapIndex1 > player.getWepInventory().size() || weapIndex2 > player.getWepInventory().size() || weapIndex3 > player.getWepInventory().size() ||
							weapIndex1 < player.getWepInventory().size() || weapIndex2 < player.getWepInventory().size() || weapIndex3 < player.getWepInventory().size()) //check if userInput is valid
							System.out.println("Error! Out of Bounds!");
						else { //calls the merge method 
							if (player.getPlayerWeapon(weapIndex1).mergeWeap(player.getPlayerWeapon(weapIndex2),player.getPlayerWeapon(weapIndex3))) {
								//if merging is successful, remove weapons from player's inventory
								System.out.println("Merging successful");
								player.getWepInventory().remove(weapIndex2); 
								player.getWepInventory().remove(weapIndex3-1);
								player.getWepInventory().trimToSize(); 
								player.displayWeaponInventory();
							}
						}
						break;
					case 2: //Level up weapon
						System.out.println("Enter the number of the weapon you wish to level up");
						weapIndex1 = Integer.parseInt(input.nextLine());
						if (weapIndex1 > player.getWepInventory().size() || weapIndex1 < player.getWepInventory().size())
							System.out.println("Error! Out of bounds!");
						else {
							System.out.println("Enter the Amount of Resource you wish to spend");
							resourceNum = Integer.parseInt(input.nextLine());
						
							if (player.getResourceAmount() > 0 && resourceNum <= player.getResourceAmount() && player.getPlayerWeapon(weapIndex1).getWeaponLevel() < 50) { //if player has any resources (>0) and weapon level < maximum
								player.getPlayerWeapon(weapIndex1).weapLevelUp(resourceNum); //Levels up the weapon based on amount of resource
								System.out.printf("Level up! %s's level is now: %d!\n", player.getPlayerWeapon(weapIndex1).getWeaponName(),
										player.getPlayerWeapon(weapIndex1).getWeaponLevel());
								player.subtractResource(resourceNum); //player's amount of resources will be subtracted by the amount they input
								System.out.println("Current Resources: " + player.getResourceAmount()); //show player's resources
							}
							else if (player.getPlayerWeapon(weapIndex1).getWeaponLevel() >= 50)
								System.out.println("Weapon has already reached maximum level!");
							else if (player.getResourceAmount() > 0 && resourceNum <= player.getResourceAmount())
								System.out.println("Error: Insufficient resources!");
						 }
						 break;
					}
				}
				else if (userChoice == 3)
					isRunning = false;
				else if (player.getCharInventory().isEmpty() || player.getWepInventory().isEmpty()) {
					if (player.getCharInventory().isEmpty())
						System.out.println("You don't have any characters!\n");
					else
						System.out.print("You don't have any weapons!\n");
				}
				if (userChoice < 1 || userChoice > 3) {
					System.out.println("Error: Invalid input!");
			}
		}
	}
	
	private void gacha(Player player) {
		//lets player pull for a character or a weapon, provided they have the necessary resources
		System.out.println("-------------Gacha------------");
		boolean isActive = true;
		while (isActive) {
		System.out.println("What do you want to do?");
		System.out.println("1. Pull for a Character");
		System.out.println("2. Pull for a Weapon");
		System.out.println("3. Go back");
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
				    player.getWepInventory().trimToSize(); 
				}
				else
					System.out.println("Error: You don't have enough resources!");
				break;
			case 2: //Multi Pull (Char)
				if (player.getResourceAmount() >= 2700) {  //if player has enough resources to pull (2700)
					player.getCharInventory().addAll(machine.charMultiPull()); //pull for ten characters and add it to the player's inventory
					player.subtractResource(2700); //subtract 2700 resources from player
					player.displayCharInventory(); //show player's character inventory
					player.getWepInventory().trimToSize(); 
				}
				else
					System.out.println("Error: You don't have enough resources!");
				break;
			case 3: //Go back
				break;
			}
		}
		else if (userChoice == 2) {
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
				    player.getWepInventory().trimToSize(); 
				}
				else
					System.out.println("Error: You don't have enough resources!");
				break;
			case 2: //Multi Pull (Weapon)
				if (player.getResourceAmount() >= 2700) {  //if player has enough resources to pull (2700)
					player.getWepInventory().addAll(machine.weapMultiPull()); //pull for ten characters and add it to the player's inventory
					player.subtractResource(2700); //subtract 2700 resources from player
					player.displayWeaponInventory(); //show player's weapon inventory
					player.getWepInventory().trimToSize(); 
				}
				else
					System.out.println("Error: You don't have enough resources!");
				break;
			}
		}
		else if (userChoice == 3)
			isActive = false;
		else if (userChoice > 3 || userChoice < 1)
			System.out.println("Error: Invalid input");
	  }
	}
	
	private void actionMenu(Player player, ArrayList<Map> mapList) {
		
		System.out.println("-------------------------------------------------");
		System.out.println("Current Resources: " + player.getResourceAmount());
		System.out.println("-------------------------------------------------");
		
		System.out.println("-------------------------------------------------");
		System.out.println("What action do you want do to next?(Enter 1, 2, or 3)");
		System.out.println("1. Go on an adventure");
		System.out.println("2. Manage Characters/Weapons");
		System.out.println("3. Gacha");
		System.out.println("4. Quit");
		System.out.println("-------------------------------------------------");
		userChoice = Integer.parseInt(input.nextLine());
		
		if (userChoice == 1) {
			if (player.getCharInventory().isEmpty()) //checks if players have characters
				System.out.println("You don't have any characters!");
			else
				playerAdventure(player, mapList); //brings up interface for Adventure
		}
		else if (userChoice == 2) {
			if (player.getCharInventory().isEmpty() && player.getWepInventory().isEmpty())
				System.out.println("Error: Your inventory is empty!");
			else
				manageInventory(player); //if players have weapons and characters, only then can they proceed to manage their inventory
		}
		else if (userChoice == 3)
			gacha(player);
		else if (userChoice == 4)
			isActive = false;
		else if (userChoice >= 4 || userChoice <= 1)
			System.out.println("Error: Invalid input!");
	}

	public void start(boolean start) {
		
		isActive = start;
		
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