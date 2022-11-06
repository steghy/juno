package juno.view.pages.main.north;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.util.ImageResizer;
import juno.view.util.LabelConfigurator;
import juno.view.util.PanelConfigurator;

import javax.swing.*;
import java.awt.*;

public class NorthPanelConfigurator {

    private NorthPanelConfigurator() {}

    public static void configure() {
        // MAIN-COMPONENT
        NorthPanel northPanel = NorthPanel.getInstance();

        // MAIN-COMPONENT DIMENSIONS
        Dimension dimension = new Dimension(500, 350);
        PanelConfigurator.configure(northPanel, dimension);

        // LOGO
        JLabel logo = new JLabel();

        // LOGO DIMENSIONS
        LabelConfigurator.configure(logo, 500, 350);

        // LOGO IMAGE
        String logoImage = PathGenerator.generate(Paths.LOGOS.getPath(), "logo.png");

        // LOGO IMAGE SETTING
        logo.setIcon(new ImageIcon(ImageResizer.resize(logo, logoImage)));

        // NORTH PANEL SETTING
        northPanel.setLogo(logo);

        // INITIALIZATION
        northPanel.init();
    }
}
