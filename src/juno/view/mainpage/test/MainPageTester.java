package juno.view.mainpage.test;

import juno.view.mainpage.MainPage;
import juno.view.mainpage.MainPageFullConfigurator;
import juno.view.util.FrameConfigurator;

import javax.swing.*;
import java.awt.*;

public class MainPageTester {

    public static void main(String[] args) {
        MainPageFullConfigurator.configure();

        JFrame frame = new JFrame();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        FrameConfigurator.configure(frame, dimension);

        frame.add(MainPage.getInstance());

        frame.setVisible(true);

    }
}
