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

package juno.controller.subscriber;

import juno.model.util.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This clas defines the ai panel subscriber.
 * @author Simone Gentili
 */
public class AiPanelSubscriber
        implements Subscriber, Observer{

    // The Observable -> Observer map.
    @Nullable
    private Map<Observable, Observer> map;

    // The AiPlayerSubscriber instance.
    private static AiPanelSubscriber instance;

    // Builds the AiPanelSubscriber instance.
    private AiPanelSubscriber() {
        map = new HashMap<>();
    }

    /**
     * Returns the AiPanelSubscriber instance.
     * @return The AiPanelSubscriber instance.
     */
    public static AiPanelSubscriber getInstance() {
        if(instance == null) instance = new AiPanelSubscriber();
        return instance;
    }

    @Override
    public void subscribe() {
        Objects.requireNonNull(map).forEach(Observable::addObserver);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        // The update comes from the Connector class.
        if(object instanceof Provider<?> provider) {
            map = (Map<Observable, Observer>) provider.provide();
            subscribe();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceProvider type expected.");
    }

}