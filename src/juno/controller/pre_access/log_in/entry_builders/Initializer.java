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

package juno.controller.pre_access.log_in.entry_builders;

import juno.controller.pre_access.log_in.path_builders.AvatarPathBuilder;
import juno.controller.pre_access.log_in.path_builders.GamesWonPathBuilder;
import juno.controller.pre_access.log_in.path_builders.LostGamesPathBuilder;
import juno.controller.pre_access.log_in.path_builders.ProfilePathBuilder;
import juno.model.data.avatar.Avatar;
import juno.model.data.avatar.AvatarConfigurationMapDecorator;
import juno.model.data.io.input.JSONDataImporter;
import juno.model.data.profile.profile.Profile;
import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.LostGamesCounter;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    public static void initialize() {
        // Components.
        // AvatarEntryBuilder.
        AvatarEntryBuilder avatarEntryBuilder = AvatarEntryBuilder.getInstance();

        // GamesWonEntryBuilder.
        GamesWonEntryBuilder gamesWonEntryBuilder = GamesWonEntryBuilder.getInstance();

        // LostGamesEntryBuilder.
        LostGamesEntryBuilder lostGamesEntryBuilder = LostGamesEntryBuilder.getInstance();

        // ProfileEntryBuilder.
        ProfileEntryBuilder profileEntryBuilder = ProfileEntryBuilder.getInstance();

        // AvatarPathBuilder.
        AvatarPathBuilder avatarPathBuilder = AvatarPathBuilder.getInstance();

        // GamesWonPathBuilder.
        GamesWonPathBuilder gamesWonPathBuilder = GamesWonPathBuilder.getInstance();

        // LostGamesPathBuilder.
        LostGamesPathBuilder lostGamesPathBuilder = LostGamesPathBuilder.getInstance();

        // ProfilePathBuilder.
        ProfilePathBuilder profilePathBuilder = ProfilePathBuilder.getInstance();

        // AvatarMapDecorator.
        AvatarConfigurationMapDecorator avatarConfigurationMapDecorator = AvatarConfigurationMapDecorator.getInstance();

        // JSONDataImporter.
        JSONDataImporter jsonDataImporter = JSONDataImporter.getInstance();

        ///////////////////////////////////////////////////////////////////////////////////7

        // Connections.
        // AvatarEntryBuilder.
        avatarEntryBuilder.setBuilder(avatarPathBuilder);
        avatarEntryBuilder.setConfigurable(Avatar.getInstance());
        avatarEntryBuilder.setImporter(jsonDataImporter);
        avatarEntryBuilder.setDecorator(avatarConfigurationMapDecorator);

        // GamesWonEntryBuilder.
        gamesWonEntryBuilder.setBuilder(gamesWonPathBuilder);
        gamesWonEntryBuilder.setConfigurable(GamesWonCounter.getInstance());
        gamesWonEntryBuilder.setImporter(jsonDataImporter);

        // LostGamesEntryBuilder.
        lostGamesEntryBuilder.setBuilder(lostGamesPathBuilder);
        lostGamesEntryBuilder.setConfigurable(LostGamesCounter.getInstance());
        lostGamesEntryBuilder.setImporter(jsonDataImporter);

        // ProfileEntryBuilder.
        profileEntryBuilder.setBuilder(profilePathBuilder);
        profileEntryBuilder.setConfigurable(Profile.getInstance());
        profileEntryBuilder.setImporter(jsonDataImporter);
    }

}