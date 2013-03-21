import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class GUI {

	public JFrame frame;
	private final int FRAME_WIDTH = 1280;
	private final int FRAME_HEIGHT = 900;
	private final int BUT_HEIGHT = 250;
	private final int BUT_WIDTH = 150;
	public JPanel shopPhase = new JPanel();
	public JPanel panel;
	public int turn = 1;
	public boolean isShopPhase = false;
	public int players = 1;
	public Player player1 = new Player();
	
	
	
	public GUI(){
		this.frame = new JFrame("Puzzle Strike: Hand of Cards");
		this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);	
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		setUp();
	}



	private void setUp() {
		this.panel = new JPanel();
		this.panel.setBackground(Color.BLACK);
		this.frame.setContentPane(this.panel);
		this.frame.validate();
		this.frame.repaint();
		
		this.shopPhase.setBackground(Color.BLACK);
		this.shopPhase.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		for (int i = 1; i <= 18; i++){
			JButton card = new JButton("Card "+i);
			card.setPreferredSize(new Dimension(BUT_WIDTH, BUT_HEIGHT));
			this.shopPhase.add(card);
		}
		
		class EndShopListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: this function;
				endShopPhase();
			}
		}
		
		
		JButton endPhase = new JButton("End Phase");
		endPhase.addActionListener(new EndShopListener());
		this.shopPhase.add(endPhase);
		newTurn();
	}



	private void newTurn() {
		JPanel playerStuff = new JPanel();
		playerStuff.setBackground(Color.BLACK);
		playerStuff.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT/3));
		JPanel hand = new JPanel();
		hand.setBackground(Color.BLACK);
		hand.setPreferredSize(new Dimension(2*FRAME_WIDTH/3, FRAME_HEIGHT/3));
		for (int i = 1; i <= 5; i++){
			JButton card = new JButton("Card "+i);
			card.setPreferredSize(new Dimension(BUT_WIDTH, BUT_HEIGHT));
			hand.add(card);
		}
		JButton discard = new JButton("Discard");
		discard.setPreferredSize(new Dimension(BUT_WIDTH, BUT_HEIGHT));
		JButton deck = new JButton("Deck");
		deck.setPreferredSize(new Dimension(BUT_WIDTH, BUT_HEIGHT));
		playerStuff.add(discard);
		playerStuff.add(deck);
		JButton endPhase = new JButton("End Phase");
		
		class EndListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: this function;
				endActionPhase();
			}
		}
		
		endPhase.addActionListener(new EndListener());
		hand.add(endPhase);
		playerStuff.add(hand);
		
		
		JPanel gemPileStuff = new JPanel();
		
		for (int i = 1; i <= this.players; i++){
			JLabel name = new JLabel("Player "+i);
			name.setForeground(Color.WHITE);
			gemPileStuff.add(name);
		}
		
		gemPileStuff.setBackground(Color.BLACK);
		gemPileStuff.setPreferredSize(new Dimension(FRAME_WIDTH, 3*FRAME_HEIGHT/5));
		JPanel mostPhases = new JPanel();
		mostPhases.setBackground(Color.BLACK);
		mostPhases.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		mostPhases.add(gemPileStuff);
		mostPhases.add(playerStuff);
		
		
		if (this.panel.getComponentCount() != 0){
			this.panel.removeAll();
		}
		this.panel.add(mostPhases);
		
		this.frame.validate();
		this.frame.repaint();
	}
	
	public void endActionPhase(){
		this.isShopPhase = true;
		newShopPhase();
	}

	public void endShopPhase(){
		this.isShopPhase = false;
		newTurn();
	}

	private void newShopPhase() {
		// TODO Auto-generated method stub
		
		if (this.panel.getComponentCount() != 0){
			this.panel.removeAll();
		}
		this.panel.add(this.shopPhase);
		
		this.frame.validate();
		this.frame.repaint();
	}
	
	


	

	
	
	
	
}
