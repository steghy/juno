package juno.view.mainpage.west;

import javax.swing.JPanel;

public class WestPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static WestPanel instance;

	private WestPanel() {}

	public static WestPanel getInstance() {
		if(instance == null) {
			instance = new WestPanel();
		} return instance;
	}
	
	private void init() {}
}