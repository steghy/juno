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

package juno.view.pages.pre_access.registration.menu;

import juno.controller.InterfaceRegistrationDataProvider;
import juno.model.data.profile.Profile;
import juno.view.pages.AbstractTenthComponent;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class MenuPanel
        extends AbstractTenthComponent
        implements InterfaceRegistrationDataProvider {

    // The MenuPanel instance.
    private static MenuPanel instance;

    // Builds the MenuPanel instance.
    private MenuPanel() {}

    /**
     * Returns the MenuPanel instance.
     * @return The MenuPanel instance.
     */
    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    @Override
    public Map<String, Object> provideRegistrationData() {
        Map<String, Object> map = new HashMap<>();

        // Profile name case.
        map.put(Profile.PROFILE_NAME, ((JTextField) Objects.requireNonNull(getFifthComponent())).getText());

        // Name case.
        JTextField nameTextField = (JTextField) getSixthComponent();
        if(Objects.requireNonNull(nameTextField).getText().length() > 0)
            map.put(Profile.NAME, nameTextField.getText());

        // Last name case.
        JTextField lastNameTextField = (JTextField) getSeventhComponent();
        if(Objects.requireNonNull(lastNameTextField).getText().length() > 0)
            map.put(Profile.LAST_NAME, lastNameTextField.getText());

        // Age case.
        String temp = ((JTextField) Objects.requireNonNull(getEighthComponent())).getText();
        if(temp.length() > 0) {
            int age;
            try {
                age = Integer.parseInt(temp);
                map.put(Profile.AGE, age);
            } catch (ClassCastException e) {
                map.put(Profile.AGE, temp);
            }
        } return map;
    }

    /** Initialize the MenuPanel instance. */
    public void init() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Profile name label.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getFirstComponent()), gbc);

        // Name label.
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getSecondComponent()), gbc);

        // Last name label.
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getThirdComponent()), gbc);

        // Age label.
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getFourthComponent()), gbc);

        // Profile name text field.
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getFifthComponent()), gbc);

        // Name text field.
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getSixthComponent()), gbc);

        // Last name text field.
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getSeventhComponent()), gbc);

        // Age text field.
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getEighthComponent()), gbc);

        // Confirm button.
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getNinthComponent()), gbc);

        // Back button.
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        this.add(Objects.requireNonNull(getTenthComponent()), gbc);

    }

    /**
     * Returns the text fields of this object.
     * @return A List object.
     */
    public java.util.List<Component> getTextFields() {
        return java.util.List.of(
                Objects.requireNonNull(getFifthComponent()),
                Objects.requireNonNull(getSixthComponent()),
                Objects.requireNonNull(getSeventhComponent()),
                Objects.requireNonNull(getEighthComponent()));
    }

}