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

    }
}
