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

import juno.controller.util.InterfaceInitializer;
import juno.controller.util.PanelChanger;
import juno.model.data.io.input.configurable.CConfigurationFileResearcher;
import juno.model.data.profile.profile.Profile;
import juno.init.ProgramDirectory;
import juno.view.pages.pre_access.card.PreAccessCardPanel;

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
        // Pre access manager.
        PreAccessManager preAccessManager = PreAccessManager.getInstance();

        // Configuration files factory.
        ConfigurationFilesFactory configurationFilesFactory = ConfigurationFilesFactory.getInstance();

        //////////////////////////////////////////////////////////////////

        // Pre access manager.
        preAccessManager.setPanelChanger(new PanelChanger(
                PreAccessCardPanel.getInstance(),
                PreAccessCardPanel.ACCESS_PANEL));
        ConfigurationFilesFactory.getInstance().addObserver(preAccessManager);

        // Configuration files factory.
        configurationFilesFactory.setConfigurable(Profile.getInstance());
        configurationFilesFactory.setPath(ProgramDirectory.PROFILES.absolutePath());
        configurationFilesFactory.setResearcher(CConfigurationFileResearcher.getInstance());
    }

}