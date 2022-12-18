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

package juno.init;

import juno.init.initializer.ControllerInitializer;
import juno.init.initializer.ModelInitializer;
import juno.init.initializer.ViewInitializer;
import juno.model.data.avatar.AvatarFrameSetter;
import juno.model.data.avatar.AvatarImageSetter;
import juno.model.data.avatar.AvatarNameSetter;
import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.awards.frame.AvatarFrame;
import juno.model.data.score.GamesWonCounter;
import juno.model.sound.AudioPlayer;
import juno.view.frame.Frame;

import javax.swing.*;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Repository.setRepository();
        try {
            // Pre initialization.
            ModelInitializer.initialize();
            ControllerInitializer.initialize();
            ViewInitializer.initialize();

            // Audio player.
            AudioPlayer audioPlayer = AudioPlayer.getInstance();
            audioPlayer.setTracks(Objects
                    .requireNonNull(new File(Directories.MUSIC.absolutePath()).listFiles()));
            audioPlayer.play();
            audioPlayer.setLoop(true);

            // Frame.
            Frame frame = Frame.getInstance();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unknown error has occurred. " +
                    "Consult the program logs for more information.");
        }
    }
}
