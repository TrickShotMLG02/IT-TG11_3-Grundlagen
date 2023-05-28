package B01_ModuloOperator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WeekdayCalculator extends JFrame {

	private JPanel contentPane;

	public String Weekdays[] = { "Sonntag", "Montag", "Dienstag", "Mittowch", "Donnerstag", "Freitag", "Samstag"};

	static LocalDateTime now = LocalDateTime.now();

	public static DateTimeFormatter strD = DateTimeFormatter.ofPattern("dd");
	public static DateTimeFormatter strM = DateTimeFormatter.ofPattern("MM");
	public static DateTimeFormatter strY = DateTimeFormatter.ofPattern("yyyy");

	public static int intD;
	public static int intM;
	public static int intY;
	private JTextField tfFinalDate;

	Calendar c = Calendar.getInstance();
	int weekday;

	public JSpinner spDaysToCount = new JSpinner();
	LocalDate date;
	Date dates;
	LocalDate newDate;
	public DayOfWeek dayOfWeek;

	JSpinner spCurrentDateDay = new JSpinner();
	JSpinner spCurrentDateMonth = new JSpinner();
	JSpinner spCurrentDateYear = new JSpinner();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeekdayCalculator frame = new WeekdayCalculator();
					frame.setVisible(true);

					intD = Integer.parseInt(strD.format(now));
					intM = Integer.parseInt(strM.format(now));
					intY = Integer.parseInt(strY.format(now));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WeekdayCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920 / 2, 1080 / 2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);

		JLabel lblNewLabel_3 = new JLabel("Date Picker and Calculator");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelTop.add(lblNewLabel_3);

		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new GridLayout(5, 2, 15, 15));

		JLabel lbDaysToCount = new JLabel("Days to count");
		panelMain.add(lbDaysToCount);

		spDaysToCount.setModel(new SpinnerNumberModel(0, null, null, 1));
		panelMain.add(spDaysToCount);

		JLabel lbCurrentDateDay = new JLabel("Current Date - Day");
		panelMain.add(lbCurrentDateDay);
	
		try {
			spCurrentDateDay.setModel(new SpinnerNumberModel(intD, 1, 31, 1));
		} catch (Exception e2) {
		}
		panelMain.add(spCurrentDateDay);

		JLabel lbCurrentDateMonth = new JLabel("Current Date - Month");
		panelMain.add(lbCurrentDateMonth);

		try {
			spCurrentDateMonth.setModel(new SpinnerNumberModel(intM, 1, 12, 1));
		} catch (Exception e1) {
		}
		panelMain.add(spCurrentDateMonth);

		JLabel lbCurrentDateYear = new JLabel("Current Date - Year");
		panelMain.add(lbCurrentDateYear);

		try {
			spCurrentDateYear.setModel(new SpinnerNumberModel(intY, 0, 9999, 1));

		} catch (Exception e1) {
		}
		panelMain.add(spCurrentDateYear);

		JLabel lblNewLabel = new JLabel("Final Date");
		panelMain.add(lblNewLabel);

		tfFinalDate = new JTextField();
		panelMain.add(tfFinalDate);
		tfFinalDate.setColumns(10);

		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				calculate();

			}
		});

		JButton btnLoadDate = new JButton("Load Current Date");
		btnLoadDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spCurrentDateDay.setModel(new SpinnerNumberModel(intD, 1, 31, 1));
				spCurrentDateMonth.setModel(new SpinnerNumberModel(intM, 1, 12, 1));
				spCurrentDateYear.setModel(new SpinnerNumberModel(intY, 0, 9999, 1));

				date = LocalDate.of(intY, intM, intD);
				dayOfWeek = date.getDayOfWeek();
				weekday = c.get(Calendar.DAY_OF_WEEK);
				//System.out.println(weekday - 1);

			}
		});
		panelButtons.add(btnLoadDate);
		panelButtons.add(btnCalculate);

		JButton btnClear = new JButton("Clear");
		panelButtons.add(btnClear);
	}

	protected void calculate() {

		intD = (int)spCurrentDateDay.getValue();
		intM = (int)spCurrentDateMonth.getValue();
		intY = (int)spCurrentDateYear.getValue();
		
		date = LocalDate.of(intY, intM, intD);
		
		date = date.plusDays((int)spDaysToCount.getValue());
		
		dates = java.sql.Date.valueOf(date);
		c.setTime(dates);
		
		
		dayOfWeek = date.getDayOfWeek();
		weekday = c.get(Calendar.DAY_OF_WEEK);
		
		newDate = date;
		
		int count = (int) spDaysToCount.getValue();
		int f = (int) ((count % 7d) + (weekday - 1)) % 7;
		tfFinalDate.setText(Weekdays[weekday - 1] + ", der " + newDate.getDayOfMonth() + "." + newDate.getMonthValue() + "." + newDate.getYear());

	}

}
