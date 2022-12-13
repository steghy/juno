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

import juno.controller.InterfaceRegistrationDataProvider;
import juno.init.Directories;
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
    private final InterfaceRegistrationDataProvider dataProvider;

    // The error provider;
    private final InterfaceErrorProvider errorProvider;

    /**
     * Builds an ErrorDecorator with the specified
     * error provider object.
     * @param errorProvider An InterfaceErrorProvider object.
     */
    public ErrorProviderDecorator(@NotNull InterfaceErrorProvider errorProvider,
                                  @NotNull InterfaceRegistrationDataProvider dataProvider) {
        this.errorProvider = errorProvider;
        this.dataProvider = dataProvider;
    }

    @Override
    public Map<String, String> getErrors() {
        Map<String, String> errors = errorProvider.getErrors();
        Map<String, Object> data = dataProvider.provideRegistrationData();
        if(data.containsKey(Profile.PROFILE_NAME_KEY))
            if(Os.exists(
                    PathGenerator.generate(
                            Directories.PROFILES.absolutePath(),
                            ProfileFileNameBuilder.build((String) data.get(Profile.PROFILE_NAME_KEY)))))
                errors.put(Profile.PROFILE_NAME_KEY, "profile name already used");
        return errors;
    }

}