package juno.view.audio.panel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serial;
import javax.swing.*;

import juno.view.exception.*;

public class Panel extends JPanel {

	@Serial
	private static final long serialVersionUID = 1L;
	private JButton next;
	private JButton back;
	private JButton toggle;

	private static Panel instance;
	
	private Panel() {
		this.setSize(new Dimension(500, 250));
	}
		
	public static Panel getInstance() {
		if(instance == null) {
			instance = new Panel();
		} return instance;
	}
	
	public void setNext(JButton button) {
		next = button;
	}
	
	public void setBack(JButton button) {
		back = button;
	}

	public void setTogle(JButton button) {
		 toggle = button;
	}

	public void init() throws JPanelNotSetException {
		if(next == null) {
			throw new JPanelNotSetException("Button not set");
		} if(back == null) {
			throw new JPanelNotSetException("Button not set");
		} if(toggle == null) {
			throw new JPanelNotSetException("Button not set");
		}

		this.setLayout(new GridLayout(1, 3, 0, 0));

		this.add(back, 0);
		this.add(toggle, 1);
		this.add(next, 2);
		this.setOpaque(false);
	}
}