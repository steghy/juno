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
import juno.model.data.awards.UserAwards;
import juno.model.data.awards.UserAwardsFileNameBuilder;
import juno.model.data.profile.Profile;
import juno.model.data.profile.ProfileFileNameBuilder;
import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.GamesWonFileNameBuilder;
import juno.model.data.score.LostGamesCounter;
import juno.model.data.score.LostGamesFileNameBuilder;
import juno.model.util.PathGenerator;

import java.util.Map;

/**
 * @author Simone Gentili
 */
@SuppressWarnings("ALL")
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    /** Initialize the juno.model.data.io.output package. */
    public static void initialize() {
        // Components.
        // Exporter.
        ExporterManager exporter = ExporterManager.getInstance();

        // Profile.
        Profile profile = Profile.getInstance();

        // UserAwards.
        UserAwards userAwards = UserAwards.getInstance();

        // GamesWonCounter.
        GamesWonCounter gamesWonCounter = GamesWonCounter.getInstance();

        // LostGamesCounter.
        LostGamesCounter lostGamesCounter = LostGamesCounter.getInstance();

        // JSONDataExporter.
        JSONDataExporter jsonDataExporter = JSONDataExporter.getInstance();

        // Exportable setter.
        ExportableSetter exportableSetter = ExportableSetter.getInstance();

        // Connections.
        // Data exporter component.
        exporter.setDataExporter(jsonDataExporter);
        exporter.setExportableSetter(exportableSetter);
    }

}