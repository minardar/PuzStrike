import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game {

	public JFrame frame;
	private final int FRAME_WIDTH = 1280;
	private final int FRAME_HEIGHT = 900;
	public JPanel hand;
	public JPanel gemPiles;
	
	
	
	public Game(){
		this.frame = new JFrame("Puzzle Strike: Hand of Cards");
		this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);	
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
	}
}
