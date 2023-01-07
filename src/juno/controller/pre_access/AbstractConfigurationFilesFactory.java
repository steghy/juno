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

import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.input.configurable.InterfaceCConfigurationFileResearcher;
import juno.model.util.AbstractObservable;
import juno.model.util.Factory;
import juno.model.util.Generator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * this abstract class defines abstract configuration
 * files factory.
 * @author Simone Gentili
 * @param <T> The type of the objects.
 */
public abstract class AbstractConfigurationFilesFactory<T>
        extends AbstractObservable
        implements Factory<T> {

    // The configuration file researcher.
    private InterfaceCConfigurationFileResearcher researcher;

    // The configurable.
    private Configurable configurable;

    // The path.
    private String path;

    /**
     * Sets the configuration files researcher of this object.
     * @param researcher An InterfaceConfigurationFileResearcher object.
     */
    public void setResearcher(@NotNull InterfaceCConfigurationFileResearcher researcher) {
        this.researcher = researcher;
    }

    /**
     * Sets the configurable object of this object.
     * @param configurable A Configurable object.
     */
    public void setConfigurable(@NotNull Configurable configurable) {
        this.configurable = configurable;
    }

    /**
     * Sets the path of this object.
     * @param path A String object.
     */
    public void setPath(@NotNull String path) {
        this.path = path;
    }

    /**
     * Returns the configuration files researcher of this object.
     * @return An InterfaceConfigurationFileResearcher object.
     */
    @Nullable
    public InterfaceCConfigurationFileResearcher getResearcher() {
        return researcher;
    }

    /**
     * Returns the configurable object of this object.
     * @return A Configurable object.
     */
    @Nullable
    public Configurable getConfigurable() {
        return configurable;
    }

    /**
     * Returns the path of this object.
     * @return A String object.
     */
    @Nullable
    public String getPath() {
        return path;
    }

}
