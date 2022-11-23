package juno.controller;

import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SendRegistrationDataAction implements ActionListener {

    private final AbstractDataProvider dataProvider;

    private final Map<String, Object> data;

    public SendRegistrationDataAction(@NotNull AbstractDataProvider dataProvider) {
        this.dataProvider = dataProvider;
        this.data = new HashMap<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        data.clear();
        data.putAll(dataProvider.getData());

    }

    public Map<String, Object> getData() {
        return data;
    }
}