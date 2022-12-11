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

import juno.model.data.io.input.AbstractPropertyCopierUser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This abstract class defines configuration file providers
 * which use compatibility checker (InterfaceCompatibilityChecker)
 * and configurator (InterfaceConfigurator) to operate.
 * @author Simone Gentili
 */
public abstract class AbstractRConfigurationFilesProvider
        extends AbstractRCompatibilityCheckerAndCopierUser {

    // The recursive value.
    private boolean recursive;

    // The extensions.
    private List<String> extensions;


    // The configurator.
    private InterfaceConfigurator configurator;

    /**
     * Sets the configurator of this object.
     * @param configurator An InterfaceConfigurator object.
     */
    public void setConfigurator(@NotNull InterfaceConfigurator configurator) {
        this.configurator = configurator;
    }

    /**
     * Sets the recursive value of this object.
     * @param recursive A boolean value.
     */
    public void setRecursive(boolean recursive) {
        this.recursive = recursive;
    }

    /**
     * Sets the extensions list of this object.
     * @param extensions A List object.
     */
    public void setExtensions(@NotNull List<String> extensions) {
        this.extensions = extensions;
    }

    /**
     * Returns the configurator of this object.
     * @return An InterfaceConfigurator object.
     */
    @Nullable
    public InterfaceConfigurator getConfigurator() {
        return configurator;
    }

    /**
     * Returns true if, and only if, the recursive value
     * of this object is true.
     * @return A boolean value.
     */
    public boolean isRecursive() {
        return recursive;
    }

    /**
     * Returns the extensions list of this object.
     * @return A List object.
     */
    @Nullable
    public List<String> getExtensions() {
        return extensions;
    }


}