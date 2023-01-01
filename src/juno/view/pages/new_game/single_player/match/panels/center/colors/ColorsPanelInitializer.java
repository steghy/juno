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

package juno.view.pages.new_game.single_player.match.panels.center.colors;

import juno.controller.new_game.controller.CardEffectController;
import juno.controller.new_game.human.PassTurnAction;
import juno.controller.util.GSetterAction;
import juno.controller.util.InterfaceInitializer;
import juno.model.card.colors.Color;
import juno.model.card.colors.InterfaceColor;
import juno.model.deck.ActualColorManager;
import juno.view.gobject.GObjectButton;
import juno.view.gobject.color.GColorCreator;
import juno.view.util.ImageResizer;

import java.util.List;

/**
 * @author Simone Gentili
 */
public class ColorsPanelInitializer
        implements InterfaceInitializer {

    // The ColorsPanelInitializer instance.
    private static ColorsPanelInitializer instance;

    // Builds the ColorsPanelInitializer instance.
    private ColorsPanelInitializer() {}

    /**
     * Returns the ColorsPanelInitializer instance.
     * @return The ColorsPanelInitializer instance.
     */
    public static ColorsPanelInitializer getInstance() {
        if(instance == null) instance = new ColorsPanelInitializer();
        return instance;
    }

    /** Initialize the ColorsPanel instance. */
    public void initialize() {
        // Colors panel.
        ColorsPanel colorsPanel = ColorsPanel.getInstance();

        // Graphic color creator.
        GColorCreator gColorCreator = GColorCreator.getInstance();

        // Actual color manager.
        ActualColorManager actualColorManager = ActualColorManager.getInstance();

        // Turn mover action.
        PassTurnAction passTurnAction = PassTurnAction.getInstance();

        // Colors settings.
        List.of(Color.values()).forEach(color -> {
            GObjectButton<InterfaceColor> gColor =
                    (GObjectButton<InterfaceColor>) gColorCreator.create(color, null);
            GSetterAction<InterfaceColor> gSetterAction = new GSetterAction<>(gColor, actualColorManager);
            gSetterAction.addObserver(colorsPanel);
            gSetterAction.addObserver(passTurnAction);
            gColor.addActionListener(gSetterAction);
            ImageResizer.resize(gColor, 4.5);
            gColor.setEnabled(false);
            colorsPanel.add(gColor);
        });

        // Observer / Observable
        CardEffectController.getInstance().addObserver(colorsPanel);
    }

}