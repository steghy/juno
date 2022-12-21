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

import juno.controller.pre_access.log_in.InterfacePathBuilder;
import juno.controller.pre_access.log_in.MapSetter;
import juno.controller.pre_access.log_in.PathBuilder;
import juno.model.data.avatar.Avatar;
import juno.model.data.profile.profile.Profile;
import juno.model.data.profile.profile.ProfileNameProvider;
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

    /** Initialize the juno.model.data.io.output package. */
    @SuppressWarnings("unchecked")
    public static void initialize() {
        // Components.
        // ExporterManager.
        ExporterManager exporterManager = ExporterManager.getInstance();

        // ExitManager.
        ExitManager<String> exitManager = (ExitManager<String>) ExitManager.getInstance();

        // JSONDataExporter.
        JSONDataExporter jsonDataExporter = JSONDataExporter.getInstance();

        ///////////////////////////////////////////////////////////////////

        // Connections.
        // ExporterManager.
        Map<Exportable, InterfacePathBuilder> map = new HashMap<>();
        map.put(Profile.getInstance(), new PathBuilder("-profile.json", ProgramDirectory.PROFILES.absolutePath()));
        map.put(GamesWonCounter.getInstance(), new PathBuilder("-games-won.json", ProgramDirectory.SCORE.absolutePath()));
        map.put(LostGamesCounter.getInstance(), new PathBuilder("-lost-games.json", ProgramDirectory.SCORE.absolutePath()));
        map.put(Avatar.getInstance(), new PathBuilder("-avatar.json", ProgramDirectory.AVATAR.absolutePath()));
        MapSetter<Exportable> mapSetter = new MapSetter<>(map);
        exporterManager.setMapSetter(mapSetter);
        exporterManager.setDataExporter(jsonDataExporter);

        // ExitManager.
        exitManager.setExporter(exporterManager);
        exitManager.setProvider(ProfileNameProvider.getInstance());
    }

}