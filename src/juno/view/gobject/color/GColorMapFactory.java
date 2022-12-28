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
import juno.model.util.Observer;
import juno.view.gobject.AbstractGObjectMapFactory;
import juno.view.gobject.InterfaceGObject;
import juno.view.gobject.InterfaceGObjectGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Simone Gentili
 */
public class GColorMapFactory
        extends AbstractGObjectMapFactory<InterfaceColor>
        implements Observer {

    // The graphic color map.
    private Map<InterfaceColor, InterfaceGObject<InterfaceColor>> gCardsMap;

    // The graphic color map factory.
    private static GColorMapFactory instance;

    // Builds a GColorMapFactory instance.
    private GColorMapFactory() {}

    /**
     * Returns the GColorMapFactory instance.
     * @return The GColorMapFactory instance.
     */
    public static GColorMapFactory getInstance() {
        if(instance == null) instance = new GColorMapFactory();
        return instance;
    }

    @Override @Nullable
    public Map<InterfaceColor, InterfaceGObject<InterfaceColor>> getGObjectsMap() {
        return gCardsMap;
    }

    @Override
    public void generate(@NotNull List<InterfaceGObject<InterfaceColor>> colors) {
        gCardsMap = colors.stream()
                .collect(Collectors.toMap(InterfaceGObject::object, value -> value));
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceGObjectGenerator<?>) {
            generate(Objects.requireNonNull(getFactory()).getGObjects());
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceGObjectGenerator type expected.");
    }

}