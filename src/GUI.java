import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUI {

	public JFrame frame;
	private final int FRAME_WIDTH = 1280;
	private final int FRAME_HEIGHT = 900;
	private final int BUT_HEIGHT = 100;
	private final int BUT_WIDTH = 100;
	public JPanel shopPhase = new JPanel();
	public JPanel shopCards = new JPanel();
	public JPanel panel;
	public JPanel gemPileStuff;
	public JPanel playerStuff;
	public Game game;
	public Color trans = new Color(255, 255, 255, 0);

	public GUI() {
		this.frame = new JFrame("Puzzle Strike: Deck of Cards");
		this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		this.game = new Game(3);
		setUp();
	}

	public class JBackgroundPanel extends JPanel {
		private BufferedImage img;

		public JBackgroundPanel() {
			// load the background image
			try {
				img = ImageIO.read(new File("./backgroundpanels.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// paint the background image and scale it to fill the entire space
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public class JBackgroundButton extends JButton {
		private BufferedImage img;

		public JBackgroundButton() {
			// load the background image
			try {
				img = ImageIO.read(new File("./cardbg.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// paint the background image and scale it to fill the entire space
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public class JBackgroundLabel extends JLabel {
		private BufferedImage img;

		public JBackgroundLabel(File path) {
			// load the background image
			try {
				img = ImageIO.read(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// paint the background image and scale it to fill the entire space
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}

	private void setUp() {
		this.panel = new JBackgroundPanel();
		this.frame.setContentPane(this.panel);
		updateFrame();

		class CardShopListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: this function;
				cardShopInfo((JButton) e.getSource());
			}
		}
		this.shopPhase.setBackground(this.trans);
		this.shopPhase
				.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.shopCards.setBackground(this.trans);
		this.shopCards.setPreferredSize(new Dimension(FRAME_WIDTH,
				14 * FRAME_HEIGHT / 16));
		for (int i = 0; i < this.game.bank.size(); i++) {
			JButton card = new JBackgroundButton();
			card.setName("" + i);
			card.add(new JLabel(this.game.bank.get(i).name));
			card.setPreferredSize(new Dimension(BUT_WIDTH, BUT_HEIGHT));
			card.addActionListener(new CardShopListener());
			this.shopCards.add(card);
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
		this.shopPhase.add(this.shopCards);
		this.shopPhase.add(endPhase);
		newTurn();
	}

	private void newTurn() {
		class CardListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: this function;
				cardInfo((JButton) e.getSource());
			}
		}
		this.playerStuff = new JPanel();
		this.playerStuff.setBackground(this.trans);
		this.playerStuff.setPreferredSize(new Dimension(FRAME_WIDTH,
				FRAME_HEIGHT / 3));
		JPanel hand = new JPanel();
		hand.setBackground(this.trans);
		hand.setPreferredSize(new Dimension(FRAME_WIDTH, 2 * FRAME_HEIGHT / 8));
		for (int i = 0; i < this.game.players.get(this.game.turn).hand.size(); i++) {
			JButton card = new JBackgroundButton();
			card.add(new JLabel(this.game.getCurrentPlayer().hand.get(i).name));
			card.setName("" + i);
			card.addActionListener(new CardListener());
			card.setPreferredSize(new Dimension(BUT_WIDTH, BUT_HEIGHT));
			hand.add(card);
		}
		JButton endPhase = new JButton("End Phase");
		class EndListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: this function;
				endActionPhase();
			}
		}

		endPhase.addActionListener(new EndListener());
		this.playerStuff.add(hand);
		this.playerStuff.add(endPhase);

		this.gemPileStuff = new JPanel();

		for (int i = 0; i < this.game.playerNum; i++) {
			JLabel name = new JLabel("Player " + (i + 1));
			JPanel gemPileMargins = new JPanel();
			JPanel gemPile = new JPanel();
			gemPileMargins.setPreferredSize(new Dimension(FRAME_WIDTH
					/ (this.game.playerNum + 1), 400));
			gemPileMargins.setBackground(this.trans);
			gemPile.setPreferredSize(new Dimension(100, 400));
			gemPile.setBackground(this.trans);
			JLabel gem1 = new JLabel("1 gem(s): "
					+ this.game.players.get(i).gemPile[0]);
			JLabel gem2 = new JLabel("2 gem(s): "
					+ this.game.players.get(i).gemPile[1]);
			JLabel gem3 = new JLabel("3 gem(s): "
					+ this.game.players.get(i).gemPile[2]);
			JLabel gem4 = new JLabel("4 gem(s): "
					+ this.game.players.get(i).gemPile[3]);
			JLabel totalVal = new JLabel("Total: "
					+ this.game.players.get(i).totalGemValue());
			gemPile.add(gem1);
			gemPile.add(gem2);
			gemPile.add(gem3);
			gemPile.add(gem4);
			gemPile.add(totalVal);
			gemPileMargins.add(gemPile);
			if (this.game.turn == i) {
				name.setForeground(Color.YELLOW);
			} else {
				name.setForeground(Color.WHITE);
			}
			JPanel player = new JPanel();
			player.setPreferredSize(new Dimension(FRAME_WIDTH
					/ (this.game.playerNum + 1), FRAME_HEIGHT / 2));
			player.setBackground(this.trans);
			player.add(name);
			player.add(gemPileMargins);
			this.gemPileStuff.add(player);
		}

		this.gemPileStuff.setBackground(this.trans);
		this.gemPileStuff.setPreferredSize(new Dimension(FRAME_WIDTH,
				3 * FRAME_HEIGHT / 5));

		JPanel mostPhases = new JPanel();
		mostPhases.setBackground(this.trans);
		mostPhases.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		mostPhases.add(this.gemPileStuff);
		mostPhases.add(this.playerStuff);

		if (this.panel.getComponentCount() != 0) {
			this.panel.removeAll();
		}
		this.panel.add(mostPhases);

		updateFrame();
	}

	public void endActionPhase() {
		newShopPhase();
	}

	public void endShopPhase() {
		if (this.game.boughtSomething) {
			this.game.getCurrentPlayer().endTurn();
			this.game.newTurn();
			newTurn();
		}
	}

	public void cardInfo(JButton card) {
		String numString = card.getName();
		int num = Integer.parseInt(numString);
		Card clicked = this.game.getCurrentPlayer().hand.get(num);
		Icon icon = new ImageIcon();
		if (clicked.imagePath != null) {
			icon = new ImageIcon(clicked.imagePath);
		}
		if (this.game.getCurrentPlayer().canUseCard(clicked)) {
			Object[] options = { "Use Card" };

			Integer n = JOptionPane.showOptionDialog(this.frame, "",
					clicked.name, JOptionPane.OK_OPTION,
					JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);

			if (n == 0) {
				newTurn();
				useCard(clicked);
			}
		} else {
			Object[] options = {};
			JOptionPane.showOptionDialog(this.frame, "", clicked.name,
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, icon, options, null);
		}

		updateFrame();
	}

	public void cardShopInfo(JButton card) {
		String numString = card.getName();
		int num = Integer.parseInt(numString);
		Card clicked = this.game.bank.get(num);
		Icon icon = new ImageIcon();
		if (clicked.imagePath != null) {
			icon = new ImageIcon(clicked.imagePath);
		}

		if (this.game.canBuy(clicked)) {
			Object[] options = { "Buy Card" };
			Integer n = JOptionPane.showOptionDialog(this.frame, "Amount: "
					+ clicked.amount, clicked.name, JOptionPane.OK_OPTION,
					JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);

			if (n == 0) {
				this.game.playerBuyCard(this.game.getCurrentPlayer(), clicked);
			}
		} else {
			Object[] options = {};
			JOptionPane.showOptionDialog(this.frame, "Amount: "
					+ clicked.amount, clicked.name, JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, icon, options, null);
		}

		updateFrame();
	}

	private void newShopPhase() {
		// TODO Auto-generated method stub

		this.game.totalMoney();
		if (this.panel.getComponentCount() != 0) {
			this.panel.removeAll();
		}
		this.panel.add(this.shopPhase);

		updateFrame();
	}

	private void useCard(Card clicked) {
		ArrayList<Choice> choices = clicked.getChoice(this.game);
		Icon icon = new ImageIcon();
		boolean completeSoFar = true;
		for (int i = 0; i < choices.size(); i++) {
			Choice current = choices.get(i);
			while (current.nextChoice()) {
				current = choices.get(i);
				Object[] options = current.getOptions().toArray();
				String n = (String) JOptionPane.showInputDialog(this.frame,
						current.getInstructions(), clicked.name,
						JOptionPane.OK_OPTION, icon, options, options[0]);
				if (n != null) {
					current.addChoice(n);
				} else {
					completeSoFar = false;
				}
			}
		}

		if (completeSoFar) {
			clicked.use(choices);
		}

		this.game.useCard(clicked);
		newTurn();
	}

	private void updateFrame() {
		this.frame.validate();
		this.frame.setVisible(true);
		this.frame.repaint();
	}

}
