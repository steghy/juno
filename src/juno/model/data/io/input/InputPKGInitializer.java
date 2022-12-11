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

package juno.model.data.io.input;

import juno.model.data.io.input.configurable.CCompatibilityChecker;
import juno.model.data.io.input.configurable.CConfigurationFilesProvider;
import juno.model.data.io.input.reflection.RCompatibilityChecker;
import juno.model.data.io.input.reflection.RConfigurationFilesProvider;

/**
 * This class defines the initializer of the package
 * it belongs to, i.e. the juno.model.data.io.input package.
 * By initialization, we mean the realization of the
 * interconnection between the concrete classes of the package.
 * @author Simone Gentili
 */
public class InputPKGInitializer {

    // Builds the InputPKGInitializer.
    private InputPKGInitializer() {}

    /**
     * Initialize the entire juno.model.data.io.input
     * package by connecting the concrete classes to
     * each other according to their respective dependencies.
     */
    public static void initialize() {
        // juno.model.data.io.input package.
        juno.model.data.io.input.
                InterfacePropertyCopier propertyCopier = juno.model.data.io.input.
                                                         PropertyCopier.getInstance();
        juno.model.data.io.input.
                InterfaceDataImporter jsonDataImporter = juno.model.data.io.input.
                                                         JSONDataImporter.getInstance();

        // juno.model.data.io.input.configurable package.
        CCompatibilityChecker cCompatibilityChecker = CCompatibilityChecker.getInstance();
        CConfigurationFilesProvider configurableConfigurationFilesProvider = CConfigurationFilesProvider.getInstance();
        cCompatibilityChecker.setImporter(jsonDataImporter);

        configurableConfigurationFilesProvider.setCopier(propertyCopier);
        configurableConfigurationFilesProvider.setChecker(cCompatibilityChecker);

        // juno.model.data.io.input.reflect package.
        RCompatibilityChecker rCompatibilityChecker = RCompatibilityChecker.getInstance();
        RConfigurationFilesProvider reflectConfigurableFilesProvider = RConfigurationFilesProvider.getInstance();
        juno.model.data.io.input.reflection.
                Configurator configurator = juno.model.data.io.input.reflection.
                                            Configurator.getInstance();

        rCompatibilityChecker.setImporter(jsonDataImporter);
        rCompatibilityChecker.setConfigurator(configurator);

        reflectConfigurableFilesProvider.setCopier(propertyCopier);
        reflectConfigurableFilesProvider.setChecker(rCompatibilityChecker);
        reflectConfigurableFilesProvider.setConfigurator(configurator);
    }

}