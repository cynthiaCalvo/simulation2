/*
 * Cynthia C. & David S.
 * February + March 2020
 */
package simulation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Winner {
	private JFrame frame;
	private JPanel panel;
	private JLabel winner;
	
	/**
	 * will open a window when initiated
	 * will show which type and whch pokemon won
	 * @param x
	 * @param name
	 */
	public Winner(int x, String name) {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 300);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel();
		String type;
		
		winner = new JLabel();
		
		//will set the text and text colour depending on which type the winner is
		if(x == 0) {
			type = "FIRE";
			winner.setForeground(Color.red);
		}else if(x == 1) {
			type = "GRASS";
			winner.setForeground(Color.green);
		}else {
			type = "WATER";
			winner.setForeground(Color.blue);
		}
		
		winner.setText("<html>" + name.toUpperCase() + " brings<br>" + type + " type to victory!!!!!!!");//maybe add more stats later
		winner.setFont(new Font("Monospaced", Font.BOLD, 40));
		
		panel.add(winner);

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

}
