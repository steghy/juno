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

public class RConfigurationFilesProvider
        extends AbstractRConfigurationFilesProvider
        implements InterfaceRConfigurationFilesProvider {

    private final List<File> configurationFiles;
    private boolean isRecursive = true;

    private static RConfigurationFilesProvider instance;

    private RConfigurationFilesProvider() {
        configurationFiles = new ArrayList<>();
    }

    public static RConfigurationFilesProvider getInstance() {
        if(instance == null) instance = new RConfigurationFilesProvider();
        return instance;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Object object,
                                            @NotNull String path) throws FileNotFoundException {
        configurationFiles.clear();
        setConfigurationFilesRecursive(object, path);
        return new ArrayList<>(configurationFiles);
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Class<?> clazz,
                                            @NotNull String path) throws FileNotFoundException {
       configurationFiles.clear();
       setConfigurationFilesRecursive(clazz, path);
       return new ArrayList<>(configurationFiles);
    }

    public void setRecursive(boolean value) {
        this.isRecursive =  value;
    }

    @SuppressWarnings("ALL")
    private void setConfigurationFilesRecursive(@NotNull Object object,
                                                @NotNull String path) throws FileNotFoundException {
        File inputFile = new File(path);
        if(!inputFile.exists()) throw new FileNotFoundException(path);
        if(inputFile.isFile()) {
            if(getRCompatibilityChecker().checkCompatibilityOf(object, path)) {
                configurationFiles.add(inputFile);
            }
        } else {
            if(inputFile.listFiles() != null) {
                for(File file : inputFile.listFiles()) {
                    if(file.isFile()) {
                        if(getRCompatibilityChecker().checkCompatibilityOf(object, file.getAbsolutePath())) {
                            configurationFiles.add(file);
                        }
                    } else {
                        if(isRecursive) {
                            setConfigurationFilesRecursive(object, file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings("ALL")
    private void setConfigurationFilesRecursive(@NotNull Class<?> clazz,
                                                @NotNull String path) throws FileNotFoundException {
        File inputFile = new File(path);
        if(!inputFile.exists()) throw new FileNotFoundException(path);
        if(inputFile.isFile()) {
            if(getRCompatibilityChecker().checkCompatibilityOf(clazz, path)) {
                configurationFiles.add(inputFile);
            }
        } else {
            if(inputFile.listFiles() != null) {
                for(File file : inputFile.listFiles()) {
                    if(file.isFile()) {
                       if(getRCompatibilityChecker().checkCompatibilityOf(clazz, file.getAbsolutePath())) {
                           configurationFiles.add(file);
                       }
                    } else {
                        if(isRecursive) {
                            setConfigurationFilesRecursive(clazz, file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}