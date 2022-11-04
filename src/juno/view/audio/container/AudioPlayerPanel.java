package juno.view.audio.container;

import java.awt.*;
import java.io.Serial;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juno.view.exception.JLabelNotSetException;
import juno.view.exception.JPanelNotSetException;

public class AudioPlayerPanel extends JPanel {

	@Serial
	private static final long serialVersionUID = 1L;
	private static AudioPlayerPanel instance;
	private JLabel background;
	private JPanel panel;

	private AudioPlayerPanel() {
		this.setSize(new Dimension(500, 250));
	}

	public static AudioPlayerPanel getInstance() {
		if(instance == null) {
			instance = new AudioPlayerPanel();
		} return instance;
	}

	public void setBackground(JLabel label) {
		background = label;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void init() throws JPanelNotSetException, JLabelNotSetException {
		if(panel == null) {
			throw new JPanelNotSetException(""
					+ "panel isn't set");
		} if(background == null) {
			throw new JLabelNotSetException(""
					+ "background isn't set");
		}
		background.setLayout(new GridLayout());
		background.add(panel, 0);
		this.add(background);
	}
}