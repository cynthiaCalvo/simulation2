package simulation;

import java.util.Random;

public class Simulation_Background {
	private String pokemonNameBank[][];
	/**the above line is where we will store the types of pokemon 
	 * we have chosen previously to randomly pick from
	 */
	private String pokemonNames[][];
	private int pokemonInt[][];
	private int time;
	
	public Simulation_Background(int length) {
		pokemonNames = new String[3][10];
		pokemonInt = new int[3][10];
		/**will set the extra spots at the end(if there are any) to 
		 * something that the program to pick up so that it doesn't count them
		 */
		time = 0;
	}
	
	private void pickPokemonRandom(int length) {
		Random random = new Random();
		int rando = random.nextInt(length);
		int x = 0;
		while(x < length) {
		}
	}
}
