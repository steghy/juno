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

package juno.controller.new_game.controller;

import juno.controller.util.InterfacePanelChanger;
import juno.controller.util.Stoppable;
import juno.model.util.AbstractObservable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class WinnerManager
        extends AbstractObservable {

    // The panel changer.
    @Nullable
    private InterfacePanelChanger panelChanger;

    // The stopper.
    @Nullable
    private Stoppable stopper;

    // The WinnerManager instance.
    private static WinnerManager instance;

    // Builds the WinnerManager instance.
    private WinnerManager() {}

    /**
     * Returns the WinnerManager instance.
     * @return The WinnerManager instance.
     */
    public static WinnerManager getInstance() {
        if(instance == null) instance = new WinnerManager();
        return instance;
    }

    public void menage() {
        updateAll();
        Objects.requireNonNull(stopper).stop();
        Objects.requireNonNull(panelChanger).changePanel();
    }

    /**
     * Sets the panel changer of this object.
     * @param panelChanger An InterfacePanelChanger object.
     */
    public void setPanelChanger(@NotNull InterfacePanelChanger panelChanger) {
        this.panelChanger = panelChanger;
    }

    /**
     * Sets the timers stopper of this object.
     * @param stopper A Stoppable object.
     */
    public void setStopper(@NotNull Stoppable stopper) {
        this.stopper = stopper;
    }

}