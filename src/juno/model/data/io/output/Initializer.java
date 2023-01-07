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
import juno.controller.pre_access.log_in.PathMapBuilder;
import juno.controller.pre_access.log_in.PathBuilder;
import juno.controller.util.InterfaceInitializer;
import juno.model.data.avatar.Avatar;
import juno.model.data.profile.profile.Profile;
import juno.model.data.profile.profile.ProfileNameProvider;
import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.LostGamesCounter;
import juno.init.ProgramDirectory;

import java.util.HashMap;
import java.util.Map;

/**
 * this class defines an initializer.
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
        // Components.
        // ExporterManager.
        ExporterManager exporterManager = ExporterManager.getInstance();

        // ExitManager.
        ExitManager exitManager = ExitManager.getInstance();

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
        PathMapBuilder<Exportable> mapSetter = new PathMapBuilder<>(map);

        // Exporter manager.
        exporterManager.setMapBuilder(mapSetter);
        exporterManager.setDataExporter(jsonDataExporter);

        // Exit manager.
        exitManager.setExporter(exporterManager);
        exitManager.setProvider(ProfileNameProvider.getInstance());
        exitManager.setGuest(Profile.GUEST_NAME);
    }

}