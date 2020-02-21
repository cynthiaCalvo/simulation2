package simulation;

import java.util.Scanner;

public class Simulation_Main {

	public static void main(String[] args) {
		Simulation_Background back = new Simulation_Background();
		Simulation_Game test = new Simulation_Game();
		Scanner input = new Scanner(System.in);
		
		int[] level = new int[3];
		
		for(int j = 0; j < 3; j++) {
			level[j] = test.returnPokemonNumbers(j);
		}
		
		back.resetPokemonNames();
		
		for(int i = 0; i < 3; i++) {
			if(level[i] != 0) {
				back.pickPokemonRandom(level[i], i);
			}
		}
	}
}
