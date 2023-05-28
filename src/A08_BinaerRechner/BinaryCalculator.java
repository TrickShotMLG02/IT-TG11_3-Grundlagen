package A08_BinaerRechner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import A07_GraphicalUserInterfaces.Calculate;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.GridLayout;


public class BinaryCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField tfDecimal;
	private JTextField tfBinary;	
	private JTextField tfHex;
	
	int bits = 8;
	int InputType = 0;
	
	static String digits = "0123456789ABCDEF";
	
	double d;
	double b;
	
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BinaryCalculator frame = new BinaryCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BinaryCalculator() {
		setTitle("Dezimal-Bin\u00E4r-Konverter");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.NORTH);
		panelMain.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel label = new JLabel("Decimal");
		panelMain.add(label);
		
		tfDecimal = new JTextField();
		tfDecimal.setColumns(10);
		tfDecimal.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                InputType = 10;
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });

		panelMain.add(tfDecimal);
		
		JLabel PlaceHolder = new JLabel("");
		panelMain.add(PlaceHolder);
		
		JLabel label_1 = new JLabel("Binary");
		panelMain.add(label_1);
		
		tfBinary = new JTextField();
		tfBinary.setColumns(10);
		
		tfBinary.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                InputType = 2;
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });
		
		panelMain.add(tfBinary);
		tfBinary.setDocument(new JTextFieldLimit(bits));
		
		String[] binaryBits = { "1", "2", "4", "8", "16" };
		JComboBox comboBoxBinary = new JComboBox(binaryBits);
		comboBoxBinary.setSelectedIndex(3);
		comboBoxBinary.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent arg0) {
	        	bits = (int)Double.parseDouble(comboBoxBinary.getSelectedItem().toString());
	        	tfBinary.setDocument(new JTextFieldLimit(bits));
	        }
	    });
		panelMain.add(comboBoxBinary);
		
		JLabel lblHex = new JLabel("Hex");
		panelMain.add(lblHex);
		
		tfHex = new JTextField();
		tfHex.setColumns(10);
		tfHex.setDocument(new JTextFieldLimit(bits));
		tfHex.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                InputType = 16;
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });
		
		panelMain.add(tfHex);
		
		String[] hexBits = { "1", "2", "4", "8", "16" };
		JComboBox comboBoxHex = new JComboBox(hexBits);
		comboBoxHex.setSelectedIndex(3);
		comboBoxHex.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent arg0) {
	        	bits = (int)Double.parseDouble(comboBoxHex.getSelectedItem().toString());
	        	tfHex.setDocument(new JTextFieldLimit(bits));
	        }
	    });
		panelMain.add(comboBoxHex);
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		
		JButton button = new JButton("Clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		panelButtons.add(button);
		
		JButton button_1 = new JButton("Calculate");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//clear();
				
				try {
					
					d = Double.parseDouble(tfDecimal.getText());
					
				} catch (NumberFormatException e1) {		
				}
				
				try {
					
					b = Double.parseDouble(tfBinary.getText());
					
				} catch (NumberFormatException e1) {
				}
				
				calculate((int) d, (int) b );
			}
		});
		panelButtons.add(button_1);
	}

	protected void calculate(int dec, int bin) {
		/**
		 * 
		 * 
		//d = 0;
		//b = 0;
			
		if (InputType == 10)
		{
			if (decToBin < Math.pow(2, bits))
			{
				tfBinary.setText("");
				
				int binary[] = new int[64];
			    for(int i = 0; decToBin > 0; i++){
			       binary[i] = decToBin % 2;
			       decToBin = decToBin / 2;
			     }
			     for(int i = bits - 1; i >= 0; i--)
			     {
			       //System.out.println(binary[i]);
			       tfBinary.setText(tfBinary.getText() + binary[i]);
			     }		
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Maximum number for " + bits + " bit is " + (int)(Math.pow(2, bits) - 1) , "Errorcode: " + "#001",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		else if (InputType == 2)
		{
			tfDecimal.setText("");
			
			int decimal[] = new int[64];
		    for(int i = 0; binToDec > 0; i++){
		       decimal[i] = binToDec % 10;
		       decimal[i] = (int) (decimal[i] * Math.pow(2, i));
		       binToDec = binToDec / 10;
		     }
		     for(int i = bits - 1; i >= 0; i--)
		     {
		    	 b += decimal[i];
		     }
		     //System.out.println(b);
		     tfDecimal.setText((int)b + "");
		}
			     
	    **/ 
		
		if (InputType == 10)
		{
			isDecimal(dec);
			decimal2Hex(dec);
			//decimal2Binary(dec);
		}
		else if(InputType == 2)
		{
			isBinary(bin);
			
			//decimal2Binary(bin);
		}
	}

	public static String decimal2Hex(int in)
	{
		if (in <= 0 ) return "0";
		int base = 16;
		String hex = "";
		while (in > 0){
			int digit = in % base;
			hex = digits.charAt(digit) + hex;
			in = in / base;
		}
		System.out.println(hex);
		return hex;
	}
	
	public static String decimal2Octal(int in)
	{
		if (in <= 0 ) return "0";
		int base = 8;
		String hex = "";
		while (in > 0){
			int digit = in % base;
			hex = digits.charAt(digit) + hex;
			in = in / base;
		}
		System.out.println(hex);
		return hex;
	}
	
	public static String decimal2Binary(int in)
	{
		if (in <= 0 ) return "0";
		int base = 2;
		String bin = "";
		while (in > 0){
			int digit = in % base;
			bin = digits.charAt(digit) + bin;
			in = in / base;
		}
		System.out.println(bin);
		return bin;
	}
	
	
	
	
	
	protected void clear() {
		
		tfBinary.setText("");
		tfDecimal.setText("");
		tfHex.setText("");
	}	
	
	
	
	
	
	protected void isHex()
	{
		
	}
	
	protected void isDecimal(int decNumber)
	{
		if (decNumber < Math.pow(2, bits))
		{
			tfBinary.setText("");
			
			int binary[] = new int[64];
		    for(int i = 0; decNumber > 0; i++){
		       binary[i] = (int) (decNumber % 2);
		       decNumber = decNumber / 2;
		     }
		     for(int i = bits - 1; i >= 0; i--)
		     {
		       //System.out.println(binary[i]);
		       tfBinary.setText(tfBinary.getText() + binary[i]);
		     }
		}
	}
	
	protected void isOctal()
	{
		
	}
	
	protected void isBinary(int binNumber)
	{
		tfDecimal.setText("");
		
		int decimal[] = new int[64];
	    for(int i = 0; binNumber > 0; i++){
	       decimal[i] = (int) (binNumber % 10);
	       decimal[i] = (int) (decimal[i] * Math.pow(2, i));
	       binNumber = binNumber / 10;
	     }
	     for(int i = bits - 1; i >= 0; i--)
	     {
	    	 binNumber += decimal[i];
	     }
	     //System.out.println(b);
	     tfDecimal.setText((int)binNumber + "");
	}
}
