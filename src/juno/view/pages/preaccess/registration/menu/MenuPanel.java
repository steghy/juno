package juno.view.pages.preaccess.registration.menu;

import juno.controller.AbstractDataProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MenuPanel extends JPanel implements AbstractDataProvider<String, String> {

    private JLabel userNameLabel;
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JLabel countryLabel;
    private JLabel cellphoneLabel;
    private JLabel password1Label;
    private JLabel password2Label;

    private JTextField userNameTextField;
    private JTextField nameTextField;
    private JTextField lastNameTextField;
    private JTextField emailTextField;
    private JTextField countryTextField;
    private JTextField cellphoneTextField;
    private JTextField password1TextField;
    private JTextField password2TextField;

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
        } if(emailLabel == null) {
            throw new IllegalArgumentException("Email label is null");
        } if(countryLabel == null) {
            throw new IllegalArgumentException("Country label is null");
        } if(cellphoneLabel == null) {
            throw new IllegalArgumentException("Cellphone label is null");
        } if(password1Label == null) {
            throw new IllegalArgumentException("Password 1 label is null");
        } if(password2Label == null) {
            throw new IllegalArgumentException("Password 2 label is null");
        }

        // TEXT FIELDS
        if(userNameTextField == null) {
            throw new IllegalArgumentException("User name text field is null");
        } if(nameTextField == null) {
            throw new IllegalArgumentException("Name text field is null");
        } if(lastNameTextField == null) {
            throw new IllegalArgumentException("Last name text field is null");
        } if(emailTextField == null) {
            throw new IllegalArgumentException("Email text field is null");
        } if(countryTextField == null) {
            throw new IllegalArgumentException("Country text field is null");
        } if(cellphoneTextField == null) {
            throw new IllegalArgumentException("Cellphone text field is null");
        } if(password1TextField == null) {
            throw new IllegalArgumentException("Password 1 text field is null");
        } if(password2TextField == null) {
            throw new IllegalArgumentException("Password 2 text field is null");
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

        // EMAIL LABEL
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(emailLabel, gbc);

        // COUNTRY LABEL
        gbc.gridx = 0;
        gbc.gridy = 4;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(countryLabel, gbc);

        // CELLPHONE LABEL
        gbc.gridx = 0;
        gbc.gridy = 5;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(cellphoneLabel, gbc);

        // PASSWORD 1 LABEL
        gbc.gridx = 0;
        gbc.gridy = 6;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(password1Label, gbc);

        // PASSWORD 2 LABEL
        gbc.gridx = 0;
        gbc.gridy = 7;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(password2Label, gbc);

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

        // EMAIL TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(emailTextField, gbc);

        // COUNTRY TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 4;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(countryTextField, gbc);

        // CELLPHONE TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 5;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(cellphoneTextField, gbc);

        // PASSWORD 1 TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 6;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(password1TextField, gbc);

        // PASSWORD 2 TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 7;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(password2TextField, gbc);
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

    public void setEmailLabel(@NotNull JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public void setCountryLabel(@NotNull JLabel countryLabel ) {
        this.countryLabel = countryLabel;
    }

    public void setCellphoneLabel(@NotNull JLabel cellphoneLabel ) {
        this.cellphoneLabel = cellphoneLabel;
    }

    public void setPassword1Label(@NotNull JLabel password1Label) {
        this.password1Label = password1Label;
    }

    public void setPassword2Label(@NotNull JLabel password2Label) {
        this.password2Label = password2Label;
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

    public void setEmailTextField(@NotNull JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public void setCountryTextField(@NotNull JTextField countryTextField) {
        this.countryTextField = countryTextField;
    }

    public void setCellphoneTextField(@NotNull JTextField cellphoneTextField) {
        this.cellphoneTextField = cellphoneTextField;
    }

    public void setPassword1TextField(@NotNull JTextField password1TextField) {
        this.password1TextField = password1TextField;
    }

    public void setPassword2TextField(@NotNull JTextField password2TextField) {
        this.password2TextField = password2TextField;
    }

    public void setConfirmButton(@NotNull AbstractButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public void setBackButton(@NotNull AbstractButton backButton) {
        this.backButton = backButton;
    }

    public JLabel getUserNameLabel() {
        return userNameLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getLastNameLabel() {
        return lastNameLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JLabel getCountryLabel() {
        return countryLabel;
    }

    public JLabel getCellphoneLabel() {
        return cellphoneLabel;
    }

    public JLabel getPassword1Label() {
        return password1Label;
    }

    public JLabel getPassword2Label() {
        return password2Label;
    }

    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JTextField getCountryTextField() {
        return countryTextField;
    }

    public JTextField getCellphoneTextField() {
        return cellphoneTextField;
    }

    public JTextField getPassword1TextField() {
        return password1TextField;
    }

    public JTextField getPassword2TextField() {
        return password2TextField;
    }

    public AbstractButton getConfirmButton() {
        return confirmButton;
    }

    public AbstractButton getBackButton() {
        return backButton;
    }

    @Override
    public Map<String, String> getData() {
        if(init) {
            Map<String, String> map = new HashMap<>();
            map.put("username", userNameTextField.getText());
            map.put("name", nameTextField.getText());
            map.put("last name", lastNameTextField.getText());
            map.put("email", emailTextField.getText());
            map.put("country", countryTextField.getText());
            map.put("cellphone", cellphoneTextField.getText());
            map.put("password1", password1TextField.getText());
            map.put("password2", password2TextField.getText());
            return map;
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }
}