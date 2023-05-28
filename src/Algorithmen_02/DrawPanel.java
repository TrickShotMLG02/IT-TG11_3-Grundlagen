package Algorithmen_02;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	public static List<Coordinates> points = new ArrayList<Coordinates>();
	public static List<Coordinates> lines = new ArrayList<Coordinates>();
	public static Coordinates coordinates;
	public static Coordinates lineCoordinates;

	public static Color solutionLineColor = Color.blue;

	public static void addCoords(int x1, int y1, int x2, int y2, String type) {
		coordinates = new Coordinates();
		coordinates.x1 = x1;
		coordinates.x2 = x2;
		coordinates.y1 = y1;
		coordinates.y2 = y2;
		coordinates.type = type;

		Collections.addAll(points, coordinates);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		if (points.size() == 0) {
			g2d.create();
		}

		for (int i = 0; i < points.size(); i++) {
			{
				g2d.setColor(points.get(i).color);
				g2d.setStroke(new BasicStroke(points.get(i).strokeWidth));
				g2d.drawOval(points.get(i).x1, points.get(i).y1, points.get(i).x2, points.get(i).y2);
			}
		}
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).type.equalsIgnoreCase("Line")) {
				g2d.setColor(lines.get(i).color);
				g2d.setStroke(new BasicStroke(lines.get(i).strokeWidth));
				g2d.drawLine(lines.get(i).x1, lines.get(i).y1, lines.get(i).x2, lines.get(i).y2);
				
			}
		}
	}

	public static void drawAllLines() {
		for (int i = 0; i < points.size(); i++) {
			for (int j = 0; j < points.size(); j++) {

				int center1x = points.get(j).x1 + (TSP_GUI.OVAL_SIZE / 2);
				int center1y = points.get(j).y1 + (TSP_GUI.OVAL_SIZE / 2);
				int center2x = points.get(i).x1 + (TSP_GUI.OVAL_SIZE / 2);
				int center2y = points.get(i).y1 + (TSP_GUI.OVAL_SIZE / 2);

				lineCoordinates = new Coordinates();
				lineCoordinates.x1 = center1x;
				lineCoordinates.x2 = center2x;
				lineCoordinates.y1 = center1y;
				lineCoordinates.y2 = center2y;
				lineCoordinates.color = Color.black;
				lineCoordinates.strokeWidth = 1;
				lineCoordinates.type = "Line";

				Collections.addAll(lines, lineCoordinates);
			}
		}
	}

	public void calculateTSP() {
		// CREATE MATRIX
		int[][] matrix = TSP.createMatrix(points.size());

		for (int i = 0; i < points.size(); i++) {
			for (int j = 0; j < points.size(); j++) {

				int ac = Math.abs(points.get(i).y1 - points.get(j).y1);
				int cb = Math.abs(points.get(i).x1 - points.get(j).x1);

				matrix[i][j] = (int) Math.hypot(ac, cb);
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][j] = TSP.DASH;
				}
			}
		}

		// START SOLVING
		TSP.TSP(matrix);

		drawSolutionLine();
	}

	public static void drawSolutionLine() {
		String connectionString = TSP.uncodedConnectionString;
		int[] pointIDs = new int[points.size() + 1];
		String[] connections = new String[points.size()];
		String resultString;

		System.out.println(connectionString);

		int counter = 0;
		for (int i = 0; i < points.size() * 2; i += 2) {
			connections[counter] = connectionString.charAt(i) + "" + connectionString.charAt(i + 1);
			counter += 1;
		}

		pointIDs[0] = Integer.parseInt(connections[0].charAt(0) + "");
		pointIDs[1] = Integer.parseInt(connections[0].charAt(1) + "");

		for (int i = 2; i < pointIDs.length; i++) {
			for (int j = 0; j < connections.length; j++) {
				if (pointIDs[i - 1] == Integer.parseInt(connections[j].charAt(0) + "")) {
					pointIDs[i] = Integer.parseInt(connections[j].charAt(1) + "");
					break;
				}
			}
		}

		for (int i = 0; i < pointIDs.length; i++) {
			System.out.println(pointIDs[i]);
		}
		
		// get points in solution order
		for (int i = 0; i < points.size(); i++) {

			int center1x = points.get(pointIDs[i]-1).x1 + (TSP_GUI.OVAL_SIZE / 2);
			int center1y = points.get(pointIDs[i]-1).y1 + (TSP_GUI.OVAL_SIZE / 2);
			int center2x = points.get(pointIDs[i+1]-1).x1 + (TSP_GUI.OVAL_SIZE / 2);
			int center2y = points.get(pointIDs[i+1]-1).y1 + (TSP_GUI.OVAL_SIZE / 2);

			lineCoordinates = new Coordinates();
			lineCoordinates.x1 = center1x;
			lineCoordinates.x2 = center2x;
			lineCoordinates.y1 = center1y;
			lineCoordinates.y2 = center2y;
			lineCoordinates.color = solutionLineColor;
			lineCoordinates.strokeWidth = 3;
			lineCoordinates.type = "Line";
			
			Collections.addAll(lines, lineCoordinates);
		}

	}

	public static void Reset() {
		// RESET VARIABLES
		points = new ArrayList<Coordinates>();
		lines = new ArrayList<Coordinates>();
		TSP.connectionString = "";
		TSP.uncodedConnectionString = "";
	}
}
