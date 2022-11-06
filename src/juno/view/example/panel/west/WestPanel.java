package juno.view.example.panel.west;

import juno.view.example.panel.AbstractPanel;

public class WestPanel extends AbstractPanel {

    private static WestPanel instance;

    private WestPanel() {}

    public static WestPanel getInstance() {
        if(instance == null) {
            instance = new WestPanel();
        } return instance;
    }
}
