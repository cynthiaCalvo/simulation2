package simulation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewWindow {
	private JFrame frame;
	private JPanel panelBlue, panelRed, panelGreen, panelGray, panelMain;
	private JLabel[][] pokemonPictures;
	private String[][] pokemonPicSource = {
			{"Scorbunny.png", "Charmander.png", "Vulpix.jpg", "Torchic.jfif", "Fennekin.jfif", "Lampent.jfif", "Fletchinder.jfif", "Braixen.jfif", "Litten.png", "Victini.jfif"},
			{"Balbasaur.png", "Oddish.jfif", "Chickorita.jfif", "Cherubi.jfif", "Snivy.png", "Pansage.jfif", "Rowlett.png", "Skiddo.jfif", "Grookey.jfif", "Bounsweet.png"},
			{"Squirtle.jfif", "Seel.jfif", "Vaporeon.jfif", "Totodile.jfif", "Omanyte.jfif", "Lotad.jfif", "Spheal.png", "Oshawott.jfif", "Ducklett.jfif", "Sobble.jfif"}
	};
	private JLabel[] typeLabel;
	//will store the names of the pokemon chosen
	private String[][] name;
	//will store the y position from the pokemonNameBank from PokemonPicking for the position in the chosen pokemon array
	private int[][] rando;
	
	/**
	 * gui() method cannot be a class method b/c it needs to be called after the other methods to set the data in arrays
	 * and so that the images/panels can all be added to the frame in the correct order so they actually appear in the window
	 */
	public void gui() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1540, 900);
		frame.setLocationRelativeTo(null);
		
		panelMain = new JPanel(new GridBagLayout());
		panelRed = new JPanel(new GridBagLayout());
		panelGreen = new JPanel(new GridBagLayout());
		panelBlue = new JPanel(new GridBagLayout());
		panelGray = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		panelMain.setLayout(new GridBagLayout());
		
		String[] typeLabelString = {"FIRE", "GRASS", "WATER"};
		typeLabel = new JLabel[3];
		
		pokemonPictures = new JLabel[3][10];
		
		for(int x = 0; x < 3; x++) {
			typeLabel[x] = new JLabel(typeLabelString[x]);
			c.gridy = x;
			c.gridx = 0;
			c.insets = new Insets(0, 0, 0, 50);
			typeLabel[x].setForeground(Color.black);
			switch(x) {
			case 0: panelRed.add(typeLabel[x], c);break;
			case 1: panelGreen.add(typeLabel[x], c);break;
			case 2: panelBlue.add(typeLabel[x], c);break;
			default: System.out.println("It doesn't work");
			}
			for(int y = 0; y < 10; y++) {
				//will only go through if there is a pokemon set to that spot
				if(!name[x][y].equals("nool")) {
					pokemonPictures[x][y] = new JLabel();
					//will set the source for the pokemon pictures so they can be added to the label
					String source = "H:/git/simulation2/simulation/src/simulation/Images/" + pokemonPicSource[x][rando[x][y]];
					pokemonPictures[x][y].setIcon(new ImageIcon(new ImageIcon(source).getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
					c.gridx = y + 1;
					c.insets = new Insets(0, 5, 0, 0);
					//adds the label/picture to the correct panel
					switch(x) {
					case 0:panelRed.add(pokemonPictures[x][y], c);break;
					case 1:panelGreen.add(pokemonPictures[x][y], c);break;
					case 2:panelBlue.add(pokemonPictures[x][y], c);break;
					default: System.out.println("It doesn't work");
					}
				}
				
			}
			System.out.println("\n");
		}
		
		panelRed.setBackground(Color.red);
		c.gridy = 0;
		c.ipadx = 1540;
		c.ipady = 20;
		c.insets = new Insets(10,0,0,0);
		panelMain.add(panelRed, c);
		
		panelGreen.setBackground(Color.green);
		c.gridy = 1;
		panelMain.add(panelGreen, c);
		
		panelBlue.setBackground(Color.blue);
		c.gridy = 2;
		panelMain.add(panelBlue, c);
		
		panelGray.setBackground(Color.gray);
		c.gridy = 3;
		c.ipady = 550;
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
}
