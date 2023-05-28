package A08_BinaerRechner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.text.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

class ItemChangeListener implements ItemListener {
	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			Object item = event.getItem();
			// do something with object
		}
	}
}

class JTextFieldLimit extends PlainDocument {
	private int limit;

	JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}

	JTextFieldLimit(int limit, boolean upper) {
		super();
		this.limit = limit;
	}

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;
		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfDecimal;
	private JTextField tfBinary;

	public double decimalNumber;

	public int binaryArray[] = new int[32];

	public double binaryNumber;

	public int bits = 8;

	String s = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Dezimal-Bin\u00E4r Konverter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelMain = new JPanel();
		contentPane.add(panelMain);
		panelMain.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblDecimal = new JLabel("Decimal");
		panelMain.add(lblDecimal);

		tfDecimal = new JTextField();
		panelMain.add(tfDecimal);
		tfDecimal.setColumns(10);

		JLabel lblBinary = new JLabel("Binary");
		panelMain.add(lblBinary);

		tfBinary = new JTextField();
		panelMain.add(tfBinary);
		tfBinary.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "4", "8", "16" }));
		comboBox.setSelectedIndex(3);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				bits = Integer.parseInt((String) comboBox.getSelectedItem());

				tfDecimal.setDocument(new JTextFieldLimit(bits));
				tfBinary.setDocument(new JTextFieldLimit(bits));
			}
		});
		panelMain.add(comboBox);

		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panelButtons.add(btnClear);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
		});
		panelButtons.add(btnCalculate);
	}

	protected void clear() {
		tfDecimal.setText("");
		tfBinary.setText("");
		s = "";
	}

	protected void calculate() {

		if (!tfDecimal.getText().equals("") && Double.parseDouble(tfDecimal.getText()) < Math.pow(2, bits)) {

			for (int i = 0; i < bits; i++) {
				
				binaryArray[i] = 0;

			}

			try {

				s = "";
				tfBinary.setText("");

				decimalNumber = Double.parseDouble(tfDecimal.getText());

				for (int i = bits; i >= 0; i--) {
					if (decimalNumber - Math.pow(2, i) >= 0) {
						decimalNumber = decimalNumber - Math.pow(2, i);
						binaryArray[i] = 1;
					} else {
						binaryArray[i] = 0;
					}

					// System.out.println(binaryArray[i]);
					// System.out.println(i + " " + binaryArray[i]);
				}

				for (int i = bits; i >= 0; i--) {
					s += binaryArray[i] + "";
				}

				// System.out.println(s);

				tfBinary.setText(s);

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(null, "Please insert your decimal number in numerical format",
						"Errorcode: " + "#002", JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (!tfBinary.getText().equals("")) {
			try {

				s = "";
				tfDecimal.setText("");

				binaryNumber = Double.parseDouble(tfBinary.getText());

				double dec = 0;

				for (int i = 0; i < tfBinary.getText().length(); i++) {
					binaryArray[i] = tfBinary.getText().charAt(i);
					// System.out.println(i + " " +
					// tfBinary.getText().charAt(i));
					System.out.println(i + " " + binaryArray[i]);
				}

				for (int i = bits; i >= 0; i--) {

					if (binaryArray[i] == 49) {

						dec += Math.pow(2, i);

					}
				}

				tfDecimal.setText(dec + "");

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(null, "Please insert your binary number in binary format",
						"Errorcode: " + "#003", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Maximum number for " + bits + " bits: " + (Math.pow(2, bits) - 1), "Errorcode: " + "#001",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
