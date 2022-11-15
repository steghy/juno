package juno.model.profile;

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
