package juno.controller.pre_access.loggers;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GuestProfileNameSetter
        extends AbstractGuestProfileNameSetter {

    // The GuestProfileNameSetter instance.
    private static GuestProfileNameSetter instance;

    // Builds the GuestProfileNameSetter instance.
    private GuestProfileNameSetter() {}

    /**
     * Returns the GuestProfileNameSetter instance.
     * @return The GuestProfileNameSetter instance.
     */
    public static GuestProfileNameSetter getInstance() {
        if(instance == null) instance = new GuestProfileNameSetter();
        return instance;
    }

    @Override
    public void setGuestProfileName() {
        Objects.requireNonNull(getNameSetter()).setProfileName(getGuestName());
    }

}