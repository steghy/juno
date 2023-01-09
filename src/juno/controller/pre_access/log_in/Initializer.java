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

package juno.controller.pre_access.log_in;

import juno.controller.util.InterfaceInitializer;
import juno.model.data.achievements.Objective;
import juno.model.data.avatar.Avatar;
import juno.model.data.io.ProgramDirectory;
import juno.model.data.io.input.JSONDataImporter;
import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.profile.profile.Profile;
import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.LostGamesCounter;

import java.util.HashMap;
import java.util.Map;

/**
 * This class defines an initializer.
 * @author Simone Gentili
 */
public class Initializer
        implements InterfaceInitializer {

    // The Initializer instance.
    private static Initializer instance;

    // Builds the initializer instance.
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
        // User data setter.
        UserDataSetter userDataSetter = new UserDataSetter();

        // Avatar user data setter.
        UserDataSetter avatarUserDataSetter = new UserDataSetter();

        // Account setter.
        AccountSetter accountSetter = AccountSetter.getInstance();

        /////////////////////////////////////////////////////////////

        // User data setter
        Map<Configurable, InterfacePathBuilder> userData = new HashMap<>();
        userData.put(Profile.getInstance(), new PathBuilder("-profile.json", ProgramDirectory.PROFILES.absolutePath()));
        userData.put(GamesWonCounter.getInstance(), new PathBuilder("-games-won.json", ProgramDirectory.SCORE.absolutePath()));
        userData.put(LostGamesCounter.getInstance(), new PathBuilder("-lost-games.json", ProgramDirectory.SCORE.absolutePath()));
        PathMapBuilder<Configurable> mapSetter = new PathMapBuilder<>(userData);
        userDataSetter.setMapBuilder(mapSetter);
        userDataSetter.setImporter(JSONDataImporter.getInstance());

        // Avatar user data setter.
        Map<Configurable, InterfacePathBuilder> avatarUserData = new HashMap<>();
        avatarUserData.put(Avatar.getInstance(), new PathBuilder("-avatar.json", ProgramDirectory.AVATAR.absolutePath()));
        PathMapBuilder<Configurable> mapSetter1 = new PathMapBuilder<>(avatarUserData);
        avatarUserDataSetter.setMapBuilder(mapSetter1);
        avatarUserDataSetter.setImporter(JSONDataImporter.getInstance());

        // Account loader.
        accountSetter.setters().add(userDataSetter);
        accountSetter.setters().add(avatarUserDataSetter);
        accountSetter.setAchievement(Objective.REGISTRATION);
    }

}