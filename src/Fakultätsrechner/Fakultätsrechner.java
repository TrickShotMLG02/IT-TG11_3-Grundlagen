package Fakultätsrechner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fakultätsrechner extends JFrame {

	private JPanel contentPane;
	private JPanel panelMain;
	private JTextField textField;
	private JRadioButton rdbtn;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fakultätsrechner frame = new Fakultätsrechner();
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
	public Fakultätsrechner() {
		setTitle("Fakult\u00E4tsrechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(0, 0));

		JPanel panelIn = new JPanel();
		panelMain.add(panelIn, BorderLayout.NORTH);
		panelIn.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panelIn.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblZuBerechnendeZahl = new JLabel("Zu berechnende Zahl");
		panel.add(lblZuBerechnendeZahl);

		textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField);

		JPanel panel_1 = new JPanel();
		panelIn.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Doppelte Kombinationen z\u00E4hlen");
		panel_1.add(lblNewLabel_1);

		rdbtn = new JRadioButton("Aktiviert");
		rdbtn.setSelected(true);
		panel_1.add(rdbtn);

		JPanel panelOut = new JPanel();
		panelMain.add(panelOut, BorderLayout.WEST);
		GridBagLayout gbl_panelOut = new GridBagLayout();
		gbl_panelOut.columnWidths = new int[] { 30, 30, 0, 0 };
		gbl_panelOut.rowHeights = new int[] { 30, 30, 0, 0 };
		gbl_panelOut.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelOut.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelOut.setLayout(gbl_panelOut);

		lblResult = new JLabel("Fakult\u00E4t:");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.gridwidth = 4;
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 1;
		panelOut.add(lblResult, gbc_lblResult);

		JPanel panelBtns = new JPanel();
		contentPane.add(panelBtns, BorderLayout.SOUTH);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clear();
			}
		});
		panelBtns.add(btnClear);

		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calculate();
			}
		});
		panelBtns.add(btnCalc);
	}

	
	
	public int Fakultaet(int Eingabe, boolean doubleValues)
	{
		int fakultaet = 1;
		try {
			int input = Eingabe;
			int n  = input;			
			if (n < 13) {
				while (n > 1) {
					fakultaet = fakultaet * n;
					n = n - 1;
				}

				boolean selected = rdbtn.isSelected();

				if (!selected) {

					fakultaet = fakultaet / 2;
				}
				
				System.out.println("Fakultaet ist " + fakultaet);
				String Ergebnis = "";				
			}
			else 
			{
				TrickShotAPI.ui.Notifications().showWarning("Eingabe ist zu gross. Es kommt bei der Berechnung zu Ungenauigkeiten", "Warnung!");
			}
		} catch (NumberFormatException e) {
			TrickShotAPI.ui.Notifications().showError(Eingabe + " ist keine Zahl", "Fehler beim Parsen");
		}
		return fakultaet;	
	}
	
	
	public void Clear()
	{
		textField.setText("");
		rdbtn.setSelected(true);
		lblResult.setText("Fakultät: ");
	}
	
	public void Calculate()
	{
		int result = Fakultaet(Integer.parseInt(textField.getText()), rdbtn.isSelected());
		lblResult.setText("Fakultät: " + ":   " + result);
	}
}
