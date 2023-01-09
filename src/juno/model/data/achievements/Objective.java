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

package juno.model.data.achievements;

import juno.model.data.score.InterfaceGamesWonCounter;
import juno.model.data.score.InterfaceLostGamesCounter;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class defines objectives objects.
 * @author Simone Gentili
 */
public enum Objective
        implements UnlockableAchievement, Observable, Observer {

    /** Registration objective. */
    REGISTRATION(0),

    /** First match won. */
    FIRST_MATCH_WON(1),

    /** First match lose. */
    FIRST_MATCH_LOSE(1),

    /** Five match won. */
    FIVE_MATCH_WON(5),

    /** Five match lose. */
    FIVE_MATCH_LOSE(5),

    /** Ten match won. */
    TEN_MATCH_WON(10),

    /** Ten match lose. */
    TEN_MATCH_LOSE(10),

    /** Fifty match won. */
    FIFTY_MATCH_WON(50),

    /** Fifty match lose. */
    FIFTY_MATCH_LOSE(50),

    /** One hundred match won. */
    ONE_HUNDRED_MATCH_WON(100),

    /** One hundred match lose. */
    ONE_HUNDRED_MATCH_LOSE(100);

    // The Observers List.
    private final List<Observer> observerList;

    // The points.
    private final int points;

    // Unlock value.
    private boolean unlock = false;

    /**
     * Builds an Objective object with the
     * specified point limit.
     * @param points An integer value.
     */
    Objective(int points) {
        this.points = points;
        observerList = new ArrayList<>();
    }

    @Override
    public void unlock() {
        if(unlock) throw new IllegalArgumentException(
                "This goal is already unlocked.");
        unlock = true;
        updateAll();
    }

    // Lock this goal.
    void lock() {
        unlock = false;
        updateAll();
    }

    @Override
    public boolean isUnlocked() {
        return unlock;
    }

    @Override
    public boolean addObserver(@NotNull Observer observer) {
        return observerList.add(observer);
    }

    @Override
    public boolean removeObserver(@NotNull Observer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    public void update(@NotNull Object object) {
        // Games won counter.
        if(object instanceof InterfaceGamesWonCounter<?> gamesWonCounter) {
            int gamesWon = (int) gamesWonCounter.provide();
            getUnreachedObjective(getGamesWonObjective()).forEach(award -> award.unlockIf(gamesWon));
        }

        // Lost games counter.
        else if(object instanceof InterfaceLostGamesCounter<?> lostGamesCounter) {
            int lostGames = (int) lostGamesCounter.provide();
            getUnreachedObjective(getLostGamesObjective()).forEach(award -> award.unlockIf(lostGames));
        }

        // Invalid case.
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                ". InterfaceGamesWonCounter or InterfaceLostGamesCounter types expected.");
    }

    /**
     * Returns the unreached objective objects within the specified
     * List of objective objects.
     * @param objectives A List object.
     * @return A List object.
     */
    public static List<Objective> getUnreachedObjective(@NotNull List<Objective> objectives) {
        return objectives.stream().filter(goal -> !goal.isUnlocked()).toList();
    }

    /**
     * Returns the reached objective objects.
     * @return A List object.
     */
    public static List<Objective> getReachedObjective() {
        return Stream.of(Objective.values()).filter(Objective::isUnlocked).toList();
    }

    /**
     * Returns the objective objects that refer to games won.
     * @return A List object.
     */
    public static List<Objective> getGamesWonObjective() {
        return Stream.of(Objective.values()).filter(objective -> objective.name().endsWith("WON")).toList();
    }

    /**
     * Returns the objective objects that refer to lost games.
     * @return A List object.
     */
    public static List<Objective> getLostGamesObjective() {
        return Stream.of(Objective.values()).filter(objective -> objective.name().endsWith("LOSE")).toList();
    }

     // Unlock this objective object if the specified
     // integer is greater than or equals to the
     // points of this objective object.
     // @param points An integer value.
    private void unlockIf(int points) {
        if(this.points == points) unlock();
    }

}