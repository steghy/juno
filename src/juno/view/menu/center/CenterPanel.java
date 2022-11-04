package juno.view.menu.center;

import java.awt.GridLayout;
import java.io.Serial;
import javax.swing.JButton;
import javax.swing.JPanel;
import juno.view.exception.JButtonNotSetException;

public class CenterPanel extends JPanel {

	@Serial
	private static final long serialVersionUID = 1L;
	private JButton newGameButton;
	private JButton optionsButton;
	private JButton scoreButton;
	private JButton exitButton;
	private static CenterPanel instance;

	private CenterPanel() {}

	public static CenterPanel getInstance() {
		if(instance == null) {
			instance = new CenterPanel();
		} return instance;
	}

	public void setNewGameButton(JButton button) {
		newGameButton = button;
	}

	public void setOptionsButton(JButton button) {
		optionsButton = button;
	}

	public void setScoreButton(JButton button) {
		scoreButton = button;
	}

	public void setExitButton(JButton button) {
		exitButton = button;
	}

	public void init() throws JButtonNotSetException {
		if(newGameButton == null) {
			throw new JButtonNotSetException(""
					+ "JButton 'new game' isn't set");
		} if(optionsButton == null) {
			throw new JButtonNotSetException(""
					+ "JButton 'options' isn't set");
		} if(scoreButton == null) {
			throw new JButtonNotSetException(""
					+ "JButton 'score' isn't set");
		} if (exitButton == null) {
			throw new JButtonNotSetException(""
					+ "JButton 'exit' isn't set");
		}
		this.setLayout(new GridLayout(3, 1, 0, 0));

		this.add(newGameButton);
		this.add(optionsButton);
		this.add(scoreButton);
		this.add(exitButton);

		this.setOpaque(false);

		this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		this.setAlignmentY(JPanel.CENTER_ALIGNMENT);
	}
}