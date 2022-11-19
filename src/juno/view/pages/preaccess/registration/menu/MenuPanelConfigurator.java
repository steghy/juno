package juno.view.pages.preaccess.registration.menu;

import juno.controller.ChangePanelAction;
import juno.controller.SendRegistrationDataAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.preaccess.card.PreAccessCardPanel;
import juno.view.pages.preaccess.registration.RegistrationPanel;
import juno.view.util.ImageResizer;
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
        JLabel ageLabel = new JLabel("age:");
        // [ TEXT FIELDS ]
        JTextField userNameTextField = new JTextField(15);
        JTextField nameTextField = new JTextField(15);
        JTextField lastNameTextField = new JTextField(15);
        JTextField ageTextField = new JTextField(15);
        // [ BUTTONS ]
        AbstractButton confirmButton = ButtonFactory.createButton(ButtonLibrary.CONFIRM);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // ADDING COMPONENTS
        // [ LABELS ]
        menuPanel.setUserNameLabel(userNameLabel);
        menuPanel.setNameLabel(nameLabel);
        menuPanel.setLastNameLabel(lastNameLabel);
        menuPanel.setAgeLabel(ageLabel);
        // [ TEXT FIELDS ]
        menuPanel.setUserNameTextField(userNameTextField);
        menuPanel.setNameTextField(nameTextField);
        menuPanel.setLastNameTextField(lastNameTextField);
        menuPanel.setAgeTextField(ageTextField);
        // [ BUTTONS ]
        menuPanel.setConfirmButton(confirmButton);
        menuPanel.setBackButton(backButton);

        // RESIZE IMAGES
        ImageResizer.resize(confirmButton, 3.0);
        ImageResizer.resize(backButton, 3.0);

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
