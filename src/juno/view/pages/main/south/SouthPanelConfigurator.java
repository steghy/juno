package juno.view.pages.main.south;

import juno.view.util.PanelConfigurator;

import java.awt.*;

public class SouthPanelConfigurator {

    private SouthPanelConfigurator() {}

    public static void configure() {
        SouthPanel southPanel = SouthPanel.getInstance();

        PanelConfigurator.configure(southPanel, new Dimension(0,0));
    }
}
