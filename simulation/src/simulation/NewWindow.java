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
			{"Scorbunny.png", "Charmander.png", "Vulpix.jpeg", "Torchic.jfif", "Fennekin.jfif", "Lampent.jfif", "Fletchinder.jfif", "Braixen.jfif", "Litten.png", "Victini.jfif"},
			{"Bulbasaur.png", "Oddish.jfif", "Chickorita.jfif", "Cherubi.jfif", "Snivy.png", "Pansage.jfif", "Rowlett.png", "Skiddo.jfif", "Grookey.jfif", "Bounsweet.png"},
			{"Squirtle.jfif", "Seel.jfif", "Vaporeon.jfif", "Totodile.jfif", "Omanyte.jfif", "Lotad.jfif", "Spheal.png", "Oshawott.jfif", "Ducklett.jfif", "Sobble.jfif"}
	};
	GridBagConstraints c = new GridBagConstraints();
	
	public void gui() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1540, 900);
		frame.setLocationRelativeTo(null);
		
		panelMain.setLayout(new GridBagLayout());
		
		panelRed.setBackground(Color.red);
		c.gridy = 0;
		c.ipadx = 1540;
		c.ipady = 70;
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
		c.ipady = 580;
		panelMain.add(panelGray, c);
		
		frame.setContentPane(panelMain);
		frame.setVisible(true);
	}
	
	public void addingPics(int x, int y, String name, int g) {
		panelMain = new JPanel(new GridBagLayout());
		panelRed = new JPanel(new GridBagLayout());
		panelGreen = new JPanel(new GridBagLayout());
		panelBlue = new JPanel(new GridBagLayout());
		panelGray = new JPanel(new GridBagLayout());
		pokemonPictures = new JLabel[3][10];

		if(!name.equals("nool")) {
			pokemonPictures[x][y] = new JLabel();
			String source = "H:\\git\\simulation2\\simulation\\src\\simulation\\Images/" + pokemonPicSource[x][g];
			pokemonPictures[x][y].setIcon(new ImageIcon(new ImageIcon(source).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
			System.out.println(source);
			
			c.gridx = g;
					
			if(x == 0) {
				panelRed.add(pokemonPictures[x][y], c);
				System.out.println("red");
			}else if(x == 1) {
				panelGreen.add(pokemonPictures[x][y], c);
				System.out.println("Green");
			}else {
				panelBlue.add(pokemonPictures[x][y], c);
				System.out.println("Blue");
			}
		}
	}
}
