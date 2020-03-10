/*
 * Cynthia C. & David S.
 * February+March 2020
 */
package simulation; //package

import java.util.Random; //import random generator

public class Battle { //class name (self evident heehoohaa)
	
	// a 2d array that holds all of the available moves that any type of pokemon can choose from, the 6th of all being "heal"
	private String pokemonMoves[][] = { 
			{"Fire punch", "Flamethrower", "Heat crash", "Inferno", "Incinerate", "Heal"}, //fire moves
			{"Bullet seed", "Energy ball", "Leaf blade", "Petal dance", "Razor leaf", "Heal"}, //grass moves
			{"Aqua jet", "Bubble", "Hydro vortex", "Whirlpool", "Splishy splash", "Heal"}, //water moves
	};
	
	// A 2d array that holds the corresponding base (lvl1) damage values for the moves in pokemonMoves 
	private int pokemonMoveValues[][] = {
			{-4, -3, -2, -6, -8, 5}, //fire moves
			{-3, -4, -5, -2, -7, 5}, //grass moves
			{-2, -6, -4, -5, -8, 5}, //water moves 
	};
	
	private int attackCoordinates; // I didn't make this lol, Cynthia can explain this
	
	
	/*
	 * Randomly selects the pokemon to be used in battle
	 * 0 is fire
	 * 1 is grass
	 * 2 is water
	 */
	 public int pokemonSelector(int population, int type) { //collects the available pokemon to choose from
		Random r = new Random();
		int pokemonRandom = 0;
		
		switch(population) { //checks for the amount of pokemon left and chooses accordingly
		case 0: pokemonRandom = 25;break;
		case 1: pokemonRandom = r.nextInt(1);break;
		case 2: pokemonRandom = r.nextInt(2);break;
		case 3: pokemonRandom = r.nextInt(3);break;
		case 4: pokemonRandom = r.nextInt(4);break;
		case 5: pokemonRandom = r.nextInt(5);break;
		case 6: pokemonRandom = r.nextInt(6);break;
		case 7: pokemonRandom = r.nextInt(7);break;
		case 8: pokemonRandom = r.nextInt(8);break;
		case 9: pokemonRandom = r.nextInt(9);break;
		case 10: pokemonRandom = r.nextInt(10);break;
		}
		return pokemonRandom;
	}//done
	
	/*
	 * Chooses a move for the pokemon to use based on it's type.
	 * 0 is fire
	 * 1 is grass
	 * 2 is water
	 */
	public String pickAttack(int type) {
		Random r = new Random();
		int randomAttack;
		String attack = null;
		
		switch(type) { // Gives randomAttack one of the 6 available pokemonMoves based on the pokemon's type
		case 0: randomAttack = r.nextInt(6); attack = pokemonMoves[0][randomAttack];break; //fire attacks
		case 1: randomAttack = r.nextInt(6); attack = pokemonMoves[1][randomAttack];break; //grass attacks
		case 2: randomAttack = r.nextInt(6); attack = pokemonMoves[2][randomAttack];break; //water attacks
		default: randomAttack = 25; //idk why it's 25 but it works so whatever
		}
		
		attackCoordinates = randomAttack;
		return attack; 
	} //done
	
	/*
	 * Returns the pokemon moves back to the main Code
	 */
	public int returnAttackValue(int type, int y) { // Cynthia...
		return pokemonMoveValues[type][y];
	}//finished
	
	/*
	 * Returns the attack values back to the main code
	 */
	public int returnAttackCoordinates() { // Cynthia, the sequal...
		return attackCoordinates;
	}//finished
	
	/*
	 * Collects the input and assaigns a variety of levels to the pokemon.
	 * Strength will be between 1 and 3, 1 being the weakest and 3 being the strongest. I need user input for this
	 * 1 strength = lvls between 1-3.
	 * 2 strength = lvls between 3-6.
	 * 3 strength = lvls between 6-10.
	 */
	public int lvlInput(int strength) {//*********************************
		Random r = new Random();
		int lvl = 1;
		
		switch(strength) { // checks how strong the user wants the pokemon to be and assigns them lvls based on strength
		case 1: lvl = r.nextInt(4 - 1) + 1;break;
		case 2: lvl = r.nextInt(7-4) + 4;break;
		case 3: lvl = r.nextInt(11-7) + 7;break;
		default: System.out.println("Error, strength type not accepted");
		}
		
		return lvl;
	} //done
	
	/*
	 * Will store/ask for variables determining how much HP the pokemon have. 
	 */
	public double hpGen(int lvl) {
		double health  = 20;
		
		switch(lvl) { //assigns the pokemon health based on their lvl
		case 1: health = health*1;break;
		case 2: health = health*1.2;break;
		case 3: health = health*1.4;break;
		case 4: health = health*1.6;break;
		case 5: health = health*1.8;break;
		case 6: health = health*2;break;
		case 7: health = health*2.2;break;
		case 8: health = health*2.4;break;
		case 9: health = health*2.6;break;
		case 10: health = health*2.8;break;
		default: System.out.println("Error in hpGen");
		}
		
		return health;
	} //done
	
	/*
	 * Will determine how strong the attack of a particular pokemon is
	 */
	public double apGen(int lvl, int atkValue) { //lvl is self explanitory, atkValue is the base damage of the generated attack
		double atk = 0;
		
		if(atkValue < 0) { //...I kinda forget how this works but it does so don't touch it
			switch(lvl) { //multiplies the damage of a given attack based on the pokemon's lvl
			case 1: atk = atkValue*1;break;
			case 2: atk = atkValue*1.2;break;
			case 3: atk = atkValue*1.4;break;
			case 4: atk = atkValue*1.6;break;
			case 5: atk = atkValue*1.8;break;
			case 6: atk = atkValue*2;break;
			case 7: atk = atkValue*2.2;break;
			case 8: atk = atkValue*2.4;break;
			case 9: atk = atkValue*2.6;break;
			case 10: atk = atkValue*2.8;break;
			}
		}else {
			atk = atkValue;
		}
		
		
		return atk;
	} //done
	
	/*
	 * Deals with assigning a chance for AN attack to do double dablage
	 */
	public double critChance(int userInput, double attack) { //userInput is the % chance the user suggests, attack is the attack that was chosen
		int chance;
		Random r = new Random();
		chance = r.nextInt(100) + 1;
		
		if(chance == userInput || chance < userInput) { //If the random amount is equal to or less than the user's number, then it'll be a crit.
			attack = attack*2;
		}else {
			//No critical hit for youuuu
		}
		return attack; 
	}
	
}