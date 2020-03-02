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
	 * 0 is fire
	 * 1 is grass
	 * 2 is water
	 */
	 public String pokemonSelector(int population, int type) { //collects the type chosen to fight, as well as the available pokemon to choose from
		//I had the choosing a type of pokemon moved to the main class b/c we were trying to grab the population of a type we hadn't even chosen yet
		 Random r = new Random();
		int pokemonRandom = 0;
		String pokemonSelected = null;
		
		switch(population) {
		case 0: pokemonRandom = r.nextInt(1);break;
		case 1: pokemonRandom = r.nextInt(2);break;
		case 2: pokemonRandom = r.nextInt(3);break;
		case 3: pokemonRandom = r.nextInt(4);break;
		case 4: pokemonRandom = r.nextInt(5);break;
		case 5: pokemonRandom = r.nextInt(6);break;
		case 6: pokemonRandom = r.nextInt(7);break;
		case 7: pokemonRandom = r.nextInt(8);break;
		case 8: pokemonRandom = r.nextInt(9);break;
		case 9: pokemonRandom = r.nextInt(10);break;
		default:
		}
		
		pokemonSelected = Integer.toString(type) + Integer.toString(pokemonRandom);// I switched this from returning the name to the coordinates - which makes it easier for me to use
		
		return pokemonSelected;
	}
	
	/*
	 * Chooses a move for the pokemon to use based on it's type.
	 * 0 is fire
	 * 1 is grass
	 * 2 is water
	 */
	public String pickAttack(int type) {
		Random r = new Random();
		int randomAttack;
		String attack = null;
		
		switch(type) {
		case 0: randomAttack = r.nextInt(4); System.out.println(randomAttack); attack = "hi";break; //fire attacks (hi is a placeholder to see if things work)
		case 1: randomAttack = r.nextInt(4); //grass attacks
		case 2: randomAttack = r.nextInt(4); //water attacks
		default: System.out.println("Error: Type not specified in Battle.java");
		}
		
		return attack; //placeholder
	}
}