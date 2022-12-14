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

package juno.view.pages.new_game.single_player.match.panels.center;

import juno.controller.audio.SoundAction;
import juno.controller.new_game.controller.CardEffectController;
import juno.controller.new_game.penalty.PenaltyTimer;
import juno.controller.new_game.restorer.Stopper;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.PanelChanger;
import juno.controller.util.StopAction;
import juno.model.sound.ButtonSoundPlayer;
import juno.model.sound.UnoSoundPlayer;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.pages.new_game.single_player.card.SinglePlayerCardPanel;
import juno.view.pages.new_game.single_player.match.panels.center.actual_color.ActualColorPanel;
import juno.view.pages.new_game.single_player.match.panels.center.circle.CirclePanel;
import juno.view.pages.new_game.single_player.match.panels.center.colors.ColorsPanel;
import juno.view.pages.new_game.single_player.match.panels.center.deck.DeckPanel;
import juno.view.pages.new_game.single_player.match.panels.center.discarded_pile.DiscardedPilePanel;
import juno.view.pages.new_game.single_player.match.panels.center.uno_button.UnoButtonPanel;
import juno.view.util.ImageResizer;

import javax.swing.*;

/**
 * This class defines the center panel configurator.
 * @author Simone Gentili
 */
public class CenterPanelConfigurator {

    // Builds a CenterPanelConfigurator object.
    private CenterPanelConfigurator() {}

    /** Configures the CenterPanel instance. */
    public static void configure() {
        // Main component.
        CenterPanel centerPanel = CenterPanel.getInstance();

        // Components.
        ImageResizer resizer = ImageResizer.getInstance();
        UnoButtonPanel unoButtonPanel = UnoButtonPanel.getInstance();
        AbstractButton unoButton = ButtonCreator.getInstance().create(Button.JUNO, null);
        AbstractButton exitButton = ButtonCreator.getInstance().create(Button.EXIT, null);

        // Uno button panel settings.
        unoButtonPanel.setFirstComponent(unoButton);

        // Image resizing.
        resizer.resize(exitButton, 3.5);
        resizer.resize(unoButton, 3.5);

        // Action listeners.
        // Exit button.
        exitButton.addActionListener(new SoundAction(ButtonSoundPlayer.getInstance(), new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL))));
        exitButton.addActionListener(new StopAction(Stopper.getInstance(), null));

        // Uno button.
        StopAction stopAction = new StopAction(PenaltyTimer.getInstance(), unoButton);
        stopAction.addObserver(CardEffectController.getInstance());
        unoButton.addActionListener(new SoundAction(UnoSoundPlayer.getInstance(), stopAction));

        // Observer / Observable.
        PenaltyTimer.getInstance().addObserver(unoButtonPanel);

        // Main component settings.
        centerPanel.setFirstComponent(CirclePanel.getInstance());
        centerPanel.setSecondComponent(DeckPanel.getInstance());
        centerPanel.setThirdComponent(DiscardedPilePanel.getInstance());
        centerPanel.setFourthComponent(ActualColorPanel.getInstance());
        centerPanel.setFifthComponent(ColorsPanel.getInstance());
        centerPanel.setSixthComponent(exitButton);
        centerPanel.setSeventhComponent(unoButtonPanel);

        // Initialization.
        centerPanel.init();
        unoButtonPanel.init();
    }

}