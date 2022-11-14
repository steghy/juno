package juno.model.profile;

import juno.controller.AbstractGuestProfileGenerator;

public class GuestProfileGenerator implements AbstractGuestProfileGenerator {

    private static GuestProfileGenerator instance;

    private GuestProfileGenerator() {}

    public static GuestProfileGenerator getInstance() {
        if(instance == null) {
            instance = new GuestProfileGenerator();
        } return instance;
    }

    @Override
    public void generateGuestProfile() {

    }
}
