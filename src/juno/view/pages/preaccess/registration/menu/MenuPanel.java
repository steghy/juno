package juno.view.pages.preaccess.registration.menu;

import juno.controller.AbstractDataProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MenuPanel
        extends JPanel
        implements AbstractDataProvider<String, String> {

    private JLabel userNameLabel;
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel ageLabel;

    private JTextField userNameTextField;
    private JTextField nameTextField;
    private JTextField lastNameTextField;
    private JTextField ageTextField;

    private AbstractButton confirmButton;
    private AbstractButton backButton;

    private boolean init;

    private static MenuPanel instance;

    private MenuPanel() {
        init = false;
    }

    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }

    public void init() {
        // LABELS
        if(userNameLabel == null) {
            throw new IllegalArgumentException("User name label is null");
        } if(nameLabel == null) {
            throw new IllegalArgumentException("Name label is null");
        } if(lastNameLabel == null) {
            throw new IllegalArgumentException("Last name label is null");
        } if(ageLabel == null) {
            throw new IllegalArgumentException("Age label is null");
        }

        // TEXT FIELDS
        if(userNameTextField == null) {
            throw new IllegalArgumentException("User name text field is null");
        } if(nameTextField == null) {
            throw new IllegalArgumentException("Name text field is null");
        } if(lastNameTextField == null) {
            throw new IllegalArgumentException("Last name text field is null");
        } if(ageTextField == null) {
            throw new IllegalArgumentException("Age text field is null");
        }

        // BUTTONS
        if(confirmButton == null) {
            throw new IllegalArgumentException("Confirm button is null");
        } if(backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }

        init = true;

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // USER NAME LABEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(userNameLabel, gbc);

        // NAME LABEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(nameLabel, gbc);

        // LAST NAME LABEL
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(lastNameLabel, gbc);

        // AGE LABEL
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(ageLabel, gbc);

        // USER NAME TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(userNameTextField, gbc);

        // NAME TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(nameTextField, gbc);

        // LAST NAME TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(lastNameTextField, gbc);

        // AGE TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(ageTextField, gbc);

        // BACK BUTTON
        gbc.gridx = 0;
        gbc.gridy = 4;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(backButton, gbc);

        // CONFIRM BUTTON
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

    public void setUserNameLabel(@NotNull JLabel userNameLabel) {
        this.userNameLabel = userNameLabel;
    }

    public void setNameLabel(@NotNull JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public void setLastNameLabel(@NotNull JLabel lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
    }

    public void setAgeLabel(@NotNull JLabel ageLabel) {
        this.ageLabel = ageLabel;
    }

    public void setUserNameTextField(@NotNull JTextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }

    public void setNameTextField(@NotNull JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public void setLastNameTextField(@NotNull JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    public void setAgeTextField(@NotNull JTextField ageTextField) {
        this.ageTextField = ageTextField;
    }

    public void setConfirmButton(@NotNull AbstractButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public void setBackButton(@NotNull AbstractButton backButton) {
        this.backButton = backButton;
    }

    @Override
    public Map<String, String> getData() {
        if(init) {
            Map<String, String> map = new HashMap<>();
            map.put("username", userNameTextField.getText());
            map.put("name", nameTextField.getText());
            map.put("last name", lastNameTextField.getText());
            map.put("age", ageTextField.getText());
            return map;
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }
}