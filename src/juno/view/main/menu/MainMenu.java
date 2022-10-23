package juno.view.main.menu;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import juno.view.exception.FactoryNotSettedException;
import juno.view.factories.AbstractMMenuFactory;
import juno.view.main.menu.factories.AbstractBackgroundFactory;
import juno.view.main.menu.factories.AbstractCPanelFactory;
import juno.view.main.menu.factories.AbstractEPanelFactory;
import juno.view.main.menu.factories.AbstractNPanelFactory;
import juno.view.main.menu.factories.AbstractSPanelFactory;
import juno.view.main.menu.factories.AbstractWPanelFactory;

/**
 * Frame class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class MainMenu extends JPanel implements AbstractMMenuFactory {

	/** Serail Version UID */
	public static final long serialVersionUID = 1L;

	/* Frame background */
	private static AbstractBackgroundFactory backgroundFactory;
	
	/* Icon logo */
	private static AbstractNPanelFactory northPanelFactory;
	
	/* Center panel */
	private static AbstractCPanelFactory centerPanelFactory;
	
	/* East Panel */
	private static AbstractEPanelFactory eastPanelFactory;
	
	/* West Panel */
	private static AbstractWPanelFactory westPanelFactory;
	
	/* South JPanel */
	private static AbstractSPanelFactory southPanelFactory;
	
	/* Frame object */
	private static MainMenu instance;

	
	/* Builds a Frame object */
	private MainMenu() {}
	
	
	@Override
	public JPanel getMMenuPanel() {
		return getInstance();
	}
	
	
	/**
	 * Returns the Frame instance
	 * @return The Frame instance
	 */
	public static MainMenu getInstance() {
		if(instance == null) {
			instance = new MainMenu();
		} return instance;
	}
	
	
	/**
	 * Sets the NorthPanelFactory of this instance
	 * @param factory A Factory
	 */
	public static void setNorthPanelFactory(AbstractNPanelFactory factory) {
		northPanelFactory = factory;
	}
	
	/**
	 * Sets the CenterPanelFactory of this instance 
	 * @param factory A Factory
	 */
	public static void setCenterPanelFactory(AbstractCPanelFactory factory) {
		centerPanelFactory = factory;
	}
	
	
	/**
	 * Sets the EastPanelFactory of this instance
	 * @param factory A Factory
	 */
	public static void setEastPanelFactory(AbstractEPanelFactory factory) {
		eastPanelFactory = factory;
	}
	
	
	/**
	 * Sets the SouthPanelFactory of this instance
	 * @param factory A Factory
	 */
	public static void setSouthPanelFactory(AbstractSPanelFactory factory) {
		southPanelFactory = factory;
	}
	
	
	/**
	 * Sets the WestPanelFactory of this instance 
	 * @param factory A Factory
	 */
	public static void setWestPanelFactory(AbstractWPanelFactory factory) {
		westPanelFactory = factory;
	}
	
	
	/**
	 * Sets the BackgroundFactory of this instance
	 * @param factory A Factory
	 */
	public static void setBackgroundFactory(AbstractBackgroundFactory factory) {
		backgroundFactory = factory;
	}

	
	/* Initialize the Frame instance */
	public void init() throws FactoryNotSettedException {
		
		// Check integrity
		if(northPanelFactory == null) {
			throw new FactoryNotSettedException();
		} else if(centerPanelFactory == null) {
			throw new FactoryNotSettedException();
		} else if(eastPanelFactory == null) {
			throw new FactoryNotSettedException();
		} else if(southPanelFactory == null) {
			throw new FactoryNotSettedException();
		} else if(westPanelFactory == null) {
			throw new FactoryNotSettedException();
		} else if(backgroundFactory == null) {
			throw new FactoryNotSettedException();
		}
		
		// Getting values
		JPanel northPanel = northPanelFactory.getNorthPanel();
		JPanel centerPanel = centerPanelFactory.getCenterPanel();
		JPanel eastPanel = eastPanelFactory.getEastPanel();
		JPanel southPanel = southPanelFactory.getSouthPanel();
		JPanel westPanel = westPanelFactory.getWestPanel();
		JLabel background = backgroundFactory.getBackgroundLabel();

		// Add components
		background.add(northPanel, BorderLayout.NORTH);
		background.add(centerPanel, BorderLayout.CENTER);
		background.add(eastPanel, BorderLayout.EAST);
		background.add(westPanel, BorderLayout.WEST);
		background.add(southPanel, BorderLayout.SOUTH);
		
	}
}