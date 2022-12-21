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

import juno.model.data.avatar.Avatar;
import juno.model.data.goals.RegistrationGoal;
import juno.model.data.io.input.JSONDataImporter;
import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.profile.profile.Profile;
import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.LostGamesCounter;
import juno.model.requester.ProgramDirectory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    public static void initialize() {
        // Components.
        // UserDataSetter.
        UserDataSetter userDataSetter = new UserDataSetter();

        UserDataSetter avatarUserDataSetter = new UserDataSetter();

        // AccountSetter.
        AccountSetter accountSetter = AccountSetter.getInstance();

        /////////////////////////////////////////////////////////////

        // Connections.
        // UserDataSetter.
        Map<Configurable, InterfacePathBuilder> userData = new HashMap<>();
        userData.put(Profile.getInstance(), new PathBuilder("-profile.json", ProgramDirectory.PROFILES.absolutePath()));
        userData.put(GamesWonCounter.getInstance(), new PathBuilder("-games-won.json", ProgramDirectory.SCORE.absolutePath()));
        userData.put(LostGamesCounter.getInstance(), new PathBuilder("-lost-games.json", ProgramDirectory.SCORE.absolutePath()));

        MapSetter<Configurable> mapSetter = new MapSetter<>(userData);
        userDataSetter.setMapSetter(mapSetter);
        userDataSetter.setDataImporter(JSONDataImporter.getInstance());

        Map<Configurable, InterfacePathBuilder> avatarUserData = new HashMap<>();
        avatarUserData.put(Avatar.getInstance(), new PathBuilder("-avatar.json", ProgramDirectory.AVATAR.absolutePath()));
        MapSetter<Configurable> mapSetter1 = new MapSetter<>(avatarUserData);
        avatarUserDataSetter.setMapSetter(mapSetter1);
        avatarUserDataSetter.setDataImporter(JSONDataImporter.getInstance());

        // AccountLoader.
        accountSetter.setters().add(userDataSetter);
        accountSetter.setters().add(avatarUserDataSetter);
        accountSetter.setRegistrationGoal(RegistrationGoal.getInstance());
    }

}