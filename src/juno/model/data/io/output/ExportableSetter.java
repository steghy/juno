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

import juno.model.requester.ProgramDirectory;
import juno.model.data.avatar.Avatar;
import juno.controller.pre_access.log_in.name_builder.AvatarFileNameBuilder;
import juno.model.data.profile.profile.Profile;
import juno.controller.pre_access.log_in.name_builder.ProfileFileNameBuilder;
import juno.model.data.score.GamesWonCounter;
import juno.controller.pre_access.log_in.name_builder.GamesWonFileNameBuilder;
import juno.model.data.score.LostGamesCounter;
import juno.controller.pre_access.log_in.name_builder.LostGamesFileNameBuilder;
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
        String profileName = Objects.requireNonNull(Profile.getInstance().profileName());
        if(!profileName.equals(Profile.GUEST_NAME)) {
            // Profile case.
            map.put(Profile.getInstance(), PathGenerator.generate(ProgramDirectory.PROFILES.absolutePath(),
                    ProfileFileNameBuilder.getInstance().build(profileName)));
            // Games won case.
            map.put(GamesWonCounter.getInstance(), PathGenerator.generate(ProgramDirectory.SCORE.absolutePath(),
                    GamesWonFileNameBuilder.getInstance().build(profileName)));
            // Lost games case.
            map.put(LostGamesCounter.getInstance(), PathGenerator.generate(ProgramDirectory.SCORE.absolutePath(),
                    LostGamesFileNameBuilder.getInstance().build(profileName)));
            // Avatar data case.
            map.put(Avatar.getInstance(), PathGenerator.generate(ProgramDirectory.AVATAR.absolutePath(),
                    AvatarFileNameBuilder.getInstance().build(profileName)));
        }
    }

}