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

public class NewWindow {
	
	private JFrame frame;
	private JPanel panelBlue, panelRed, panelGreen, panelGray, panelMain;
	
	public NewWindow() {
		frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1540, 900);
		frame.setLocationRelativeTo(null);
		
		panelMain = new JPanel(new GridBagLayout());
		panelRed = new JPanel(new GridBagLayout());
		panelGreen = new JPanel(new GridBagLayout());
		panelBlue = new JPanel(new GridBagLayout());
		panelGray = new JPanel(new GridBagLayout());
		
		panelMain.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		panelRed.setBackground(Color.red);
		
		panelGreen.setBackground(Color.green);
		
		panelBlue.setBackground(Color.blue);
		
		panelGray.setBackground(Color.gray);
		
		
		frame.setContentPane(panelMain);
		frame.setVisible(true);
	}
	

}
