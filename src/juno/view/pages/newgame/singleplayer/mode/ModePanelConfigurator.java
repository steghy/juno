package juno.view.pages.newgame.singleplayer.mode;

import juno.view.pages.newgame.singleplayer.mode.menu.MenuPanel;
import juno.view.pages.newgame.singleplayer.mode.title.TitlePanel;

public class ModePanelConfigurator {

    private ModePanelConfigurator() {}

    public static void configure() {
        // MAIN-COMPONENT
        ModePanel modePanel = ModePanel.getInstance();

        // SUB-COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENTS
        modePanel.setTitlePanel(titlePanel);
        modePanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        modePanel.init();
    }
}