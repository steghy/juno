package juno.view.pages.preaccess.registration.menu;

import juno.controller.ChangePanelAction;
import juno.controller.SendRegistrationDataAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.preaccess.card.PreAccessCardPanel;
import juno.view.pages.preaccess.registration.RegistrationPanel;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MenuPanel menuPanel = MenuPanel.getInstance();

        // SUB-COMPONENTS
        // [ LABELS ]
        JLabel userNameLabel = new JLabel("username:");
        JLabel nameLabel = new JLabel("name:");
        JLabel lastNameLabel= new JLabel("last name:");
        JLabel emailLabel= new JLabel("email:");
        JLabel countryLabel = new JLabel("country:");
        JLabel cellphoneLabel = new JLabel("cellphone");
        JLabel password1Label = new JLabel("password:");
        JLabel password2Label = new JLabel("repeat password:");
        // [ TEXT FIELDS ]
        JTextField userNameTextField = new JTextField(15);
        JTextField nameTextField = new JTextField(15);
        JTextField lastNameTextField = new JTextField(15);
        JTextField emailTextField = new JTextField(15);
        JTextField countryTextField = new JTextField(15);
        JTextField cellphoneTextField = new JTextField(15);
        JTextField password1TextField = new JTextField(15);
        JTextField password2TextField = new JTextField(15);
        // [ BUTTONS ]
        AbstractButton confirmButton = ButtonFactory.createButton(ButtonLibrary.CONFIRM);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // ADDING COMPONENTS
        // [ LABELS ]
        menuPanel.setUserNameLabel(userNameLabel);
        menuPanel.setNameLabel(nameLabel);
        menuPanel.setLastNameLabel(lastNameLabel);
        menuPanel.setEmailLabel(emailLabel);
        menuPanel.setCountryLabel(countryLabel);
        menuPanel.setCellphoneLabel(cellphoneLabel);
        menuPanel.setPassword1Label(password1Label);
        menuPanel.setPassword2Label(password2Label);
        // [ TEXT FIELDS ]
        menuPanel.setUserNameTextField(userNameTextField);
        menuPanel.setNameTextField(nameTextField);
        menuPanel.setLastNameTextField(lastNameTextField);
        menuPanel.setEmailTextField(emailTextField);
        menuPanel.setCountryTextField(countryTextField);
        menuPanel.setCellphoneTextField(cellphoneTextField);
        menuPanel.setPassword1TextField(password1TextField);
        menuPanel.setPassword2TextField(password2TextField);
        // [ BUTTONS ]
        menuPanel.setConfirmButton(confirmButton);
        menuPanel.setBackButton(backButton);

        // ACTION LISTENERS
        confirmButton.addActionListener(new SendRegistrationDataAction(menuPanel));
        backButton.addActionListener(listener -> {
            LayoutManager layoutManager = PreAccessCardPanel.getInstance().getLayout();
            if(layoutManager instanceof CardLayout cardLayout) {
                if(RegistrationPanel.getInstance().isFromWelcomePanel()) {
                    cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.WELCOME_PANEL);
                } else {
                    cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.ACCESS_PANEL);
                }
            } else {
                throw new IllegalArgumentException("Invalid layout type (" + layoutManager.getClass() +")");
            }
        });


        // BORDER SETTINGS
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // INITIALIZATION
        menuPanel.init();
    }
}
