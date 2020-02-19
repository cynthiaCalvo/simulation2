package simulation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Simulation_Game implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	
	public Simulation_Game() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1540, 900);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//put everything else here
		
		panel.setOpaque(true);
		panel.setBackground(Color.CYAN);
		
		
		//do not put anything in this method past these two lines
		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	//for buttons, which I'm assuming we'll need
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
}
