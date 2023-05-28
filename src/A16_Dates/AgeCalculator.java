package A16_Dates;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.time.Period;
import java.awt.event.ActionEvent;

public class AgeCalculator extends JFrame {

	private JPanel contentPane;
	private static JTextField tfFirstDate;
	private static JTextField tfSecondDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgeCalculator frame = new AgeCalculator();
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
	public AgeCalculator() {
		setTitle("Age Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new GridLayout(4, 4, 0, 0));

		JLabel lblNewLabel = new JLabel("First Date");
		panelMain.add(lblNewLabel);

		tfFirstDate = new JTextField();
		panelMain.add(tfFirstDate);
		tfFirstDate.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Second Date");
		panelMain.add(lblNewLabel_1);

		tfSecondDate = new JTextField();
		panelMain.add(tfSecondDate);
		tfSecondDate.setColumns(10);

		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);

		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				getDate();

			}
		});
		panelButtons.add(btnCalc);
	}

	protected void getDate() {
		try {
			
			Period p;
			if (tfSecondDate.getText().equals("")) {
				p = TrickShotAPI.util.Date().getDifference(TrickShotAPI.util.Date().parseStringToDate(tfFirstDate.getText()), null);
			} else {
				p = TrickShotAPI.util.Date().getDifference(TrickShotAPI.util.Date().parseStringToDate(tfFirstDate.getText()),TrickShotAPI.util.Date().parseStringToDate(tfSecondDate.getText()));
			}
			
			TrickShotAPI.ui.Notifications().showInfo(p.getDays() + "d " + p.getMonths() + "m " + p.getYears() + "y","Difference between the two dates is: ");
		
		} catch (Exception e) {
			TrickShotAPI.ui.Notifications().showError("Invalid date\nDates must be in the format: yyyy-MM-dd", "Error");
		}
	}

}
