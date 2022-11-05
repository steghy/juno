package juno.view.topframe;

import javax.swing.*;

public class Frame extends JFrame {

    private JPanel mainPage;

    private static Frame instance;

    private Frame() {}

    public static Frame getInstance() {
        if(instance == null) {
            instance = new Frame();
        } return instance;
    }

    public void setMainPage(JPanel mainPage) {
        this.mainPage = mainPage;
    }

    public void init() {
        if(mainPage == null) {
            throw new IllegalArgumentException("MainPage isn't set");
        }
        this.add(mainPage);
    }

}
