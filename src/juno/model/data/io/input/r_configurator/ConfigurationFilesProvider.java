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

package juno.model.data.io.input.r_configurator;

import juno.model.data.io.input.AbstractRConfigurationFilesProvider;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class provides two methods for providing the
 * configuration files of a specified Object instance
 * or Class type. A file is considered compatible
 * for a given object if no exceptions are thrown when
 * the object is configured with that file.
 * The component that checks compatibility is the
 * 'RCompatibilityChecker' (see the associated documentation
 * for more information on this).
 * @author Simone Gentili
 */
public class ConfigurationFilesProvider
        extends AbstractRConfigurationFilesProvider {

    /* Recursive boolean value */
    private boolean recursive = true;

    private final List<String> extensions;

    /* The RConfigurationFilesProvider instance */
    private static ConfigurationFilesProvider instance;

    /* Builds the RConfigurationFilesProvider */
    private ConfigurationFilesProvider() {
        extensions = new ArrayList<>();
    }

    /**
     * Returns the RConfigurationFilesProvider instance.
     * @return The RConfigurationFilesProvider instance.
     */
    public static ConfigurationFilesProvider getInstance() {
        if(instance == null) instance = new ConfigurationFilesProvider();
        return instance;
    }

    /**
     * Returns the extensions List object.
     * @return A List<String> object.
     */
    public List<String> extensions() {
        return extensions;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Object object,
                                            @NotNull String path) throws FileNotFoundException {
        // Compatible files list.
        List<File> configurationFiles = new ArrayList<>();

        File inputFile = new File(path);
        if(!inputFile.exists()) throw new FileNotFoundException(path);

        if(inputFile.isFile()) {
            if(getChecker().checkCompatibilityOf(object, path)) {
                configurationFiles.add(inputFile);
            }
        } else {
            if(inputFile.listFiles() != null) {
                // Objects.requireNonNull suppress the Nullable warning
                for(File file : Objects.requireNonNull(inputFile.listFiles())) {
                    if(file.isFile()) {
                        if(getChecker().checkCompatibilityOf(object, file.getAbsolutePath())) {
                            configurationFiles.add(file);
                        }
                    } else {
                        if(recursive) {
                            configurationFiles.addAll(getConfigurationFiles(object, file.getAbsolutePath()));
                        }
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

}