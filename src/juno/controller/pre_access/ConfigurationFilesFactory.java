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

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ConfigurationFilesFactory
        extends AbstractConfigurationFilesFactory<File> {

    // The configuration files.
    private List<File> configurationFiles;

    // The ConfigurationFilesFactory instance.
    private static ConfigurationFilesFactory instance;

    // Builds the ConfigurationFilesFactory instance.
    private ConfigurationFilesFactory() {}

    /**
     * Returns the ConfigurationFilesFactory instance.
     * @return The ConfigurationFilesFactory instance.
     */
    public static ConfigurationFilesFactory getInstance() {
        if(instance == null) instance = new ConfigurationFilesFactory();
        return instance;
    }

    @Override
    @Nullable
    public Collection<File> getObjects() {
        return configurationFiles;
    }

    @Override
    public void generate() {
        try {
            configurationFiles = Objects.requireNonNull(getResearcher())
                    .getConfigurationFiles(getConfigurable(), getPath());
        } catch (FileNotFoundException e) {
            boolean r = (new File(Objects.requireNonNull(getPath()))).mkdir();
            if (r) throw new IllegalArgumentException(
                    "Fatal Error: Cannot create directory in the " +
                            "following path: " + getPath());
        } updateAll();
    }

}