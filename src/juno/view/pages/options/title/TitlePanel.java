package juno.view.pages.options.title;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class TitlePanel
        extends JPanel {

    private AbstractButton title;
    private static TitlePanel instance;

    private TitlePanel() {}

    public static TitlePanel getInstance() {
        if(instance == null) instance = new TitlePanel();
        return instance;
    }

    public void init() {
        if(title == null) {
            throw new IllegalArgumentException("Title is null");
        }

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = 0;
        gbc.gridheight = 0;

        gbc.insets = new Insets(0,0,0,0);

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(title, gbc);
    }

    public void setTitle(@NotNull AbstractButton title) {
        this.title = title;
    }
}