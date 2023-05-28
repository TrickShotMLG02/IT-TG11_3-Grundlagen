package A15_Lotto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lotto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lotto frame = new Lotto();
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
	public Lotto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Numbers = new JPanel();
		panel.add(panel_Numbers, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		panel_Numbers.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("X");
		panel_Numbers.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		panel_Numbers.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("X");
		panel_Numbers.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("X");
		panel_Numbers.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("X");
		panel_Numbers.add(lblNewLabel_6);
		
		JLabel lblSz = new JLabel("   SZ: ");
		panel_Numbers.add(lblSz);
		
		JLabel lblNewLabel_7 = new JLabel("X");
		panel_Numbers.add(lblNewLabel_7);
		
		JPanel panel_Btns = new JPanel();
		panel.add(panel_Btns, BorderLayout.SOUTH);
		
		JButton Randomize = new JButton("Randomize");
		Randomize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TrickShotAPI.util.arrays.print.printArray(TrickShotAPI.util.arrays.convert.IntToString(LottoNumbers()));
				lblNewLabel_1.setText(LottoNumbers()[1]+"");
				lblNewLabel_2.setText(LottoNumbers()[2]+"");
				lblNewLabel_3.setText(LottoNumbers()[3]+"");
				lblNewLabel_4.setText(LottoNumbers()[4]+"");
				lblNewLabel_5.setText(LottoNumbers()[5]+"");
				lblNewLabel_6.setText(LottoNumbers()[6]+"");
				//lblNewLabel_7.setText(LottoNumbers()[7]+"");
				
			}
		});
		panel_Btns.add(Randomize);
	}

	public static int[] LottoNumbers()
	{
		int[] numbers = createNumbers(49);
		numbers = getNumbers(7, mixNumbers(numbers));				
		
		return numbers;
	}
	
	public static int[] createNumbers(int count) {
		int[] numbers = new int[count];
		for (int i = 1; i < count; i++) {
			numbers[i] = i+1;
		}
		return numbers;
	}

	public static int[] mixNumbers(int[] numbersToMix) {
		int[] mixedNumbers = new int[numbersToMix.length];
		for (int i = 0; i < mixedNumbers.length; i++) {
			mixedNumbers[i] = -1;
		}

		int rnd = 0;
		
		for (int i = 0; i < mixedNumbers.length; i++) {

			while (mixedNumbers[rnd] != -1) {
				rnd = (int) (Math.random() * (numbersToMix.length - 1)+1);
			}
			mixedNumbers[rnd] = i + 1;			
		}
		
		return mixedNumbers;
	}

	public static int[] getNumbers(int count, int[] numbers)
	{
		int[] LottoNumbers = new int[count];
		
		for (int i = 0; i < LottoNumbers.length; i++) {
			LottoNumbers[i] = numbers[i];
		}		
		return LottoNumbers;
	}
}
