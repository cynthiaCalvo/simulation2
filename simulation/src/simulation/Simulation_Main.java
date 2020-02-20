package simulation;

import java.util.Scanner;

public class Simulation_Main {

	public static void main(String[] args) {
		Simulation_Background back = new Simulation_Background();
		//Simulation_Game test = new Simulation_Game();
		Scanner input = new Scanner(System.in);
		
		int[] level = new int[3];
		//i'm doing input here just to make sure everything works
		System.out.println("How many fire?:");
		level[0] = input.nextInt();
		System.out.println("How many grass?:");
		level[1] = input.nextInt();
		System.out.println("How many water?:");
		level[2] = input.nextInt();
		
		back.resetPokemonNames();
		
		for(int i = 0; i < 3; i++) {
			if(level[i] != 0) {
				back.pickPokemonRandom(level[i], i);
			}
		}
	}
}
