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

import juno.view.frame.FrameInitializer;
import juno.view.pages.card.TopCardPanelConfigurator;
import juno.view.pages.main.MainPanelInitializer;
import juno.view.pages.new_game.NewGameInitializer;
import juno.view.pages.options.OptionsInitializer;
import juno.view.pages.pre_access.PreAccessInitializer;
import juno.view.pages.score.ScorePanelInitializer;

/**
 * @author Simone Gentili
 */
public class ViewInitializer {

    // Builds a ViewInitializer object.
    private ViewInitializer() {}

    /** Initialize the juno.view package. */
    public static void initialize() {
        // juno.view.awards.avatars package.
        juno.view.awards.avatars.Initializer.initialize();

        // juno.view.awards.frames package.
        juno.view.awards.frames.Initializer.initialize();

        // juno.view.pages.new_game package.
        juno.view.pages.new_game.NewGameInitializer.initialize();

        // juno.view.pages.score package.
        juno.view.pages.score.ScorePanelInitializer.initialize();

        // juno.view.pages.option package.
        OptionsInitializer.initialize();

        // juno.view.pages.pre_access package.
        PreAccessInitializer.initialize();

        // juno.view.card.TopCardPanel configuration.
        TopCardPanelConfigurator.configure();

        // juno.view.main package.
        MainPanelInitializer.initialize();

        // juno.view.frame package.
        FrameInitializer.initializer();
    }

}