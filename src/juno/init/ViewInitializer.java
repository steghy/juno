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

package juno.init;

import juno.view.frame.FrameInitializer;
import juno.view.pages.card.TopCardPanelConfigurator;
import juno.view.pages.main.MainPanelInitializer;
import juno.view.pages.newgame.NewGameInitializer;
import juno.view.pages.options.OptionsInitializer;
import juno.view.pages.preaccess.PreAccessInitializer;
import juno.view.pages.score.ScorePanelInitializer;

public class ViewInitializer {

    private ViewInitializer() {}

    public static void initialize() {
        // NEW GAME SECTION
        NewGameInitializer.initialize();

        // SCORE SECTION
        ScorePanelInitializer.initialize();

        // OPTIONS SECTION
        OptionsInitializer.initialize();

        // MAIN PANEL SECTION
        MainPanelInitializer.initialize();

        // PRE ACCESS PANEL
        PreAccessInitializer.initialize();

        // TOP CARD PANEL CONFIGURATION
        TopCardPanelConfigurator.configure();

        // FRAME SECTION
        FrameInitializer.initializer();
    }
}