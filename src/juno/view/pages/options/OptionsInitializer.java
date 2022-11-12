package juno.view.pages.options;

import juno.view.pages.options.menu.MenuPanelConfigurator;
import juno.view.pages.options.title.TitlePanelConfigurator;

public class OptionsInitializer {

    private OptionsInitializer() {}

    public static void initialize() {
        MenuPanelConfigurator.configure();
        TitlePanelConfigurator.configure();
        OptionsPanelConfigurator.configure();
    }
}
