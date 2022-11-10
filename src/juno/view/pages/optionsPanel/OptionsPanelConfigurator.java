package juno.view.pages.optionsPanel;

import juno.view.pages.optionsPanel.menuPanel.MenuPanel;
import juno.view.pages.optionsPanel.titlePanel.TitlePanel;

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
