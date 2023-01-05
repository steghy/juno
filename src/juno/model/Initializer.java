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

package juno.model;

import juno.controller.util.InterfaceInitializer;

/**
 * @author Simone Gentili
 */
public class Initializer
        implements InterfaceInitializer {

    // The Initializer instance.
    private static Initializer instance;

    // Builds the Initializer instance.
    private Initializer() {}

    /**
     * Returns the Initializer instance.
     * @return The Initializer instance.
     */
    public static Initializer getInstance() {
        if(instance == null) instance = new Initializer();
        return instance;
    }

    @Override
    public void initialize() {
        // juno.model.requester package.
        juno.model.requester.Initializer.getInstance().initialize();

        // juno.model.deck package.
        juno.model.deck.Initializer.getInstance().initialize();

        // juno.model.data package.
        juno.model.data.profile.Initializer.getInstance().initialize();
        juno.model.data.io.input.Initializer.getInstance().initialize();
        juno.model.data.io.output.Initializer.getInstance().initialize();
        juno.model.data.avatar.Initializer.getInstance().initialize();
        juno.model.data.goals.Initializer.getInstance().initialize();
        juno.model.data.awards.Initializer.getInstance().initialize();

        // juno.model.subjects package.
        juno.model.subjects.factory.Initializer.getInstance().initialize();
        juno.model.subjects.ai.examiner.Initializer.getInstance().initialize();
        juno.model.subjects.shift.Initializer.getInstance().initialize();
        juno.model.subjects.human.Initializer.getInstance().initialize();

        // juno.model.sound package.
        juno.model.sound.Initializer.getInstance().initialize();
    }

}