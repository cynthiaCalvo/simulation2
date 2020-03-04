package simulation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstWindow implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JTextField[] choosePopulation;
	private int[] pokemonNumbers, pokemonStrength;
	private JButton button;
	private boolean trigger;
	private JLabel[] labels;
	private JLabel top, middle;
	private JComboBox[] strength;
	
	/**
	 * will open the first window for user to choose their variables before the simulation starts
	 */
	public FirstWindow() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		String[] labelString = {"Fire Type", "Grass Type", "Water Type"};
		String[] strengthString = {"1", "2", "3"};
		labels = new JLabel[3];
		pokemonNumbers = new int[3];
		button = new JButton("START");
		button.addActionListener(this);
		button.setActionCommand("START");
		
		strength = new JComboBox[3];
		pokemonStrength = new int[3];
		
		top = new JLabel("How many do you want of:");
		c.gridy = 0;
		c.gridx = 1;
		c.insets = new Insets(0, 0, 10, 0);
		panel.add(top, c);
		
		choosePopulation = new JTextField[3];
		
		for(int i = 0; i < 3; i++) {
			labels[i] = new JLabel(labelString[i]);
			c.gridy = 1;
			c.gridx = i;
			c.insets = new Insets(0, 5, 0, 5);
			switch(i) {
			case 0:labels[i].setForeground(Color.RED);break;
			case 1:labels[i].setForeground(Color.green);break;
			case 2:labels[i].setForeground(Color.blue);break;
			default: System.out.println("Something isn't working");
			}
			
			panel.add(labels[i], c);
			choosePopulation[i] = new JTextField(10);
			c.gridy = 3;
			choosePopulation[i].setActionCommand(Integer.toString(i));
			panel.add(choosePopulation[i], c);	
		}
		
		middle = new JLabel("How strong do you want each type to be:");
		c.gridy = 4;
		c.gridx = 1;
		c.insets = new Insets(20, 0, 20, 0);
		panel.add(middle, c);
		
		for(int y = 0; y < 3; y++) {
			labels[y] = new JLabel(labelString[y]);
			c.gridy = 5;
			c.gridx = y;
			c.insets = new Insets(0, 5, 0, 5);
			switch(y) {
			case 0:labels[y].setForeground(Color.RED);break;
			case 1:labels[y].setForeground(Color.green);break;
			case 2:labels[y].setForeground(Color.blue);break;
			default: System.out.println("Something isn't working");
			}
			panel.add(labels[y], c);
			
			strength[y] = new JComboBox(strengthString);
			strength[y].addActionListener(this);
			c.gridx = y;
			c.gridy = 6;
			panel.add(strength[y], c);
		}
		
		panel.setOpaque(true);
		panel.setBackground(Color.lightGray);
		
		c.gridy = 7;
		c.gridx = 1;
		c.insets = new Insets(10, 0, 0, 0);
		panel.add(button, c);

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	/**
	 * will run when user pressed GO
	 */
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		//will grab the populations of each type from the text fields
		if(eventName.equals("START")) {
			for(int i = 0; i < 3; i++) {
				pokemonNumbers[i] = Integer.parseInt(choosePopulation[i].getText());
				pokemonStrength[i] = strength[i].getSelectedIndex() + 1;//the +1 is needed b/c we had the user pick b/t 1,2,3 but the computer sees it as 0,1,2
				trigger = true;
			}
		}
	}
	
	/**
	 * will allow the TestingClass to stop opening the new window until user has pressed the GO button
	 * 
	 * very important do not remove
	 * @return
	 */
	public boolean returnTrigger() {
		return trigger;
	}
	
	/**
	 * will return the population of each type
	 * @param i
	 * @return
	 */
	public int returnPokemonNumbers(int i) {
		//will return the population of each type unless the user has not pressed the GO button
		if(trigger) {
			return pokemonNumbers[i];
		}else {
			return 25;
		}
	}
}
