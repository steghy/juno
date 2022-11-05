package juno.view.mainpage;

import juno.view.mainpage.center.CenterPanelConfigurator;
import juno.view.mainpage.east.EastPanelConfigurator;
import juno.view.mainpage.north.NorthPanelConfigurator;
import juno.view.mainpage.south.SouthPanelConfigurator;
import juno.view.mainpage.west.WestPanelConfigurator;

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
