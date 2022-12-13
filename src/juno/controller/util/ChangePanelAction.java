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

package juno.controller.util;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ChangePanelAction
        extends AbstractPanelChangerUser {

    // The card panel.
    private final JPanel cardPanel;

    // The key of the panel.
    private final String panelKey;

    /**
     * Builds a ChangePanelAction object with
     * the specified objects.
     * @param cardPanel A JPanel object.
     * @param panel A String object.
     */
    public ChangePanelAction(@NotNull JPanel cardPanel,
                             @NotNull String panel) {
        this.cardPanel = cardPanel;
        this.panelKey = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Objects.requireNonNull(getPanelChanger()).changePanel(cardPanel, panelKey);
    }

}