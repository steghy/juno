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
public class RConfigurationFilesProvider
        extends AbstractRConfigurationFilesProvider
        implements InterfaceRConfigurationFilesProvider {

    /* Recursive boolean value */
    private boolean recursive = true;

    /* The RConfigurationFilesProvider instance */
    private static RConfigurationFilesProvider instance;

    /* Builds the RConfigurationFilesProvider */
    private RConfigurationFilesProvider() {}

    /**
     * Returns the RConfigurationFilesProvider instance.
     * @return The RConfigurationFilesProvider instance.
     */
    public static RConfigurationFilesProvider getInstance() {
        if(instance == null) instance = new RConfigurationFilesProvider();
        return instance;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Object object,
                                            @NotNull String path) throws FileNotFoundException {
        List<File> files = new ArrayList<>();
        File inputFile = new File(path);
        if(!inputFile.exists()) throw new FileNotFoundException(path);
        if(inputFile.isFile()) {
            if(getRCompatibilityChecker().checkCompatibilityOf(object, path)) {
                files.add(inputFile);
            }
        } else {
            if(inputFile.listFiles() != null) {
                // Objects.requireNonNull suppress the Nullable warning
                for(File file : Objects.requireNonNull(inputFile.listFiles())) {
                    if(file.isFile()) {
                        if(getRCompatibilityChecker().checkCompatibilityOf(object, file.getAbsolutePath())) {
                            files.add(file);
                        }
                    } else {
                        if(recursive) {
                            files.addAll(getConfigurationFiles(object, file.getAbsolutePath()));
                        }
                    }
                }
            }
        } return files;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Class<?> clazz,
                                            @NotNull String path) throws FileNotFoundException {
        List<File> files = new ArrayList<>();
        File inputFile = new File(path);
        if(!inputFile.exists()) throw new FileNotFoundException(path);
        if(inputFile.isFile()) {
            if(getRCompatibilityChecker().checkCompatibilityOf(clazz, path)) {
                files.add(inputFile);
            }
        } else {
            if(inputFile.listFiles() != null) {
                // Objects.requireNonNull suppress the Nullable warning
                for(File file : Objects.requireNonNull(inputFile.listFiles())) {
                    if(file.isFile()) {
                       if(getRCompatibilityChecker().checkCompatibilityOf(clazz, file.getAbsolutePath())) {
                           files.add(file);
                       }
                    } else {
                        if(recursive) {
                            files.addAll(getConfigurationFiles(clazz, file.getAbsolutePath()));
                        }
                    }
                }
            }
        } return files;
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