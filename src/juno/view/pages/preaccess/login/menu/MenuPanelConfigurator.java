package juno.view.pages.preaccess.login.menu;

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

        // RESIZE IMAGES

        // ADDING COMPONENTS

        // ACTION LISTENERS

        // BORDER SETTINGS
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // INITIALIZATION
        // menuPanel.init();
    }
}
