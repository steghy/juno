package juno.view.audio.panel;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button(){
       init();
    }


    public void setIcon(Icon icon){
        if(icon instanceof ImageIcon){
            Image scaledImage = ((ImageIcon)icon).getImage()
                    .getScaledInstance(this.getWidth(), this.getHeight(), 0);
            super.setIcon(new ImageIcon(scaledImage));
        }
    }

    private void init(){

        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setFocusPainted(false);

        Dimension dimension = new Dimension(50, 50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);

        this.setOpaque(false);
    }
}
