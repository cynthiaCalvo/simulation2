/**
 * David Sawatzky
 * I made this a while ago so I don't know the exact date lol
 */
package simulation; 

import java.util.Random;

public class Battle {
	//this will handle the fighting aspect of the program
	private String pokemonMoves[][] = {
			{"Fire punch", "Flamethrower", "Heat crash", "Inferno", "Incinerate"}, //fire moves
			{"Bullet seed", "Energy ball", "Leaf blade", "Petal dance", "Razor leaf"}, //grass moves
			{"Aqua jet", "Bubble", "Hydro vortex", "Whirlpool", "Splishy splash"}, //water moves
	};
	
	private int pokemonMoveValues[][] = {
			{4, 3, 2, 6, 8}, //fire moves
			{3, 4, 5, 2, 7}, //grass moves
			{2, 6, 4, 5, 8}, //water moves
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
		String pokemonSelected;
		
		switch(population) {
		case 0: pokemonRandom = r.nextInt(0);break;
		case 1: pokemonRandom = r.nextInt(1);break;
		case 2: pokemonRandom = r.nextInt(2);break;
		case 3: pokemonRandom = r.nextInt(3);break;
		case 4: pokemonRandom = r.nextInt(4);break;
		case 5: pokemonRandom = r.nextInt(5);break;
		case 6: pokemonRandom = r.nextInt(6);break;
		case 7: pokemonRandom = r.nextInt(7);break;
		case 8: pokemonRandom = r.nextInt(8);break;
		case 9: pokemonRandom = r.nextInt(9);break;
		case 10: pokemonRandom = r.nextInt(10);break;
		default:
		}
		
		pokemonSelected = Integer.toString(pokemonRandom);// I switched this from returning the name to the coordinates - which makes it easier for me to use
		
		return pokemonSelected;
	}//done
	
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
		case 0: randomAttack = r.nextInt(4); attack = pokemonMoves[0][randomAttack];break; //fire attacks
		case 1: randomAttack = r.nextInt(4); attack = pokemonMoves[1][randomAttack];break; //grass attacks
		case 2: randomAttack = r.nextInt(4); attack = pokemonMoves[2][randomAttack];break; //water attacks
		default: System.out.println("Error: Type not specified in Battle.java");
		}
		
		return attack; 
	} //done
	
	/*
	 * Collects the input and assaigns a variety of levels to the pokemon.
	 * Strength will be between 1 and 3, 1 being the weakest and 3 being the strongest. I need user input for this
	 * 1 strength = lvls between 1-3.
	 * 2 strength = lvls between 3-6.
	 * 3 strength = lvls between 6-10.
	 */
	public int lvlInput(int strength) {
		Random r = new Random();
		int lvl = 1;
		
		switch(strength) {
		case 1: lvl = r.nextInt(3);break;
		case 2: lvl = r.nextInt(6-3) + 3;break;
		case 3: lvl = r.nextInt(11-6) + 6;break;
		default: System.out.println("Error, strength type not accepted");
		}
		
		return lvl;
	} //done
	
	/*
	 * Will store/ask for variables determining how much HP the pokemon have. 
	 */
	public int hpGen() {
		
		
		return 0;
	}
	
	/*
	 * Will determine how strong the attack of a particular pokemon is
	 */
	public int apGen(int lvl) {
		
		
		return 0;
	}
	
	/*
	 * Deals with assigning a chance for AN attack to do double dablage
	 */
	public int dailyDoubleChance() {
		
		
		return 0; //placeholder
	}
}