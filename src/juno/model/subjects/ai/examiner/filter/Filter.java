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

package juno.model.subjects.ai.examiner.filter;

import juno.model.card.InterfaceCard;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * This class defines a filter.
 * @author Simone Gentili
 */
public class Filter
        implements InterfaceFilter<InterfaceCard> {

    // The Filter instance.
    private static Filter instance;

    // Builds the Filter instance.
    private Filter() {}

    /**
     * Returns the Filter instance.
     * @return The Filter instance.
     */
    public static Filter getInstance() {
        if(instance == null) instance = new Filter();
        return instance;
    }

    @Override
    public List<InterfaceCard> action(@NotNull List<InterfaceCard> cards) {
        return cards.stream()
                .filter(card -> card.action() != null && !(card.action().isJolly()))
                .toList();
    }

    @Override
    public List<InterfaceCard> jolly(@NotNull List<InterfaceCard> cards) {
        return cards.stream()
                .filter(card -> card.action() != null && card.action().isJolly())
                .toList();
    }

    @Override
    public List<InterfaceCard> number(@NotNull List<InterfaceCard> cards) {
        return cards.stream()
                .filter(card -> card.value() != null)
                .toList();
    }

    @Override
    public List<InterfaceCard> color(@NotNull List<InterfaceCard> cards) {
        return cards.stream()
                .filter(card -> card.color() != null)
                .toList();
    }

    @Override
    public List<InterfaceCard> red(@NotNull List<InterfaceCard> cards) {
        return cards.stream()
                .filter(card -> card.color() != null && card.color().isRed())
                .toList();
    }

    @Override
    public List<InterfaceCard> blue(@NotNull List<InterfaceCard> cards) {
        return cards.stream()
                .filter(card -> card.color() != null && card.color().isBlue())
                .toList();
    }

    @Override
    public List<InterfaceCard> green(@NotNull List<InterfaceCard> cards) {
        return cards.stream()
                .filter(card -> card.color() != null && card.color().isGreen())
                .toList();
    }

    @Override
    public List<InterfaceCard> yellow(@NotNull List<InterfaceCard> cards) {
        return cards.stream()
                .filter(card -> card.color() != null && card.color().isYellow())
                .toList();
    }

}