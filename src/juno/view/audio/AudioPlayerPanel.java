package juno.view.audio;

import java.awt.*;
import java.io.Serial;
import javax.swing.*;

import juno.view.exception.JLabelNotSetException;
import juno.view.exception.JPanelNotSetException;

public class AudioPlayerPanel extends JPanel {

	@Serial
	private static final long serialVersionUID = 1L;
	private static AudioPlayerPanel instance;
	private JLabel background;
	private JButton next;
	private JButton back;
	private JToggleButton toggle;

	private AudioPlayerPanel() {
	}

	public static AudioPlayerPanel getInstance() {
		if(instance == null) {
			instance = new AudioPlayerPanel();
		} return instance;
	}

	public void setBackground(JLabel label) {
		background = label;
	}

	public void setToggleButton(JToggleButton toggle) {
		this.toggle = toggle;
	}

	public void setNextButton(JButton next) {
		this.next = next;
	}

	public void setBackButton(JButton back) {
		this.back = back;
	}

	public void init() throws JPanelNotSetException, JLabelNotSetException {
		if(background == null) {
			throw new IllegalArgumentException("Background isn't set");
		} if(next == null) {
			throw new IllegalArgumentException("Next isn't set");
		} if(back == null) {
			throw new IllegalArgumentException("Back isn't set");
		} if(toggle == null) {
			throw new IllegalArgumentException("Toggle isn't set");
		}
		background.setLayout(new GridLayout());
		background.add(back, 0);
		background.add(toggle, 1);
		background.add(next, 2);
		this.add(background);
	}
}