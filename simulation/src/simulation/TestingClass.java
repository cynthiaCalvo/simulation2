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
		for(int h = 0; h < 3; h++) {
			for(int g = 0; g < 10; g++) {
				nw.addingPics(h, g, back.returnPokemonNames(h, g), back.returnRandoPokemon(h, g));
			}
		}
		nw.gui();
	}
}
