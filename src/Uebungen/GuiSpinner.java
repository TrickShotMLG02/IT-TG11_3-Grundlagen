package Uebungen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiSpinner extends JFrame {

	private JPanel contentPane;
	private JTextField tfAusgabe;
	public JSpinner spinner = new JSpinner();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiSpinner frame = new GuiSpinner();
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
	public GuiSpinner() {
		setTitle("\u00DCbung - Spinner");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfAusgabe = new JTextField();
		tfAusgabe.setEditable(false);
		tfAusgabe.setBounds(161, 40, 96, 20);
		contentPane.add(tfAusgabe);
		tfAusgabe.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ausgabe");
		lblNewLabel.setBounds(21, 43, 103, 14);
		contentPane.add(lblNewLabel);

		spinner.setBounds(103, 88, 154, 40);
		spinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Spinner geändert auf " + spinner.getValue());
				
			}
		});
		contentPane.add(spinner);

		JButton btnBerechne = new JButton("Berechne");
		btnBerechne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				calculate();

			}
		});
		btnBerechne.setBounds(89, 189, 89, 23);
		contentPane.add(btnBerechne);

		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cancel();

			}
		});
		btnAbbrechen.setBounds(188, 189, 89, 23);
		contentPane.add(btnAbbrechen);
		
		System.out.println("Spinner geändert auf " + spinner.getValue());
		tfAusgabe.setText("" + spinner.getValue());
	}

	protected void cancel() {

		System.out.println("Abbrechen geklickt");
		spinner.setValue(0);
		tfAusgabe.setText("");
		
	}

	protected void calculate() {

		System.out.println("Berechnen geklickt");
		tfAusgabe.setText("" + spinner.getValue());
	}
}
