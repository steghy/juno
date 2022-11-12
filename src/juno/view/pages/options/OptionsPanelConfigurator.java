package juno.view.pages.options;

import juno.view.pages.options.menu.MenuPanel;
import juno.view.pages.options.title.TitlePanel;

import javax.swing.*;

public class OptionsPanelConfigurator {

    private OptionsPanelConfigurator() {}

    public static void configure() {
        OptionsPanel optionsPanel = OptionsPanel.getInstance();

        JPanel titlePanel = TitlePanel.getInstance();
        JPanel menuPanel = MenuPanel.getInstance();

        optionsPanel.setTitlePanel(titlePanel);
        optionsPanel.setMenuPanel(menuPanel);

        optionsPanel.init();
    }
}
