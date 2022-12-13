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

import juno.model.data.io.output.AbstractExporterManagerAndPanelChangerUser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author Simone Gentili
 */
public abstract class AbstractRequestResolver
        extends AbstractExporterManagerAndPanelChangerUser
        implements InterfaceRequestResolver {

    // The card panel.
    private JPanel cardPanel;

    // The panel key.
    private String panelKey;

    /**
     * Sets the card panel of this object.
     * @param cardPanel A JPanel object.
     */
    public void setCardPanel(@NotNull JPanel cardPanel) {
        this.cardPanel = cardPanel;
    }

    /**
     * Sets the panel key of this object.
     * @param panelKey A String object.
     */
    public void setPanelKey(@NotNull String panelKey) {
        this.panelKey = panelKey;
    }

    /**
     * Returns the card panel of this object.
     * @return A JPanel object.
     */
    @Nullable
    public JPanel getCardPanel() {
        return cardPanel;
    }

    /**
     * Returns the panel key of this object.
     * @return A String object.
     */
    @Nullable
    public String getPanelKey() {
        return panelKey;
    }

}