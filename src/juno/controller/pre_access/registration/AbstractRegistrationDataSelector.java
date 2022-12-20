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

package juno.controller.pre_access.registration;

import juno.controller.pre_access.loggers.InterfaceLogger;
import juno.model.data.io.input.AbstractCCompatibilityCheckerUser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 */
public abstract class AbstractRegistrationDataSelector
        extends AbstractCCompatibilityCheckerUser {

    // The error notifier.
    private InterfaceErrorNotifier notifier;

    // The logger object.
    private InterfaceLogger logger;

    /**
     * Sets the error notifier of this object.
     * @param notifier An InterfaceErrorNotifier object.
     */
    public void setNotifier(@NotNull InterfaceErrorNotifier notifier) {
        this.notifier = notifier;
    }

    /**
     * Sets the logger object of this object.
     * @param resolver An InterfaceLogger object.
     */
    public void setLogger(@NotNull InterfaceLogger resolver) {
        this.logger = resolver;
    }

    /**
     * Sets the error notifier of this object.
     * @return An InterfaceErrorNotifier object.
     */
    @Nullable
    public InterfaceErrorNotifier getNotifier() {
        return notifier;
    }

    /**
     * Returns the logger object of this object.
     * @return An InterfaceLogger object.
     */
    @Nullable
    public InterfaceLogger getLogger() {
        return logger;
    }

}