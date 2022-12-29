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

import juno.controller.util.InterfaceInitializer;
import juno.model.card.colors.Color;
import juno.model.requester.PathProviderAssembler;
import juno.model.requester.ProgramDirectory;
import juno.view.img_initializer.ImageComponentInitializer;
import juno.view.util.RotatedIcon;

import java.util.List;

/**
 * @author Simone Gentili
 */
public class Initializer
        implements InterfaceInitializer {

    // The Initializer instance.
    private static Initializer instance;

    // Builds the Initializer instance.
    private Initializer() {}

    /**
     * Returns the Initializer instance.
     * @return The Initializer instance.
     */
    public static Initializer getInstance() {
        if(instance == null) instance = new Initializer();
        return instance;
    }

    @Override
    public void initialize() {
        GColorCreator gColorCreator = GColorCreator.getInstance();
        GColorFactory gColorFactory = GColorFactory.getInstance();
        GColorMapFactory gColorMapFactory = GColorMapFactory.getInstance();
        gColorCreator.setProvider(ProgramDirectory.COLORS);
        gColorCreator.setInitializer(ImageComponentInitializer.getInstance());
        gColorCreator.setAssembler(PathProviderAssembler.getInstance());
        gColorFactory.setCreator(gColorCreator);
        gColorMapFactory.setFactory(gColorFactory);
        gColorFactory.addObserver(gColorMapFactory);
        gColorFactory.generate(List.of(Color.values()), RotatedIcon.Rotate.ABOUT_CENTER);
    }

}