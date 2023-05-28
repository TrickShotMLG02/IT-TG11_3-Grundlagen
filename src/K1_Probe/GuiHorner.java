package K1_Probe;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GuiHorner extends JFrame {

	private JPanel contentPane;
	private JTextField tfInput1;
	private JTextField tfInput2;
	private JTextField tfInput3;
	private JTextField tfInput4;
	private JTextField tfAusgabe1;
	private JTextField tfAusgabe2;
	private JTextField tfAusgabe3;
	private JTextField tfAusgabe4;
	private JTextField tfFinalOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiHorner() {
		setTitle("Horner 0.3 - (c) Hammer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));

		JPanel panelTitle = new JPanel();
		panelTop.add(panelTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("HORNER SCHEMA");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelTitle.add(lblTitle);

		JPanel panelInput = new JPanel();
		panelInput.setBorder(new TitledBorder(null, "Eingabe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTop.add(panelInput, BorderLayout.SOUTH);
		panelInput.setLayout(new GridLayout(2, 0, 10, 5));

		JLabel lbInput1 = new JLabel("Nullstellen von:");
		panelInput.add(lbInput1);

		JLabel lbInput2 = new JLabel("Nullstellen bis:");
		panelInput.add(lbInput2);

		JLabel lbInput3 = new JLabel("Schrittweite");
		panelInput.add(lbInput3);

		JLabel lbInput4 = new JLabel("Koeffizienten");
		panelInput.add(lbInput4);

		JButton btnUerbenehmen = new JButton("\u00DCbernehmen");
		btnUerbenehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clickedUebernehmen();

			}
		});
		panelInput.add(btnUerbenehmen);

		tfInput1 = new JTextField();
		panelInput.add(tfInput1);
		tfInput1.setColumns(10);

		tfInput2 = new JTextField();
		panelInput.add(tfInput2);
		tfInput2.setColumns(10);

		tfInput3 = new JTextField();
		panelInput.add(tfInput3);
		tfInput3.setColumns(10);

		tfInput4 = new JTextField();
		panelInput.add(tfInput4);
		tfInput4.setColumns(10);

		JButton btnCancel = new JButton("Abbrechen");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clickedAbbrechen();
				
			}
		});
		panelInput.add(btnCancel);

		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new TitledBorder(null, "Ausgabe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lbAusgabe1 = new JLabel("\u00DCbernommene Koeffizienten");
		panelCenter.add(lbAusgabe1);

		tfAusgabe1 = new JTextField();
		panelCenter.add(tfAusgabe1);
		tfAusgabe1.setColumns(10);

		JLabel lbAusgabe2 = new JLabel("Horner Summanden");
		panelCenter.add(lbAusgabe2);

		tfAusgabe2 = new JTextField();
		panelCenter.add(tfAusgabe2);
		tfAusgabe2.setColumns(10);

		JLabel lbAusgabe3 = new JLabel("Horner Summe");
		panelCenter.add(lbAusgabe3);

		tfAusgabe3 = new JTextField();
		panelCenter.add(tfAusgabe3);
		tfAusgabe3.setColumns(10);

		JLabel lbAusgabe4 = new JLabel("Gleichung");
		panelCenter.add(lbAusgabe4);

		tfAusgabe4 = new JTextField();
		panelCenter.add(tfAusgabe4);
		tfAusgabe4.setColumns(10);

		JPanel panelBottom = new JPanel();
		panelBottom.setBorder(null);
		contentPane.add(panelBottom, BorderLayout.SOUTH);
		GridBagLayout gbl_panelBottom = new GridBagLayout();
		gbl_panelBottom.columnWidths = new int[] {75, 75, 25, 100, 0, 0, 208, 50};
		gbl_panelBottom.rowHeights = new int[] {5};
		gbl_panelBottom.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelBottom.rowWeights = new double[]{0.0, 0.0};
		panelBottom.setLayout(gbl_panelBottom);
				
				JButton btnNew = new JButton("Neu");
				btnNew.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clickedNeu();
					}
				});
				
				GridBagConstraints gbc_btnNew = new GridBagConstraints();
				gbc_btnNew.insets = new Insets(0, 0, 5, 5);
				gbc_btnNew.gridx = 1;
				gbc_btnNew.gridy = 1;
				panelBottom.add(btnNew, gbc_btnNew);
				
				JButton btnClose = new JButton("Beenden");
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clickedBeenden();
					}
				});
				
				GridBagConstraints gbc_btnClose = new GridBagConstraints();
				gbc_btnClose.insets = new Insets(0, 0, 5, 5);
				gbc_btnClose.gridx = 3;
				gbc_btnClose.gridy = 1;
				panelBottom.add(btnClose, gbc_btnClose);
				
				tfFinalOutput = new JTextField();
				tfFinalOutput.setHorizontalAlignment(SwingConstants.CENTER);
				tfFinalOutput.setText("gen\u00E4herte Nullstelle: -5.0");
				tfFinalOutput.setEditable(false);
				GridBagConstraints gbc_tfFinalOutput = new GridBagConstraints();
				gbc_tfFinalOutput.insets = new Insets(0, 0, 5, 0);
				gbc_tfFinalOutput.gridwidth = 2;
				gbc_tfFinalOutput.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfFinalOutput.gridx = 5;
				gbc_tfFinalOutput.gridy = 1;
				panelBottom.add(tfFinalOutput, gbc_tfFinalOutput);
				tfFinalOutput.setColumns(10);
	}

	protected void clickedBeenden() {
		System.out.println("Beenden geklickt");
		
	}

	protected void clickedNeu() {
		System.out.println("Neu geklickt");
		
	}

	protected void clickedAbbrechen() {
		System.out.println("Abbrechen geklickt");
	}

	protected void clickedUebernehmen() {
		System.out.println("Übernehmen geklickt");
	}

}
