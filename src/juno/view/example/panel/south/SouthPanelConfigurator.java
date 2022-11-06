package juno.view.example.panel.south;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.util.ImageResizer;
import juno.view.util.LabelConfigurator;

import javax.swing.*;
import java.awt.*;

public class SouthPanelConfigurator {

    private SouthPanelConfigurator() {}

    public static void configure() {
        SouthPanel southPanel = SouthPanel.getInstance();
        southPanel.setOpaque(false);

        JLabel southLabel = new JLabel();
        LabelConfigurator.configure(southLabel, 0, 0);

        String donutsDirectory = PathGenerator.generate(Paths.GIFS.getPath(), "donut-transparent-gif");
        String donutImage = PathGenerator.generate(donutsDirectory, "donut-transparent-1.gif");
        // southLabel.setIcon(new ImageIcon(ImageResizer.resize(southLabel, donutImage)));

        southLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        southPanel.add(southLabel);
    }
}
