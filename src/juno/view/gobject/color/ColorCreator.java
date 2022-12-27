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
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ColorCreator
        extends AbstractGObjectCreator<InterfaceColor>
        implements InterfaceGObjectCreator<InterfaceColor> {

    // The ColorCreator instance.
    private static ColorCreator instance;

    // Builds the ColorCreator instance.
    private ColorCreator() {}

    /**
     * Returns the ColorCreator instance.
     * @return The ColorCreator instance.
     */
    public static ColorCreator getInstance() {
        if(instance == null) instance = new ColorCreator();
        return instance;
    }

    @Override
    public InterfaceGObject<InterfaceColor> create(@NotNull InterfaceColor color) {
        GObjectLabel<InterfaceColor> graphicColor = new GObjectLabel<>(color);
        InterfacePathProviderAssembler assembler = getAssembler();
        InterfacePathObjectProvider<InterfaceColor> provider = getProvider();
        InterfacePathProvider pathObject = Objects.requireNonNull(provider).getPathObjectOf(color);
        Objects.requireNonNull(assembler);
        Objects.requireNonNull(getInitializer()).initialize(
                graphicColor,
                assembler.assemble(pathObject, color.name() + ".png"));
        return graphicColor;
    }

}