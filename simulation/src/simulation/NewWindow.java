/*
 * Cynthia C. & David S.
 * February+March 2020
 */
package simulation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewWindow {
	private JFrame frame;
	private JPanel[] panelColour;
	private JPanel panelGray, panelMain;
	private JLabel[][] pokemonPictures;
	private String[][] pokemonPicSource = {
			{"Scorbunny.jpg", "Charmander.png", "Vulpix.jpg", "Torchic.jfif", "Fennekin.jfif", "Lampent.jfif", "Fletchinder.jfif", "Braixen.jfif", "Litten.png", "Victini.jfif"},
			{"Bulbasaur.png", "Oddish.jfif", "Chickorita.jfif", "Cherubi.jfif", "Snivy.png", "Pansage.jfif", "Rowlett.png", "Skiddo.jfif", "Grookey.jfif", "Bounsweet.png"},
			{"Squirtle.jfif", "Seel.jfif", "Vaporeon.jfif", "Totodile.jfif", "Omanyte.jfif", "Lotad.jfif", "Spheal.png", "Oshawott.jfif", "Ducklett.jfif", "Sobble.jfif"}
	};
	private JButton nextAttack, nextBattle;
	private JLabel[] typeLabel, pokemonBattle, stats, attack;
	private String[][] name;
	private String[] source;
	private int[][] rando, pokLevelValue;
	private int[] population, pokLevel, strength, type, y;
	private double[] pokHealth;
	private boolean[][] pokLevelSet, alive;
	private boolean turn;
	private int criticalHitChance;
	private JLabel rules;
	
	/**
	 * gui() method cannot be a class method b/c it needs to be called after the other methods to set the data in arrays
	 * and so that the images/panels can all be added to the frame in the correct order so they actually appear in the window
	 */
	public void gui() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 700);
		frame.setLocationRelativeTo(null);
		
		panelMain = new JPanel(new GridBagLayout());
		panelMain.setLayout(new GridBagLayout());
		panelGray = new JPanel(new GridBagLayout());
		panelGray.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		
		panelColour = new JPanel[3];
		GridBagConstraints c = new GridBagConstraints();
		
		String[] typeLabelString = {"FIRE", "GRASS", "WATER"};
		typeLabel = new JLabel[3];
		
		pokemonPictures = new JLabel[3][10];
		
		//will loop so all type panels are added to the main panel
		for(int x = 0; x < 3; x++) {
			panelColour[x] = new JPanel(new GridBagLayout());
			typeLabel[x] = new JLabel(typeLabelString[x]);
			c.gridy = x;
			c.gridx = 0;
			c.insets = new Insets(0, 0, 0, 50);
			typeLabel[x].setForeground(Color.black);
			panelColour[x].add(typeLabel[x], c);
			//will loop to make sure all the pictures of chosen pokemon get placed into their colour panel
			for(int y = 0; y < 10; y++) {
				//@school: H:/git/simulation2/simulation/src/simulation/Images/
				//@my house: C:\Users\Cynthia\Documents\git\simulation2\simulation\src\simulation\Images/
				if(!name[x][y].equals("nool")) {
					pokemonPictures[x][y] = new JLabel();
					String source = "H:/git/simulation2/simulation/src/simulation/Images/" + pokemonPicSource[x][rando[x][y]];
					pokemonPictures[x][y].setIcon(new ImageIcon(new ImageIcon(source).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
					c.gridx = y + 1;
					c.insets = new Insets(0, 5, 0, 0);
					panelColour[x].add(pokemonPictures[x][y], c);
				}
			}
		}
		pokemonBattle = new JLabel[2];
		population = new int[3];
		stats = new JLabel[2];
		attack = new JLabel[2];
		
		rules = new JLabel("<html>A random attack will be chosen when you click 'NEXT ATTACK'<br>The attack name will turn red when there is a Critical Hit<br>A Critical Hit will result in x2 damage<br>Pokemon can heal themselves in place of attacking the other pokemon<br>In which case they recieve +5 health");
		panelGray.add(rules);
		
		//will set the display up for battleing
		for(int u = 0; u < 2; u++) {
			pokemonBattle[u] = new JLabel();
			g.gridy = 0;
			g.gridx = u + 1;
			g.insets = new Insets(0, 30, 0, 30);
			panelGray.add(pokemonBattle[u], g);
			
			stats[u] = new JLabel();
			g.gridy = 0;
			//will set the grid to be on the correct side of their picture
			switch(u) {
			case 0:g.gridx = 0;break;
			case 1:g.gridx = 3;break;
			}
			g.insets = new Insets(0, 10, 0, 10);
			panelGray.add(stats[u], g);
			
			attack[u] = new JLabel();
			g.gridy = 1;
			g.gridx = u + 1;
			g.insets = new Insets(10, 10, 0, 0);
			panelGray.add(attack[u], g);
		}
		
		pokHealth = new double[2];
		pokLevel = new int[2];
		pokLevelSet = new boolean[3][10];
		alive = new boolean[3][10];
		pokLevelValue = new int[3][10];
		source = new String[2];
		type = new int[2];
		y = new int[2];
		turn = true;
		
		//will set pokLevelSet(to make sure a pokemon's level isn't set twice) & alive(if they're dead or not)
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 10; y++) {
				pokLevelSet[x][y] = false;
				alive[x][y] = true;
			}
		}

		nextBattle = new JButton("START");
		Battle battle = new Battle();
		nextBattle.addActionListener(new ActionListener() {

			@Override
			/**
			 * will go when the user clicks the "START" or "NEXT BATTLE" button as it changes what it says
			 * this will initialize the next battle or pop up the window for the winner
			 */
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				int notDead = 0;
				rules.setText("");
				
				//will check each pokemon in previous battle
				for(int c = 0; c < 2; c++) {
					//will go though if it's not the first time clicking nextBattle button
					if(!nextBattle.getText().equals("START")) {
						//will decide if the battle is over
						if(pokHealth[0] == 0 || pokHealth[1] == 0 || nextAttack.getText().equals("NOPE")) {
							//will decide what to do if the pokemon won or not
							if(pokHealth[c] == 0) {
								alive[type[c]][y[c]] = false;
							}else {
								pokemonPictures[type[c]][y[c]].setIcon(new ImageIcon(new ImageIcon(source[c]).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
							}
						}
					}
				}
				
				//will loop to check how many pokemon are still alive
				for(int x = 0; x < 3; x++) {
					for(int y = 0; y < 10; y++) {
						if(alive[x][y] && !name[x][y].equals("nool")) {
							notDead++;	
						}
					}
				}
				
				/**
				 * will display winner if there's only one pokemon left alive
				 * or will run next battle
				 */
				if(notDead == 1) {
					//will decide which pokemon in final battle won & initialze the window for the winner
					if(pokHealth[1] <= 0) {
						Winner win = new Winner(type[0], name[type[0]][y[0]]);
					}else {
						Winner win = new Winner(type[1], name[type[1]][y[1]]);
					}
				}else if(pokHealth[0] == 0 || pokHealth[1] == 0 || nextBattle.getText().equals("START")) {
					//will repeat for both pokemon taking place in the battle
					for(int i = 0; i < 2; i++) {
						int rounds = 0;
						attack[i].setText("");
						source[i] = "";
						/**
						 * will loop until both pokemon are:
						 * different
						 * alive
						 * & will set the source for their picture
						 */
						do {
							//will change type if the population is zero(0)
							do {
								type[i] = r.nextInt(3);
								y[i] = battle.pokemonSelector(population[type[i]], type[i]);
							}while(y[i] == 25);
							
							source[i] = "H:/git/simulation2/simulation/src/simulation/Images/" + matchSourceName(i, type[i], y[i]);

							//will change which type it's looking through if it's gone through one whole type already
							if(rounds > 10) {
								rounds = 0;
							}else {
								rounds++;
							}
						}while(i == 1 && source[0].equals(source[1]) || !alive[type[i]][y[i]]);
						
						pokemonBattle[i].setIcon(new ImageIcon(new ImageIcon(source[i]).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
						pokemonPictures[type[i]][y[i]].setIcon(null);
						
						//will set a pokemon's level and say that has taken place
						if(!pokLevelSet[type[i]][y[i]]) {
							pokLevel[i] = battle.lvlInput(strength[type[i]]);
							pokLevelValue[type[i]][y[i]] = pokLevel[i];
							pokLevelSet[type[i]][y[i]] = true;
						}else {
							pokLevel[i] = pokLevelValue[type[i]][y[i]];
						}
						pokHealth[i] = battle.hpGen(pokLevel[i]);
						
						stats[i].setText("<html>" + name[type[i]][y[i]].toUpperCase() + "<br>Level: " + pokLevel[i] + "<br>Health: " + pokHealth[i]);
					}
					nextAttack.setText("ATTACK");
				}
				nextBattle.setText("NEXT BATTLE");
			}
		});
		c.gridy = 2;
		c.gridx = 1;
		panelGray.add(nextBattle, c);
		
		nextAttack = new JButton("ATTACK");
		nextAttack.addActionListener(new ActionListener() {

			@Override
			/**
			 * will initiate the next attack
			 */
			public void actionPerformed(ActionEvent e) {
				double hpLost, criHit;
				//will only be able to press button if both pokemon's health is above zero
				if(pokHealth[0] > 0 && pokHealth[1] > 0) {
					//will decide who's turn it is
					if(turn) {
						attack[0].setText(battle.pickAttack(type[0]));
						attack[1].setText("");
						attack[0].setForeground(Color.magenta);
						hpLost = battle.apGen(pokLevel[0], battle.returnAttackValue(type[0], battle.returnAttackCoordinates()));
						hpLost = Math.round(hpLost);
						//will do heal instead of attack
						if(hpLost > 1) {
							pokHealth[0]+=hpLost;
							attack[0].setForeground(Color.cyan);
							stats[0].setText("<html>" + name[type[0]][y[0]].toUpperCase() + "<br>Level: " + pokLevel[0] + "<br>Health: " + pokHealth[0] + "<br>+" + hpLost);
						}else {
							criHit = hpLost;
							hpLost = battle.critChance(criticalHitChance, hpLost);
							//will recognize when a CriticalHit has taken place
							if(hpLost == (criHit*2)) {
								attack[0].setForeground(Color.red);
							}
							pokHealth[1]+=hpLost;
							//will change the health to 0.0 if it below that so it looks better(can't have negative health)
							if(pokHealth[1] <= 0) {
								pokHealth[1] = 0.0;
							}
							stats[1].setText("<html>" + name[type[1]][y[1]].toUpperCase() + "<br>Level: " + pokLevel[1] + "<br>Health: " + pokHealth[1] + "<br>" + hpLost);
						}
						turn = false;
					}else {
						attack[1].setText(battle.pickAttack(type[1]));
						attack[0].setText("");
						attack[1].setForeground(Color.pink);
						hpLost = battle.apGen(pokLevel[1], battle.returnAttackValue(type[1], battle.returnAttackCoordinates()));
						hpLost = Math.round(hpLost);
						//will do heal instead of attack
						if(hpLost > 1) {
							pokHealth[1]+=hpLost;
							attack[1].setForeground(Color.cyan);
							stats[1].setText("<html>" + name[type[1]][y[1]].toUpperCase() + "<br>Level: " + pokLevel[1] + "<br>Health: " + pokHealth[1] + "<br>+" + hpLost);
						}else {
							criHit = hpLost;
							hpLost = battle.critChance(criticalHitChance, hpLost);
							//will recognize when a CriticalHit has taken place
							if(hpLost == (criHit*2)) {
								attack[1].setForeground(Color.red);
							}
							pokHealth[0]+=hpLost;
							//will change the health to 0.0 if it below that so it looks better(can't have negative health)
							if(pokHealth[0] <= 0) {
								pokHealth[0] = 0.0;
							}
							stats[0].setText("<html>" + name[type[0]][y[0]].toUpperCase() + "<br>Level: " + pokLevel[0] + "<br>Health: " + pokHealth[0] + "<br>" + hpLost);
						}
						turn = true;
					}	
					nextAttack.setText("NEXT ATTACK");
				}
				if(pokHealth[0] == 0 || pokHealth[1] == 0){
					nextAttack.setText("NOPE");
				}
			}
				
		});
		
		c.gridy = 2;
		c.gridx = 2;
		panelGray.add(nextAttack, c);
		
		panelColour[0].setBackground(Color.red);
		c.gridy = 0;
		c.gridx = 0;
		c.ipadx = 1540;
		c.ipady = 20;
		c.insets = new Insets(10,0,0,0);
		panelMain.add(panelColour[0], c);
		
		panelColour[1].setBackground(Color.green);
		c.gridy = 1;
		c.gridx = 0;
		panelMain.add(panelColour[1], c);
		
		panelColour[2].setBackground(Color.blue);
		c.gridy = 2;
		c.gridx = 0;
		panelMain.add(panelColour[2], c);
		
		panelGray.setBackground(Color.gray);
		c.gridy = 3;
		c.gridx = 0;
		c.ipady = 100;
		panelMain.add(panelGray, c);
		
		panelMain.setBackground(Color.gray);
		
		frame.setContentPane(panelMain);
		frame.setVisible(true);
	}

	/**
	 * will set rando and name to be used for later
	 */
	public void setRandoAndName() {
		name = new String[3][10];
		rando = new int[3][10];
	}
	
	/**
	 * will grab the name of the chosen pokemon
	 * @param grab
	 * @param type
	 * @param pok
	 */
	public void grabPokemonNames(String grab, int type, int pok) {
		name[type][pok] = grab;
	}
	
	/**
	 * will grab the y coordinate of the chosen pokemon relative to the pokemonNameBank
	 * @param grab
	 * @param type
	 * @param pok
	 */
	public void grabRandoPokemon(int grab, int type, int pok) {
		rando[type][pok] = grab;
	}
	
	
	/**
	 * will grab population from TestingClass
	 * which comes from FirstWindow
	 * @param type
	 * @param pop
	 */
	public void grabPopulation(int type, int pop) {
		population[type] = pop;
	}
	
	/**
	 * matches the name of the pokemon with it's picture source
	 * @param i
	 * @param type
	 * @param y
	 * @return
	 */
	public String matchSourceName(int i, int type, int y) {
		boolean done = false;
		String source = "blub";
		int t = 0;
		//will loop until the name matches with the correct source so the name and picture macth for being put on the window
		while(!done) {
			//will set source if the first three letters of the name of the chosen pokemon and the source are the same
			if(name[type][y].substring(0, 3).equals(pokemonPicSource[type][t].substring(0, 3))) {
				done = true;
				source = pokemonPicSource[type][t];
			}else {
				t++;
			}
		}
		return source;
	}

	/**
	 * will set the array strength to used later
	 */
	public void setStrength() {
		strength = new int[3];
	}
	
	/**
	 * will grab the strength of each type from TestingClass to set levels of each pokemon
	 * which comes from FirstWindow
	 */
	public void grabStrength(int type, int stren) {
		strength[type] = stren;
	}
	
	/**
	 * will grab the chance % of a critical hit from TestingClass
	 * which comes from FirstWindow
	 * @param chc
	 */
	public void setCriticalHitChance(int chc) {
		criticalHitChance = chc;
	}
}
