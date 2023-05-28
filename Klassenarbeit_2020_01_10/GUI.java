package Klassenarbeit_2020_01_10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textfieldNote1;
	private JTextField textfieldNote3;
	private JTextField textfieldNote2;
	private JTextField textfieldEndnote;

	JSpinner spinner1 = new JSpinner();
	JSpinner spinner2 = new JSpinner();
	JSpinner spinner3 = new JSpinner();

	public double dMark1;
	public double dMark2;
	public double dMark3;

	public int i1;
	public int i2;
	public int i3;

	public double dMark;
	private JButton btnDelete;

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
		setTitle("Notentester");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

		JPanel panelInput = new JPanel();
		panelInput.setBorder(new TitledBorder(null, "Eingabe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMain.add(panelInput);
		panelInput.setLayout(new GridLayout(3, 4, 0, 0));

		JLabel lblNewLabel = new JLabel("Teilnote 1");
		panelInput.add(lblNewLabel);

		textfieldNote1 = new JTextField();
		panelInput.add(textfieldNote1);
		textfieldNote1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Gewichtung 1");
		panelInput.add(lblNewLabel_1);

		spinner1.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinner1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Gewichtung 1 = " + spinner1.getValue());

			}
		});
		panelInput.add(spinner1);

		JLabel lblNewLabel_2 = new JLabel("Teilnote 2");
		panelInput.add(lblNewLabel_2);

		textfieldNote2 = new JTextField();
		panelInput.add(textfieldNote2);
		textfieldNote2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Gewichtung 2");
		panelInput.add(lblNewLabel_3);

		spinner2.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinner2.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Gewichtung 2 = " + spinner2.getValue());

			}
		});
		panelInput.add(spinner2);

		JLabel lblNewLabel_4 = new JLabel("Teilnote 3");
		panelInput.add(lblNewLabel_4);

		textfieldNote3 = new JTextField();
		panelInput.add(textfieldNote3);
		textfieldNote3.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Gewichtung 3");
		panelInput.add(lblNewLabel_5);

		spinner3.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinner3.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Gewichtung 3 = " + spinner3.getValue());

			}
		});
		panelInput.add(spinner3);

		JPanel panelOutput = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelOutput.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelOutput.setBorder(new TitledBorder(null, "Ausgabe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMain.add(panelOutput);

		JLabel Endnote = new JLabel("Endnote");
		panelOutput.add(Endnote);

		textfieldEndnote = new JTextField();
		textfieldEndnote.setEditable(false);
		panelOutput.add(textfieldEndnote);
		textfieldEndnote.setColumns(10);

		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);

		JButton btnBerechne = new JButton("Berechnen");
		btnBerechne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clickedBerechne();
			}
		});
		panelButtons.add(btnBerechne);

		btnDelete = new JButton("L\u00F6schen");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clickedDelete();

			}
		});
		panelButtons.add(btnDelete);
	}

	protected void clickedDelete() {

		try {
			textfieldEndnote.setText("");
			textfieldNote1.setText("");
			textfieldNote2.setText("");
			textfieldNote3.setText("");

			spinner1.setValue(1);
			spinner2.setValue(1);
			spinner3.setValue(1);

			dMark = 0;
			dMark1 = 0;
			dMark2 = 0;
			dMark3 = 0;
			i1 = 0;
			i2 = 0;
			i3 = 0;

			System.out.println("löschen");
		} catch (Exception e) {
			System.out.println("löschen fehlgeschlagen");

		}

	}

	protected void clickedBerechne() {

		try {
			dMark1 = Double.parseDouble(textfieldNote1.getText());
			dMark2 = Double.parseDouble(textfieldNote2.getText());
			dMark3 = Double.parseDouble(textfieldNote3.getText());

			i1 = (int) spinner1.getValue();
			i2 = (int) spinner2.getValue();
			i3 = (int) spinner3.getValue();

			dMark = ((dMark1 * i1) + (dMark2 * i2) + (dMark3 * i3)) / (i1 + i2 + i3);

			String strMark = dMark + "";

			dMark = (int) (dMark * 100);
			dMark = dMark / 100;

			textfieldEndnote.setText(dMark + "");
			System.out.println("berechnen");

		} catch (NumberFormatException e) {
			System.out.println("berechnen fehlgeschlagen");
		}

	}

}
