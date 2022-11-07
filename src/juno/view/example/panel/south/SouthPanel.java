package juno.view.example.panel.south;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.util.LabelConfigurator;

import javax.swing.*;

public class SouthPanel extends JPanel {

    private static SouthPanel instance;

    private SouthPanel() {
        init();
    }

    public static SouthPanel getInstance() {
        if(instance == null) {
            instance = new SouthPanel();
        } return instance;
    }

    private void init() {
        this.setOpaque(false);

        JLabel southLabel = new JLabel();
        LabelConfigurator.configure(southLabel, 0, 0);

        String donutsDirectory = PathGenerator.generate(Paths.GIFS.getPath(), "donut-transparent-gif");
        String donutImage = PathGenerator.generate(donutsDirectory, "donut-transparent-1.gif");
        // southLabel.setIcon(new ImageIcon(ImageResizer.resize(southLabel, donutImage)));

        southLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        this.add(southLabel);
    }
}
