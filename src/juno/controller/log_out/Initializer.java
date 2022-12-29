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
import juno.controller.util.InterfaceInitializer;
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
        AccountExiter accountExiter = AccountExiter.getInstance();
        List<Restorable> restorableList = accountExiter.getRestorableList();
        restorableList.add(Profile.getInstance());
        restorableList.add(LostGamesCounter.getInstance());
        restorableList.add(GamesWonCounter.getInstance());
        restorableList.add(RegistrationGoal.getInstance());
        restorableList.add(GoalsRestorer.getInstance());
        accountExiter.setGenerator(ConfigurationFilesFactory.getInstance());
        accountExiter.setProvider(ProfileNameProvider.getInstance());
        accountExiter.setExporterManager(ExporterManager.getInstance());
    }

}