package juno.model.data.avatar;

import juno.model.util.Provider;

/**
 * This class defines an avatar name provider.
 * @author Simone Gentili
 */
public class AvatarNameProvider
        implements Provider<String> {

    // The AvatarNameProvider instance.
    private static AvatarNameProvider instance;

    // Builds the AvatarNameProvider instance.
    private AvatarNameProvider() {}

    /**
     * Returns the AvatarNameProvider instance.
     * @return The AvatarNameProvider instance.
     */
    public static AvatarNameProvider getInstance() {
        if(instance == null) instance = new AvatarNameProvider();
        return instance;
    }

    @Override
    public String provide() {
        return Avatar.getInstance().avatarName;
    }

}