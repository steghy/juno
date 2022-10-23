package juno.view.main.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import juno.observer.Observer;
import juno.observer.Subject;
import juno.view.main.menu.center.CenterPanel;
import juno.view.main.menu.east.EastPanel;
import juno.view.main.menu.north.NorthPanel;
import juno.view.main.menu.south.SouthPanel;
import juno.view.main.menu.west.WestPanel;

/**
 * Frame class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Frame extends JFrame implements Subject {

	/** Serail Version UID */
	public static final long serialVersionUID = 1L;

	/** Default Frame Dimension */
	public Dimension DEF_DIMENSION = new Dimension(1200, 800);
	
	/* Preferred Frame Dimension */
	public Dimension PRF_DIMENSION = new Dimension(1500, 1100);
	
	/* Maximun Frame Dimension */
	public Dimension MAX_DIMENSION = new Dimension(0, 0);
	
	/* Minimun Frame Dimension */
	public Dimension MIN_DIMENSION = new Dimension (800, 600);
	
	/* Observer list */
	List<Observer> observers;

	/* Frame background */
	private Background background;
	
	/* Icon logo */
	private JPanel northPanel;
	
	/* Center panel */
	private JPanel centerPanel;
	
	/* East Panel */
	private JPanel eastPanel;
	
	/* West Panel */
	private JPanel westPanel;
	
	/* South JPanel */
	private JPanel southPanel;
	
	/* Frame object */
	private static Frame instance;

	
	/* Builds a Frame object */
	private Frame() {
		init();
	}
	
	
	/**
	 * Returns the Frame instance
	 * @return The Frame instance
	 */
	public static Frame getInstance() {
		if(instance == null) {
			instance = new Frame();
		} return instance;
	}
	
	
	public void setBackgroundImage(String path) {
		ImageIcon backgroundImage = new ImageIcon(path);
		this.background.setIcon(backgroundImage);
	}
	
	@Override
	public void attach(Observer observer) {}


	@Override
	public void detach(Observer observer) {}


	@Override
	public void update() {}
	
	
	/* Initialize the Frame instance */
	private void init() {
		
		this.observers = new ArrayList<Observer>();

		// Dimension Settings
		this.setSize(DEF_DIMENSION);
		this.setPreferredSize(PRF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);

		// Frame settings
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(true);
		
		
		// Components
		this.background = Background.getInstance();
		this.centerPanel = CenterPanel.getInstance();
		this.northPanel = NorthPanel.getInstance();
		this.eastPanel = EastPanel.getInstance();
		this.westPanel = WestPanel.getInstance();
		this.southPanel = SouthPanel.getInstance();

		// Add components
		this.add(background);
		background.setLayout(new BorderLayout());
		background.add(this.northPanel, BorderLayout.NORTH);
		background.add(this.centerPanel, BorderLayout.CENTER);
		background.add(this.eastPanel, BorderLayout.EAST);
		background.add(this.westPanel, BorderLayout.WEST);
		background.add(this.southPanel, BorderLayout.SOUTH);
		
	}
}