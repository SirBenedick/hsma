package pr1.uebung04;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame {

	private static final String EMPTY  = "";
	private static final String CROSS  = "X";
	private static final String CIRCLE = "O";
	private String currentSymbol = CROSS;
	private JButton[][] fields;

	TicTacToe() {
		super("Tic Tac Toe");
		setLayout(new GridLayout(3, 3));
		fields = new JButton[3][3];
		for (int row = 0; row < fields.length; row++) {
			for (int col = 0; col < fields[row].length; col++) {
				fields[row][col] = new JButton(EMPTY);
				fields[row][col].setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 36));
				fields[row][col].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						((JButton) e.getSource()).setText(currentSymbol);
						if (success(fields[0][0].getText(), fields[0][1].getText(), fields[0][2].getText(), fields[1][0].getText(), fields[1][1].getText(), fields[1][2].getText(), fields[2][0].getText(), fields[2][1].getText(), fields[2][2].getText())) {
							JOptionPane.showMessageDialog(TicTacToe.this, "Spieler '" + currentSymbol + "' hat gewonnen", "Gewonnen!", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else if (draw(fields[0][0].getText(), fields[0][1].getText(), fields[0][2].getText(), fields[1][0].getText(), fields[1][1].getText(), fields[1][2].getText(), fields[2][0].getText(), fields[2][1].getText(), fields[2][2].getText())) {
							JOptionPane.showMessageDialog(TicTacToe.this, "Das Spiel endete leider unentschieden", "Unentschieden!", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else {
							toggleSymbol();
						}
					}
				});
				add(fields[row][col]);
			}
		}
		
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void toggleSymbol () {
		if (currentSymbol.equals(CROSS))
			currentSymbol = CIRCLE;
		else
			currentSymbol = CROSS;
	}
	
	static boolean success(String topLeft, String topCenter, String topRight, String middleLeft, String middleCenter, String middleRight, String bottomLeft, String bottomCenter, String bottomRight) {
		if (	(topLeft.equals("X") && topCenter.equals("X") && topRight.equals("X"))
				||	(middleLeft.equals("X") && middleCenter.equals("X") && middleRight.equals("X"))	
				||	(bottomLeft.equals("X") && bottomCenter.equals("X") && bottomRight.equals("X"))
				||	(topLeft.equals("X") && middleLeft.equals("X") && bottomLeft.equals("X"))
				||	(topCenter.equals("X") && middleCenter.equals("X") && bottomCenter.equals("X"))
				||	(topRight.equals("X") && middleRight.equals("X") && bottomRight.equals("X"))
				||	(topLeft.equals("X") && middleCenter.equals("X") && bottomRight.equals("X"))
				||	(topRight.equals("X") && middleCenter.equals("X") && bottomLeft.equals("X"))
				){
				return true;
			}
		if (	(topLeft.equals("O") && topCenter.equals("O") && topRight.equals("O"))
				||	(middleLeft.equals("O") && middleCenter.equals("O") && middleRight.equals("O"))	
				||	(bottomLeft.equals("O") && bottomCenter.equals("O") && bottomRight.equals("O"))
				||	(topLeft.equals("O") && middleLeft.equals("O") && bottomLeft.equals("O"))
				||	(topCenter.equals("O") && middleCenter.equals("O") && bottomCenter.equals("O"))
				||	(topRight.equals("O") && middleRight.equals("O") && bottomRight.equals("O"))
				||	(topLeft.equals("O") && middleCenter.equals("O") && bottomRight.equals("O"))
				||	(topRight.equals("O") && middleCenter.equals("O") && bottomLeft.equals("O"))){
				return true;
			}
		
		return false;
	}

	static boolean draw(String topLeft, String topCenter, String topRight, String middleLeft, String middleCenter, String middleRight, String bottomLeft, String bottomCenter, String bottomRight) {
		if(topLeft!="" && topCenter!="" && topRight!=""
			&& middleLeft!="" && middleCenter!="" && middleRight!=""
			&& bottomLeft!="" && bottomCenter!="" && bottomRight!=""
			&&  !(success(topLeft,topCenter, topRight, middleLeft, middleCenter, middleRight, bottomLeft, bottomCenter, bottomRight)) ){
			return true;
		}
		
		
		return false;
	}

	public static void main(String[] args) {
		new TicTacToe().setVisible(true);
	}

}