package juno.view.pages.preaccess.welcome.menu;

import juno.controller.ExitAction;
import juno.model.data.io.output.ExitManager;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
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
        AbstractButton createAnAccountButton = ButtonFactory.createButton(ButtonLibrary.CREATE_AN_ACCOUNT);
        AbstractButton continueWithoutAnAccountButton = ButtonFactory.createButton(ButtonLibrary.CONTINUE_WITHOUT_AN_ACCOUNT);
        AbstractButton exitButton = ButtonFactory.createButton(ButtonLibrary.EXIT);

        // RESIZE IMAGES
        ImageResizer.resize(createAnAccountButton, 3.0);
        ImageResizer.resize(continueWithoutAnAccountButton, 3.0);
        ImageResizer.resize(exitButton, 3.0);

        // ADDING COMPONENTS
        menuPanel.setCreateAnAccountButton(createAnAccountButton);
        menuPanel.setContinueWithoutAnAccountButton(continueWithoutAnAccountButton);
        menuPanel.setExitButton(exitButton);

        // ACTION LISTENERS
        createAnAccountButton.addActionListener(listener -> {
            RegistrationPanel.getInstance().setFromWelcomePanel(true);
            LayoutManager layoutManager = PreAccessCardPanel.getInstance().getLayout();
            if(layoutManager instanceof CardLayout cardLayout) {
                cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.REGISTRATION_PANEL);
            } else {
                throw new IllegalArgumentException("Invalid layout type (" + layoutManager.getClass() +")");
            }
        });
        continueWithoutAnAccountButton.addActionListener(null);
        exitButton.addActionListener(new ExitAction(ExitManager.getInstance()));

        // BORDER SETTINGS
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // INITIALIZATION
        menuPanel.init();
    }
}
