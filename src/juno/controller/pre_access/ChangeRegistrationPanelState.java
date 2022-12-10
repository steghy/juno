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

package juno.controller.pre_access;

import juno.model.data.profile.Profile;
import juno.view.pages.pre_access.registration.menu.MenuPanel;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Map;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ChangeRegistrationPanelState {

    // The ChangeRegistrationPanelState instance.
    private static ChangeRegistrationPanelState instance;

    // Builds the ChangeRegistrationPanel instance.
    private ChangeRegistrationPanelState() {}

    /**
     * Returns the ChangeRegistrationPanelState instance.
     * @return The ChangeRegistrationPanelState instance.
     */
    public static ChangeRegistrationPanelState getInstance() {
        if(instance == null) instance = new ChangeRegistrationPanelState();
        return instance;
    }

    public void changeState() {
        Map<String, String> errors = Profile.getInstance().getErrors();
        if(errors.isEmpty()) throw new IllegalArgumentException("Nothing to change.");
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Cleaning the borders.
        menuPanel.getTextFields().forEach(textField -> {
            ((JTextField) textField).setBorder(null);
        });

        Border border = BorderFactory.createLineBorder(Color.RED);
        errors.forEach((k, v) -> {
            JTextField textField;
            switch (k) {
                case (Profile.PROFILE_NAME) -> {
                    textField = (JTextField) menuPanel.getFifthComponent();
                    Objects.requireNonNull(textField).setText("");
                    textField.setBorder(BorderFactory.createTitledBorder(border, v));
                }
                case (Profile.NAME) -> {
                    textField = (JTextField) menuPanel.getSixComponent();
                    Objects.requireNonNull(textField).setText("");
                    textField.setBorder(BorderFactory.createTitledBorder(border, v));
                }
                case (Profile.LAST_NAME) -> {
                    textField = (JTextField) menuPanel.getSevenComponent();
                    Objects.requireNonNull(textField).setText("");
                    textField.setBorder(BorderFactory.createTitledBorder(border, v));
                }
                case (Profile.AGE) -> {
                    textField = (JTextField) menuPanel.getEightComponent();
                    Objects.requireNonNull(textField).setText("");
                    textField.setBorder(BorderFactory.createTitledBorder(border, v));
                }
            }
        });
    }

}