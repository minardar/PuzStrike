import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpScreen{

	private final int FRAME_WIDTH = 640;
	private final int FRAME_HEIGHT = 900;
	private final int BUT_HEIGHT = 100;
	private final int BUT_WIDTH = 100;
	public JFrame frame;
	public Game game;
	public JPanel panel = new JBackgroundPanel();	
	public Color trans = new Color(255, 255, 255, 0);
	
	public HelpScreen(Game game){
		this.game = game;
		this.frame = new JFrame("Help");
		this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		this.frame.setBackground(Color.PINK);
		this.frame.setContentPane(this.panel);
		Page1();
	}
	
	
	private void updateFrame() {
		this.frame.validate();
		this.frame.setVisible(true);
		this.frame.repaint();
	}
	
	
	class Page1Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Page1();
		}
	}
	class Page2Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Page2();
		}
	}
	class Page3Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Page3();
		}
	}
	class Page4Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Page4();
		}
	}
	class Page5Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Page5();
		}
	}
	
	private void Page1(){
		if (this.panel.getComponentCount() != 0) {
			this.panel.removeAll();
		}
		JPanel page1 = new JPanel();
		page1.setPreferredSize(new Dimension(this.FRAME_WIDTH, this.FRAME_HEIGHT - 100));
		page1.setBackground(trans);
		page1.setName("1");
		JLabel title = new JLabel(new ImageIcon(this.game.names.getString("Path")+"helptitle.png"));
		page1.add(title);
		JButton next = new JButton(">");
		next.addActionListener(new Page2Listener());
		this.panel.add(page1);
		this.panel.add(next);
		updateFrame();
	}
	
	void Page2(){
		if (this.panel.getComponentCount() != 0) {
			this.panel.removeAll();
		}
		JPanel page1 = new JPanel();
		page1.setBackground(trans);
		page1.setName("2");
		page1.setPreferredSize(new Dimension(this.FRAME_WIDTH, this.FRAME_HEIGHT - 100));
		JLabel title = new JLabel(new ImageIcon(this.game.names.getString("Path")+"help1.png"));
		page1.add(title);
		JButton next = new JButton(">");
		next.addActionListener(new Page3Listener());
		JButton prev = new JButton("<");
		prev.addActionListener(new Page1Listener());
		this.panel.add(page1);
		this.panel.add(prev);
		this.panel.add(next);
		updateFrame();

	}
	
	void Page3(){
		if (this.panel.getComponentCount() != 0) {
			this.panel.removeAll();
		}
		JPanel page1 = new JPanel();
		page1.setBackground(trans);
		page1.setName("3");
		page1.setPreferredSize(new Dimension(this.FRAME_WIDTH, this.FRAME_HEIGHT - 100));
		JLabel title = new JLabel(new ImageIcon(this.game.names.getString("Path")+"help2.png"));
		page1.add(title);
		JButton next = new JButton(">");
		next.addActionListener(new Page4Listener());
		JButton prev = new JButton("<");
		prev.addActionListener(new Page2Listener());
		this.panel.add(page1);
		this.panel.add(prev);
		this.panel.add(next);
		updateFrame();

	}
	
	void Page4(){
		if (this.panel.getComponentCount() != 0) {
			this.panel.removeAll();
		}
		JPanel page1 = new JPanel();
		page1.setName("4");
		page1.setBackground(trans);
		page1.setPreferredSize(new Dimension(this.FRAME_WIDTH, this.FRAME_HEIGHT - 100));
		JLabel title = new JLabel(new ImageIcon(this.game.names.getString("Path")+"help3.png"));
		page1.add(title);
		JButton next = new JButton(">");
		next.addActionListener(new Page5Listener());
		JButton prev = new JButton("<");
		prev.addActionListener(new Page3Listener());
		this.panel.add(page1);
		this.panel.add(prev);
		this.panel.add(next);
		updateFrame();

	}
	
	void Page5(){
		if (this.panel.getComponentCount() != 0) {
			this.panel.removeAll();
		}
		JPanel page1 = new JPanel();
		page1.setName("5");
		page1.setBackground(trans);
		page1.setPreferredSize(new Dimension(this.FRAME_WIDTH, this.FRAME_HEIGHT - 100));
		JLabel title = new JLabel(new ImageIcon(this.game.names.getString("Path")+"help4.png"));
		page1.add(title);
		JButton prev = new JButton("<");
		prev.addActionListener(new Page4Listener());
		this.panel.add(page1);
		this.panel.add(prev);
		updateFrame();
	}
	
	public class JBackgroundPanel extends JPanel {
		private BufferedImage img;

		public JBackgroundPanel() {
			// load the background image
			try {
				img = ImageIO.read(new File("./rules.png"));
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
}
