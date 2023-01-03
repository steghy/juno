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

import juno.controller.pre_access.loggers.Logger;
import juno.controller.util.InterfaceInitializer;
import juno.model.data.io.input.configurable.CCompatibilityChecker;
import juno.view.pages.pre_access.registration.menu.MenuPanel;

/**
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
        // Registration data selector.
        RegistrationDataSelector registrationDataSelector = RegistrationDataSelector.getInstance();

        // Error notifier.
        ErrorNotifier errorNotifier = ErrorNotifier.getInstance();

        // Logger.
        Logger logger = Logger.getInstance();

        // CCompatibility checker.
        CCompatibilityChecker checker = CCompatibilityChecker.getInstance();

        // MenuPanel (Data line provider).
        MenuPanel menuPanel = MenuPanel.getInstance();

        /////////////////////////////////////////////////////////////////////////

        // Registration data selector.
        registrationDataSelector.setNotifier(errorNotifier);
        registrationDataSelector.setLogger(logger);
        registrationDataSelector.setChecker(checker);

        // Error notifier.
        errorNotifier.setDataLineProvider(menuPanel);
    }

}