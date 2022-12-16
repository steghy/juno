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

package juno.view.pages.score.avatar_frame;

import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.view.awards.frames.GFrame;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Simone Gentili
 */
public class AvatarFramesPanel
        extends JPanel {

    // The List of GFrame objects.
    private final java.util.List<GFrame<InterfaceAvatarFrame>> avatarFrames;

    // The AvatarFramesPanel instance.
    private static AvatarFramesPanel instance;

    // Builds the AvatarFramesPanel instance.
    private AvatarFramesPanel() {
        avatarFrames = new ArrayList<>();
    }

    /**
     * Returns the AvatarFramesPanel instance.
     * @return The AvatarFramesPanel instance.
     */
    public static AvatarFramesPanel getInstance() {
        if(instance == null) instance = new AvatarFramesPanel();
        return instance;
    }

    /** Initialize the AvatarFramesPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new GridLayout(5, 5));
        avatarFrames.forEach(this::add);
    }

    /**
     * Adds the specified avatar frame to the
     * avatar frames List.
     * @param avatarFrame A GFrame object.
     */
    public void addAvatarFrame(@NotNull GFrame<InterfaceAvatarFrame> avatarFrame) {
        avatarFrames.add(avatarFrame);
    }

    /**
     * Returns the avatar frames.
     * @return A List object.
     */
    public java.util.List<GFrame<InterfaceAvatarFrame>> getAvatarFrames() {
        return avatarFrames;
    }

}