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

package juno.view.pages.score.avatar_images_panel;

import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.view.gobject.avatars.GAvatarImage;
import juno.view.util.ImageResizer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Simone Gentili
 */
public class AvatarImagesPanel
        extends JPanel {

    // List of GAvatarImage objects.
    private final java.util.List<GAvatarImage<InterfaceAvatarImage>> gAvatarImages;

    // The AvatarImagesPanel instance.
    private static AvatarImagesPanel instance;

    // Builds the AvatarImagesPanel instance.
    private AvatarImagesPanel() {
        gAvatarImages = new ArrayList<>();
    }

    /**
     * Returns the AvatarImagesPanel instance.
     * @return The AvatarImagesPanel instance.
     */
    public static AvatarImagesPanel getInstance() {
        if(instance == null) instance = new AvatarImagesPanel();
        return instance;
    }

    /** Initialize the AvatarImagesPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new GridLayout(1, 1));
        gAvatarImages.forEach(this::add);
    }

    /**
     * Returns the graphic avatar images List of this object.
     * @return A List object.
     */
    public java.util.List<GAvatarImage<InterfaceAvatarImage>> gAvatarImages() {
        return gAvatarImages;
    }

}