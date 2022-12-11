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

import juno.model.data.profile.InterfaceErrorProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 */
public abstract class AbstractErrorNotifier {

    // The error provider.
    private InterfaceErrorProvider errorProvider;

    // The data line provider.
    private InterfaceDataLineProvider dataLineProvider;

    /**
     * Sets the error provider of this object.
     * @param errorProvider An InterfaceErrorProvider object.
     */
    public void setErrorProvider(@NotNull InterfaceErrorProvider errorProvider) {
        this.errorProvider = errorProvider;
    }

    /**
     * Sets the data line provider of this object.
     * @param dataLineProvider An InterfaceDataLineProvider object.
     */
    public void setDataLineProvider(@NotNull InterfaceDataLineProvider dataLineProvider) {
        this.dataLineProvider = dataLineProvider;
    }

    /**
     * Returns the error provider of this object.
     * @return An InterfaceErrorProvider object.
     */
    @Nullable
    public InterfaceErrorProvider getProvider() {
        return errorProvider;
    }

    /**
     * Returns the data line provider of this object.
     * @return An InterfaceDataLineProvider object.
     */
    @Nullable
    public InterfaceDataLineProvider getDataLineProvider() {
        return dataLineProvider;
    }

}