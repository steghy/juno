package juno.view.mainframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import juno.observer.Observer;
import juno.observer.Subject;
import juno.view.mainframe.center.Menu;
import juno.view.mainframe.east.EastPanel;
import juno.view.mainframe.north.Logo;
import juno.view.mainframe.north.NorthPanel;
import juno.view.mainframe.south.SouthPanel;
import juno.view.mainframe.west.WestPanel;

/**
 * Frame class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Frame extends JFrame implements Subject {

	/** Serail Version UID */
	public static final long serialVersionUID = 1L;

	/** Default Frame dimension */
	public Dimension DEF_DIMENSION = new Dimension(1400, 1000);
	
	/* Minimun Frame dimension */
	public Dimension MIN_DIMENSION = new Dimension (900,  700);
	
	List<Observer> observers;

	/* Frame background */
	private Background background;
	
	/* Frame menu */
	private JPanel menu;
	
	/* Icon logo */
	private JPanel northPanel;
	
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

		// Frame settings
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(DEF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(true);
		
		// Components
		this.background = Background.getInstance();
		this.menu = Menu.getInstance();
		this.northPanel = NorthPanel.getInstance();
		this.eastPanel = EastPanel.getInstance();
		this.westPanel = WestPanel.getInstance();
		this.southPanel = SouthPanel.getInstance();

		// Add components
		this.add(background);
		background.setLayout(new BorderLayout());
		background.add(this.northPanel, BorderLayout.NORTH);
		background.add(this.menu, BorderLayout.CENTER);
		background.add(this.eastPanel, BorderLayout.EAST);
		background.add(this.westPanel, BorderLayout.WEST);
		background.add(this.southPanel, BorderLayout.SOUTH);
	}
}