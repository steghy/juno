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

package juno.view.pages.pre_access.registration;

import juno.view.panels.AbstractSecondComponent;

import java.awt.*;
import java.util.Objects;

/**
 * This class defines the registration panel
 * @author Simone Gentili
 */
public class RegistrationPanel
        extends AbstractSecondComponent {

    /** From welcome panel boolean value. */
    private boolean fromWelcomePanel = false;

    // The Registration panel instance.
    private static RegistrationPanel instance;

    // Builds the registration panel instance.
    private RegistrationPanel() {}

    /**
     * Returns the RegistrationPanel instance.
     * @return The RegistrationPanel instance.
     */
    public static RegistrationPanel getInstance() {
        if(instance == null) instance = new RegistrationPanel();
        return instance;
    }

    /** Initialize the RegistrationPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Title panel.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,30,0);
        this.add(Objects.requireNonNull(getFirstComponent()), gbc);

        // Menu panel.
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        this.add(Objects.requireNonNull(getSecondComponent()), gbc);
    }

    /**
     * Sets the form welcome panel boolean value
     * of this object:
     * @param value A boolean value
     */
    public void setFromWelcomePanel(boolean value) {
        this.fromWelcomePanel = value;
    }

    /**
     * Returns true if this panel comes from
     * the welcome panel
     * @return A boolean value.
     */
    public boolean isFromWelcomePanel() {
        return fromWelcomePanel;
    }

}