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

package juno.controller.pre_access.registration;

import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import juno.model.data.profile.InterfaceErrorProvider;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class represents the registration data selector component.
 * @author Simone Gentili
 */
public class RegistrationDataSelector
        extends AbstractRegistrationDataSelector
        implements InterfaceRegistrationDataSelector, Observable {

    // The Observers List.
    private final List<Observer> observerList;

    // The RegistrationDataSelector instance.
    private static RegistrationDataSelector instance;

    // Builds the RegistrationDataSelector instance.
    private RegistrationDataSelector() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the RegistrationDataSelector instance.
     * @return The RegistrationDataSelector instance.
     */
    public static RegistrationDataSelector getInstance() {
        if(instance == null) instance = new RegistrationDataSelector();
        return instance;
    }

    @Override
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
            Objects.requireNonNull(getLogger()).logIn();
            updateAll();
        }
    }

    @Override
    public boolean addObserver(@NotNull Observer observer) {
        return observerList.add(observer);
    }

    @Override
    public boolean removeObserver(@NotNull Observer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

}