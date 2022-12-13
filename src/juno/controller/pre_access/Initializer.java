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

import juno.controller.util.PanelChanger;
import juno.model.data.io.input.configurable.CCompatibilityChecker;
import juno.model.data.io.output.ExporterManager;
import juno.view.pages.card.TopCardPanel;
import juno.view.pages.pre_access.registration.menu.MenuPanel;

import java.awt.*;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds a PreAccessControllerInitializer object.
    private Initializer() {}

    /** Initialize the juno.controller.pre_access.controller package. */
    public static void initialize() {
        // Components.
        // Registration data selector.
        RegistrationDataSelector selector = RegistrationDataSelector.getInstance();

        // Error notifier.
        ErrorNotifier notifier = ErrorNotifier.getInstance();

        // Request resolver.
        RequestResolver resolver = RequestResolver.getInstance();

        // CCompatibility checker.
        CCompatibilityChecker checker = CCompatibilityChecker.getInstance();

        // Data line provider.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Exporter manager.
        ExporterManager exporterManager = ExporterManager.getInstance();

        // Card panel.
        TopCardPanel topCardPanel = TopCardPanel.getInstance();

        // Panel key
        String panelKey = TopCardPanel.MAIN_PANEL;

        // Panel changer
        PanelChanger panelChanger = PanelChanger.getInstance();

        /////////////////////////////////////////////////////////////////////////

        // Connections.
        // Registration data selector.
        selector.setNotifier(notifier);
        selector.setResolver(resolver);
        selector.setChecker(checker);

        // Notifier.
        notifier.setDataLineProvider(menuPanel);

        // Resolver.
        resolver.setExporterManager(exporterManager);
        resolver.setPanelChanger(panelChanger);
        resolver.setCardPanel(topCardPanel);
        resolver.setPanelKey(panelKey);
    }

}