// main/driver class
import java.util.Scanner;
import java.util.ArrayList;

public class GachaSimulator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //scanner variable that takes user inputs
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
			userChoice = input.nextInt();
			
			if (userChoice == 1) {
				System.out.println("-----------Adventure-----------");
				System.out.println("Select two characters: ");
				
				//int variables that store the index of chosen character (based on user input):
				int charIndex1 = 0;
				int charIndex2 = 0;
				
				for (int i = 0; i < 2; i++) {
					
					player.displayCharInventory();
					
					if (i == 0)
						charIndex1 = input.nextInt();
					if (i == 1)
						charIndex2 = input.nextInt();
					
					if (charIndex1 == charIndex2)
						System.out.println("Error! Choose another character!");
				}
				
				System.out.println("Choose a map: ");
				
				for (int j = 0; j < mapList.size(); j++) { //displays map names
					System.out.printf("[%d] %s\n", j, mapList.get(j).getMapName());
				}
				
				int mapChoice = input.nextInt();
				
				switch(userChoice) {
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
				
			}
		}
		
	}
}
