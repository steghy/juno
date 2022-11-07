package juno.view.pages.main.menuPanel;

import juno.controller.menu.NewGameListener;
import juno.init.Downloader;
import juno.init.Directories;
import juno.init.URLBuilder;
import juno.model.util.Os;
import juno.model.util.PathGenerator;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewGameButtonInitializer {

    private NewGameButtonInitializer() {}

    public static void initialize() {
        NewGameButton newGameButton = NewGameButton.getInstance();

        // IMAGE
        String imageName = "new-game-button.png";
        String imagePath = PathGenerator.generate(Directories.BUTTONS.getAbsolutePath(), imageName);
        URLBuilder url = URLBuilder.getInstance();
        if(!Os.exists(imagePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(Directories.BUTTONS, imageName),
                        PathGenerator.generate(Directories.BUTTONS.getAbsolutePath(), imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(PathGenerator
                    .generate(Directories.BUTTONS.getPath(), "new-game-button.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ROLLOVER IMAGE
        String rolloverImageName = "new-game-button-rollover.png";
        String rolloverImagePath = PathGenerator.generate(Directories.BUTTONS.getPath(), rolloverImageName);
        if(!Os.exists(rolloverImagePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(Directories.BUTTONS, rolloverImageName),
                        PathGenerator.generate(Directories.BUTTONS.getPath(), rolloverImageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedImage rolloverImage = null;
        try {
            rolloverImage = ImageIO.read(new File(PathGenerator
                    .generate(Directories.BUTTONS.getPath(), rolloverImageName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ICONS & DIMENSION SETTINGS
        if(image != null && rolloverImage != null) {
            newGameButton.setIcon(new ImageIcon(image));
            newGameButton.setRolloverIcon(new ImageIcon(rolloverImage));

            newGameButton.setSize(image.getWidth(), image.getHeight());
        }

        // LISTENER
        newGameButton.addActionListener(NewGameListener.getInstance());

    }
}
