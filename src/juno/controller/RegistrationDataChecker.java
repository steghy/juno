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

package juno.controller;

import juno.model.data.io.input.Configurable;
import juno.model.data.io.input.InterfaceMapCCompatibilityChecker;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class RegistrationDataChecker
        implements ActionListener, InterfaceRegistrationDataChecker {

    private InterfaceRegistrationDataProvider provider;

    private InterfaceMapCCompatibilityChecker compatibilityChecker;

    private Configurable configurable;

    private static RegistrationDataChecker instance;

    private RegistrationDataChecker() {}

    public static RegistrationDataChecker getInstance() {
        if(instance == null) instance = new RegistrationDataChecker();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(provider == null) {
            throw new IllegalArgumentException("RegistrationDataProvider is null");
        }

        Map<String, Object> data = provider.provideRegistrationData();
        if(!data.isEmpty()) {

        }
    }

    @Override
    public Map<String, String> getResponse() {

    }

    public void setProvider(@NotNull InterfaceRegistrationDataProvider provider) {
        this.provider = provider;
    }

    public void setCompatibilityChecker(@NotNull InterfaceMapCCompatibilityChecker compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    public void setConfigurable(@NotNull Configurable configurable) {
        this.configurable = configurable;
    }
}