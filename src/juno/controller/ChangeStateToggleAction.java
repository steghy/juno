package juno.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChangeStateToggleAction extends AbstractAction {

    private JToggleButton button;

    public ChangeStateToggleAction(JToggleButton button) {
       this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Icon icon = button.getIcon();
        Icon rolloverIcon = button.getRolloverIcon();
        Icon selectedIcon = button.getSelectedIcon();
        Icon rolloverSelectedIcon = button.getRolloverSelectedIcon();

        button.setIcon(selectedIcon);
        button.setRolloverIcon(rolloverSelectedIcon);

        button.setSelectedIcon(icon);
        button.setRolloverSelectedIcon(rolloverIcon);
    }
}
