package juno.view.mainpage.south;

import javax.swing.JPanel;

public class SouthPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static SouthPanel instance;

	private SouthPanel() {
		init();
	}

	public static SouthPanel getInstance() {
		if(instance == null) {
			instance = new SouthPanel();
		} return instance;
	}
	
	public void init() {}
}