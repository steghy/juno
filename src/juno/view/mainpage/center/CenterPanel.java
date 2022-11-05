package juno.view.mainpage.center;

import java.awt.*;
import java.io.Serial;
import javax.swing.*;

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

	public void init() {
		if(newGameButton == null) {
			throw new IllegalArgumentException("New game button isn't set");
		} if(optionsButton == null) {
			throw new IllegalArgumentException("Options button isn't set");
		} if(scoreButton == null) {
			throw new IllegalArgumentException("Score button isn't set");
		} if(exitButton == null) {
			throw new IllegalArgumentException("Exit button isn't set");
		}
		GridLayout gridLayout = new GridLayout();
		gridLayout.setColumns(1);
		gridLayout.setRows(4);
		gridLayout.setVgap(1);
		this.setLayout(gridLayout);
		this.add(newGameButton, 0);
		this.add(scoreButton, 1);
		this.add(optionsButton, 2);
		this.add(exitButton, 3);
	}
}