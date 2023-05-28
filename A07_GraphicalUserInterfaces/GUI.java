package A07_GraphicalUserInterfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.*;

// ERROR CODES
//
// Errorcode #001:	Please insert your Age in numerical format
// Errorcode #002:	Please insert your Weight in numerical format
// Errorcode #003:	Please insert your Height in numerical format

public class GUI extends JFrame {

	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	public static int screenHeight;
	public static int screenWidth;
	public double bmi;
	public int age = 0;
	public double height = 0;
	public double weight = 0;
	public String DigitsToRound;

	JComboBox cbRound;

	JPanel contentPane;
	JPanel panelInput;
	JPanel panelOutput;
	JPanel panelButtons;

	JLabel lbAge;
	JLabel lbWeight;
	JLabel lbHeight;
	JLabel lbBmi;
	JLabel lbRound;

	JTextField tfAge;
	JTextField tfWeight;
	JTextField tfHeight;

	JButton btnCalculate;
	JButton btnCancel;

	public GUI() {

		this.setTitle("GUI-Example");
		this.setResizable(false);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocation((int) ((dimension.getWidth() - this.getWidth()) / 2),
				(int) (((dimension.getHeight() - (this.getHeight())) / 2)));

		System.out.println("Moved window to " + this.getLocation().x + ", " + this.getLocation().y);

		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				clickedButtonCalculate();
			}
		});

		btnCancel = new JButton("Clear");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				clickedButtonCancel();
			}
		});

		lbAge = new JLabel("Age");
		lbWeight = new JLabel("Weight in kg");
		lbHeight = new JLabel("Height in cm");
		lbRound = new JLabel("Round to digit");
		lbBmi = new JLabel("");

		tfAge = new JTextField();
		tfWeight = new JTextField();
		tfHeight = new JTextField();

		panelButtons = new JPanel();
		panelButtons.setLayout(new FlowLayout());
		panelButtons.add(btnCalculate);
		panelButtons.add(btnCancel);

		panelInput = new JPanel();
		panelInput.setLayout(new GridLayout(5, 2));
		panelInput.add(lbAge);
		panelInput.add(tfAge);
		panelInput.add(lbWeight);
		panelInput.add(tfWeight);
		panelInput.add(lbHeight);
		panelInput.add(tfHeight);

		panelOutput = new JPanel();
		panelOutput.add(lbBmi);

		String[] Runden = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		cbRound = new JComboBox(Runden);
		cbRound.setSelectedIndex(3);
		cbRound.setBounds(192, 100, 100, 20);

		panelInput.add(lbRound);
		panelInput.add(cbRound);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(panelButtons, BorderLayout.SOUTH);
		contentPane.add(panelInput, BorderLayout.CENTER);
		contentPane.add(panelOutput, BorderLayout.EAST);

		this.setContentPane(contentPane);
		this.setVisible(true);

	}

	protected void clickedButtonCalculate() {

		DigitsToRound = (String) cbRound.getSelectedItem();

		try {

			age = Integer.parseInt(tfAge.getText());

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Please insert your Age in numerical format", "Errorcode: " + "#001",
					JOptionPane.INFORMATION_MESSAGE);
		}

		try {

			weight = Double.parseDouble(tfWeight.getText());

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Please insert your Weight in numerical format", "Errorcode: " + "#002",
					JOptionPane.INFORMATION_MESSAGE);
		}

		try {

			height = Double.parseDouble(tfHeight.getText());

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Please insert your Height in numerical format", "Errorcode: " + "#003",
					JOptionPane.INFORMATION_MESSAGE);
		}

		try {

			bmi = weight / Math.pow(height / 100, 2);

			NumberFormat formatter = NumberFormat.getInstance();
			formatter.setMaximumFractionDigits(Integer.parseInt(DigitsToRound));
			lbBmi.setText(formatter.format(bmi) + " " + "BMI");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Please insert only numbers", "Errorcode: " + "#001",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	protected void clickedButtonCancel() {

		tfAge.setText("");
		tfHeight.setText("");
		tfWeight.setText("");
		lbBmi.setText("");
		cbRound.setSelectedIndex(3);
	}
}