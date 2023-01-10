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

package juno.view.gobject.cards;

import juno.model.requester.InterfacePathProvider;
import juno.model.card.InterfaceCard;
import juno.view.gobject.*;
import juno.model.requester.InterfacePathProviderAssembler;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class defines a graphic card creator.
 * @author Simone Gentili
 */
public class GCardCreator
        extends AbstractGObjectCreator
        implements InterfaceGObjectCreator<InterfaceCard> {

    // The path object provider.
    private InterfacePathObjectProvider<InterfaceCard> provider;

    // The GCardCreator instance.
    private static GCardCreator instance;

    // Builds the GCardCreator instance.
    private GCardCreator() {}

    /**
     * Returns the GCardCreator instance.
     * @return The GCardCreator instance.
     */
    public static GCardCreator getInstance() {
        if(instance == null) instance = new GCardCreator();
        return instance;
    }

    /**
     * Sets the path provider of this object.
     * @param provider An InterfacePathObjectProvider object.
     */
    public void setProvider(@NotNull InterfacePathObjectProvider<InterfaceCard> provider) {
        this.provider = provider;
    }

    @Override
    public InterfaceGObject<InterfaceCard> create(@NotNull InterfaceCard card, RotatedIcon.Rotate rotate) {
        GObjectButton<InterfaceCard> graphicCard = new GObjectButton<>(card, Objects.requireNonNull(getResizer()));
        String file;
        if(card.value() != null) {
            file = card.value().toString();
        } else if (card.action() != null) {
            file = card.action().toString();
        } else throw new IllegalArgumentException("Invalid card attributes.");
        InterfacePathProviderAssembler assembler = getAssembler();
        InterfacePathProvider pathObject = Objects.requireNonNull(provider).getPathObjectOf(card);
        Objects.requireNonNull(assembler);
        Objects.requireNonNull(getInitializer()).initialize(
                graphicCard,
                assembler.assemble(pathObject, file + ".png"),
                assembler.assemble(pathObject, file + "_ROLLOVER" + ".png"),
                rotate);
        return graphicCard;
    }

}