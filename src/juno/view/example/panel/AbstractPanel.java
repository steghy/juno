package juno.view.example.panel;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPanel extends JPanel {

    private JLabel background;
    private Component northComponent;
    private Component centerComponent;
    private Component southComponent;
    private Component westComponent;
    private Component eastComponent;

    public void setNorthComponent(Component northComponent) {
        this.northComponent = northComponent;
    }

    public void setBackground(JLabel background) {
        this.background = background;
    }

    public void setCenterComponent(Component centerComponent) {
        this.centerComponent = centerComponent;
    }

    public void setSouthComponent(Component southComponent) {
        this.southComponent = southComponent;
    }

    public void setWestComponent(Component westComponent) {
        this.westComponent = westComponent;
    }

    public void setEastComponent(Component eastComponent) {
        this.eastComponent = eastComponent;
    }

    public void init() {
        if(northComponent == null){
            throw new IllegalArgumentException("North component is not set");
        } if(centerComponent == null) {
            throw new IllegalArgumentException("Center component is not set");
        } if(southComponent == null) {
            throw new IllegalArgumentException("South component is not set");
        } if(westComponent == null) {
            throw new IllegalArgumentException("West component is not set");
        } if(eastComponent == null) {
            throw new IllegalArgumentException("East component is not set");
        }

        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        if(background != null) {
            background.setLayout(new BorderLayout());
            background.add(northComponent, BorderLayout.NORTH);
            background.add(centerComponent, BorderLayout.CENTER);
            background.add(southComponent, BorderLayout.SOUTH);
            background.add(westComponent, BorderLayout.WEST);
            background.add(eastComponent, BorderLayout.EAST);
            this.add(background);
        } else {
            this.add(northComponent, BorderLayout.NORTH);
            this.add(centerComponent, BorderLayout.CENTER);
            this.add(southComponent, BorderLayout.SOUTH);
            this.add(westComponent, BorderLayout.WEST);
            this.add(eastComponent, BorderLayout.EAST);
        }
    }
}