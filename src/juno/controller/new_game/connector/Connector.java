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

import juno.model.util.InterfaceFactory;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Simone Gentili
 */
public class Connector
        implements InterfaceConnector<Observable>, Observer {

    // North card panel observer.
    Observer north;

    // East card panel observer.
    Observer east;

    // West card panel observer.
    Observer west;

    // The Connector instance.
    private static Connector instance;

    // Builds the Connector instance.
    private Connector() {}

    /**
     * Returns the Connector instance.
     * @return The Connector instance.
     */
    public static Connector getInstance() {
        if(instance == null) instance = new Connector();
        return instance;
    }

    @Override
    public void connect(@NotNull List<Observable> players) {
        if(players.size() == 1) {
            players.get(0).addObserver(north);
        } else if(players.size() == 2) {
            players.get(0).addObserver(west);
            players.get(1).addObserver(north);
        } else if(players.size() == 3) {
            players.get(0).addObserver(west);
            players.get(1).addObserver(north);
            players.get(2).addObserver(east);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceFactory<?> provider) {
            connect((List<Observable>) provider.getObjects());
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceProvider type expected.");
    }

}