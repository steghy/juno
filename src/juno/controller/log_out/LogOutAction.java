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
import juno.model.util.InterfaceGenerator;
import juno.model.util.InterfaceProvider;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogOutAction<T>
        implements ActionListener {

    private final Restorable restorable;
    private final InterfaceExporterManager<T> exporterManager;
    private final InterfaceProvider<T> provider;
    private final InterfaceGenerator generator;

    public LogOutAction(@NotNull Restorable restorable,
                        @NotNull InterfaceExporterManager<T> exporterManager,
                        @NotNull InterfaceProvider<T> provider,
                        @NotNull InterfaceGenerator generator) {
        this.restorable = restorable;
        this.exporterManager = exporterManager;
        this.provider = provider;
        this.generator = generator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        T provided = provider.provide();
        exporterManager.export(provided);
        restorable.restore();
        generator.generate();
    }

}