package juno.model.data.avatar;

import juno.model.data.achievements.InterfaceAvatarImage;
import juno.model.util.Provider;

/**
 * This class defines an avatar image provider.
 * @author Simone Gentili
 */
public class AvatarImageProvider
        implements Provider<InterfaceAvatarImage> {

    // The AvatarImageProvider instance.
    private static AvatarImageProvider instance;

    // Builds the AvatarImageProvider instance.
    private AvatarImageProvider() {}

    /**
     * Returns the AvatarImageProvider instance.
     * @return The AvatarImageProvider instance.
     */
    public static AvatarImageProvider getInstance() {
        if(instance == null) instance = new AvatarImageProvider();
        return instance;
    }

    @Override
    public InterfaceAvatarImage provide() {
        return Avatar.getInstance().avatarImage;
    }

}