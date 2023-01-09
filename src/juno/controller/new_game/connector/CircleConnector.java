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
import juno.model.util.AbstractObservable;
import juno.model.util.Observer;
import juno.model.util.Provider;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class defines a circle connector.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class CircleConnector<T>
        extends AbstractObservable
        implements InterfaceConnector<InterfacePlayer<T>>, Observer, Provider<Map<InterfacePlayer<T>, Component>> {

    // The map InterfacePlayer -> Circle gif.
    private final Map<InterfacePlayer<T>, Component> map;

    // The north component.
    private Component north;

    // The south component.
    private Component south;

    // The east component.
    private Component east;

    // The west component.
    private Component west;

    // The CircleConnector instance.
    private static CircleConnector<?> instance;

    // Builds the CircleConnector instance.
    private CircleConnector() {
        map = new HashMap<>();
    }

    /**
     * Returns the CircleConnector instance.
     * @return The CircleConnector instance.
     */
    public static CircleConnector<?> getInstance() {
        if(instance == null) instance = new CircleConnector<>();
        return instance;
    }

    @Override
    public void connect(@NotNull List<InterfacePlayer<T>> list) {
        map.clear();

        // Two players case.
        if(list.size() == 2) {
            map.put(list.get(0), north);
            map.put(list.get(1), south);
        }

        // Three players case.
        else if(list.size() == 3) {
            map.put(list.get(0), west);
            map.put(list.get(1), north);
            map.put(list.get(2), south);
        }

        // Four players case.
        else if(list.size() == 4) {
            map.put(list.get(0), west);
            map.put(list.get(1), north);
            map.put(list.get(2), east);
            map.put(list.get(3), south);
        }

        // Invalid case.
        else throw new IllegalArgumentException(
                "Invalid number of player.");
        updateAll();
    }

    @Override
    public Map<InterfacePlayer<T>, Component> provide() {
        return map;
    }

    @Override
    @SuppressWarnings("unchecked")
    // The update comes from the PlayerProvider class.
    public void update(@NotNull Object object) {
        if(object instanceof Provider<?> provider)
          connect((List<InterfacePlayer<T>>) provider.provide());
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". Provider type expected");
    }

    /**
     * Sets the north component of this object.
     * @param north A Component object.
     */
    public void setNorth(@NotNull Component north) {
        this.north = north;
    }

    /**
     * Sets the east component of this object.
     * @param east A Component object.
     */
    public void setEast(@NotNull Component east) {
        this.east = east;
    }

    /**
     * Sets the west component of this object.
     * @param west A Component object.
     */
    public void setWest(@NotNull Component west) {
        this.west = west;
    }

    /**
     * Sets the south component of this object.
     * @param south A Component object.
     */
    public void setSouth(@NotNull Component south) {
        this.south = south;
    }

}