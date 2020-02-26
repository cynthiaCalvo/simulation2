package simulation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstWindow implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JTextField[] choosePopulation;//where user enters their chosen values
	private int[] pokemonNumbers;//for population of each type
	private JButton button;//to open new window
	private boolean trigger;
	private JLabel[] labels;
	private JLabel top;
	
	/**
	 * will open the first window for user to choose their variables before the simulation starts
	 */
	public FirstWindow() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1540, 900);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		String[] labelString = {"Fire Type", "Grass Type", "Water Type"};
		labels = new JLabel[3];
		pokemonNumbers = new int[3];
		button = new JButton("GO");
		button.addActionListener(this);
		button.setActionCommand("GO");
		
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
			if(i == 0) {
				labels[i].setForeground(Color.RED);
			}else if(i == 1) {
				labels[i].setForeground(Color.green);
			}else {
				labels[i].setForeground(Color.blue);
			}
			panel.add(labels[i], c);
			choosePopulation[i] = new JTextField(10);
			c.gridy = 2;
			choosePopulation[i].setActionCommand(Integer.toString(i));
			panel.add(choosePopulation[i], c);
			
		}
		
		panel.setOpaque(true);
		panel.setBackground(Color.lightGray);
		
		c.gridy = 3;
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
		if(eventName.equals("GO")) {
			for(int i = 0; i < 3; i++) {
				pokemonNumbers[i] = Integer.parseInt(choosePopulation[i].getText());
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
