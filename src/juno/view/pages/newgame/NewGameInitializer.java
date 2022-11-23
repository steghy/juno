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

package juno.view.pages.newgame;

// MAIN COMPONENT

import juno.view.pages.newgame.card.NewGameCardPanelConfigurator;
import juno.view.pages.newgame.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.multiplayer.card.MultiplayerInitializer;
import juno.view.pages.newgame.singleplayer.SinglePlayerInitializer;
import juno.view.pages.newgame.title.TitlePanelConfigurator;


public class NewGameInitializer {

    private NewGameInitializer() {}

    public static void initialize() {
        // SUB COMPONENT INITIALIZATION
        SinglePlayerInitializer.initialize();
        MultiplayerInitializer.initialize();

        // MAIN COMPONENT CONFIGURATION
        MenuPanelConfigurator.configure();
        TitlePanelConfigurator.configure();
        NewGamePanelConfigurator.configure();

        // CARD PANEL CONFIGURATION
        NewGameCardPanelConfigurator.configure();
    }
}
