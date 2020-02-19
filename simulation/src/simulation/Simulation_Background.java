package simulation;

import java.util.Random;

public class Simulation_Background {
	//for all the stuff other than GUI
	/**feel free to make another class if you think that it's 
	 * large enough that it will clutter this one
	 */
	private String pokemonNameBank[][];
	/**the above line is where we will store the types of pokemon 
	 * we have chosen previously to randomly pick from
	 */
	private String pokemonNames[][];
	
	public Simulation_Background(int length) {
		pokemonNames = new String[3][641531];
		/**find the max number for a type and set 2nd set of brackets to that 
		 * &&&
		 * will set the extra spots at the end(if there are any) to 
		 * something that the program to pick up so that it doesn't count them
		 */
	}
	
	private void pickPokemonRandom(int length) {
		Random random = new Random();
		int rando = random.nextInt(length);
		int x = 0;
	}
}
