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

package juno.controller.pre_access.log_in.path_builder;

import juno.controller.pre_access.log_in.name_builder.AvatarFileNameBuilder;
import juno.controller.pre_access.log_in.name_builder.GamesWonFileNameBuilder;
import juno.controller.pre_access.log_in.name_builder.LostGamesFileNameBuilder;
import juno.controller.pre_access.log_in.name_builder.ProfileFileNameBuilder;
import juno.model.requester.ProgramDirectory;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    public static void initialize() {
        // Components.
        // AvatarPathBuilder.
        AvatarPathBuilder avatarPathBuilder = AvatarPathBuilder.getInstance();

        // GamesWonPathBuilder.
        GamesWonPathBuilder gamesWonPathBuilder = GamesWonPathBuilder.getInstance();

        // LostGamesPathBuilder.
        LostGamesPathBuilder lostGamesPathBuilder = LostGamesPathBuilder.getInstance();

        // ProfilePathBuilder.
        ProfilePathBuilder profilePathBuilder = ProfilePathBuilder.getInstance();

        // AvatarFileNameBuilder.
        AvatarFileNameBuilder avatarFileNameBuilder = AvatarFileNameBuilder.getInstance();

        // GamesWonFileNameBuilder.
        GamesWonFileNameBuilder gamesWonFileNameBuilder = GamesWonFileNameBuilder.getInstance();

        // LostGamesFileNameBuilder.
        LostGamesFileNameBuilder lostGamesFileNameBuilder = LostGamesFileNameBuilder.getInstance();

        ProfileFileNameBuilder profileFileNameBuilder = ProfileFileNameBuilder.getInstance();

        /////////////////////////////////////////////////////////////////////////////////

        // Connections.
        // AvatarPathBuilder.
        avatarPathBuilder.setBuilder(avatarFileNameBuilder);
        avatarPathBuilder.setDirectory(ProgramDirectory.AVATAR.absolutePath());

        // GamesWonPathBuilder.
        gamesWonPathBuilder.setBuilder(gamesWonFileNameBuilder);
        gamesWonPathBuilder.setDirectory(ProgramDirectory.SCORE.absolutePath());

        // LostGamesPathBuilder.
        lostGamesPathBuilder.setBuilder(lostGamesFileNameBuilder);
        lostGamesPathBuilder.setDirectory(ProgramDirectory.SCORE.absolutePath());

        // ProfilePathBuilder.
        profilePathBuilder.setBuilder(profileFileNameBuilder);
        profilePathBuilder.setDirectory(ProgramDirectory.PROFILES.absolutePath());
    }

}