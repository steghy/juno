package juno.view.pages.newGamePanel.multiplayer;

import javax.swing.*;
import java.awt.*;

public class UnavailableServicePanel extends JPanel {

    private JLabel unavailableServiceText;
    private AbstractButton backButton;
    private AbstractButton unavailableServiceButtonImage;
    private static UnavailableServicePanel instance;

    private UnavailableServicePanel() {}

    public static UnavailableServicePanel getInstance() {
        if(instance == null) {
            instance = new UnavailableServicePanel();
        } return instance;
    }

    public void init() {
        if(unavailableServiceText == null) {
            throw new IllegalArgumentException("Unavailable service text is null");
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(unavailableServiceText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(backButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(unavailableServiceButtonImage, gbc);
    }

    public void setUnavailableServiceText(JLabel unavailableServiceText) {
        this.unavailableServiceText = unavailableServiceText;
    }

    public void setBackButton(AbstractButton backButton) {
        this.backButton = backButton;
    }

    public void setUnavailableServiceButtonImage(AbstractButton unavailableServiceButtonImage) {
        this.unavailableServiceButtonImage = unavailableServiceButtonImage;
    }

    public JLabel getUnavailableServiceText() {
        return unavailableServiceText;
    }

    public AbstractButton getBackButton() {
        return backButton;
    }

    public AbstractButton getUnavailableServiceButtonImage() {
        return unavailableServiceButtonImage;
    }
}
