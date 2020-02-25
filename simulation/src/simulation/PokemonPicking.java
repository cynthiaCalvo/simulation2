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
		pokemonNames = new String[3][10];
		noRepeats = new boolean[3][10];
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
		while(x < length) {
			int rando = random.nextInt(10);
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
	
	public String returnPokemonNames(int type, int pok) {
		return pokemonNames[type][pok];
	}
}
