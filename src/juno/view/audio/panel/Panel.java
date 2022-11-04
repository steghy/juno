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
	private JToggleButton toggle;

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

	public void setToggle(JToggleButton button) {
		 toggle = button;
	}

	public void init() throws JPanelNotSetException {
		if(next == null) {
			throw new JPanelNotSetException("NextButton not set");
		} if(back == null) {
			throw new JPanelNotSetException("BackButton not set");
		} if(toggle == null) {
			throw new JPanelNotSetException("JToggleButton not set");
		}

		this.setLayout(new GridLayout(1, 3, 0, 0));

		this.add(back, 0);
		this.add(toggle, 1);
		this.add(next, 2);
		this.setOpaque(false);
	}
}