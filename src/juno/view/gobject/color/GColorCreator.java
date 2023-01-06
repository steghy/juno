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

package juno.view.gobject.color;

import juno.model.card.colors.InterfaceColor;
import juno.model.requester.InterfacePathProvider;
import juno.model.requester.InterfacePathProviderAssembler;
import juno.view.gobject.*;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GColorCreator
        extends AbstractGObjectCreator<InterfaceColor>
        implements InterfaceGObjectCreator<InterfaceColor> {

    // The directory path provider.
    private InterfacePathProvider pathProvider;

    // The ColorCreator instance.
    private static GColorCreator instance;

    // Builds the ColorCreator instance.
    private GColorCreator() {}

    /**
     * Returns the ColorCreator instance.
     * @return The ColorCreator instance.
     */
    public static GColorCreator getInstance() {
        if(instance == null) instance = new GColorCreator();
        return instance;
    }

    /**
     * Sets the directory path provider of this object.
     * @param pathProvider An interfacePathProvider object.
     */
    public void setProvider(@NotNull InterfacePathProvider pathProvider) {
        this.pathProvider = pathProvider;
    }

    @Override
    public InterfaceGObject<InterfaceColor> create(@NotNull InterfaceColor color, RotatedIcon.Rotate rotate) {
        GObjectButton<InterfaceColor> graphicColor = new GObjectButton<>(color, Objects.requireNonNull(getResizer()));
        InterfacePathProviderAssembler assembler = getAssembler();
        Objects.requireNonNull(assembler);
        Objects.requireNonNull(getInitializer()).initialize(
                graphicColor,
                assembler.assemble(pathProvider, color.name() + ".png"),
                assembler.assemble(pathProvider, color.name() + "_ROLLOVER" + ".png"),
                rotate);
        return graphicColor;
    }

}