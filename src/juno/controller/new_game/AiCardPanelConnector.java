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

package juno.controller.new_game;

import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.AI;
import juno.model.subjects.factory.AiPlayerFactory;
import juno.model.subjects.factory.InterfaceAiPlayerGenerator;
import juno.model.util.Observer;
import juno.view.pages.new_game.single_player.match.panels.east.EastCardPanel;
import juno.view.pages.new_game.single_player.match.panels.north.NorthCardPanel;
import juno.view.pages.new_game.single_player.match.panels.west.WestCardPanel;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class AiCardPanelConnector
        implements Observer {

    // The Connector instance.
    private static AiCardPanelConnector instance;

    // Builds the Connector instance.
    private AiCardPanelConnector() {}

    /**
     * Returns the Connector instance.
     * @return The Connector instance.
     */
    public static AiCardPanelConnector getInstance() {
        if(instance == null) instance = new AiCardPanelConnector();
        return instance;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceAiPlayerGenerator<?>) {
            List<? extends InterfacePlayer<?>> aiList = AiPlayerFactory.getInstance().getObjects();
            Objects.requireNonNull(aiList);
            if(aiList.size() == 1) {
                ((AI<?, ?>) aiList.get(0)).addObserver(NorthCardPanel.getInstance());
            } else if(aiList.size() == 2) {
                ((AI<?, ?>) aiList.get(0)).addObserver(WestCardPanel.getInstance());
                ((AI<?, ?>) aiList.get(1)).addObserver(NorthCardPanel.getInstance());
            } else if(aiList.size() == 3) {
                ((AI<?, ?>) aiList.get(0)).addObserver(WestCardPanel.getInstance());
                ((AI<?, ?>) aiList.get(1)).addObserver(NorthCardPanel.getInstance());
                ((AI<?, ?>) aiList.get(2)).addObserver(EastCardPanel.getInstance());
            }
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceGenerator type expected.");
    }

}