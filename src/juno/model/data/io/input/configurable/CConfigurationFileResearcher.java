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

package juno.model.data.io.input.configurable;

import juno.model.util.ExtensionExtractor;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class defines a configuration file researcher.
 * The method implemented by the 'InterfaceConfigurationFilesResearcher'
 * interface allows to obtain the configuration files
 * compatible with the specified object. A configuration
 * file is considered compatible only if no exceptions
 * are thrown during the configuration process.
 * it is possible to specify the extensions of the files
 * to be considered (in case the list is empty all the
 * extensions will be considered) by invoking the 'extensions()'
 * method and adding to the returned list the strings
 * representing the extensions to be included.
 * By default, the method is recursive, but it is possible
 * to disable this behavior by calling the 'setRecursive()'
 * method.
 * @author Simone Gentili
 */
public class CConfigurationFileResearcher
        extends AbstractCConfigurationFileResearcher
        implements InterfaceCConfigurationFileResearcher {

    // The ConfigurationFileResearcher instance.
    private static CConfigurationFileResearcher instance;

    // Builds the ConfigurationFileResearcher instance.
    private CConfigurationFileResearcher() {}

    /**
     * Returns the ConfigurationFileResearcher instance.
     * @return The ConfigurationFileResearcher instance.
     */
    public static CConfigurationFileResearcher getInstance() {
        if (instance == null) instance = new CConfigurationFileResearcher();
        return instance;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Configurable configurable,
                                            @NotNull String path) throws FileNotFoundException{
        // Taking a copy of the object's data.
        Map<String, Object> properties = Objects.requireNonNull(getCopier()).copy(configurable);

        // Getting configurations files.
        List<File> configurationFiles = getFiles(configurable, path);

        // Attempt to restore the initial state of the object.
        if(!properties.isEmpty()) configurable.configure(properties);
        return configurationFiles;
    }

    private List<File> getFiles(@NotNull Configurable configurable,
                                @NotNull String path) throws FileNotFoundException {
        // Compatible configuration files.
        List<File> configurationFiles = new ArrayList<>();
        File inputFile = new File(path);
        if(!inputFile.exists()) throw new FileNotFoundException(path);
        if(inputFile.isFile()) {
            if(preliminaries(inputFile) &&
                    Objects.requireNonNull(getChecker()).areCompatible(configurable, path))
               configurationFiles.add(inputFile);
        } else if(inputFile.listFiles() != null) {
            // Objects.requireNonNull suppress the Nullable warning.
            for(File file : Objects.requireNonNull(inputFile.listFiles())) {
                if(file.isFile()) {
                    if(preliminaries(file) &&
                            Objects.requireNonNull(getChecker()).areCompatible(configurable, file.getAbsolutePath()))
                        configurationFiles.add(file);
                } else {
                    if(isRecursive()) {
                        configurationFiles.addAll(getConfigurationFiles(configurable, file.getAbsolutePath()));
                    }
                }
            }
        } return configurationFiles;
    }

    // Returns true if, and only if the extension list
    // of this object has length 0 or the extension of
    // the file is contained by the extension List.
    private boolean preliminaries(@NotNull File file) {
        return getExtensions() == null ||
                getExtensions() != null &&
                        getExtensions().size() == 0 ||
                    getExtensions().stream()
                        .anyMatch(s -> s.equals(ExtensionExtractor
                                .extract(file.getName())));
    }

}