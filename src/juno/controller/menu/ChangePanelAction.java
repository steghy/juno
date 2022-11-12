package juno.controller.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChangePanelAction extends AbstractAction {

    private JPanel cardPanel;
    private String panel;

    public ChangePanelAction(JPanel cardPanel, String panel) {
        this.cardPanel = cardPanel;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LayoutManager layoutManager = cardPanel.getLayout();
        if(layoutManager instanceof CardLayout cardLayout) {
            cardLayout.show(cardPanel, panel);
        } else {
            throw new IllegalArgumentException("Invalid JPanel");
        }
    }
}
