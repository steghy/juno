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

package juno.view.pages.pre_access.card;

import juno.model.data.io.input.c_configurator.Configurable;
import juno.model.data.io.input.c_configurator.InterfaceConfigurationFilesProvider;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class PreAccessInitialChooser {

    /* The configuration files provider. */
    private InterfaceConfigurationFilesProvider configurationFilesProvider;

    /* The PreAccessInitialChooser instance. */
    private static PreAccessInitialChooser instance;

    /* Builds the PreAccessInitialChooser instance. */
    private PreAccessInitialChooser() {}

    /**
     * Returns the PreAccessInitialChooser instance.
     * @return The PreAccessInitialChooser instance.
     */
    public static PreAccessInitialChooser getInstance() {
        if(instance == null) instance = new PreAccessInitialChooser();
        return instance;
    }

    public void setFirstPanelToShow(@NotNull String path,
                                    @NotNull Configurable configurable) {
        List<File> files = null;
        try {
            files = configurationFilesProvider.getConfigurationFiles(configurable, path);
        } catch (FileNotFoundException e) {
            // Directory not found !!! solve.
            e.printStackTrace();
        } if(files != null) {
            LayoutManager layoutManager = PreAccessCardPanel.getInstance().getLayout();
            if(layoutManager instanceof CardLayout cardLayout) {
                cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.ACCESS_PANEL);
            } else {
                throw new IllegalArgumentException("CardLayout expected");
            }
        }
    }

    /**
     * Sets the configuration files provider of this object.
     * @param configurationFilesProvider An InterfaceConfigurationFilesProvider object.
     */
    public void setConfigurationFilesProvider(@NotNull InterfaceConfigurationFilesProvider configurationFilesProvider) {
        this.configurationFilesProvider = configurationFilesProvider;
    }

}