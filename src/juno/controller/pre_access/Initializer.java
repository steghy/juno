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
import juno.model.data.profile.profile.ProfileNameSetter;
import juno.view.pages.card.TopCardPanel;
import juno.view.pages.pre_access.registration.menu.MenuPanel;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds a PreAccessControllerInitializer object.
    private Initializer() {}

    /** Initialize the juno.controller.pre_access.controller package. */
    public static void initialize() {
        // Components.
        // RegistrationDataSelector.
        RegistrationDataSelector registrationDataSelector = RegistrationDataSelector.getInstance();

        // ErrorNotifier.
        ErrorNotifier errorNotifier = ErrorNotifier.getInstance();

        // RequestResolver.
        RequestResolver requestResolver = RequestResolver.getInstance();

        // CCompatibilityChecker.
        CCompatibilityChecker checker = CCompatibilityChecker.getInstance();

        // MenuPanel (Data line provider).
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ExporterManager.
        ExporterManager exporterManager = ExporterManager.getInstance();

        // TopCardPanel.
        TopCardPanel topCardPanel = TopCardPanel.getInstance();

        // PanelKey.
        String panelKey = TopCardPanel.MAIN_PANEL;

        // PanelChanger.
        PanelChanger panelChanger = PanelChanger.getInstance();

        // GuestProfileCreator.
        GuestProfileCreator guestProfileCreator = GuestProfileCreator.getInstance();

        // Profile name setter.
        ProfileNameSetter profileNameSetter = ProfileNameSetter.getInstance();

        /////////////////////////////////////////////////////////////////////////

        // Connections.
        // RegistrationDataSelector.
        registrationDataSelector.setNotifier(errorNotifier);
        registrationDataSelector.setResolver(requestResolver);
        registrationDataSelector.setChecker(checker);

        // ErrorNotifier.
        errorNotifier.setDataLineProvider(menuPanel);

        // RequestResolver.
        requestResolver.setExporterManager(exporterManager);
        requestResolver.setPanelChanger(panelChanger);
        requestResolver.setCardPanel(topCardPanel);
        requestResolver.setPanelKey(panelKey);

        // GuestProfileCreator.
        guestProfileCreator.setExporterManager(exporterManager);
        guestProfileCreator.setPanelChanger(panelChanger);
        guestProfileCreator.setCardPanel(topCardPanel);
        guestProfileCreator.setPanelKey(panelKey);
    }

}