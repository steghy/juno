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

import juno.model.data.io.input.configurable.Configurable;
import juno.model.util.InterfaceFactory;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class PreAccessManager
        extends AbstractPreAccessManager
        implements InterfaceFactory<File>, Observable {

    // The configuration files.
    private final List<File> configurationFiles;

    // The Observers List.
    private final List<Observer> observerList;

    // The PreAccessInitialChooser instance.
    private static PreAccessManager instance;

    // Builds the PreAccessInitialChooser instance.
    private PreAccessManager() {
        observerList = new ArrayList<>();
        configurationFiles = new ArrayList<>();
    }

    /**
     * Returns the PreAccessInitialChooser instance.
     * @return The PreAccessInitialChooser instance.
     */
    public static PreAccessManager getInstance() {
        if(instance == null) instance = new PreAccessManager();
        return instance;
    }

    /**
     * Sets the first panel to show.
     * @param path A String object.
     * @param configurable A Configurable object.
     */
    @SuppressWarnings("ALL")
    public void setFirstPanelToShow(@NotNull String path,
                                    @NotNull Configurable configurable) {
        List<File> files = null;
        try {
            files = Objects.requireNonNull(getResearcher())
                    .getConfigurationFiles(configurable, path);
        } catch (FileNotFoundException e) {
            new File(path).mkdir();
            e.printStackTrace();
        } if(files != null && files.size() > 0) {
            LayoutManager layoutManager = PreAccessCardPanel.getInstance().getLayout();
            if(layoutManager instanceof CardLayout cardLayout)
                cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.ACCESS_PANEL);
            else throw new IllegalArgumentException(
                        "Invalid object type: " + layoutManager.getClass() +
                                ". CardLayout type expected.");
            configurationFiles.clear();
            configurationFiles.addAll(files);
            updateAll();
        }
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    public Collection<File> getObjects() {
        return configurationFiles;
    }

}