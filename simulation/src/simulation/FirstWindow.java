package simulation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstWindow implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JTextField[] choosePopulation;
	private int[] pokemonNumbers;
	private JButton button;
	private boolean trigger;
	
	public FirstWindow() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1540, 900);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
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
		
		if(eventName.equals("GO")) {
			for(int i = 0; i < 3; i++) {
				pokemonNumbers[i] = Integer.parseInt(choosePopulation[i].getText());
				trigger = true;
			}
		}
	}
	
	public boolean returnTrigger() {
		return trigger;
	}
	
	public int returnPokemonNumbers(int i) {
		if(trigger) {
			return pokemonNumbers[i];
		}else {
			return 25;
		}
	}
}
