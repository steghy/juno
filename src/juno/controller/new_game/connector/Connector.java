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

package juno.controller.new_game.connector;

import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.factory.AiPlayerFactory;
import juno.model.subjects.factory.InterfaceAiPlayerGenerator;
import juno.model.util.AbstractObservable;
import juno.model.util.Observer;
import juno.model.util.Provider;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class Connector
        extends AbstractObservable
        implements InterfaceConnector<InterfacePlayer<?>>, Observer, Provider<Map<InterfacePlayer<?>, Component>> {

    // The north component.
    Component north;

    // The west component.
    Component west;

    // The east component.
    Component east;

    // The map InterfacePlayer -> Component.
    private final Map<InterfacePlayer<?>, Component> map;

    // The Connector instance.
    private static Connector instance;

    // Builds the Connector instance.
    private Connector() {
        map = new HashMap<>();
    }

    /**
     * Returns the Connector instance.
     * @return The Connector instance.
     */
    public static Connector getInstance() {
        if(instance == null) instance = new Connector();
        return instance;
    }

    public void connect(@NotNull List<InterfacePlayer<?>> list) {
        map.clear();
        // One AI player case.
        if(list.size() == 1) map.put(list.get(0), north);
        // Two AI player case.
        else if(list.size() == 2) {
            map.put(list.get(0), west);
            map.put(list.get(1), north);
        }
        // Three AI player case.
        else if(list.size() == 3) {
            map.put(list.get(0), west);
            map.put(list.get(1), north);
            map.put(list.get(2), east);
        } else throw new IllegalArgumentException(
                "Invalid number of players.");
        updateAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        // The update comes from the AI players factory.
        if(object instanceof InterfaceAiPlayerGenerator<?>)
            connect(factory.getObjects());
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". Provider type expected.");
    }

    @Override
    public Map<InterfacePlayer<?>, Component> provide() {
        return map;
    }

}