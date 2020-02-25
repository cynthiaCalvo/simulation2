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
	private String[][] name;
	private int[][] rando;
	
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
		
		pokemonPictures = new JLabel[3][10];
		
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 10; y++) {

				if(!name[x][y].equals("nool")) {
					pokemonPictures[x][y] = new JLabel();
					String source = "H:/git/simulation2/simulation/src/simulation/Images/" + pokemonPicSource[x][rando[x][y]];
					pokemonPictures[x][y].setIcon(new ImageIcon(new ImageIcon(source).getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
					System.out.println(source);
					c.gridx = y;
					c.insets = new Insets(0, 5, 0, 0);
					if(x == 0) {
						panelRed.add(pokemonPictures[x][y], c);
					}else if(x == 1) {
						panelGreen.add(pokemonPictures[x][y], c);
					}else {
						panelBlue.add(pokemonPictures[x][y], c);
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
	
	public void grabPokemonNames(String grab, int type, int pok) {
		name[type][pok] = grab;
	}
	
	public void grabRandoPokemon(int grab, int type, int pok) {
		rando[type][pok] = grab;
	}
	
	public void setRandoAndName() {
		name = new String[3][10];
		rando = new int[3][10];
	}
}
