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

package juno.init.initializer;

/**
 * @author Simone Gentili
 */
public class ModelInitializer {

    // Builds a ModelInitializer object.
    private ModelInitializer() {}

    /** Initialize the juno.model package. */
    public static void initialize() {
        juno.model.requester.Initializer.initialize();
        juno.model.data.io.input.Initializer.initialize();
        juno.model.data.profile.Initializer.initialize();
        juno.model.data.io.output.Initializer.initialize();
        juno.model.data.avatar.Initializer.initialize();
        juno.model.data.goals.Initializer.initialize();
        juno.model.data.awards.Initializer.initialize();
        juno.model.deck.Initializer.initialize();
        juno.model.subjects.factory.Initializer.getInstance().initialize();
        juno.model.subjects.ai.examiner.Initializer.initialize();
        juno.model.subjects.shift.Initializer.getInstance().initialize();
        juno.model.subjects.human.Initializer.getInstance().initialize();
    }

}