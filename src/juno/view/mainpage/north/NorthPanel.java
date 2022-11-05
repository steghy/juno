package juno.view.mainpage.north;

import java.io.Serial;

import javax.swing.*;

public class NorthPanel extends JPanel {

	@Serial
	private static final long serialVersionUID = 1L;
	private JLabel logo;

	private static NorthPanel instance;

	private NorthPanel() {}
	
	public static NorthPanel getInstance() {
		if(instance == null) {
			instance = new NorthPanel();
		} return instance;
	}

	public void setLogo(JLabel logo) {
		this.logo = logo;
	}

	public void init() {
		if(logo == null) {
			throw new IllegalArgumentException("Logo isn't set");
		}
		this.add(logo);
	}
}