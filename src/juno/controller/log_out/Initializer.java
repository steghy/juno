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

package juno.controller.log_out;

import juno.controller.pre_access.ConfigurationFilesFactory;
import juno.model.data.goals.GoalsRestorer;
import juno.model.data.goals.RegistrationGoal;
import juno.model.data.io.output.ExporterManager;
import juno.model.data.profile.profile.Profile;
import juno.model.data.profile.profile.ProfileNameProvider;
import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.LostGamesCounter;

import java.util.List;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds the Initializer object.
    private Initializer() {}

    public static void initialize() {
        Restorer restorer = Restorer.getInstance();
        AccountExiter accountExiter = AccountExiter.getInstance();
        ///////////////////////////////////////////////////////////
        // Restorer.
        List<Restorable> restorableList = restorer.restorableList();
        restorableList.add(Profile.getInstance());
        restorableList.add(LostGamesCounter.getInstance());
        restorableList.add(GamesWonCounter.getInstance());
        restorableList.add(RegistrationGoal.getInstance());
        restorableList.add(GoalsRestorer.getInstance());
        // AccountExiter.
        accountExiter.setGenerator(ConfigurationFilesFactory.getInstance());
        accountExiter.setProvider(ProfileNameProvider.getInstance());
        accountExiter.setExporterManager(ExporterManager.getInstance());
        accountExiter.setRestorable(Restorer.getInstance());
    }

}