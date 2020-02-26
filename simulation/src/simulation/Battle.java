package simulation; 

import java.util.Random;

public class Battle {
	//this will handle the fighting aspect of the program
	private String pokemonMoves[][] = {
			{"Fire punch", "Flamethrower", "Heat crash", "Inferno", "Incinerate"}, //fire moves
			{"Bullet seed", "Energy ball", "Leaf blade", "Petal dance", "Razor leaf"}, //grass moves
			{"Aqua jet", "Bubble", "Hydro vortex", "Whirlpool", "Splishy splash", }, //water moves
	};
	
	/*
	 * Randomly selects the pokemon to be used in battle
	 */
	// public int pokemonSelector() {
	//	Random r = new Random();
	//	int pokemon, type;
		
	//	pokemon = r.nextInt(10); //selects a random number between 0-9 to return to the main
		
	//	type = r.nextInt(3); //selects a random number between 0-2 to return to the main branch to 
		
	//	return 0; //placeholder rn
	//}
	/*
	 * I made all of this a comment because I think you've already made a program for this
	 */
	
	/*
	 * Chooses a move for the pokemon to use based on it's type.
	 * 0 is fire
	 * 1 is grass
	 * 2 is water
	 */
	public String pickAttack(int type) {
		Random r = new Random();
		int randomAttack = 0;
		String attack = "Ain't working chief";
		
		type = 0; //not permanent, this is for testing
		
		switch(type) {
		case 0: randomAttack = r.nextInt(4); System.out.println(randomAttack); attack = "hi";break; //fire attacks (hi is a placeholder to see if things work)
		case 1: randomAttack = r.nextInt(4); //grass attacks
		case 2: randomAttack = r.nextInt(4); //water attacks
		default: System.out.println("Error: Type not specified in Battle.java");
		}
		
		return attack; //placeholder
	}
}