package juno.view.pages;

import juno.view.pages.main.center.CenterPanelConfigurator;
import juno.view.pages.main.east.EastPanelConfigurator;
import juno.view.pages.main.north.NorthPanelConfigurator;
import juno.view.pages.main.south.SouthPanelConfigurator;
import juno.view.pages.main.west.WestPanelConfigurator;

public class MainPageFullConfigurator {

    private MainPageFullConfigurator() {}

    public static void configure() {
        CenterPanelConfigurator.configure();
        NorthPanelConfigurator.configure();
        EastPanelConfigurator.configure();
        WestPanelConfigurator.configure();
        SouthPanelConfigurator.configure();
        MainPageConfigurator.configure();
    }
}
