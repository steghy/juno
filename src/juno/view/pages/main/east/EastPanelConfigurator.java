package juno.view.pages.main.east;

import juno.view.util.PanelConfigurator;

import java.awt.*;

public class EastPanelConfigurator {

    private EastPanelConfigurator() {}

    public static void configure() {
        EastPanel eastPanel = EastPanel.getInstance();

        // PANEL CONFIGURATION
        PanelConfigurator.configure(eastPanel, new Dimension(0,0));
    }
}
