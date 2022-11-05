package juno.view.mainpage.west;

import juno.view.util.PanelConfigurator;

import java.awt.*;

public class WestPanelConfigurator {

    private WestPanelConfigurator() {}

    public static void configure() {
        WestPanel westPanel = WestPanel.getInstance();

        PanelConfigurator.configure(westPanel, new Dimension(0,0));
    }
}
