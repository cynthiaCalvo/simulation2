package simulation;

public class TestingClass {

	public static void main(String[] args) {
		int[] population = new int[3];
				
		FirstWindow test = new FirstWindow();
		PokemonPicking back = new PokemonPicking();
		back.resetPokemonNames();
		
		//will wait until the user presses the GO button to initiate the other window
		while(!test.returnTrigger()) {
			System.out.print("");
		}
		
		//will grab values from FirstWindow and send them to PokemonPicking
		for(int x = 0; x < 3; x++) {
			if(test.returnPokemonNumbers(x) != 25) {
				back.pickPokemonRandom(test.returnPokemonNumbers(x), x);
			}
		}
		
		for(int t=0; t<3; t++) {
			population[t] = test.returnPokemonNumbers(t);
		}
		
		NewWindow nw = new NewWindow();
		nw.setRandoAndName();
		//will grab values from PokemonPicking and send them to NewWindow
		for(int h = 0; h < 3; h++) {
			for(int g = 0; g < 10; g++) {
				nw.grabPokemonNames(back.returnPokemonNames(h, g), h, g);
				nw.grabRandoPokemon(back.returnRandoPokemon(h, g), h, g);
			}
		}
		
		//will pop up the new window 
		nw.gui();

		Battle battle = new Battle();
		battle.setPokemonNameBankLength();
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 10; y++) {
				battle.setPokemonNameBankValues(back.returnPokemonNameBank(x, y), x, y);
			}
		}
		
	}
}
