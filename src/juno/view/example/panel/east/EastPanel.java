package juno.view.example.panel.east;

import javax.swing.*;
import java.awt.*;

public class EastPanel extends JPanel {

    private static EastPanel instance;

    private EastPanel() {
        init();
    }

    public static EastPanel getInstance() {
        if(instance == null) {
            instance = new EastPanel();
        } return instance;
    }

    private void init(){
        this.setOpaque(false);
        JLabel eastLabel = new JLabel();
        eastLabel.setOpaque(false);
        eastLabel.setPreferredSize(new Dimension(300,0));

        this.add(eastLabel);
    }
}
