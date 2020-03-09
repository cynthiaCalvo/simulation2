/*
 * Cynthia C. & David S.
 * February+March 2020
 */
package simulation;

import java.util.Random;

public class PokemonPicking {
	private String pokemonNameBank[][] = {
			{"Scorbunny", "Charmander", "Vulpix", "Torchic", "Fennekin", "Lampent", "Fletchinder", "Braixen", "Litten", "Victini"},
			{"Bulbasaur", "Oddish", "Chickorita", "Cherubi", "Snivy", "Pansage", "Rowlett", "Skiddo", "Grookey", "Bounsweet"},
			{"Squirtle", "Seel", "Vaporeon", "Totodile", "Omanyte", "Lotad", "Spheal", "Oshawott", "Ducklett", "Sobble"}
	};
	private boolean noRepeats[][];
	private String pokemonNames[][];
	private int[][] randoPokemon;
	
	public PokemonPicking() {
		//will be set to the pokemon that are randomly chosen
		pokemonNames = new String[3][10];
		//will turn to true if that pokemon has been chosen so there are no repeats
		noRepeats = new boolean[3][10];
		//will be set to the location of the pokemon chosen for that spot in the array
		randoPokemon = new int[3][10];
		/**will set the extra spots at the end(if there are any) to 
		 * "null" so that it doesn't count them
		 */
	}
	/**
	 * int level is the type it will randomly be choosing from
	 * int length is the number of pokemon they wanted from that type
	 * @param length
	 * @param level
	 */
	public void pickPokemonRandom(int length, int level) {
		Random random = new Random();
		int x = 0;
		//will set random pokemon for however many the user wnats
		while(x < length) {
			int rando = random.nextInt(10);
			//will set the spot to a rando pokemon unless there is already a pokemon there & if that pokemon hasn't been chosen yet
			if(pokemonNames[level][x].equals("nool") && noRepeats[level][rando] != true) {
				pokemonNames[level][x] = pokemonNameBank[level][rando];
				System.out.println(pokemonNames[level][x]);
				noRepeats[level][rando] = true;
				randoPokemon[level][x] = rando;
				x++;
			}
		}
		System.out.println("\n");
	}
	
	/**
	 * will return the y position from pokemonNameBank for the pokemon chosen
	 * for that specific spot in the array of chosen pokemon
	 * @param type
	 * @param pok
	 * @return
	 */
	public int returnRandoPokemon(int type, int pok) {
		return randoPokemon[type][pok];
	}
	
	/**
	 * will set all places to "null", and the ones not set as pokemon later will stay as "null"
	 * so the program will be able to tell how many pokemon of each type there are
	 */
	public void resetPokemonNames() {
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 10; y++) {
				pokemonNames[x][y] = "nool";
			}
		}
	}
	
	/**
	 * will return the name of the pokemon chosen for that spot in the array of chosen pokemon
	 * @param type
	 * @param pok
	 * @return
	 */
	public String returnPokemonNames(int type, int pok) {
		return pokemonNames[type][pok];
	}
	
	public String returnPokemonNameBank(int type, int pok) {
		return pokemonNameBank[type][pok];
	}
}
