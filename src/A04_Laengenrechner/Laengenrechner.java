package A04_Laengenrechner;

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

import A04_Laengenrechner.Laengen.Length;
import javax.swing.JLabel;
import java.awt.Font;


/**
 * @author Tim Schlachter TG11/3 14.10.2019
 *
 */


/* Error codes
 * 
 * Error code #01: No Input Unit selected
 * Error code #02: No Output Unit selected
 * Error code #03: Input isn't a Number
 * Error code #04: "Nothing"
 * Error code #05: "Nothing"
 * Error code #06: "Nothing"
 * Error code #07: "Nothing"
 * Error code #08: "Nothing"
 * Error code #09: Unknown Error
 * 
 */


public class Laengenrechner implements Length{

	public static String Input;
	public static String Output;

	public static String NumberInputAsString;
	public static double NumberInputAsDouble;
	public static double Result;
	
	private JFrame frmLngenrechner;
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
					Laengenrechner window = new Laengenrechner();
					window.frmLngenrechner.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Laengenrechner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLngenrechner = new JFrame();
		frmLngenrechner.setTitle("L\u00E4ngenrechner");
		frmLngenrechner.setResizable(false);
		frmLngenrechner.setBounds(100, 100, 325, 185);
		frmLngenrechner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLngenrechner.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(28, 25, 150, 20);
		frmLngenrechner.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		String[] Eingangsgrösse = {"Eingangsgrösse auswählen","Millimeter","Centimeter","Meter","Kilometer","Fuss","Yards","Inch/Zoll","Seemeile","Meile"};
		JComboBox<String> comboBox = new JComboBox(Eingangsgrösse);
		comboBox.setEditable(true);
		comboBox.setBounds(192, 25, 100, 20);
		frmLngenrechner.getContentPane().add(comboBox);
			
		
		String[] Ausgangsgrössen = {"Ausgangsgrössen auswählen","Millimeter","Centimeter","Meter","Kilometer","Fuss","Yards","Inch/Zoll","Seemeile","Meile"};
		JComboBox comboBox_1 = new JComboBox(Ausgangsgrössen);
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(192, 64, 100, 20);
		frmLngenrechner.getContentPane().add(comboBox_1);
		
		
		txtResult = new JTextField();
		txtResult.setEditable(false);
		txtResult.setHorizontalAlignment(SwingConstants.CENTER);
		txtResult.setText("Result");
		txtResult.setBounds(28, 64, 150, 20);
		frmLngenrechner.getContentPane().add(txtResult);
		txtResult.setColumns(10);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
				Input = (String) comboBox.getSelectedItem();
				Output = (String) comboBox_1.getSelectedItem();
				
				if(Input == "Eingangsgrösse auswählen")
				{
					JOptionPane.showMessageDialog(null, "Bitte Wählen sie die Eingangsgrösse aus", "ErrorCode " + "#01", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(Output == "Ausgangsgrössen auswählen")
				{
					JOptionPane.showMessageDialog(null, "Bitte Wählen sie die Ausgangsgrösse aus", "ErrorCode " + "#02", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					
					NumberInputAsString = textField.getText();
					VerifyInput();
					
				}				
			}
		});
		btnNewButton.setBounds(28, 95, 150, 30);
		frmLngenrechner.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Tim Schlachter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(245, 131, 64, 14);
		frmLngenrechner.getContentPane().add(lblNewLabel);
				
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
        	ConvertInputToMeters();
        else
        {
        	JOptionPane.showMessageDialog(null, "Bitte geben sie eine Zahl ein", "ErrorCode " + "#03", JOptionPane.INFORMATION_MESSAGE);
        }
            
    }
	
	
	public void ConvertInputToMeters()
	{
		if (Input == "Millimeter")
		{
			Result = NumberInputAsDouble / METER_IN_MILLIMETER;
		}
		else if (Input == "Centimeter")
		{
			Result = NumberInputAsDouble / METER_IN_CENTIMETER;
		}
		else if (Input == "Meter")
		{
			Result = NumberInputAsDouble / METER_IN_METER;
		}
		else if (Input == "Kilometer")
		{
			Result = NumberInputAsDouble / METER_IN_KILOMETER;
		}
		else if (Input == "Fuss")
		{
			Result = NumberInputAsDouble * METER_IN_FUSS;
		}
		else if (Input == "Yards")
		{
			Result = NumberInputAsDouble * METER_IN_YARDS;
		}
		else if (Input == "Inch/Zoll")
		{
			Result = NumberInputAsDouble / METER_IN_INCH;
		}
		else if (Input == "Seemeile")
		{
			Result = NumberInputAsDouble * METER_IN_SEEMEILEN;
		}
		else if (Input == "Meile")
		{
			Result = NumberInputAsDouble * METER_IN_MEILEN;
		}
		
		ConvertInputToOutput();
		
	}
	
	
	public void ConvertInputToOutput()
	{
		if (Output == "Millimeter")
		{
			Result = Result * METER_IN_MILLIMETER;
		}
		else if (Output == "Centimeter")
		{
			Result = Result * METER_IN_CENTIMETER;
		}
		else if (Output == "Meter")
		{
			Result = Result * METER_IN_METER;
		}
		else if (Output == "Kilometer")
		{
			Result = Result * METER_IN_KILOMETER;
		}
		else if (Output == "Fuss")
		{
			Result = Result / METER_IN_FUSS;
		}
		else if (Output == "Yards")
		{
			Result = Result / METER_IN_YARDS;
		}
		else if (Output == "Inch/Zoll")
		{
			Result = Result * METER_IN_INCH;
		}
		else if (Output == "Seemeile")
		{
			Result = Result / METER_IN_SEEMEILEN;
		}
		else if (Output == "Meile")
		{
			Result = Result / METER_IN_MEILEN;
		}
		
		Calculate();
		
	}
	
	
	public void Calculate()
	{	
		NumberFormat formatter = NumberFormat.getInstance();
	    formatter.setMaximumFractionDigits(5);
		txtResult.setText(formatter.format(Result) + " " + Output);		
	}
				
}