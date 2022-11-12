package juno.view.pages.newgame.menu.multiplayer.unavailable;

import juno.view.pages.newgame.menu.multiplayer.unavailable.menu.MenuPanel;
import juno.view.pages.newgame.menu.multiplayer.unavailable.title.TitlePanel;

public class UnavailableServicePanelConfigurator {

    private UnavailableServicePanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        UnavailableServicePanel unavailableServicePanel = UnavailableServicePanel.getInstance();

        // SUB-COMPONENT
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENTS
        unavailableServicePanel.setTitlePanel(titlePanel);
        unavailableServicePanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        unavailableServicePanel.init();
    }
}