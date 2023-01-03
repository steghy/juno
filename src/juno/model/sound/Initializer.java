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

package juno.model.sound;

import juno.controller.util.InterfaceInitializer;
import juno.init.ProgramDirectory;

import java.io.File;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class Initializer
        implements InterfaceInitializer {

    // The Initializer instance.
    private static Initializer instance;

    // Builds an Initializer instance.
    private Initializer() {}

    /**
     * Returns the Initializer instance.
     * @return The Initializer instance.
     */
    public static Initializer getInstance() {
        if(instance == null) instance = new Initializer();
        return instance;
    }

    @Override
    public void initialize() {
        // Audio player.
        AudioPlayer audioPlayer = AudioPlayer.getInstance();

        // Button audio player.
        ButtonSoundPlayer buttonSoundPlayer = ButtonSoundPlayer.getInstance();

        // Welcome back sound player.
        WelcomeBackSoundPlayer welcomeBackSoundPlayer = WelcomeBackSoundPlayer.getInstance();

        //////////////////////////////////////////////////////////////////////////////

        // Audio player.
        audioPlayer.setTracks((Objects.requireNonNull(
                new File(ProgramDirectory.MUSIC.absolutePath()).listFiles())));
        audioPlayer.setLoop(true);

        // Button sound player.
        buttonSoundPlayer.load(new File(
                ProgramDirectory.EFFECTS.absolutePath(), "click.wav"
        ));

        // Welcome back sound player.
        welcomeBackSoundPlayer.load(new File(
                ProgramDirectory.EFFECTS.absolutePath(), "welcome-back.wav"
        ));
    }

}