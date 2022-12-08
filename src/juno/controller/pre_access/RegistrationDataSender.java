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

import juno.controller.InterfaceRegistrationDataProvider;
import juno.model.data.io.input.PropertyCopier;
import juno.model.data.io.input.configurable.CompatibilityChecker;
import juno.model.data.io.input.configurable.Configurable;
import juno.view.pages.pre_access.card.PreAccessCardPanel;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class RegistrationDataSender
        extends AbstractRegistrationDataSender
        implements ActionListener {

    // The configurable.
    private final Configurable configurable;

    // The registration data provider.
    private final InterfaceRegistrationDataProvider provider;

    /**
     * Builds a RegistrationDataSender with the specified
     * Configurable and InterfaceRegistrationDataSender
     * objects.
     * @param configurable A Configurable object.
     * @param provider An InterfaceRegistrationDataProvider.
     */
    public RegistrationDataSender(@NotNull Configurable configurable,
                                  @NotNull InterfaceRegistrationDataProvider provider) {
        this.configurable = configurable;
        this.provider = provider;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // Current status of the object.
        Map<String, Object> properties = PropertyCopier.getInstance().copy(configurable);

        // Checking compatibility.
        boolean result = CompatibilityChecker.getInstance()
                    .areCompatible(configurable, provider.provideRegistrationData());

        if(!result) {
            getChanger().change();
            configurable.configure(properties);
        }
    }

}