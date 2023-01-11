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

package juno.controller.log_out;

import juno.model.data.io.output.InterfaceExporterManager;
import juno.model.util.Provider;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class defines export user data action.
 * @author Simone Gentili
 * @param <T> The type of the provided objects.
 */
public class ExportUserDataAction<T>
        implements ActionListener {

    // The exporter manager.
    private final InterfaceExporterManager<T> exporterManager;

    // The object.
    private final Provider<T> provider;

    /**
     * Builds a ExportUserDataAction with the
     * specified parameters.
     * @param exporterManager An InterfaceExporterManager object.
     * @param provider A Provider object.
     */
    public ExportUserDataAction(@NotNull InterfaceExporterManager<T> exporterManager,
                                @NotNull Provider<T> provider) {
        this.exporterManager = exporterManager;
        this.provider = provider;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        exporterManager.export(provider.provide());
    }

}