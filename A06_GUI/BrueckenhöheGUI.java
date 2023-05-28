package A06_GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import Interfaces.Physik;


/**
 * @author Tim Schlachter TG11/3 04.11.2019
 *
 */


/* Error codes
 * 
 * Error code #01: "Nothing"
 * Error code #02: "Nothing"
 * Error code #03: No valid digit count to round selected
 * Error code #04: No Input / Input isn't a valid Number
 * Error code #05: "Nothing"
 * Error code #06: "Nothing"
 * Error code #07: "Nothing"
 * Error code #08: "Nothing"
 * Error code #09: Unknown Error
 * 
 */


public class BrueckenhöheGUI implements Physik{

	public static String Input;
	public static String Output;
	public static String DigitsToRound;

	public static String NumberInputAsString;
	public static double NumberInputAsDouble;
	public static double Result;
	
	private JFrame frmBrueckenhöheGUI;
	private JTextField textField;
	private JTextField txtResult;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrueckenhöheGUI window = new BrueckenhöheGUI();
					window.frmBrueckenhöheGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BrueckenhöheGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrueckenhöheGUI = new JFrame();
		frmBrueckenhöheGUI.setTitle("Brückenhöhe-Rechner");
		frmBrueckenhöheGUI.setResizable(false);
		frmBrueckenhöheGUI.setBounds(100, 100, 325, 185);
		frmBrueckenhöheGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrueckenhöheGUI.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(28, 25, 150, 20);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frmBrueckenhöheGUI.getContentPane().add(textField);
		textField.setColumns(10);
				
		
		String[] Runden = {"Nachkommastellen auswählen","1","2","3","4","5","6","7","8","9","10"};
		JComboBox comboBox_2 = new JComboBox(Runden);
		comboBox_2.setSelectedIndex(5);
		comboBox_2.setBounds(192, 100, 100, 20);
		frmBrueckenhöheGUI.getContentPane().add(comboBox_2);
		
		
		txtResult = new JTextField();
		txtResult.setEditable(false);
		txtResult.setHorizontalAlignment(SwingConstants.CENTER);
		txtResult.setText("Result");
		txtResult.setBounds(28, 64, 150, 20);
		frmBrueckenhöheGUI.getContentPane().add(txtResult);
		txtResult.setColumns(10);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
											
				DigitsToRound = (String) comboBox_2.getSelectedItem();	
				
				NumberInputAsString = textField.getText();
				VerifyInput();			
			}
		});
		btnNewButton.setBounds(28, 95, 150, 30);
		frmBrueckenhöheGUI.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Tim Schlachter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(245, 131, 64, 14);
		frmBrueckenhöheGUI.getContentPane().add(lblNewLabel);
				
	}
	
	
	
	
	
	public void VerifyInput()
	{
		
		boolean numeric = true;
        try {
            NumberInputAsDouble = Double.parseDouble(NumberInputAsString);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        if(numeric)
        {
        	if (DigitsToRound != "Nachkommastellen auswählen")
        	{
        		Calculate();
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null, "Bitte wählen sie die Nachkommastellen aus", "ErrorCode " + "#03", JOptionPane.INFORMATION_MESSAGE);
        	}
        }        	
        else
        {
        	JOptionPane.showMessageDialog(null, "Bitte geben sie eine Zahl ein", "ErrorCode " + "#04", JOptionPane.INFORMATION_MESSAGE);
        }
            
    }
	
	
	public void Calculate()
	{	
		Result = 1f / 2 * EARTH_MAGNITUDE * Math.pow(NumberInputAsDouble, 2);
		
		NumberFormat formatter = NumberFormat.getInstance();
	    formatter.setMaximumFractionDigits(Integer.parseInt(DigitsToRound));
		txtResult.setText(formatter.format(Result) + " " + "Meter");		
	}
}