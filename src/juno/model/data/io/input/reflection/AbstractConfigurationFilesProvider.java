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

import juno.model.data.io.input.InterfacePropertyCopier;
import org.jetbrains.annotations.NotNull;

/**
 * This abstract class defines configuration file providers
 * which use compatibility checker to operate.
 * @author Simone Gentili
 */
public abstract class AbstractConfigurationFilesProvider
        extends juno.model.data.io.input.AbstractConfigurationFilesProvider {

    // The compatibility checker.
    private InterfaceCompatibilityChecker checker;

    // The configurator.
    private InterfaceConfigurator configurator;

    /**
     * Sets the compatibility checker of this object.
     * @param checker An InterfaceCompatibilityChecker object.
     */
    public void setChecker(@NotNull InterfaceCompatibilityChecker checker) {
        this.checker = checker;
    }

    /**
     * Sets the configurator of this object.
     * @param configurator An InterfaceConfigurator object.
     */
    public void setConfigurator(@NotNull InterfaceConfigurator configurator) {
        this.configurator = configurator;
    }

    /**
     * Returns the compatibility checker of this object.
     * @return An InterfaceCompatibilityChecker object.
     */
    public InterfaceCompatibilityChecker getChecker() {
        return checker;
    }

    /**
     * Returns the configurator of this object.
     * @return An InterfaceConfigurator object.
     */
    public InterfaceConfigurator getConfigurator() {
        return configurator;
    }

}