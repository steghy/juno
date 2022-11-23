package juno.view.pages.options;

import juno.view.pages.options.menu.MenuPanelConfigurator;
import juno.view.pages.options.title.TitlePanelConfigurator;

public class OptionsInitializer {

    private OptionsInitializer() {}

    public static void initialize() {
        // SUB COMPONENTS
        MenuPanelConfigurator.configure();
        TitlePanelConfigurator.configure();

        // MAIN COMPONENT
        OptionsPanelConfigurator.configure();
    }
}