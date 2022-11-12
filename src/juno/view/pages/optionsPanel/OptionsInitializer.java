package juno.view.pages.optionsPanel;

import juno.view.pages.optionsPanel.menuPanel.MenuPanelConfigurator;
import juno.view.pages.optionsPanel.titlePanel.TitlePanelConfigurator;

public class OptionsInitializer {

    private OptionsInitializer() {}

    public static void initialize() {
        MenuPanelConfigurator.configure();
        TitlePanelConfigurator.configure();
        OptionsPanelConfigurator.configure();
    }
}
