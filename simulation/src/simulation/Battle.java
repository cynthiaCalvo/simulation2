package simulation; 

import java.util.Random;

public class Battle {
	//this will handle the fighting aspect of the program
	private String pokemonMoves[][] = {
			{"Fire punch", "Flamethrower", "Heat crash", "Inferno", "Incinerate"}, //fire moves
			{"Bullet seed", "Energy ball", "Leaf blade", "Petal dance", "Razor leaf"}, //grass moves
			{"Aqua jet", "Bubble", "Hydro vortex", "Whirlpool", "Splishy splash", }, //water moves
	};
	private String pokemonNameBank[][] = {
			{"Scorbunny", "Charmander", "Vulpix", "Torchic", "Fennekin", "Lampent", "Fletchinder", "Braixen", "Litten", "Victini"},
			{"Bulbasaur", "Oddish", "Chickorita", "Cherubi", "Snivy", "Pansage", "Rowlett", "Skiddo", "Grookey", "Bounsweet"},
			{"Squirtle", "Seel", "Vaporeon", "Totodile", "Omanyte", "Lotad", "Spheal", "Oshawott", "Ducklett", "Sobble"}
	};
	
	/*
	 * Randomly selects the pokemon to be used in battle
	 * 0 is fire
	 * 1 is grass
	 * 2 is water
	 */
	 public String pokemonSelector(int type, int available) { //collects the type chosen to fight, as well as the available pokemon to choose from
		/**
		 * i have a few questions about how this will work:
		 * what is the variable: available? what value is this?
		 * where are you getting the type from?
		 * how will the switch statements work? I'm not understanding the relationship between the case # and the # you're randomly choosing from(r.nextInt(#))
		 */
		 Random r = new Random();
		int pokemonRandom = 0;
		String pokemonSelected = null;
		
		if(type == 0) { //selects an available fire pokemon
			switch(available) {
			case 0: pokemonRandom = r.nextInt(10);break;
			case 1: pokemonRandom = r.nextInt(9);break;
			case 2: pokemonRandom = r.nextInt(8);break;
			case 3: pokemonRandom = r.nextInt(7);break;
			case 4: pokemonRandom = r.nextInt(6);break;
			case 5: pokemonRandom = r.nextInt(5);break;
			case 6: pokemonRandom = r.nextInt(4);break;
			case 7: pokemonRandom = r.nextInt(3);break;
			case 8: pokemonRandom = r.nextInt(2);break;
			case 9: pokemonRandom = r.nextInt(1);break;
			default: //I presume I can leave this blank and then it won't do anything
			}
			//Now that I have the randomly selected pokemon number, plug it into the array and return it here
			
			
		}else if(type == 1) { //water pokemon
			switch(available) {
			case 0: pokemonRandom = r.nextInt(10);break;
			case 1: pokemonRandom = r.nextInt(9);break;
			case 2: pokemonRandom = r.nextInt(8);break;
			case 3: pokemonRandom = r.nextInt(7);break;
			case 4: pokemonRandom = r.nextInt(6);break;
			case 5: pokemonRandom = r.nextInt(5);break;
			case 6: pokemonRandom = r.nextInt(4);break;
			case 7: pokemonRandom = r.nextInt(3);break;
			case 8: pokemonRandom = r.nextInt(2);break;
			case 9: pokemonRandom = r.nextInt(1);break;
			default:
			}
			
			
			
		}else if(type == 2) { //water pokemon - ******this should just be an else - or you can have a println like "this doesn't work" for the else, but it needs an else part of the if statement
			switch(available) {
			case 0: pokemonRandom = r.nextInt(10);break;
			case 1: pokemonRandom = r.nextInt(9);break;
			case 2: pokemonRandom = r.nextInt(8);break;
			case 3: pokemonRandom = r.nextInt(7);break;
			case 4: pokemonRandom = r.nextInt(6);break;
			case 5: pokemonRandom = r.nextInt(5);break;
			case 6: pokemonRandom = r.nextInt(4);break;
			case 7: pokemonRandom = r.nextInt(3);break;
			case 8: pokemonRandom = r.nextInt(2);break;
			case 9: pokemonRandom = r.nextInt(1);break;
			default:
			}
			
			
			
		}
		
		return pokemonSelected;
	}
	
	/*
	 * Chooses a move for the pokemon to use based on it's type.
	 * 0 is fire
	 * 1 is grass
	 * 2 is water
	 */
	public String pickAttack(int type) {
		Random r = new Random();
		int randomAttack = 0;
		String attack = "Ain't working chief";
		
		type = 0; //not permanent, this is for testing
		
		switch(type) {
		case 0: randomAttack = r.nextInt(4); System.out.println(randomAttack); attack = "hi";break; //fire attacks (hi is a placeholder to see if things work)
		case 1: randomAttack = r.nextInt(4); //grass attacks
		case 2: randomAttack = r.nextInt(4); //water attacks
		default: System.out.println("Error: Type not specified in Battle.java");
		}
		
		return attack; //placeholder
	}
}