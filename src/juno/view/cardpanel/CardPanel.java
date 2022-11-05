package juno.view.cardpanel;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    public static final String MAIN_PAGE = "main-page";
    public static final String NEW_GAME_PAGE = "new-game-page";
    public static final String SCORE_PAGE = "score-page";
    public static final String OPTIONS_PAGE = "options-page";

    private JPanel mainPage;
    private JPanel newGamePage;
    private JPanel scorePage;
    private JPanel optionsPage;
    private static CardPanel instance;

    private CardPanel() {}

    public static CardPanel getInstance() {
        if(instance == null) {
            instance = new CardPanel();
        } return instance;
    }

    public void init() {
        if(mainPage == null) {
            throw new IllegalArgumentException("Main page isn't set");
        } if(newGamePage == null) {
            throw new IllegalArgumentException("New game page isn't set");
        } if(scorePage == null) {
            throw new IllegalArgumentException("Score page isn't set");
        } if(optionsPage == null) {
            throw new IllegalArgumentException("Options page isn't set");
        }
        CardLayout cardLayout = new CardLayout();
        cardLayout.first(mainPage);
        this.setLayout(cardLayout);
        this.add(mainPage, MAIN_PAGE);
        this.add(newGamePage, NEW_GAME_PAGE);
        this.add(scorePage, SCORE_PAGE);
        this.add(optionsPage, OPTIONS_PAGE);
    }
}
