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

package juno.view.panels;

import org.jetbrains.annotations.Nullable;

import java.awt.*;

/**
 * This abstract class defines a panel with
 * ten components.
 * @author Simone Gentili
 */
public abstract class AbstractTenthComponent
        extends AbstractNinthComponent {

    /** Constructor. */
    public AbstractTenthComponent() {}

    /** The tenth component. */
    private Component tenthComponent;

    /**
     * Sets the tenth component of this object.
     * @param tenthComponent A Component object.
     */
    public void setTenthComponent(@Nullable Component tenthComponent) {
        this.tenthComponent = tenthComponent;
    }

    /**
     * Returns the tenth component of this object.
     * @return A Component object.
     */
    @Nullable
    public Component getTenthComponent() {
        return tenthComponent;
    }

}