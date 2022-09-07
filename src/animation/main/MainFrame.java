package animation.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Il JFrame di default utilizza il BorderLayout. Il BorderLayout divide la finestra
 * in cinque aree (Nord, sub, ovest, est e centro). Ogni area può contenere soltanto un
 * componente (o elemento)
 * @author steghy
 *
 */
public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private Title title;
	private FirstPanel panel1;
	private SecondPanel panel2;
	private ThirdPanel panel3;
	
	public MainFrame() {
		
		this.title = new Title();
		this.panel1 = new FirstPanel();
		this.panel2 = new SecondPanel();
		this.panel3 = new ThirdPanel();
		this.init();
	}
	
	/**
	 * 
	 */
	private void init() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //termina alla chiusura
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen option
		
		this.setLocationRelativeTo(null); //al centro
	
		//this.setUndecorated(true); //toglie la barra in alto 
		
		this.setTitle("juno"); //title
		
		this.setResizable(true); //ridimensionabile
		
		//this.setAlwaysOnTop(rootPaneCheckingEnabled); //non lo so
		
		this.add(this.title, BorderLayout.CENTER);
		this.add(this.panel1, BorderLayout.SOUTH); 
		this.add(this.panel2, BorderLayout.NORTH);
		this.add(this.panel3, BorderLayout.EAST);
		
		
		
		this.pack(); // TASK : cosa fa ?
			
		this.setVisible(true);
		
	}
	

}
