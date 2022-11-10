package juno.view.frame;

import juno.view.pages.mainPanel.MainPanel;
import juno.view.pages.optionsPanel.OptionsPanel;

import javax.swing.*;

public class CardPanelConfigurator {

    private CardPanelConfigurator() {}

    public static void configure() {
        CardPanel cardPanel = CardPanel.getInstance();

        MainPanel mainPanel = MainPanel.getInstance();
        OptionsPanel optionsPanel = OptionsPanel.getInstance();

        cardPanel.setMainPanel(mainPanel);
        cardPanel.setOptionsPanel(optionsPanel);
        cardPanel.setScorePanel(new JPanel());
        cardPanel.setNewGamePanel(new JPanel());

        cardPanel.init();
    }
}
