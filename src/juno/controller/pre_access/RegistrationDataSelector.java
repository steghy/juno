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

package juno.controller.pre_access;

import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import juno.model.data.profile.InterfaceErrorProvider;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class RegistrationDataSelector
        extends AbstractRegistrationDataSelector
        implements InterfaceRegistrationDataSelector {

    // The RegistrationDataSelector instance.
    private static RegistrationDataSelector instance;

    // Builds the RegistrationDataSelector instance.
    private RegistrationDataSelector() {}

    /**
     * Returns the RegistrationDataSelector instance.
     * @return The RegistrationDataSelector instance.
     */
    public static RegistrationDataSelector getInstance() {
        if(instance == null) instance = new RegistrationDataSelector();
        return instance;
    }

    public void elaborate(@NotNull Configurable configurable,
                          @NotNull Exportable exportable,
                          @NotNull InterfaceErrorProvider errorProvider) {
        // Checking compatibility.
        Objects.requireNonNull(getChecker())
                .areCompatible(configurable, exportable.exportData());
        // The errors.
        Map<String, String> errors = errorProvider.getErrors();
        if(!errors.isEmpty()) {
            // Notify the error to the registration panel.
            Objects.requireNonNull(getNotifier()).notifyErrors(errors);
        } else {
            // Resolve the registration request.
            Objects.requireNonNull(getResolver()).resolve();
        }
    }

}