package juno.view.pages.options;

import juno.view.pages.options.menu.MenuPanel;
import juno.view.pages.options.title.TitlePanel;

import javax.swing.*;

public class OptionsPanelConfigurator {

    private OptionsPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        OptionsPanel optionsPanel = OptionsPanel.getInstance();

        // SUB COMPONENTS
        JPanel titlePanel = TitlePanel.getInstance();
        JPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENTS
        optionsPanel.setTitlePanel(titlePanel);
        optionsPanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        optionsPanel.init();
    }
}