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

public class InputDataInitializer {

    private InputDataInitializer() {}

    public static void initialize() {
        // CCOMPATIBILITY CHECKER
        JSONDataImporter jsonDataImporter = JSONDataImporter.getInstance();
        PropertyCopier propertyCopier = PropertyCopier.getInstance();
        CCompatibilityChecker cCompatibilityChecker = CCompatibilityChecker.getInstance();
        cCompatibilityChecker.setDataImporter(jsonDataImporter);
        cCompatibilityChecker.setPropertyCopier(propertyCopier);

        // RCOMPATIBILITY CHECKER
        RCompatibilityChecker rCompatibilityChecker = RCompatibilityChecker.getInstance();
        RConfigurator rConfigurator = RConfigurator.getInstance();
        rCompatibilityChecker.setDataImporter(jsonDataImporter);
        rCompatibilityChecker.setPropertyCopier(propertyCopier);
        rCompatibilityChecker.setRConfigure(rConfigurator);

        // CCONFIGURATION FILES PROVIDER
        CConfigurationFilesProvider cConfigurationFilesProvider = CConfigurationFilesProvider.getInstance();
        cConfigurationFilesProvider.setCCompatibilityChecker(cCompatibilityChecker);

        // RCONFIGURATION FILES PROVIDER
        RConfigurationFilesProvider rConfigurationFilesProvider = RConfigurationFilesProvider.getInstance();
        rConfigurationFilesProvider.setRCompatibilityChecker(rCompatibilityChecker);

        // CONFIGURATION FILES PROVIDER
        ConfigurationFilesProvider configurationFilesProvider = ConfigurationFilesProvider.getInstance();
        configurationFilesProvider.setCConfigurationFilesProvider(cConfigurationFilesProvider);
        configurationFilesProvider.setRConfigurationFilesProvider(rConfigurationFilesProvider);
    }
}