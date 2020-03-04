/*
 * Cynthia C. & David S.
 * February+March 2020
 */
package simulation;

public class TestingClass {

	public static void main(String[] args) {
		int[] population = new int[3];
				
		FirstWindow fw = new FirstWindow();
		PokemonPicking picking = new PokemonPicking();
		picking.resetPokemonNames();
		
		//will wait until the user presses the GO button to initiate the other window
		while(!fw.returnTrigger()) {
			System.out.print("");
		}
		
		//will grab values from FirstWindow and send them to PokemonPicking
		for(int x = 0; x < 3; x++) {
			if(fw.returnPokemonNumbers(x) != 25) {
				picking.pickPokemonRandom(fw.returnPokemonNumbers(x), x);
			}
		}
		for(int t=0; t<3; t++) {
			population[t] = fw.returnPokemonNumbers(t);
		}
		NewWindow nw = new NewWindow();
		nw.setRandoAndName();
		
		//will grab values from PokemonPicking and send them to NewWindow
		for(int h = 0; h < 3; h++) {
			for(int g = 0; g < 10; g++) {
				nw.grabPokemonNames(picking.returnPokemonNames(h, g), h, g);
				nw.grabRandoPokemon(picking.returnRandoPokemon(h, g), h, g);
			}
		}
		
		//will pop up the new window 
		nw.gui();

		for(int v = 0; v < 3; v++) {
			nw.grabPopulation(v, population[v]);
		}
	}
}
