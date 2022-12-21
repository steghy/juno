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
import juno.model.data.io.input.configurable.CConfigurationFileResearcher;
import juno.model.data.profile.profile.Profile;
import juno.model.requester.ProgramDirectory;
import juno.view.pages.pre_access.card.PreAccessCardPanel;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    /** Initialize the juno.controller.pre_access package. */
    public static void initialize() {
        // Components.
        // PreAccessManager.
        PreAccessManager preAccessManager = PreAccessManager.getInstance();

        // ConfigurationFilesFactory.
        ConfigurationFilesFactory configurationFilesFactory = ConfigurationFilesFactory.getInstance();

        //////////////////////////////////////////////////////////////////

        // Connections.
        // PreAccessManager.
        preAccessManager.setPanelChanger(new PanelChanger(
                PreAccessCardPanel.getInstance(),
                PreAccessCardPanel.ACCESS_PANEL));
        ConfigurationFilesFactory.getInstance().addObserver(preAccessManager);

        // ConfigurationFilesFactory.
        configurationFilesFactory.setConfigurable(Profile.getInstance());
        configurationFilesFactory.setPath(ProgramDirectory.PROFILES.absolutePath());
        configurationFilesFactory.setResearcher(CConfigurationFileResearcher.getInstance());
    }

}