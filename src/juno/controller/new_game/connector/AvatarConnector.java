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
import juno.model.util.Observer;
import juno.model.util.Provider;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class defines an avatar connector.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class AvatarConnector<T>
        implements InterfaceConnector<InterfacePlayer<T>>, Observer, Provider<Map<InterfacePlayer<T>, Component>> {

    // The north component.
    private Component north;

    // The west component.
    private Component west;

    // The east component.
    private Component east;

    // The south component.
    private Component  south;

    // The map InterfacePlayer -> Component.
    private final Map<InterfacePlayer<T>, Component> map;

    // The AvatarConnector instance.
    private static AvatarConnector<?> instance;

    // Builds the AvatarConnector instance.
    private AvatarConnector() {
        map = new HashMap<>();
    }

    /**
     * Returns the AvatarConnector instance.
     * @return The AvatarConnector instance.
     */
    public static AvatarConnector<?> getInstance() {
        if(instance == null) instance = new AvatarConnector<>();
        return instance;
    }

    @Override
    public void connect(@NotNull List<InterfacePlayer<T>> list) {
        map.clear();
        if(list.size() == 2) {
            map.put(list.get(0), north);
            map.put(list.get(1), south);
        } else if(list.size() == 3) {
            map.put(list.get(0), west);
            map.put(list.get(1), north);
            map.put(list.get(2), south);
        } else if(list.size() == 4) {
            map.put(list.get(0), west);
            map.put(list.get(1), north);
            map.put(list.get(2), east);
            map.put(list.get(3), south);
        } else throw new IllegalArgumentException(
                "Invalid number of players.");
    }

    @Override
    public Map<InterfacePlayer<T>, Component> provide() {
        return map;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        // The update comes from the PlayerProvider class.
        if(object instanceof Provider<?> provider)
            connect((List<InterfacePlayer<T>>) provider.provide());
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". Provider type expected.");
    }

    /**
     * Sets the north component of this object.
     * @param north A Component object.
     */
    public void setNorth(@NotNull Component north) {
        this.north = north;
    }

    /**
     * Sets the west component of this object.
     * @param west A Component object.
     */
    public void setWest(@NotNull Component west) {
        this.west = west;
    }

    /**
     * Sets the east component of this object.
     * @param east A Component object.
     */
    public void setEast(@NotNull Component east) {
        this.east = east;
    }

    /**
     * Sets the south component of this object.
     * @param south A Component object.
     */
    public void setSouth(@NotNull Component south) {
        this.south = south;
    }

}