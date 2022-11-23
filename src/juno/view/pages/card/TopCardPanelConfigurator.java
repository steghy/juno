package juno.view.pages.card;

import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.preaccess.card.PreAccessCardPanel;

public class TopCardPanelConfigurator {

    private TopCardPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        TopCardPanel topCardPanel = TopCardPanel.getInstance();

        // SUB COMPONENTS
        PreAccessCardPanel preAccessCardPanel = PreAccessCardPanel.getInstance();
        MainCardPanel mainCardPanel = MainCardPanel.getInstance();

        // ADDING COMPONENTS
        topCardPanel.setPreAccessPanel(preAccessCardPanel);
        topCardPanel.setMainPanel(mainCardPanel);

        // INITIALIZATION
        topCardPanel.init();
    }
}