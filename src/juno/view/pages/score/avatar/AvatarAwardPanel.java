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

package juno.view.pages.score.avatar;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines the avatar awards panel.
 * @author Simone Gentili
 */
public class AvatarAwardPanel
        extends JPanel {

    // The 'left' insects parameter.
    private final int leftInsectsParameter;

    // The grid bag constraints.
    private final GridBagConstraints gbc;

    /** Builds an AvatarAwardPanel instance. */
    public AvatarAwardPanel() {
        gbc = new GridBagConstraints();
        leftInsectsParameter = 90;
        setOpaque(false);
        setLayout(new GridBagLayout());
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.ipadx = 0;
        gbc.ipady = 0;
    }

    /**
     * Adds a Component object to this object.
     * @param c A Component.
     */
    public void addComponent(@NotNull Component c) {
        if(getComponents().length == 0) gbc.insets = new Insets(0,  0, 0, 0);
        else gbc.insets = new Insets(0, gbc.insets.left + leftInsectsParameter, 0, 0);
        super.add(c, gbc);
        revalidate();
        repaint();
    }

}