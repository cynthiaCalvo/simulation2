/*
 * Cynthia C. & David S.
 * February + March 2020
 */
package simulation;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Winner {
	private JFrame frame;
	private JPanel panel;
	private JLabel winner;
	
	public Winner(int x, String name) {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel();
		String type;
		
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
		
		winner = new JLabel("<html>WINNER: <br>" + type + "TYPE WINS!!!!!!!!<br>" + name);
		
		panel.add(winner);

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

}
