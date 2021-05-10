package com.mco1.classes;

import java.util.Scanner;
import java.util.ArrayList;

public class GachaSimulator {
	
	private Scanner input = new Scanner(System.in); //scanner variable that takes string inputs
	private boolean isActive = false; //used in main loop
	
	private ArrayList<Map> mapList = new ArrayList<Map>();
	private GachaMachine machine = new GachaMachine(); //create new gacha machine object
	private Player player;
	
	
	//Interface functions
	private void playerAdventure() {
		
		//int variables that store the index of chosen character (based on user input):
		int charIndex1 = 0;
		int charIndex2 = 0;
		
		boolean start = true;
		String quit = "quit";
		
		System.out.println("-----------Adventure-----------");
		while(start) {
			System.out.println("Current inventory: ");
			//Show player's character inventory
			this.player.displayCharInventory();
			
			System.out.println("Enter 'continue' to proceed with adventure");
			System.out.println("Enter 'quit' to go back to menu");
			if (quit.equals(input.nextLine())) {
				start = false;
				break;
			}
			else
				System.out.println("Select two characters: ");
				//store following input to charIndex variables
				charIndex1 = Integer.parseInt(input.nextLine());
				charIndex2 = Integer.parseInt(input.nextLine());
				
				//Check if both characters have weapons equipped
				if (this.player.getCharInventory().get(charIndex1).getCharacterWeapon() == null && this.player.getCharInventory().get(charIndex2).getCharacterWeapon() == null) {
					System.out.println("Error: Your characters must have a weapon equipped before going on an adventure!");
					start = false;
				}
				else if (charIndex1 > this.player.getCharInventory().size() || charIndex2 > this.player.getCharInventory().size()) {
					System.out.println("Error! Out of bounds!");
				}
				else {
					if (this.player.getCharInventory().get(charIndex1) == this.player.getCharInventory().get(charIndex2))
						System.out.println("Error: Choose another character!");
					else {
						System.out.println("Choose a map: ");
				
						for (int j = 0; j < this.mapList.size(); j++) //displays map names
							System.out.printf("[%d] %s\n", j, this.mapList.get(j).getMapName());
					
						int mapChoice = Integer.parseInt(input.nextLine());
				
						switch(mapChoice) {
						case 0: //underground caverns
							//player gets resources from the map and the total no. of resources is increased
							this.player.addResource(this.mapList.get(mapChoice).adventure(this.player.getPlayerCharacter(charIndex1), this.player.getPlayerCharacter(charIndex2)));
							break;
						case 1: //forest of enchantments
							this.player.addResource(this.mapList.get(mapChoice).adventure(this.player.getPlayerCharacter(charIndex1), this.player.getPlayerCharacter(charIndex2)));
							break;
						case 2: //sea of hope
							this.player.addResource(this.mapList.get(mapChoice).adventure(this.player.getPlayerCharacter(charIndex1), this.player.getPlayerCharacter(charIndex2)));
							break;
						case 3: //tower of ether
							this.player.addResource(this.mapList.get(mapChoice).adventure(this.player.getPlayerCharacter(charIndex1), this.player.getPlayerCharacter(charIndex2)));
							break;
						case 4: //celestial plane
							this.player.addResource(this.mapList.get(mapChoice).adventure(this.player.getPlayerCharacter(charIndex1), this.player.getPlayerCharacter(charIndex2)));
							break;
					  }
						System.out.println("Current Resources: " + this.player.getResourceAmount());
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
	
	private void manageInventory() {
		//lets player manage (merge, equip/unequip, level up) their characters and weapons
		
		int userChoice; //int variable for user actions 
		
		//int variables that store the index of chosen character (based on user input):
		int charIndex1 = 0;
		int charIndex2 = 0;
		int charIndex3 = 0;
		
		//int variables that store the index of chosen weapon (based on user input):
		int weapIndex1 = 0; 
		int weapIndex2 = 0; 
		int weapIndex3 = 0;
		
		boolean isRunning = true;
		int resourceNum = 0; //stores user input for resources (used in level up)
		while (isRunning) {
			
			System.out.println("---------Management-------------");
			System.out.println("Enter 1 to manage Characters or Enter 2 to manage Weapons or Enter 3 to go back");
			userChoice = Integer.parseInt(input.nextLine());
			if (userChoice < 1 || userChoice > 3) 
				System.out.println("Error: Invalid input!");
			else {
			if (userChoice == 1 && this.player.getCharInventory().isEmpty() == false) { //Character
				System.out.println("---------Character Management-------------");
				this.player.displayCharInventory(); // display Character Inventory
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
					if (charIndex1 > this.player.getCharInventory().size() || charIndex2 > this.player.getCharInventory().size() || charIndex3 > this.player.getCharInventory().size() ||
						charIndex1 < 0 || charIndex2 < 0 || charIndex3 < 0) {
						System.out.println("Error! Out of bounds!");
					}
					else {
						//calls the merge method 
						if (this.player.getPlayerCharacter(charIndex1).mergeChar(this.player.getPlayerCharacter(charIndex2),this.player.getPlayerCharacter(charIndex3))) {
							//if merging is successful, remove characters from player's inventory
							System.out.println("Merging successful");
							this.player.getCharInventory().remove(charIndex2); 
							this.player.getCharInventory().remove(charIndex3-1);
							this.player.getCharInventory().trimToSize();
							this.player.displayCharInventory();
						}
					}
					break;
				case 2: //Level up characters
					System.out.println("Enter the number of the character you wish to level up");
					charIndex1 = Integer.parseInt(input.nextLine());
					if (charIndex1 > this.player.getCharInventory().size() || charIndex1 < 0)
						System.out.println("Error! Out of bounds!");
					else {
						System.out.println("Enter the amount of resources you wish to spend (Max: 100)");
						resourceNum = Integer.parseInt(input.nextLine());
						//check if this.player has any resources (>0), userInput is within resource bounds, and character's level < maximum
						if (this.player.getResourceAmount() > 0 && resourceNum <= this.player.getResourceAmount() && this.player.getPlayerCharacter(charIndex1).getCharacterLevel() < 100) { 
							this.player.getPlayerCharacter(charIndex1).charLevelUp(resourceNum); //Levels up the character based on amount of resource
							System.out.printf("Level up! %s's level is now: %d!\n", this.player.getPlayerCharacter(charIndex1).getCharacterName(),
									this.player.getPlayerCharacter(charIndex1).getCharacterLevel());
							this.player.subtractResource(resourceNum); //player's amount of resources will be subtracted by the amount they input
							System.out.println("Current Resources: " + this.player.getResourceAmount()); //show player's resources
						}
						else if (this.player.getPlayerCharacter(charIndex1).getCharacterLevel() >= 100)
							System.out.println("Character has already reached maximum level!");
						else 
							System.out.println("Error: Insufficient resources!");
					}
					break;
				case 3: //Equip weapon on a character
					this.player.displayWeaponInventory();
					if(this.player.getCharInventory().isEmpty() == false && this.player.getWepInventory().isEmpty() == false) { //if player has weapons and characters:
						System.out.println("Enter the number of the weapon you wish to equip ");
						weapIndex1 = Integer.parseInt(input.nextLine()); //stores the weapon's index
						System.out.println("Enter the number of the character you wish to equip the weapon on");
						charIndex1 = Integer.parseInt(input.nextLine());
						if (charIndex1 > this.player.getCharInventory().size() || weapIndex1 > this.player.getWepInventory().size()
							|| charIndex1 < 0 || weapIndex1 < 0)
							System.out.println("Error! Out of bounds!");
						else {
							//Equips the weapon to the corresponding character
							this.player.getPlayerCharacter(charIndex1).weaponEquip(this.player.getPlayerWeapon(weapIndex1));
							System.out.printf("%s is now equipped with %s!\n", this.player.getPlayerCharacter(charIndex1).getCharacterName(), 
															this.player.getPlayerCharacter(charIndex1).getCharacterWeapon().getWeaponName());
						}
					}
					break;
				case 4: //Unequip a weapon
					//show player inventory
					this.player.displayCharInventory();
					//Ask for user input
					System.out.println("Enter the number of the character with a weapon you wish to unequip: ");
					charIndex1 = Integer.parseInt(input.nextLine());
					if (this.player.getPlayerCharacter(charIndex1).getCharacterWeapon() != null) {
						//unequip
						this.player.getPlayerCharacter(charIndex1).weaponUnequip();
						System.out.println("Weapon unequipped!");
					}
					else if (charIndex1 > this.player.getCharInventory().size() || charIndex1 < 0)
						System.out.println("Error! Out of bounds!");
					else 
						System.out.println("Error! This character doesn't have a weapon equipped!");
					break;
				case 5:
					break;
					}
				}
				else if (userChoice == 2 && this.player.getWepInventory().isEmpty() == false) { //Weapon
					System.out.println("---------Weapon Management-------------");
					this.player.displayWeaponInventory(); // displays Weapon Inventory
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
						
						if (weapIndex1 > this.player.getWepInventory().size() || weapIndex2 > this.player.getWepInventory().size() || weapIndex3 > this.player.getWepInventory().size() ||
							weapIndex1 < 0 || weapIndex2 < 0 || weapIndex3 < 0) //check if userInput is valid
							System.out.println("Error! Out of Bounds!");
						else { //calls the merge method 
							if (this.player.getPlayerWeapon(weapIndex1).mergeWeap(this.player.getPlayerWeapon(weapIndex2),this.player.getPlayerWeapon(weapIndex3))) {
								//if merging is successful, remove weapons from player's inventory
								System.out.println("Merging successful");
								this.player.getWepInventory().remove(weapIndex2); 
								this.player.getWepInventory().remove(weapIndex3-1);
								this.player.getWepInventory().trimToSize(); 
								this.player.displayWeaponInventory();
							}
						}
						break;
					case 2: //Level up weapon
						System.out.println("Enter the number of the weapon you wish to level up");
						weapIndex1 = Integer.parseInt(input.nextLine());
						if (weapIndex1 > this.player.getWepInventory().size() || weapIndex1 < 0)
							System.out.println("Error! Out of bounds!");
						else {
							System.out.println("Enter the Amount of Resource you wish to spend");
							resourceNum = Integer.parseInt(input.nextLine());
						
							if (this.player.getResourceAmount() > 0 && resourceNum <= this.player.getResourceAmount() && this.player.getPlayerWeapon(weapIndex1).getWeaponLevel() < 50) { //if player has any resources (>0) and weapon level < maximum
								this.player.getPlayerWeapon(weapIndex1).weapLevelUp(resourceNum); //Levels up the weapon based on amount of resource
								System.out.printf("Level up! %s's level is now: %d!\n", this.player.getPlayerWeapon(weapIndex1).getWeaponName(),
										this.player.getPlayerWeapon(weapIndex1).getWeaponLevel());
								this.player.subtractResource(resourceNum); //player's amount of resources will be subtracted by the amount they input
								System.out.println("Current Resources: " + this.player.getResourceAmount()); //show player's resources
							}
							else if (this.player.getPlayerWeapon(weapIndex1).getWeaponLevel() >= 50)
								System.out.println("Weapon has already reached maximum level!");
							else
								System.out.println("Error: Insufficient resources!");
						 }
						 break;
					}
				}
				else if (userChoice == 3)
					isRunning = false;
				else if (this.player.getCharInventory().isEmpty() || this.player.getWepInventory().isEmpty()) {
					if (this.player.getCharInventory().isEmpty())
						System.out.println("You don't have any characters!\n");
					else
						System.out.print("You don't have any weapons!\n");
				}
			}
		}
	}
	
	private void gacha() {
		int userChoice; //int variable for user actions 
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
				if (this.player.getResourceAmount() >= 300) { //if player has enough resources to pull (300)
					this.player.addCharacter(machine.charSinglePull()); //pull for one character and add it to the player's inventory
				    this.player.subtractResource(300); //subtract 300 resources from player
				    this.player.displayCharInventory(); //show player's character inventory
				    this.player.getWepInventory().trimToSize(); 
				}
				else
					System.out.println("Error: You don't have enough resources!");
				break;
			case 2: //Multi Pull (Char)
				if (this.player.getResourceAmount() >= 2700) {  //if player has enough resources to pull (2700)
					this.player.getCharInventory().addAll(machine.charMultiPull()); //pull for ten characters and add it to the player's inventory
					this.player.subtractResource(2700); //subtract 2700 resources from player
					this.player.displayCharInventory(); //show player's character inventory
					this.player.getWepInventory().trimToSize(); 
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
				if (this.player.getResourceAmount() >= 300) { //if player has enough resources to pull (300)
					this.player.addWeapon(machine.weapSinglePull());
				    this.player.subtractResource(300); //subtract 300 resources from player
				    this.player.displayWeaponInventory(); //show player's weapon inventory
				    this.player.getWepInventory().trimToSize(); 
				}
				else
					System.out.println("Error: You don't have enough resources!");
				break;
			case 2: //Multi Pull (Weapon)
				if (this.player.getResourceAmount() >= 2700) {  //if player has enough resources to pull (2700)
					this.player.getWepInventory().addAll(machine.weapMultiPull()); //pull for ten characters and add it to the player's inventory
					this.player.subtractResource(2700); //subtract 2700 resources from player
					this.player.displayWeaponInventory(); //show player's weapon inventory
					this.player.getWepInventory().trimToSize(); 
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
	
	private void actionMenu() {
		
		int userChoice; //int variable for user actions 
		System.out.println("-------------------------------------------------");
		System.out.println("Current Resources: " + this.player.getResourceAmount());
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
			if (this.player.getCharInventory().isEmpty()) //checks if players have characters
				System.out.println("You don't have any characters!");
			else
				playerAdventure(); //brings up interface for Adventure
		}
		else if (userChoice == 2) {
			if (this.player.getCharInventory().isEmpty() && this.player.getWepInventory().isEmpty())
				System.out.println("Error: Your inventory is empty!");
			else
				manageInventory(); //if players have weapons and characters, only then can they proceed to manage their inventory
		}
		else if (userChoice == 3)
			gacha();
		else if (userChoice == 4)
			isActive = false;
		else
			System.out.println("Error: Invalid input!");
	}

	public void start(boolean start) {
		
		isActive = start;
		
		//Maps
		this.mapList.add(new Map("underground caverns"));
		this.mapList.add(new Map("forest of enchantments"));
		this.mapList.add(new Map("sea of hope"));
		this.mapList.add(new Map("tower of ether"));
		this.mapList.add(new Map("celestial plane"));
		
		//Intro message
		System.out.println("Welcome to the Gacha Simulator!");
		System.out.printf("\n");
		System.out.println("Please enter your username: ");
		
		String playerName = input.nextLine(); //take user input as player name
		
		this.player = new Player(playerName); //create a new player
		
		System.out.printf("\n");
		
		//Tutorial message
		System.out.println("------------------------------------");
		System.out.printf("Hello %s!\n", this.player.getPlayerName());
		System.out.println("Before you start adventuring, you'll need characters and weapons!");
		System.out.println("You can get characters and weapons when you pull for them in the gacha! (Option 3)");
		System.out.println("When you're done, don't forget to equip your new weapons to your characters!");
		System.out.println("You can equip weapons to your characters in the Manage characters/weapons option! (Option 2)");
		System.out.println("------------------------------------");
		
		//ask player what they want to do next (Manage characters/weapons [this includes merging characters/weap, level up, equip/unequip], or go on an adventure)
		while (isActive) { //main loop	
			actionMenu(); //brings up Menu for next action
		 }
		System.out.println("Thank you for playing!");
		input.close();
		System.exit(0);
  }
}