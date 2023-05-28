package B01_ModuloOperator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class VendingMachine extends JFrame {

	public String priceAsString;
	public double priceAsDouble;
		
	public JLabel lblTwoEur;
	public JLabel lblOneEur;
	public JLabel lblFiftyCent;
	public JLabel lblTwentyCent;
	public JLabel lblTenCent;
	public JLabel lblFiveCent;
	public JLabel lblTwoCent;
	public JLabel lblOneCent;
	
	public ButtonGroup selectGroup;
	
	private JPanel contentPane;
	private JTextField tfChange;
	private JTextField tfInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendingMachine frame = new VendingMachine();
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
	public VendingMachine() {
		setResizable(false);
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920/2, 1080/2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		selectGroup = new ButtonGroup();
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				calculateChange();
				
			}
		});
		panelButtons.add(btnPurchase);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				clear();
				
			}
		});
		panelButtons.add(btnClear);
		
		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.NORTH);
		panelMain.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panelTitle = new JPanel();
		panelMain.add(panelTitle);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Vending Machine");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblTitle, BorderLayout.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 60));
		
		JPanel panelInput = new JPanel();
		panelMain.add(panelInput);
		panelInput.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblInput = new JLabel("Input");
		panelInput.add(lblInput);
		
		tfInput = new JTextField();
		tfInput.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(tfInput);
		tfInput.setColumns(10);
		
		JLabel lblChange = new JLabel("Change");
		panelInput.add(lblChange);
		
		tfChange = new JTextField();
		tfChange.setHorizontalAlignment(SwingConstants.CENTER);
		tfChange.setEditable(false);
		panelInput.add(tfChange);
		tfChange.setColumns(10);
		
		JPanel panelSelect = new JPanel();
		panelMain.add(panelSelect);
		panelSelect.setLayout(new GridLayout(5, 3, 0, 0));
		
		JRadioButton rdbtnItem1 = new JRadioButton("Sprite 1.49€");
		rdbtnItem1.setActionCommand("1.49");
		panelSelect.add(rdbtnItem1);
		selectGroup.add(rdbtnItem1);
		
		JRadioButton rdbtnItem2 = new JRadioButton("Pepsi 1.39€");
		rdbtnItem2.setActionCommand("1.39");
		panelSelect.add(rdbtnItem2);
		selectGroup.add(rdbtnItem2);
		
		JRadioButton rdbtnItem3 = new JRadioButton("CocaCola 1.79€");
		rdbtnItem3.setActionCommand("1.79");
		panelSelect.add(rdbtnItem3);
		selectGroup.add(rdbtnItem3);
		
		JRadioButton rdbtnItem4 = new JRadioButton("Vittel (Kohlensäure) 1.95€");
		rdbtnItem4.setActionCommand("1.95");
		panelSelect.add(rdbtnItem4);
		selectGroup.add(rdbtnItem4);
		
		JRadioButton rdbtnItem5 = new JRadioButton("Vittel (Still) 1.19€");
		rdbtnItem5.setActionCommand("1.19");
		panelSelect.add(rdbtnItem5);
		selectGroup.add(rdbtnItem5);
		
		JRadioButton rdbtnItem6 = new JRadioButton("n/a");
		rdbtnItem6.setActionCommand("n/a");
		rdbtnItem6.setEnabled(false);
		panelSelect.add(rdbtnItem6);
		selectGroup.add(rdbtnItem6);
		
		JRadioButton rdbtnItem7 = new JRadioButton("n/a");
		rdbtnItem7.setActionCommand("n/a");
		rdbtnItem7.setEnabled(false);
		panelSelect.add(rdbtnItem7);
		selectGroup.add(rdbtnItem7);
		
		JRadioButton rdbtnItem8 = new JRadioButton("n/a");
		rdbtnItem8.setActionCommand("n/a");
		rdbtnItem8.setEnabled(false);
		panelSelect.add(rdbtnItem8);
		selectGroup.add(rdbtnItem8);
		
		JPanel panelCoins = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCoins.getLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(50);
		panelMain.add(panelCoins);
		
		lblTwoEur = new JLabel("2€");
		panelCoins.add(lblTwoEur);
		
		lblOneEur = new JLabel("1€");
		panelCoins.add(lblOneEur);
		
		lblFiftyCent = new JLabel("50Cent");
		panelCoins.add(lblFiftyCent);
		
		lblTwentyCent = new JLabel("20Cent");
		panelCoins.add(lblTwentyCent);
		
		lblTenCent = new JLabel("10Cent");
		panelCoins.add(lblTenCent);
		
		lblFiveCent = new JLabel("5Cent");
		panelCoins.add(lblFiveCent);
		
		lblTwoCent = new JLabel("2Cent");
		panelCoins.add(lblTwoCent);
		
		lblOneCent = new JLabel("1Cent");
		panelCoins.add(lblOneCent);
	}

	void clear()
	{
		tfChange.setText("");
		tfInput.setText("");
		selectGroup.clearSelection();
	}
	
	
	void calculateChange()
	{		
				
		try {
			priceAsString =  selectGroup.getSelection().getActionCommand();
			priceAsDouble = Double.parseDouble(priceAsString);
			int given = (int)Double.parseDouble(tfInput.getText());	
			int change = (int)(given * 100 - (priceAsDouble * 100));
			
			int TwoEurCount = change / 200;
			change = (change % 200);
			
			int OneEurCount = change / 100;
			change = (change % 100);

			int FiftyCentCount = change / 50;
			change = (change % 50);

			int TwentyCentCount = change / 20;
			change = (change % 20);

			int TenCentCount = change / 10;
			change = (change % 10);

			int FiveCentCount = change / 5;
			change = (change % 5);

			int TwoCentCount = change / 2;
			change = (change % 2);

			int OneCentCount = change / 1;
			change = (change % 1);
			
			tfChange.setText((given - priceAsDouble) + "€");
			
			lblTwoEur.setText(TwoEurCount + " x " + "2€");
			lblOneEur.setText(OneEurCount + " x " + "1€");
			lblFiftyCent.setText(FiftyCentCount + " x " + "50Cent");
			lblTwentyCent.setText(TwentyCentCount + " x " + "20Cent");
			lblTenCent.setText(TenCentCount + " x " + "10Cent");
			lblFiveCent.setText(FiveCentCount + " x " + "5Cent");
			lblTwoCent.setText(TwoCentCount + " x " + "2Cent");
			lblOneCent.setText(OneCentCount + " x " + "1Cent");
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Unknown Error ", "Errorcode: " + "#001",
					JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
	
}
