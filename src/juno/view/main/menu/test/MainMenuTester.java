package juno.view.main.menu.test;

import javax.swing.ImageIcon;

import juno.main.init.Paths;
import juno.model.sound.AudioPlayer;
import juno.model.util.PathGenerator;
import juno.view.audio.NextButton;
import juno.view.audio.PreviousButton;
import juno.view.audio.ToggleSwitch;
import juno.view.main.menu.Background;
import juno.view.main.menu.MainMenu;
import juno.view.main.menu.center.ExitButton;
import juno.view.main.menu.center.NewGameButton;
import juno.view.main.menu.center.OptionsButton;
import juno.view.main.menu.north.Logo;

/**
 * Main menu tester
 * @author steghy
 * @email steghy.github@proton.me
 */
public class MainMenuTester {

	public static void main(String[] args) {
		/* ====== Test Juno GUI ========*/

		
		// Main frame components
		MainMenu frame = MainMenu.getInstance();
		Logo logo = Logo.getInstance();
		Background background = Background.getInstance();
		NewGameButton newGameButton = NewGameButton.getInstance();
		OptionsButton optionsButton = OptionsButton.getInstance();
		ExitButton exitButton = ExitButton.getInstance();
		
		// AudioPlayer components
		NextButton nextButton = NextButton.getInstance();
		PreviousButton previousButton = PreviousButton.getInstance();
		ToggleSwitch toggleButton = ToggleSwitch.getInstance();

		String logoImage = PathGenerator
				.generate(Paths.LOGOS.getPath(), "default-logo.png");
		String backgroundImage = PathGenerator
				.generate(Paths.BACKGROUNDS.getPath(), "default-background.gif");
		String newGameImage = PathGenerator
				.generate(Paths.BUTTONS.getPath(), "style-2/new-game.png");
		String optionsImage = PathGenerator
				.generate(Paths.BUTTONS.getPath(), "style-2/options.png");
		String exitImage = PathGenerator
				.generate(Paths.BUTTONS.getPath(), "style-2/exit.png");
		String previousImage = PathGenerator
				.generate(Paths.AUDIOPLAYER.getPath(), "previous.png");
		String toggleImage = PathGenerator
				.generate(Paths.AUDIOPLAYER.getPath(), "play.png");
		String nextImage = PathGenerator
				.generate(Paths.AUDIOPLAYER.getPath(), "next.png");
		
		

		// Main Frame components Settings
		logo.setIcon(new ImageIcon(logoImage));
		background.setIcon(new ImageIcon(backgroundImage));
		newGameButton.setIcon(new ImageIcon(newGameImage));
		optionsButton.setIcon(new ImageIcon(optionsImage));
		exitButton.setIcon(new ImageIcon(exitImage));
		
		// AudioPlayer components Settings
		nextButton.setIcon(new ImageIcon(nextImage));
		previousButton.setIcon(new ImageIcon(previousImage));
		toggleButton.setIcon(new ImageIcon(toggleImage));

		// Start
		frame.setVisible(true);
		AudioPlayer.getInstance().run();
		
	}
}
