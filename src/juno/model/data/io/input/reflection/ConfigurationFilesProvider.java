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

package juno.model.data.io.input.reflection;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class defines a configuration file provider.
 * The method implemented by the 'InterfaceConfigurationFilesProvider'
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
public class ConfigurationFilesProvider
        extends AbstractConfigurationFilesProvider
        implements InterfaceConfigurationFilesProvider {

    // Recursive boolean value.
    private boolean recursive;

    // List of extensions.
    private final List<String> extensions;

    // The ConfigurationFilesProvider instance.
    private static ConfigurationFilesProvider instance;

    // Builds the ConfigurationFilesProvider.
    private ConfigurationFilesProvider() {
        recursive = true;
        extensions = new ArrayList<>();
    }

    /**
     * Returns the ConfigurationFilesProvider instance.
     * @return The ConfigurationFilesProvider instance.
     */
    public static ConfigurationFilesProvider getInstance() {
        if(instance == null) instance = new ConfigurationFilesProvider();
        return instance;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Object object,
                                            @NotNull String path) throws FileNotFoundException {
        // Taking a copy of the object's data.
        Map<String, Object> properties = getCopier().copy(object);
        // Getting configurations files.
        List<File> configurationFiles = getFiles(object, path);
        // Attempt to restore the initial state of the object.
        try {
            if(!properties.isEmpty())
                getConfigurator().configure(object, properties);
        } catch (IllegalAccessException |
                 NoSuchFieldException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        } return configurationFiles;
    }

    private List<File> getFiles(Object object,
                                String path) throws FileNotFoundException {
        // Compatible configuration files.
        List<File> configurationFiles = new ArrayList<>();
        File inputFile = new File(path);
        if(!inputFile.exists()) throw new FileNotFoundException(path);
        if(inputFile.isFile()) {
            if(getChecker().areCompatible(object, path)) {
                configurationFiles.add(inputFile);
            }
        } else if(inputFile.listFiles() != null) {
            // Objects.requireNonNull suppress the Nullable warning.
            for(File file : Objects.requireNonNull(inputFile.listFiles())) {
                if(file.isFile()) {
                    if(getChecker().areCompatible(object, file.getAbsolutePath())) {
                        configurationFiles.add(file);
                    }
                } else {
                    if(recursive) {
                        configurationFiles.addAll(getConfigurationFiles(object, file.getAbsolutePath()));
                    }
                }
            }
        } return configurationFiles;
    }

    /**
     * Sets the recursion of the getConfigurationFiles()
     * methods.
     * @param value A boolean value.
     */
    public void setRecursive(boolean value) {
        this.recursive = value;
    }

    /**
     * Returns the extensions List object.
     * @return A List<String> object.
     */
    public List<String> extensions() {
        return extensions;
    }

}