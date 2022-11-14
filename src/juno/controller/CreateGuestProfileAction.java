package juno.controller;

import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateGuestProfileAction implements ActionListener {

    private AbstractGuestProfileGenerator guestProfileGenerator;

    public CreateGuestProfileAction(@NotNull AbstractGuestProfileGenerator guestProfileGenerator) {
        this.guestProfileGenerator = guestProfileGenerator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        guestProfileGenerator.generateGuestProfile();
    }
}