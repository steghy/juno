package juno.controller;

import juno.model.data.io.output.AbstractExitManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExitAction extends AbstractAction {

    private AbstractExitManager exitManager;

    public ExitAction(AbstractExitManager exitManager) {
        this.exitManager = exitManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        exitManager.exit();
    }
}
