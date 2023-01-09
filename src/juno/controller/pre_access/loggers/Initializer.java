/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.controller.pre_access.loggers;

import juno.controller.pre_access.registration.RegistrationDataSelector;
import juno.controller.util.InterfaceInitializer;
import juno.controller.util.PanelChanger;
import juno.model.data.avatar.AvatarImageSetter;
import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.goals.RegistrationObjective;
import juno.model.data.profile.profile.Profile;
import juno.model.data.profile.profile.ProfileNameSetter;
import juno.view.pages.card.TopCardPanel;

/**
 * This class defines an initializer.
 * @author Simone Gentili
 */
public class Initializer
        implements InterfaceInitializer {

    // The Initializer instance.
    private static Initializer instance;

    // Builds the Initializer instance.
    private Initializer() {}

    /**
     * Returns the Initializer instance.
     * @return The Initializer instance.
     */
    public static Initializer getInstance() {
        if(instance == null) instance = new Initializer();
        return instance;
    }

    @Override
    public void initialize() {
        // Logger.
        Logger logger = Logger.getInstance();

        // Guest logger.
        GuestLogger guestLogger = GuestLogger.getInstance();

        // Avatar setter.
        AvatarSetter avatarSetter = AvatarSetter.getInstance();

        // Guest profile name setter.
        GuestProfileNameSetter guestProfileNameSetter = GuestProfileNameSetter.getInstance();

        /////////////////////////////////////////////////////////////////////////////////

        // Avatar setter.
        avatarSetter.setAvatarImage(AvatarImage.AVATAR_IMAGE_1);
        avatarSetter.setAvatarImageSetter(AvatarImageSetter.getInstance());

        // Guest profile name setter.
        guestProfileNameSetter.setGuestName(Profile.GUEST_NAME);
        guestProfileNameSetter.setNameSetter(ProfileNameSetter.getInstance());

        // Logger.
        logger.setPanelChanger(new PanelChanger(TopCardPanel.getInstance(), TopCardPanel.MAIN_PANEL));
        logger.setAvatarSetter(avatarSetter);
        logger.setAchievement(RegistrationObjective.getInstance());

        // Guest logger..
        guestLogger.setPanelChanger(new PanelChanger(TopCardPanel.getInstance(), TopCardPanel.MAIN_PANEL));
        guestLogger.setAvatarSetter(avatarSetter);
        guestLogger.setAchievement(RegistrationObjective.getInstance());
        guestLogger.setGuestNameSetter(guestProfileNameSetter);

        // Registration message notifier.
        RegistrationDataSelector.getInstance().addObserver(RegistrationNotifier.getInstance());
    }

}