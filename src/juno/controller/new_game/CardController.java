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

package juno.controller.new_game;

import juno.model.card.InterfaceCard;
import juno.model.subjects.InterfacePlayer;
import juno.model.util.AbstractObservable;
import juno.model.util.InterfaceGenerator;
import juno.model.util.InterfaceProvider;
import juno.model.util.Observer;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Simone Gentili
 */
public class CardController
        extends AbstractObservable
        implements
        Observer,
        InterfaceProvider<List<InterfacePlayer<InterfaceCard>>>,
        InterfaceGenerator {

    // The players.
    private List<InterfacePlayer<InterfaceCard>> players;

    // The CardController instance.
    private static CardController instance;

    // Builds a CardController.
    private CardController() {}

    /**
     * Returns the CardController instance.
     * @return The CardController instance.
     */
    public static CardController getInstance() {
        if(instance == null) instance = new CardController();
        return instance;
    }

    @Override
    public List<InterfacePlayer<InterfaceCard>> provide() {
        return players;
    }

    @Override
    public void generate() {
        Map<InterfacePlayer<InterfaceCard>, InterfaceCard> map =
                players.stream().collect(Collectors.toMap(player -> player, InterfaceProvider::provide));
    }

    @Override @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof InterfaceProvider<?> provider) {
            players = (List<InterfacePlayer<InterfaceCard>>) provider.provide();
            generate();
        } else throw new IllegalArgumentException();
    }

}