package Algorithmen_02;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;

public class TSP_GUI extends JFrame {

	private JPanel contentPane;
	public DrawPanel drawPanel;
	
	public final static int OVAL_SIZE = 25;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TSP_GUI frame = new TSP_GUI();
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
	

	
	public TSP_GUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		
		DrawPanel drawPanel = new DrawPanel();	
		setContentPane(drawPanel);
		drawPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		drawPanel.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnCalc = new JButton("Calculate");
		panel_1.add(btnCalc);
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				drawLines();
				drawPanel.calculateTSP();
				
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
		panel_1.add(btnClear);
		drawPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Point point = e.getPoint();
				draw(point.x, point.y);
				
			}
		});				
	}
	
	public void drawLines()
	{
		drawPanel.drawAllLines();
		revalidate();
		this.repaint();
	}	
	public void draw(int x, int y)
	{
		//System.out.println("x: " + x + " y: " + y);
		drawPanel.addCoords(x - (OVAL_SIZE/2), y - (OVAL_SIZE/2), OVAL_SIZE, OVAL_SIZE, "Oval");
		//drawPanel.drawLines();
		revalidate();
		this.repaint();
	}
	
	public void Reset()
	{
		drawPanel.Reset();
		revalidate();
		this.repaint();
	}

}
