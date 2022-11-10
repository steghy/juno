package juno.init;

import juno.view.frame.CardPanelConfigurator;
import juno.view.frame.FrameConfigurator;
import juno.view.logo.LogoPanelConfigurator;
import juno.view.pages.mainPanel.MainPanelConfigurator;
import juno.view.pages.optionsPanel.OptionsPanelConfigurator;
import juno.view.pages.optionsPanel.menuPanel.MenuPanelConfigurator;
import juno.view.pages.optionsPanel.titlePanel.TitlePanelConfigurator;

public class ViewInitializer {

    private ViewInitializer() {}

    public static void initialize() {
        // MAIN PANEL
        LogoPanelConfigurator.configure();
        juno.view.pages.mainPanel.menuPanel.MenuPanelConfigurator.configure();
        MainPanelConfigurator.configure();

        // OPTIONS PANEL
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();
        OptionsPanelConfigurator.configure();

        // FRAME
        CardPanelConfigurator.configure();
        FrameConfigurator.configure();
    }
}
