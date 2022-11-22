package juno.view.pages.card;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class TopCardPanel
        extends JPanel {

    public static final String PRE_ACCESS_PANEL = "Pre access panel";
    public static final String MAIN_PANEL = "Main panel";

    private JPanel preAccessPanel;
    private JPanel mainPanel;
    private static TopCardPanel instance;

    private TopCardPanel() {}

    public static TopCardPanel getInstance() {
        if(instance == null) instance = new TopCardPanel();
        return instance;
    }

    public void init() {
        if(preAccessPanel == null) {
            throw new IllegalArgumentException("Pre access panel is null");
        } if(mainPanel == null) {
            throw new IllegalArgumentException("Main panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(preAccessPanel, PRE_ACCESS_PANEL);
        add(mainPanel, MAIN_PANEL);
    }

    public void setPreAccessPanel(@NotNull JPanel preAccessPanel) {
        this.preAccessPanel = preAccessPanel;
    }

    public void setMainPanel(@NotNull JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}