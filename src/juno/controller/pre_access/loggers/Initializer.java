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

import juno.controller.util.PanelChanger;
import juno.model.data.avatar.AvatarFrameSetter;
import juno.model.data.avatar.AvatarImageSetter;
import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.awards.frame.AvatarFrame;
import juno.model.data.goals.RegistrationGoal;
import juno.model.data.io.output.ExporterManager;
import juno.model.data.profile.profile.ProfileNameSetter;
import juno.view.pages.card.TopCardPanel;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    public static void initialize() {
        // Components.
        // Logger.
        Logger logger = Logger.getInstance();

        // GuestLogger.
        GuestLogger guestLogger = GuestLogger.getInstance();

        // AvatarSetter.
        AvatarSetter avatarSetter = AvatarSetter.getInstance();

        // GuestProfileNameSetter.
        GuestProfileNameSetter guestProfileNameSetter = GuestProfileNameSetter.getInstance();

        /////////////////////////////////////////////////////////////////////////////////

        // Connections.
        // AvatarSetter.
        avatarSetter.setAvatarFrame(AvatarFrame.GREY_FRAME);
        avatarSetter.setAvatarImage(AvatarImage.AVATAR_IMAGE_1);
        avatarSetter.setAvatarFrameSetter(AvatarFrameSetter.getInstance());
        avatarSetter.setAvatarImageSetter(AvatarImageSetter.getInstance());

        // GuestProfileNameSetter.
        guestProfileNameSetter.setGuestName("Guest");
        guestProfileNameSetter.setNameSetter(ProfileNameSetter.getInstance());

        // Logger.
        logger.setCardPanel(TopCardPanel.getInstance());
        logger.setPanelKey(TopCardPanel.MAIN_PANEL);
        logger.setAvatarSetter(avatarSetter);
        logger.setPanelChanger(PanelChanger.getInstance());
        logger.setExporterManager(ExporterManager.getInstance());
        logger.setRegistrationGoal(RegistrationGoal.getInstance());

        // GuestLogger.
        guestLogger.setCardPanel(TopCardPanel.getInstance());
        guestLogger.setPanelKey(TopCardPanel.MAIN_PANEL);
        guestLogger.setAvatarSetter(avatarSetter);
        guestLogger.setPanelChanger(PanelChanger.getInstance());
        guestLogger.setRegistrationGoal(RegistrationGoal.getInstance());
        guestLogger.setGuestNameSetter(guestProfileNameSetter);
    }

}