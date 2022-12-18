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

package juno.view.factories;

import juno.init.InterfacePathProvider;
import juno.view.gobject.AbstractGObjectCreator;
import juno.view.gobject.InterfacePathObjectProvider;
import juno.view.util.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ButtonCreator
        extends AbstractGObjectCreator<InterfaceButton> {

    // The ImageButtonCreator instance.
    private static ButtonCreator instance;

    // Builds the ImageButtonCreator instance.
    private ButtonCreator() {}

    /**
     * Returns the ImageButtonCreator instance.
     * @return The ImageButtonCreator instance.
     */
    public static ButtonCreator getInstance() {
        if(instance == null) instance = new ButtonCreator();
        return instance;
    }

    public AbstractButton create(@NotNull InterfaceButton button) {
        AbstractButton temp;
        String rollover = "_ROLLOVER";
        String selected = "_SELECTED";
        String extension = ".png";
        InterfaceImageComponentInitializer initializer = getInitializer();
        InterfacePathObjectAssembler assembler = getAssembler();
        InterfacePathObjectProvider<InterfaceButton> provider = getProvider();
        InterfacePathProvider pathObject = Objects.requireNonNull(provider).getPathObjectOf(button);
        Objects.requireNonNull(assembler);
        Objects.requireNonNull(initializer);
        if(button.isToggleButton()) {
            temp = new ImageToggleButton();
            initializer.initialize(
                    temp,
                    assembler.assemble(pathObject, button.name() + extension),
                    assembler.assemble(pathObject, button.name() + rollover + extension),
                    assembler.assemble(pathObject, button.name() + selected + extension),
                    assembler.assemble(pathObject, button.name() + rollover + selected + extension));
        } else {
            temp = new ImageButton();
            initializer.initialize(
                    temp,
                    assembler.assemble(pathObject, button.name() + extension),
                    assembler.assemble(pathObject, button.name() + rollover + extension));
        } return temp;
    }

}