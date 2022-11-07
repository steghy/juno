package juno.view.pages.main.menuPanel;

import juno.controller.menu.NewGameListener;
import juno.init.Paths;
import juno.model.util.PathGenerator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewGameButtonInitializer {

    private NewGameButtonInitializer() {}

    public static void initialize() {
        NewGameButton newGameButton = NewGameButton.getInstance();

        // LISTENER
        newGameButton.addActionListener(NewGameListener.getInstance());

        // ICON
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(PathGenerator
                    .generate(Paths.BUTTONS.getPath(), "new-game-button.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ROLLOVER ICON
        BufferedImage rolloverImage = null;
        try {
            rolloverImage = ImageIO.read(new File(PathGenerator
                    .generate(Paths.BUTTONS.getPath(), "new-game-button-rollover.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ICONS & DIMENSION SETTINGS
        if(image != null && rolloverImage != null) {
            newGameButton.setIcon(new ImageIcon(image));
            newGameButton.setRolloverIcon(new ImageIcon(rolloverImage));

            newGameButton.setSize(image.getWidth(), image.getHeight());
        }

    }
}
