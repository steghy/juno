package juno.observer;

import javax.swing.ImageIcon;

import juno.main.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.mainframe.Background;
import juno.view.mainframe.Frame;
import juno.view.mainframe.center.ExitButton;
import juno.view.mainframe.center.NewGameButton;
import juno.view.mainframe.center.OptionsButton;
import juno.view.mainframe.north.Logo;

public class Main {

	public static void main(String[] args) {
		/* ====== Test Juno GUI ========*/

		// Components
		Frame frame = Frame.getInstance();
		Logo logo = Logo.getInstance();
		Background background = Background.getInstance();
		NewGameButton newGameButton = NewGameButton.getInstance();
		OptionsButton optionsButton = OptionsButton.getInstance();
		ExitButton exitButton = ExitButton.getInstance();

		// Logo Image
		String logoImage = PathGenerator
				.generate(Paths.LOGOS.getPath(), 
						"default-logo.png");

		// Background Image
		String backgroundImage = PathGenerator
				.generate(Paths.BACKGROUNDS.getPath(), 
						"default-background.gif");
		
		// NewGameButton Image
		String newGameImage = PathGenerator
				.generate(Paths.BUTTONS.getPath(), "style-2/new-game.png");

		// OptionsButton Image
		String optionsImage = PathGenerator
				.generate(Paths.BUTTONS.getPath(), "style-2/options.png");
		
		// ExitButton Image
		String exitImage = PathGenerator
				.generate(Paths.BUTTONS.getPath(), "style-2/exit.png");

		// Settings
		logo.setIcon(new ImageIcon(logoImage));
		background.setIcon(new ImageIcon(backgroundImage));
		newGameButton.setIcon(new ImageIcon(newGameImage));
		optionsButton.setIcon(new ImageIcon(optionsImage));
		exitButton.setIcon(new ImageIcon(exitImage));

		// Show the frame
		frame.setVisible(true);
		
	}
}
