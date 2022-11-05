package juno.view.mainpage;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPage extends JPanel {

	public static final long serialVersionUID = 1L;
	private JLabel background;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private static MainPage instance;

	private MainPage() {}
	
	public static MainPage getInstance() {
		if(instance == null) {
			instance = new MainPage();
		} return instance;
	}
	
	
	public void setNorthPanel(JPanel panel) {
		northPanel = panel;
	}
	public void setCenterPanel(JPanel panel) {
		centerPanel = panel;
	}
	public void setEastPanel(JPanel panel) {
		eastPanel = panel;
	}
	public void setSouthPanel(JPanel panel) {
		southPanel = panel;
	}
	public void setWestPanel(JPanel panel) {
		westPanel = panel;
	}
	public void setBackground(JLabel label) {
		background = label;
	}

	public void init() {
		if(northPanel == null) {
			throw new IllegalArgumentException("North panel isn't set");
		} if(centerPanel == null) {
			throw new IllegalArgumentException("Center panel isn't set");
		} if(eastPanel == null) {
			throw new IllegalArgumentException("East panel isn't set");
		} if(southPanel == null) {
			throw new IllegalArgumentException("South panel isn't set");
		} if(westPanel == null) {
			throw new IllegalArgumentException("West panel isn't set");
		} if(background == null) {
			throw new IllegalArgumentException("Background isn't set");
		}

		this.add(background);
		background.setLayout(new BorderLayout());
		background.add(northPanel, BorderLayout.NORTH);
		background.add(centerPanel, BorderLayout.CENTER);
		background.add(eastPanel, BorderLayout.EAST);
		background.add(westPanel, BorderLayout.WEST);
		background.add(southPanel, BorderLayout.SOUTH);
	}
}