package simulation;

public class TestingClass {

	public static void main(String[] args) {
		FirstWindow test = new FirstWindow();
		PokemonPicking back = new PokemonPicking();
		back.resetPokemonNames();
		
		while(!test.returnTrigger()) {
			System.out.print("");
		}
		
		for(int x = 0; x < 3; x++) {
			if(test.returnPokemonNumbers(x) != 25) {
				back.pickPokemonRandom(test.returnPokemonNumbers(x), x);
			}
		}
		
		NewWindow nw = new NewWindow();
		nw.setRandoAndName();
		for(int h = 0; h < 3; h++) {
			for(int g = 0; g < 10; g++) {
				nw.grabPokemonNames(back.returnPokemonNames(h, g), h, g);
				nw.grabRandoPokemon(back.returnRandoPokemon(h, g), h, g);
			}
		}
		nw.gui();
		
	}
}
