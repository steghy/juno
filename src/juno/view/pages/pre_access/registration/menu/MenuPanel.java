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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class MenuPanel
        extends JPanel
        implements InterfaceRegistrationDataProvider {

    private JLabel profileNameLabel;
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel ageLabel;

    private JTextField profileNameTextField;
    private JTextField nameTextField;
    private JTextField lastNameTextField;
    private JTextField ageTextField;

    private AbstractButton confirmButton;
    private AbstractButton backButton;

    private boolean init;

    // The MenuPanel instance.
    private static MenuPanel instance;

    // Builds the MenuPanel instance.
    private MenuPanel() {
        init = false;
    }

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
        if(init) {
            Map<String, Object> map = new HashMap<>();

            // Profile name case.
            map.put(Profile.PROFILE_NAME, profileNameTextField.getText());

            // Name case.
            if(nameTextField.getText().length() > 0)
                map.put(Profile.NAME, nameTextField.getText());

            // Last name case.
            if(lastNameTextField.getText().length() > 0)
                map.put(Profile.LAST_NAME, lastNameTextField.getText());

            // Age case.
            String temp = ageTextField.getText();
            if(temp.length() > 0) {
                int age;
                try {
                    age = Integer.parseInt(temp);
                    map.put(Profile.AGE, age);
                } catch (ClassCastException e) {
                    map.put(Profile.AGE, temp);
                }
            } return map;
        } else throw new IllegalArgumentException("Not initialized");
    }

    public void init() {
        // Labels.
        if(profileNameLabel == null) throw new IllegalArgumentException("User name label is null");
        if(nameLabel == null) throw new IllegalArgumentException("Name label is null");
        if(lastNameLabel == null) throw new IllegalArgumentException("Last name label is null");
        if(ageLabel == null) throw new IllegalArgumentException("Age label is null");

        // Text fields.
        if(profileNameTextField == null) throw new IllegalArgumentException("User name text field is null");
        if(nameTextField == null) throw new IllegalArgumentException("Name text field is null");
        if(lastNameTextField == null) throw new IllegalArgumentException("Last name text field is null");
        if(ageTextField == null) throw new IllegalArgumentException("Age text field is null");

        // Buttons.
        if(confirmButton == null) throw new IllegalArgumentException("Confirm button is null");
        if(backButton == null)throw new IllegalArgumentException("Back button is null");

        init = true;

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

        this.add(profileNameLabel, gbc);

        // Name label.
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,5,0);

        this.add(nameLabel, gbc);

        // Last name label.
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,5,0);

        this.add(lastNameLabel, gbc);

        // Age label.
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,5,0);

        this.add(ageLabel, gbc);

        // Profile name text field.
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,5,0);

        this.add(profileNameTextField, gbc);

        // Name text field.
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,5,0);

        this.add(nameTextField, gbc);

        // Last name text field.
        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,5,0);

        this.add(lastNameTextField, gbc);

        // Age text field.
        gbc.gridx = 1;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,5,0);

        this.add(ageTextField, gbc);

        // Back button.
        gbc.gridx = 0;
        gbc.gridy = 4;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(backButton, gbc);

        // Confirm button.
        gbc.gridx = 1;
        gbc.gridy = 4;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(confirmButton, gbc);
    }

    /**
     * Sets the profile name label of this object.
     * @param userNameLabel A JLabel object
     */
    public void setProfileNameLabel(@NotNull JLabel userNameLabel) {
        this.profileNameLabel = userNameLabel;
    }

    /**
     * Sets the name label of this object.
     * @param nameLabel A JLabel object.
     */
    public void setNameLabel(@NotNull JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * Sets the last name label of this object.
     * @param lastNameLabel A JLabel object.
     */
    public void setLastNameLabel(@NotNull JLabel lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
    }

    /**
     * Sets the last name label of this object.
     * @param ageLabel A JLabel text field.
     */
    public void setAgeLabel(@NotNull JLabel ageLabel) {
        this.ageLabel = ageLabel;
    }

    /**
     * Sets the profile name text field of this object.
     * @param profileNameTextField A JTextField object.
     */
    public void setProfileNameTextField(@NotNull JTextField profileNameTextField) {
        this.profileNameTextField = profileNameTextField;
    }

    /**
     * Sets the name text field of this object.
     * @param nameTextField A JTextField object.
     */
    public void setNameTextField(@NotNull JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    /**
     * Sets the last name text field of this object.
     * @param lastNameTextField A JTextField object.
     */
    public void setLastNameTextField(@NotNull JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    /**
     * Sets the age text field of this object.
     * @param ageTextField A JTextField object.
     */
    public void setAgeTextField(@NotNull JTextField ageTextField) {
        this.ageTextField = ageTextField;
    }

    /**
     * Sets the confirm button of this object.
     * @param confirmButton An AbstractButton object.
     */
    public void setConfirmButton(@NotNull AbstractButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    /**
     * Sets the back button of this object.
     * @param backButton An AbstractButton object.
     */
    public void setBackButton(@NotNull AbstractButton backButton) {
        this.backButton = backButton;
    }

    /**
     * Returns the profile name label of this object.
     * @return A JLabel object.
     */
    @Nullable
    public JLabel getProfileNameLabel() {
        return profileNameLabel;
    }

    /**
     * Returns the name label of this object.
     * @return A JLabel object.
     */
    @Nullable
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * Returns the last name label of this object.
     * @return A JLabel object.
     */
    @Nullable
    public JLabel getLastNameLabel() {
        return lastNameLabel;
    }

    /**
     * Returns the age label of this object.
     * @return A JLabel object
     */
    @Nullable
    public JLabel getAgeLabel() {
        return ageLabel;
    }

    /**
     * Returns the profile name text field of this object.
     * @return A JTextField object.
     */
    @Nullable
    public JTextField getProfileNameTextField() {
        return profileNameTextField;
    }

    /**
     * Returns the name text field of this object.
     * @return A JTextField object.
     */
    @Nullable
    public JTextField getNameTextField() {
        return nameTextField;
    }

    /**
     * Returns the last name text field of this object.
     * @return A JTextField object.
     */
    @Nullable
    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    /**
     * Returns the age text field of this object.
     * @return A JTextField object
     */
    @Nullable
    public JTextField getAgeTextField() {
        return ageTextField;
    }

    /**
     * Returns the confirm button of this object.
     * @return An AbstractButton object.
     */
    @Nullable
    public AbstractButton getConfirmButton() {
        return confirmButton;
    }

    /**
     * Returns the back button of this object.
     * @return An AbstractButton object.
     */
    @Nullable
    public AbstractButton getBackButton() {
        return backButton;
    }

    /**
     * Returns the text fields of this object.
     * @return A List object.
     */
    public java.util.List<JTextField> getTextFields() {
        return java.util.List.of(
                profileNameTextField,
                nameTextField,
                lastNameTextField,
                ageTextField);
    }

    /**
     * Returns the labels of this object.
     * @return A List object.
     */
    public java.util.List<JLabel> getLabels() {
        return java.util.List.of(
                profileNameLabel,
                nameLabel,
                lastNameLabel,
                ageLabel);
    }

}