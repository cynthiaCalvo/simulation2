package simulation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Simulation_Game implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JTextField[] choosePopulation;
	private int[] pokemonNumbers;
	private JButton button;
	
	public Simulation_Game() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1540, 900);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//put everything else here
		
		pokemonNumbers = new int[3];
		button = new JButton("GO");
		button.addActionListener(this);
		button.setActionCommand("GO");
		
		choosePopulation = new JTextField[3];
		
		for(int i = 0; i < 3; i++) {
			choosePopulation[i] = new JTextField(10);
			choosePopulation[i].setActionCommand(Integer.toString(i));
			panel.add(choosePopulation[i]);
			
		}
		
		panel.setOpaque(true);
		panel.setBackground(Color.CYAN);
		
		panel.add(button);

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		Simulation_Background back = new Simulation_Background();
		
		back.resetPokemonNames();
		
		if(eventName.equals("GO")) {
			for(int i = 0; i < 3; i++) {
				pokemonNumbers[i] = Integer.parseInt(choosePopulation[i].getText());
				back.pickPokemonRandom(pokemonNumbers[i], i);
			}
		}
		
	}
	
}
