/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno;

import juno.controller.pre_access.ConfigurationFilesFactory;
import juno.model.requester.GitHubRepositorySetter;
import juno.model.sound.AudioPlayer;
import juno.model.sound.ButtonSoundPlayer;
import juno.view.frame.Frame;
import juno.view.pages.options.menu.MenuPanel;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * This class defines the Main class of
 * the J-Uno application.
 * @author Simone Gentili
 */
public class JUno {

    // Builds a Main object.
    private JUno() {}

    /**
     * Starts the J-UNO applications with the
     * specified arguments.
     * @param args An array of String object.
     */
    public static void main(String[] args) {
        try {
            // Setting GitHub repository.
            GitHubRepositorySetter.setRepository();

            // Model -> View -> Controller initialization.
            juno.model.Initializer.getInstance().initialize();
            juno.view.Initializer.getInstance().initialize();
            juno.controller.Initializer.getInstance().initialize();

            // Getting profiles.
            ConfigurationFilesFactory.getInstance().generate();

            // Audio player.
            AudioPlayer.getInstance().play();

            // Fullscreen mode.
            ButtonSoundPlayer.getInstance().mute();
            ((JToggleButton) Objects.requireNonNull(MenuPanel.getInstance().getThirdComponent())).doClick();
            ButtonSoundPlayer.getInstance().unmute();

            // Frame.
            Frame frame = Frame.getInstance();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder b = new StringBuilder();
            Arrays.stream(e.getStackTrace()).forEach(l -> b.append(l).append("\n"));
            JOptionPane.showMessageDialog(
                    null,
                    "An error has occurred: \n" + b,
                    "ERROR", JOptionPane.ERROR_MESSAGE);

            System.exit(1);
        }
    }

}