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


public class Brueckenh�heGUI implements Physik{

	public static String Input;
	public static String Output;
	public static String DigitsToRound;

	public static String NumberInputAsString;
	public static double NumberInputAsDouble;
	public static double Result;
	
	private JFrame frmBrueckenh�heGUI;
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
					Brueckenh�heGUI window = new Brueckenh�heGUI();
					window.frmBrueckenh�heGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Brueckenh�heGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrueckenh�heGUI = new JFrame();
		frmBrueckenh�heGUI.setTitle("Br�ckenh�he-Rechner");
		frmBrueckenh�heGUI.setResizable(false);
		frmBrueckenh�heGUI.setBounds(100, 100, 325, 185);
		frmBrueckenh�heGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrueckenh�heGUI.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(28, 25, 150, 20);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frmBrueckenh�heGUI.getContentPane().add(textField);
		textField.setColumns(10);
				
		
		String[] Runden = {"Nachkommastellen ausw�hlen","1","2","3","4","5","6","7","8","9","10"};
		JComboBox comboBox_2 = new JComboBox(Runden);
		comboBox_2.setSelectedIndex(5);
		comboBox_2.setBounds(192, 100, 100, 20);
		frmBrueckenh�heGUI.getContentPane().add(comboBox_2);
		
		
		txtResult = new JTextField();
		txtResult.setEditable(false);
		txtResult.setHorizontalAlignment(SwingConstants.CENTER);
		txtResult.setText("Result");
		txtResult.setBounds(28, 64, 150, 20);
		frmBrueckenh�heGUI.getContentPane().add(txtResult);
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
		frmBrueckenh�heGUI.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Tim Schlachter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(245, 131, 64, 14);
		frmBrueckenh�heGUI.getContentPane().add(lblNewLabel);
				
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
        	if (DigitsToRound != "Nachkommastellen ausw�hlen")
        	{
        		Calculate();
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null, "Bitte w�hlen sie die Nachkommastellen aus", "ErrorCode " + "#03", JOptionPane.INFORMATION_MESSAGE);
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