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

import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public abstract class AbstractAudioPlayer
        implements MuteableAudioPlayer, ActionListener {

    // The timer.
    private Timer timer;

    // The clip object.
    private Clip clip;

    // The clip float control.
    private FloatControl floatControl;

    // The mute boolean value.
    private boolean mute = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        clip.stop();
        clip.setMicrosecondPosition(0);
    }

    @Override
    public void play() {
        if(!mute) {
            timer.start();
            clip.start();
        }
    }

    @Override
    public void mute() {
        if(!mute) {
            mute = true;
            floatControl.setValue(-80);
        }
    }

    @Override
    public void unmute() {
        if(mute) {
            mute = false;
            floatControl.setValue(0);
        }
    }

    @Override
    public boolean isMuted() {
        return mute;
    }

    /**
     * Returns the timer of this object.
     * @return A Timer object.
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * Returns the clip of this object.
     * @return A Clip object.
     */
    public Clip getClip() {
        return clip;
    }

    /**
     * Loads the specified audio track represented by
     * the specified File object.
     * @param track A File object.
     */
    public void load(@NotNull File track) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(track);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Volume control.
            floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            if(mute) floatControl.setValue(-80);

            // The timer.
            timer = new Timer(0, this);
            timer.setInitialDelay((int) clip.getMicrosecondLength() / 1000);
            timer.setRepeats(false);
        } catch (LineUnavailableException e) {
            throw new RuntimeException("Line not available: " + e);
        } catch (IOException e) {
            throw new RuntimeException("IO error: " + e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException("Unsupported audio file: " + e);
        }
    }

}