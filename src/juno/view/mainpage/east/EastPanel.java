package juno.view.mainpage.east;

import javax.swing.JPanel;
import java.io.Serial;

public class EastPanel extends JPanel {

	@Serial
	private static final long serialVersionUID = 1L;
	private static EastPanel instance;

	private EastPanel() {}

	public static EastPanel getInstance() {
		if(instance == null) {
			instance = new EastPanel();
		} return instance;
	}

	public void init() {}
}