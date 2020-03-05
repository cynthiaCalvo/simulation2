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
			{"Scorbunny.png", "Charmander.png", "Vulpix.jpg", "Torchic.jfif", "Fennekin.jfif", "Lampent.jfif", "Fletchinder.jfif", "Braixen.jfif", "Litten.png", "Victini.jfif"},
			{"Bulbasaur.png", "Oddish.jfif", "Chickorita.jfif", "Cherubi.jfif", "Snivy.png", "Pansage.jfif", "Rowlett.png", "Skiddo.jfif", "Grookey.jfif", "Bounsweet.png"},
			{"Squirtle.jfif", "Seel.jfif", "Vaporeon.jfif", "Totodile.jfif", "Omanyte.jfif", "Lotad.jfif", "Spheal.png", "Oshawott.jfif", "Ducklett.jfif", "Sobble.jfif"}
	};
	private JButton nextAttack, nextBattle;
	private JLabel[] typeLabel, pokemonBattle, stats;
	private String[][] name;
	private int[][] rando;
	private int[] population, pokLevel, strength;
	private double[] pokHealth;
	
	/**
	 * gui() method cannot be a class method b/c it needs to be called after the other methods to set the data in arrays
	 * and so that the images/panels can all be added to the frame in the correct order so they actually appear in the window
	 */
	public void gui() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
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
		
		for(int x = 0; x < 3; x++) {
			panelColour[x] = new JPanel(new GridBagLayout());
			typeLabel[x] = new JLabel(typeLabelString[x]);
			c.gridy = x;
			c.gridx = 0;
			c.insets = new Insets(0, 0, 0, 50);
			typeLabel[x].setForeground(Color.black);
			panelColour[x].add(typeLabel[x], c);
			for(int y = 0; y < 10; y++) {
				//@school: H:/git/simulation2/simulation/src/simulation/Images/
				//@home computer b/c source is different: C:\Users\Cynthia\Documents\git\simulation2\simulation\src\simulation\Images/
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
		
		for(int u = 0; u < 2; u++) {
			pokemonBattle[u] = new JLabel();
			g.gridy = 0;
			g.gridx = u + 1;
			g.insets = new Insets(0, 30, 0, 30);
			panelGray.add(pokemonBattle[u], g);
			
			stats[u] = new JLabel();
			stats[u].setBackground(Color.white);
			g.gridy = 0;
			switch(u) {
			case 0:g.gridx = 0;break;
			case 1:g.gridx = 3;break;
			}
			g.insets = new Insets(0, 10, 0, 10);
			panelGray.add(stats[u], g);
		}
		
		/**
		 * notes for me, not you
		 * put nextAttack button within the nextBattle actionListener method - so it will be there until there is another battle
		 * for nextAttack it will then need to loop until one pokemon's health is at 0
		 * then the user will need to press nextBattle button to start it over again
		 */
		pokHealth = new double[2];
		pokLevel = new int[2];
		

		nextBattle = new JButton("START");
		Battle battle = new Battle();
		nextBattle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				String[] source = new String[2];
				int type, y;
				for(int i = 0; i < 2; i++) {
					type = r.nextInt(3);
					pokLevel[i] = battle.lvlInput(strength[type]);
					pokHealth[i] = battle.hpGen(pokLevel[i]);
					do {
						y = Integer.parseInt(battle.pokemonSelector(population[type], type));
						source[i] = "H:/git/simulation2/simulation/src/simulation/Images/" + matchSourceName(i, type, y);
					}while(i == 1 && source[0].equals(source[1]));
					pokemonBattle[i].setIcon(new ImageIcon(new ImageIcon(source[i]).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
					stats[i].setText("Level: " + pokLevel[i] + "\nHealth: " + pokHealth[i]);
				}
				nextBattle.setText("NEXTBATTLE");
			}
		});
		c.gridy = 1;
		c.gridx = 0;
		panelGray.add(nextBattle, c);//have not able to click until health is @ 0
		
		nextAttack = new JButton("NEXT ATTACK");
		nextAttack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					if(pokHealth[0] > 0 && pokHealth[1] > 0) {
						
					}
			}
				
		});
		c.gridy = 1;
		c.gridx = 1;
		panelGray.add(nextAttack, c);//have not able to click after health is @ 0
		
		panelColour[0].setBackground(Color.red);
		c.gridy = 0;
		c.ipadx = 1540;
		c.ipady = 20;
		c.insets = new Insets(10,0,0,0);
		panelMain.add(panelColour[0], c);
		
		panelColour[1].setBackground(Color.green);
		c.gridy = 1;
		panelMain.add(panelColour[1], c);
		
		panelColour[2].setBackground(Color.blue);
		c.gridy = 2;
		panelMain.add(panelColour[2], c);
		
		panelGray.setBackground(Color.gray);
		c.gridy = 3;
		c.ipady = 100;
		panelMain.add(panelGray, c);
		
		frame.setContentPane(panelMain);
		frame.setVisible(true);
	}
	
	/**
	 * will set the name array to the names of the chosen pokemon
	 * it has to grab these from the TestingClass b/c we cannot directly take from PokemonPicking
	 * without making an instance of PokemonPicking - which would reset all the data
	 * @param grab
	 * @param type
	 * @param pok
	 */
	public void grabPokemonNames(String grab, int type, int pok) {
		name[type][pok] = grab;
	}
	
	/**
	 * will set rando array to the y position of the pokemon from pokemonNameBank
	 * same as before - this has to be grabbed from TestingClass b/c we cannot take
	 * directly from PokemonPicking w/o making an instance of it here in this class
	 * which would reset all the data
	 * @param grab
	 * @param type
	 * @param pok
	 */
	public void grabRandoPokemon(int grab, int type, int pok) {
		rando[type][pok] = grab;
	}
	
	/**
	 * will set rando and name array so they can have values placed in them
	 * this has to be done in a seperate method b/c the gui(); method has to be called afterwards
	 * which will be explained there
	 */
	public void setRandoAndName() {
		name = new String[3][10];
		rando = new int[3][10];
	}
	
	public void grabPopulation(int type, int pop) {
		population[type] = pop;
	}
	
	public String matchSourceName(int i, int type, int y) {
		boolean done = false;
		String source = "blub";
		int t = 0;
		while(!done) {
			if(name[type][y].substring(0, 3).equals(pokemonPicSource[type][t].substring(0, 3))) {
				done = true;
				source = pokemonPicSource[type][t];
			}else {
				t++;
			}
		}
		return source;
	}
	
	public void grabStrength(int type, int stren) {
		strength[type] = stren;
	}
	
	public void setStrength() {
		strength = new int[3];
	}
}
