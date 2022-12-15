import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class XOXGame implements ActionListener{
	
	private Random random;
	private JFrame frame;
	
	
	
	JButton[] board= new JButton[9];
	private boolean pl1;
	
	XOXGame() {
		random = new Random();
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLayout(new GridLayout(3,3));
		
		for(int i=0; i < board.length ;i++) {
				board[i] = new JButton();
				frame.add(board[i]);
				board[i].setFont(new Font("Serif", Font.BOLD,100));
				
				board[i].setFocusable(false);
				board[i].addActionListener(this);
			
		}
		firstPlayer();
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i = 0; i<board.length;i++) {
			
				if(e.getSource()==board[i]) {
				if(pl1) {
					if(board[i].getText()=="") {
						board[i].setForeground(Color.RED);
						board[i].setText("X");
						pl1 = false;
						checkWinner();
					}
				}
				else {
					if(board[i].getText()=="") {
						board[i].setForeground(Color.GREEN);
						board[i].setText("O");
						pl1 = true;
						checkWinner();
						
					}
				}
				
			}
			
		}
		
	}
	
	
	public void firstPlayer() {
		
		if(random.nextInt(2)==0) {
			pl1 = true;
			System.out.println("İlk X");
		}
		else {
			pl1 = false;
			System.out.println("İlk O");
		}
	}
	
	public void checkWinner() {
		if(board[0].getText()=="X" && board[1].getText()=="X" && board[2].getText()=="X") {
			winnerX(0, 1, 2);
		}
		if(board[3].getText()=="X" && board[4].getText()=="X" && board[5].getText()=="X") {
			winnerX(3, 4, 5);
		}
		if(board[6].getText()=="X" && board[7].getText()=="X" && board[8].getText()=="X") {
			winnerX(6, 7, 8);
		}
		if(board[0].getText()=="X" && board[3].getText()=="X" && board[6].getText()=="X") {
			winnerX(0, 3, 6);
		}
		if(board[0].getText()=="X" && board[4].getText()=="X" && board[8].getText()=="X") {
			winnerX(0, 4, 8);
		}
		if(board[1].getText()=="X" && board[4].getText()=="X" && board[7].getText()=="X") {
			winnerX(1, 4, 7);
		}
		if(board[2].getText()=="X" && board[6].getText()=="X" && board[8].getText()=="X") {
			winnerX(2, 6, 8);
		}
		if(board[2].getText()=="X" && board[4].getText()=="X" && board[6].getText()=="X") {
			winnerX(2, 4, 6);
		}
		
		
		if(board[0].getText()=="O" && board[1].getText()=="O" && board[2].getText()=="O") {
			winnerO(0, 1, 2);
		}
		if(board[3].getText()=="O" && board[4].getText()=="O" && board[5].getText()=="O") {
			winnerO(3, 4, 5);
		}
		if(board[6].getText()=="O" && board[7].getText()=="O" && board[8].getText()=="O") {
			winnerO(6, 7, 8);
		}
		if(board[0].getText()=="O" && board[3].getText()=="O" && board[6].getText()=="O") {
			winnerO(0, 3, 6);
		}
		if(board[0].getText()=="O" && board[4].getText()=="O" && board[8].getText()=="O") {
			winnerO(0, 4, 8);
		}
		if(board[1].getText()=="O" && board[4].getText()=="O" && board[7].getText()=="O") {
			winnerO(1, 4, 7);
		}
		if(board[2].getText()=="O" && board[6].getText()=="O" && board[8].getText()=="O") {
			winnerO(2, 6, 8);
		}
		if(board[2].getText()=="O" && board[4].getText()=="O" && board[6].getText()=="O") {
			winnerO(2, 4, 6);
		}
	}
	
	public void winnerX(int a, int b, int c ) {
		board[a].setBackground(Color.RED);
		board[b].setBackground(Color.RED);
		board[c].setBackground(Color.RED);
		
		for(int i=0; i<9; i++ ) {
			board[i].setEnabled(false);
		}
		System.out.println("X kazandı");
	}
	
	public void winnerO(int a, int b, int c) {
		board[a].setBackground(Color.GREEN);
		board[b].setBackground(Color.GREEN);
		board[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9; i++ ) {
			board[i].setEnabled(false);
		}
		System.out.println("O kazandı");
	}

	
}

	

