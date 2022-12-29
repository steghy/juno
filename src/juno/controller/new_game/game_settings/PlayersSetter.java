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

package juno.controller.new_game.game_settings;

import juno.model.util.InterfaceSetter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 */
public class PlayersSetter
        implements InterfaceSetter<Integer> {

    // The PlayersSetter instance.
    private static PlayersSetter instance;

    // Builds the PlayersSetter instance.
    private PlayersSetter() {}

    /**
     * Returns the PlayersSetter instance.
     * @return The PlayersSetter instance.
     */
    public static PlayersSetter getInstance() {
        if(instance == null) instance = new PlayersSetter();
        return instance;
    }

    @Override
    public void set(@NotNull Integer players) {
        if(players < 2 || players > 4) throw new IllegalArgumentException(
                "Invalid number of players.");
        GameData.players =  players;
    }

}