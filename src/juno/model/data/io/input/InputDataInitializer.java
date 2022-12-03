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

import juno.model.data.io.input.c_configurator.CompatibilityChecker;
import juno.model.data.io.input.c_configurator.ConfigurationFilesProvider;
import juno.model.data.io.input.r_configurator.Configurator;

public class InputDataInitializer {

    /* Builds an InputDataInitializer object. */
    private InputDataInitializer() {}

    /** Initialize the juno.model.data.io.input package. */
    public static void initialize() {
        // C-Compatibility checker.
        JSONDataImporter jsonDataImporter = JSONDataImporter.getInstance();
        PropertyCopier propertyCopier = PropertyCopier.getInstance();
        CompatibilityChecker cCompatibilityChecker = CompatibilityChecker.getInstance();
        cCompatibilityChecker.setDataImporter(jsonDataImporter);
        cCompatibilityChecker.setPropertyCopier(propertyCopier);

        // R-Compatibility checker.
        juno.model.data.io.input.r_configurator.CompatibilityChecker rCompatibilityChecker = juno.model.data.io.input.r_configurator.CompatibilityChecker.getInstance();
        Configurator rConfigurator = Configurator.getInstance();
        rCompatibilityChecker.setDataImporter(jsonDataImporter);
        rCompatibilityChecker.setPropertyCopier(propertyCopier);
        rCompatibilityChecker.setRConfigure(rConfigurator);

        // C-Configuration files provider.
        ConfigurationFilesProvider cConfigurationFilesProvider = ConfigurationFilesProvider.getInstance();
        cConfigurationFilesProvider.setCCompatibilityChecker(cCompatibilityChecker);

        // R-Configuration files provider.
        juno.model.data.io.input.r_configurator.ConfigurationFilesProvider rConfigurationFilesProvider = juno.model.data.io.input.r_configurator.ConfigurationFilesProvider.getInstance();
        rConfigurationFilesProvider.setChecker(rCompatibilityChecker);
    }

}