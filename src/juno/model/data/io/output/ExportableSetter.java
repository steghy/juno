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

package juno.model.data.io.output;

import juno.init.Directories;
import juno.model.data.goals.UserGoals;
import juno.model.data.goals.UserGoalsFileNameBuilder;
import juno.model.data.profile.Profile;
import juno.model.data.profile.ProfileFileNameBuilder;
import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.GamesWonFileNameBuilder;
import juno.model.data.score.LostGamesCounter;
import juno.model.data.score.LostGamesFileNameBuilder;
import juno.model.util.PathGenerator;

import java.util.Map;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ExportableSetter
        implements InterfaceExportableSetter {

    // The ExportableSetter instance.
    private static ExportableSetter instance;

    // Builds an ExporterManagerSetter object.
    private ExportableSetter() {}

    /**
     * Returns the ExportableSetter instance.
     * @return The ExportableSetter instance.
     */
    public static ExportableSetter getInstance() {
        if(instance == null) instance = new ExportableSetter();
        return instance;
    }

    /** Sets the exportable map of the ExporterManager instance. */
    @Override
    public void setExportable() {
        // Exportable components.
        Map<Exportable, String> map = ExporterManager.getInstance().exportableMap();
        // Profile case.
        map.put(Profile.getInstance(), PathGenerator.generate(Directories.PROFILES.absolutePath(),
                ProfileFileNameBuilder.build(Objects.requireNonNull(Profile.getInstance().profileName()))));
        // User awards case.
        map.put(UserGoals.getInstance(), PathGenerator.generate(Directories.GOALS.absolutePath(),
                UserGoalsFileNameBuilder.build(Objects.requireNonNull(Profile.getInstance().profileName()))));
        // Games won case.
        map.put(GamesWonCounter.getInstance(), PathGenerator.generate(Directories.SCORE.absolutePath(),
                GamesWonFileNameBuilder.build(Objects.requireNonNull(Profile.getInstance().profileName()))));
        // Lost games case.
        map.put(LostGamesCounter.getInstance(), PathGenerator.generate(Directories.SCORE.absolutePath(),
                LostGamesFileNameBuilder.build(Objects.requireNonNull(Profile.getInstance().profileName()))));
    }

}