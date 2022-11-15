package juno.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendRegistrationDataAction implements ActionListener {

    private AbstractDataProvider dataProvider;

    public SendRegistrationDataAction(AbstractDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dataProvider.getData().entrySet().stream().forEach(System.out::println);
    }
}
