// main/driver class
import java.util.Scanner;

public class GachaSimulator {

	public static void main(String[] args) {
		
		Scanner stringInput = new Scanner(System.in); //takes strings as inputs
		Scanner numInput    = new Scanner(System.in); //takes integers as inputs
		
		//Intro message
		System.out.println("Welcome to the Gacha Simulator!");
		System.out.printf("\n");
		System.out.println("Please enter your username: ");
		
		String playerName = stringInput.nextLine(); //take user input as player name
		stringInput.close();
		
		Player player = new Player(playerName); //create a new player
		GachaMachine machine = new GachaMachine(); //create new gacha machine object
		
		//TODO: Perform 1 multiroll for characters, store it to player inventory
		
		//TODO: Perform 1 multiroll for weapons, store it to player inventory
		
		System.out.printf("Hello %s!\n", player.getPlayerName());
		System.out.println("Before you start adventuring, you'll need characters and weapons!");
		System.out.println("Fortunately for you, you already start with 10 of each!");
		System.out.println("Here are the characters and weapons you currently have: ");
		
		//Display player inventory (both character & weapons)
		player.displayInventory();
		
		//TODO: ask player what they want to do next (Manage characters/weapons [this includes merging characters/weap, level up, equip/unequip], or go on an adventure)
		//TODO: implement main loop
	}

}
