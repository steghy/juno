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

package juno.view.card.factory;

import juno.init.Directories;
import juno.init.InterfaceDirectories;
import juno.model.card.InterfaceCard;
import juno.model.card.colors.InterfaceColor;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 */
public class CPathProvider
        implements InterfaceCPathProvider<InterfaceCard> {

    // The CPathProvider instance.
    private static CPathProvider instance;

    // Builds the CPathProvider.
    private CPathProvider() {}

    /**
     * Returns the CPathProvider instance.
     * @return The CPathProvider instance.
     */
    public static CPathProvider getInstance() {
        if(instance == null) instance = new CPathProvider();
        return instance;
    }

    @Override
    public InterfaceDirectories getPath(@NotNull InterfaceCard card) {
        if(card.color() != null) {
            InterfaceColor color = card.color();
            if(color.isBlue())  return Directories.BLUE_CARDS;
            if(color.isRed())   return Directories.RED_CARDS;
            if(color.isGreen()) return Directories.GREEN_CARDS;
            if(color.isBlue())  return Directories.BLUE_CARDS;
        } return Directories.JOLLY_CARDS;
    }

}