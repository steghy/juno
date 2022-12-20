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

package juno.model.data.goals;

import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.LostGamesCounter;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    /** Initialize the goals and they relative awards. */
    public static void initialize() {
        // Components.
        // GamesWonCounter.
        GamesWonCounter gamesWonCounter = GamesWonCounter.getInstance();

        // LostGamesCounter.
        LostGamesCounter lostGamesCounter = LostGamesCounter.getInstance();

        ////////////////////////////////////////////////////////////////////

        // Observer / Observable connections.
        // Games won goals case.
        Goal.getGamesWonGoals().forEach(gamesWonCounter::addObserver);

        // Lost games goals case.
        Goal.getLostGamesGoals().forEach(lostGamesCounter::addObserver);

    }

}