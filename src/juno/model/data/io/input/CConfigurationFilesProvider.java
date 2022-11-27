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

public class CConfigurationFilesProvider
        extends AbstractCConfigurationFilesProvider
        implements InterfaceCConfigurationFilesProvider {

    private final List<File> configurationFiles;

    private static CConfigurationFilesProvider instance;

    private CConfigurationFilesProvider() {
        configurationFiles = new ArrayList<>();
    }

    public static CConfigurationFilesProvider getInstance() {
        if (instance == null) instance = new CConfigurationFilesProvider();
        return instance;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Configurable configurable,
                                            @NotNull String path) throws FileNotFoundException{
        configurationFiles.clear();
        if (!new File(path).exists()) throw new FileNotFoundException(path);
        setConfigurationFilesRecursive(configurable, path);
        return configurationFiles;
    }

    public void setConfigurationFilesRecursive(@NotNull Configurable configurable,
                                               @NotNull String path) throws FileNotFoundException {
        File inputFile = new File(path);
        if (!inputFile.exists()) throw new FileNotFoundException(path);
        if (inputFile.isFile() &&
                getCCompatibilityChecker().checkCompatibilityOf(configurable, path))
                configurationFiles.add(inputFile);
        else
            if (inputFile.listFiles() != null)
                for(File file : Objects.requireNonNull(inputFile.listFiles())) {
                    if(file.isFile() &&
                            getCCompatibilityChecker()
                                    .checkCompatibilityOf(configurable, file.getAbsolutePath()))
                        configurationFiles.add(file);
                    else
                        setConfigurationFilesRecursive(configurable, file.getAbsolutePath());
                }
    }
}