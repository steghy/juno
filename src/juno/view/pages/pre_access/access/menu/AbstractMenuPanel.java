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

package juno.view.pages.pre_access.access.menu;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author Simone Gentili
 */
public class AbstractMenuPanel
        extends JPanel {

    // Sub components.
    private AbstractButton createAnAccountButton;
    private AbstractButton logInButton;
    private AbstractButton continueWithoutAnAccountButton;
    private AbstractButton exitButton;


    /**
     * Sets the 'Create an account' button.
     *
     * @param createAnAccountButton An AbstractButton.
     */
    public void setCreateAnAccountButton(@NotNull AbstractButton createAnAccountButton) {
        this.createAnAccountButton = createAnAccountButton;
    }

    /**
     * Sets the 'Log in' button.
     *
     * @param logInButton An AbstractButton.
     */
    public void setLogInButton(@NotNull AbstractButton logInButton) {
        this.logInButton = logInButton;
    }

    /**
     * Sets the 'Continue without an account' button.
     *
     * @param continueWithoutAnAccountButton An AbstractButton.
     */
    public void setContinueWithoutAnAccountButton(@NotNull AbstractButton continueWithoutAnAccountButton) {
        this.continueWithoutAnAccountButton = continueWithoutAnAccountButton;
    }

    /**
     * Sets the 'Exit' button.
     *
     * @param exitButton An AbstractButton.
     */
    public void setExitButton(@NotNull AbstractButton exitButton) {
        this.exitButton = exitButton;
    }

    /**
     * Returns the 'Create an account' button of this object.
     * @return An AbstractButton object.
     */
    @Nullable
    public AbstractButton getCreateAnAccountButton() {
        return createAnAccountButton;
    }

    /**
     * Returns the 'Log in' button of this object.
     * @return An AbstractButton object.
     */
    @Nullable
    public AbstractButton getLogInButton() {
        return logInButton;
    }

    /**
     * Returns the 'Continue without an account'
     * button of this object.
     * @return An AbstractButton object.
     */
    @Nullable
    public AbstractButton getContinueWithoutAnAccountButton() {
        return continueWithoutAnAccountButton;
    }

    /**
     * Returns the 'Exit' button of this object.
     * @return An AbstractButton object.
     */
    @Nullable
    public AbstractButton getExitButton() {
        return exitButton;
    }

}