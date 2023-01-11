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

import juno.controller.pre_access.log_in.InterfacePathBuilder;
import juno.model.data.io.output.Exportable;
import juno.model.util.Os;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * This class defines an error provider decorator.
 * @author Simone Gentili
 */
public class ErrorProviderDecorator
        implements InterfaceErrorDecorator {

    // The profile name key;
    private final String key;

    // The guest name;
    private final String guest;

    // The data provider.
    private final Exportable exportable;

    // The error provider;
    private final InterfaceErrorProvider errorProvider;

    // The path builder.
    private final InterfacePathBuilder pathBuilder;

    /**
     * Builds an ErrorProviderDecorator object with the
     * specified paramenters.
     * @param errorProvider An InterfaceErrorProvider object.
     * @param pathBuilder An InterfacePathBuilder object.
     * @param exportable An Exportable object.
     * @param key A String object.
     * @param guest A String object.
     */
    public ErrorProviderDecorator(@NotNull InterfaceErrorProvider errorProvider,
                                  @NotNull InterfacePathBuilder pathBuilder,
                                  @NotNull Exportable exportable,
                                  @NotNull String key,
                                  @NotNull String guest) {
        this.errorProvider = errorProvider;
        this.exportable = exportable;
        this.pathBuilder = pathBuilder;
        this.key = key;
        this.guest = guest;
    }

    @Override
    public Map<String, String> getErrors() {
        // The errors to decorate produced when
        // configuring the profile class.
        Map<String, String> errors = errorProvider.getErrors();
        Map<String, Object> data = exportable.exportData();

        // The only data that is considered is the profile name.
        // key = Profile.PROFILE_NAME_KEY
        if(data.containsKey(key)) {
            Object object = data.get(key);
            if(object instanceof String profileName) {

                // The profile name has already been used.
                if(Os.exists(pathBuilder.build((profileName))))
                    errors.put(key, "profile name already used");

                // The Guest name cannot be used.
                else if(profileName.equalsIgnoreCase(guest))
                    errors.put(key, "guest name cannot be used");
            }

            // Invalid case.
            else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass() +
                            ". String type expected.");
        } return errors;
    }

}