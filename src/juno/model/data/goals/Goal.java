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

import juno.model.data.score.InterfaceGamesWonCounter;
import juno.model.data.score.InterfaceLostGamesCounter;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Simone Gentili
 */
public enum Goal
        implements
        InterfaceGoal,
        Observable,
        Observer {

    FIRST_MATCH_WON(1),
    FIRST_MATCH_LOSE(1),

    TEN_MATCH_WON(10),
    TEN_MATCH_LOSE(10),

    FIFTY_MATCH_WON(50),
    FIFTY_MATCH_LOSE(50),

    ONE_HUNDRED_MATCH_WON(100),
    ONE_HUNDRED_MATCH_LOSE(100);

    // The Observers List.
    private final List<Observer> observerList;

    // The points.
    private final int points;

    // Unlock value.
    private boolean unlock = false;

    /**
     * Builds a Goal object with the
     * specified point limit.
     * @param points An integer value.
     */
    Goal(int points) {
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

    @Override
    public boolean isReached() {
        return unlock;
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceGamesWonCounter gamesWonCounter) {
            int gamesWon = gamesWonCounter.getCount();
            getUnreachedGoals(getGamesWonGoals()).forEach(goal -> {
                goal.unlockIf(gamesWon); });
        } else if(object instanceof InterfaceLostGamesCounter lostGamesCounter) {
            int lostGames = lostGamesCounter.getCount();
            getUnreachedGoals(getLostGamesGoals()).forEach(goal -> {
                goal.unlockIf(lostGames); });
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                ". InterfaceGamesWonCounter or InterfaceLostGamesCounter types expected.");
    }

    public static List<Goal> getUnreachedGoals() {
        return Stream.of(Goal.values()).filter(goal -> !goal.isReached()).toList();
    }

    public static List<Goal> getUnreachedGoals(List<Goal> goals) {
        return goals.stream().filter(goal -> !goal.isReached()).toList();
    }

    public static List<Goal> getGamesWonGoals() {
        return Stream.of(Goal.values()).filter(goal -> goal.name().endsWith("WON")).toList();
    }

    public static List<Goal> getLostGamesGoals() {
        return Stream.of(Goal.values()).filter(goal -> goal.name().endsWith("LOSE")).toList();
    }

    private void unlockIf(int points) {
        if(this.points >= points) unlock();
    }

}