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

package juno.model.data.profile;

import juno.controller.pre_access.log_in.name_builder.ProfileFileNameBuilder;
import juno.model.requester.ProgramDirectory;
import juno.model.data.io.output.Exportable;
import juno.model.data.profile.profile.Profile;
import juno.model.util.Os;
import juno.model.util.PathGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Simone Gentili
 */
public class ErrorProviderDecorator
        implements InterfaceErrorDecorator {

    // The data provider.
    private final Exportable exportable;

    // The error provider;
    private final InterfaceErrorProvider errorProvider;

    /**
     * Builds an ErrorDecorator with the specified
     * error provider object.
     * @param errorProvider An InterfaceErrorProvider object.
     */
    public ErrorProviderDecorator(@NotNull InterfaceErrorProvider errorProvider,
                                  @NotNull Exportable exportable) {
        this.errorProvider = errorProvider;
        this.exportable = exportable;
    }

    @Override
    public Map<String, String> getErrors() {
        Map<String, String> errors = errorProvider.getErrors();
        Map<String, Object> data = exportable.exportData();
        if(data.containsKey(Profile.PROFILE_NAME_KEY)) {
            Object object = data.get(Profile.PROFILE_NAME_KEY);
            if(object instanceof String profileName) {
                if(Os.exists(PathGenerator.generate(
                        ProgramDirectory.PROFILES.absolutePath(),
                        ProfileFileNameBuilder.build((profileName))))) {
                    errors.put(Profile.PROFILE_NAME_KEY, "profile name already used");
                } else if(profileName.equalsIgnoreCase(Profile.GUEST_NAME)) {
                    errors.put(Profile.PROFILE_NAME_KEY, "guest name cannot be used");
                }
            } else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass() +
                            ". String type expected.");
        } return errors;
    }

}