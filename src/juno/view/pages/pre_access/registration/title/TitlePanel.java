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

package juno.view.pages.pre_access.registration.title;

import juno.view.panels.AbstractFirstComponent;

import java.awt.*;
import java.util.Objects;

/**
 * This class defines a title panel.
 * @author Simone Gentili
 */
public class TitlePanel
        extends AbstractFirstComponent {

    // The TitlePanel instance.
    private static TitlePanel instance;

    // Builds the TitlePanel instance.
    private TitlePanel() {}

    /**
     * Returns the TitlePanel instance.
     * @return The TitlePanel instance.
     */
    public static TitlePanel getInstance() {
        if(instance == null) instance = new TitlePanel();
        return instance;
    }

    /** Initialize the TitlePanel instnace. */
    public void init() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Title panel.
        gbc.gridwidth = 0;
        gbc.gridheight = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        this.add(Objects.requireNonNull(getFirstComponent()), gbc);
    }

}