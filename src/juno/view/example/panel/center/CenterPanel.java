package juno.view.example.panel.center;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.example.panel.center.center.MenuPanel;
import juno.view.util.ButtonConfigurator;
import juno.view.util.ImageResizer;
import juno.view.util.LabelConfigurator;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    private static CenterPanel instance;

    private CenterPanel() {
        init();
    }

    public static CenterPanel getInstance() {
        if(instance == null) {
            instance = new CenterPanel();
        } return instance;
    }

    private void init() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());

        JLabel animation = new JLabel();
        JButton northLabel = new JButton();
        JPanel menuPanel = MenuPanel.getInstance();
        JLabel southLabel = new JLabel();
        JLabel westLabel = new JLabel();
        JLabel eastLabel = new JLabel();

        ButtonConfigurator.configure(northLabel, 130, 50);
        LabelConfigurator.configure(animation, 200, 200);
        LabelConfigurator.configure(southLabel, 0, 0);
        LabelConfigurator.configure(westLabel, 0, 0);
        LabelConfigurator.configure(eastLabel, 0, 0);

        String animationDirectory = PathGenerator.generate(Paths.GIFS.getPath(), "circles-transparent-gif");
        String animationImage = PathGenerator.generate(animationDirectory, "circle-transparent-1.gif");
        String northLabelImageNF = PathGenerator.generate(Paths.LOGOS.getPath(), "logo-not-focus.png");
        String northLabelImageF = PathGenerator.generate(Paths.LOGOS.getPath(), "logo-focus.png");

        animation.setIcon(new ImageIcon(ImageResizer.resize(animation, animationImage)));
        northLabel.setIcon(new ImageIcon(ImageResizer.resize(northLabel, northLabelImageNF)));
        northLabel.setRolloverIcon(new ImageIcon(ImageResizer.resize(northLabel, northLabelImageF)));

        animation.setLayout(new BorderLayout());
        animation.add(northLabel, BorderLayout.CENTER);
        animation.setOpaque(false);
        animation.setHorizontalAlignment(SwingConstants.CENTER);
        northLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(menuPanel, BorderLayout.CENTER);
        this.add(animation, BorderLayout.NORTH);
        this.add(southLabel, BorderLayout.SOUTH);
        this.add(westLabel, BorderLayout. WEST);
        this.add(eastLabel, BorderLayout.EAST);
    }

}
