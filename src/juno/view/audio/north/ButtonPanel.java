package juno.view.audio.north;

import javax.swing.*;
import java.awt.*;

/**
 * @author steghy
 * @email steghy.github@proton.me
 */
public class ButtonPanel extends JPanel {

    private JButton button;

    public ButtonPanel(){
       init();
    }


    public void setIcon(Icon icon){
        if(icon instanceof ImageIcon){
            Image scaledImage = ((ImageIcon)icon).getImage()
                    .getScaledInstance(this.getWidth(), this.getHeight(), 0);
            button.setIcon(new ImageIcon(scaledImage));
        }
    }

    /* Initialize the ButtonPanel object */
    private void init(){

        // BUTTON SETTING
        this.button = new JButton();
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setFocusPainted(false);

        // PANEL DIMENSION
        Dimension dimension = new Dimension(75, 75);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);


        // PANERL SETTING
        this.setOpaque(false);

        // ALIGNMENT
        this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        this.setAlignmentY(JPanel.CENTER_ALIGNMENT);

        // ADD COMPONENT
        this.add(button);
    }
}
