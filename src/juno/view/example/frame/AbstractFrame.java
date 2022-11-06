package juno.view.example.frame;

import javax.swing.JFrame;
import java.awt.Component;

public abstract class AbstractFrame extends JFrame {

    private Component component;

    public void setPanel(Component component) {
        this.component = component;
    }

    public void init() {
        if(component == null) {
            throw new IllegalArgumentException("Component is not set");
        }
        this.add(component);
    }
}
