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

package juno.view.pages.new_game.single_player.match.panels.south;

import juno.controller.log_out.Restorable;
import juno.controller.new_game.GameStarter;
import juno.controller.new_game.dispenser.CardDispenser;
import juno.controller.new_game.human.DiscardedCardSetter;
import juno.controller.new_game.penalty.PenaltyExecutor;
import juno.controller.new_game.penalty.PenaltyTimer;
import juno.controller.util.GSetterAction;
import juno.model.card.InterfaceCard;
import juno.model.deck.InterfaceCompatibilityChecker;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.shift.InterfaceTurnMover;
import juno.model.util.Provider;
import juno.model.util.Setter;
import juno.model.util.Observer;
import juno.view.gobject.GObjectButton;
import juno.view.gobject.InterfaceGObjectCreator;
import juno.view.util.InterfaceImageResizer;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class SouthCardPanel
        extends JPanel
        implements Observer, Restorable {

    // The 'Game is started' boolean value.
    private boolean gameStarted;

    // 'Left' insects value parameter.
    private final int leftInsectsParameter;

    // The penalty boolean value.
    private boolean penalty;

    // The dispenser boolean value.
    private boolean dispenser;

    // The human player.
    private InterfacePlayer<InterfaceCard> humanPlayer;

    // The card -> graphic card map.
    private final Map<InterfaceCard, GObjectButton<InterfaceCard>> componentMap;

    // The grid bag constraints.
    private final GridBagConstraints gbc;

    // The playable card setter.
    private Setter<List<GObjectButton<InterfaceCard>>> playableCardSetter;

    // The graphic object creator.
    private InterfaceGObjectCreator<InterfaceCard> creator;

    // The discarded card setter.
    private Setter<InterfaceCard> discardedCardSetter;

    // The current player provider.
    private Provider<InterfacePlayer<InterfaceCard>> currentPlayerProvider;

    // The image resizer.
    private InterfaceImageResizer resizer;

    // The card compatibility checker.
    private InterfaceCompatibilityChecker<InterfaceCard> compatibilityChecker;

    // The SouthCardPanel instance.
    private static SouthCardPanel instance;

    // Builds the SouthCardPanel instance.
    private SouthCardPanel() {
        // Booleans.
        gameStarted = false;
        dispenser = false;
        penalty = false;

        componentMap = new HashMap<>();
        leftInsectsParameter = 48;
        setOpaque(false);
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        setBackground(Color.GRAY);
    }

    /**
     * Returns the SouthCardPanel instance.
     * @return The SouthCardPanel instance.
     */
    public static SouthCardPanel getInstance() {
        if(instance == null) instance = new SouthCardPanel();
        return instance;
    }

    /**
     * Sets the discarded card setter of this object.
     * @param discardedCardSetter An InterfaceSetter object.
     */
    public void setDiscardedCardSetter(@NotNull Setter<InterfaceCard> discardedCardSetter) {
        this.discardedCardSetter = discardedCardSetter;
    }

    /**
     * Sets the playable card setter of this object.
     * @param playableCardSetter An InterfaceSetter object.
     */
    public void setPlayableCardSetter(@NotNull Setter<List<GObjectButton<InterfaceCard>>> playableCardSetter) {
        this.playableCardSetter = playableCardSetter;
    }

    /**
     * Sets the current player provider of this object.
     * @param currentPlayerProvider A Provider object.
     */
    public void setCurrentPlayerProvider(@NotNull Provider<InterfacePlayer<InterfaceCard>> currentPlayerProvider) {
        this.currentPlayerProvider = currentPlayerProvider;
    }

    /**
     * Sets the human player of this object.
     * @param humanPlayer An InterfacePlayer object.
     */
    public void setHumanPlayer(@NotNull InterfacePlayer<InterfaceCard> humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    /**
     * Sets the graphic object creator of this object.
     * @param creator An InterfaceGObjectCreator object.
     */
    public void setCreator(@NotNull InterfaceGObjectCreator<InterfaceCard> creator) {
        this.creator = creator;
    }

    /**
     * Sets the image resizer of this object.
     * @param resizer An InterfaceImageResizer object.
     */
    public void setResizer(@NotNull InterfaceImageResizer resizer) {
        this.resizer = resizer;
    }

    /**
     * Sets the card compatibility checker of this object.
     * @param compatibilityChecker An InterfaceCompatibilityChecker.
     */
    public void setCompatibilityChecker(@NotNull InterfaceCompatibilityChecker<InterfaceCard> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    /**
     * Adds the specified graphic card to this panel.
     * @param gCard A GObjectButton object.
     */
    public void addComponent(@NotNull GObjectButton<InterfaceCard> gCard) {
        if(componentMap.isEmpty())
            gbc.insets = new Insets(0, 0, 0, 0);
        else
            gbc.insets = new Insets(0, gbc.insets.left + leftInsectsParameter, 0, 0);
        super.add(gCard, gbc);
        componentMap.put(gCard.object(), gCard);
        revalidate();
        repaint();
    }

    /**
     * Removes the specified graphic card from this panel.
     * @param gCard A GObjectButton object.
     */
    @SuppressWarnings("unchecked")
    public void removeComponent(@NotNull GObjectButton<InterfaceCard> gCard) {
        ArrayList<GObjectButton<InterfaceCard>> components =
                new ArrayList<>(Arrays.stream(getComponents())
                        .map(c -> (GObjectButton<InterfaceCard>) c).toList());
        if (components.contains(gCard)) {
            super.remove(gCard);
            components.remove(gCard);
            componentMap.clear();
            components.forEach(this::addComponent);
        } else throw new IllegalArgumentException("GCard is not in " + this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        // This update comes from the HumanPlayer class.
        if(object instanceof InterfacePlayer<?>) {
            InterfaceCard card = humanPlayer.provide();

            // A card has been removed.
            if(humanPlayer.hasRemoved())
                if(componentMap.containsKey(card)) {
                    removeComponent(componentMap.get(card));
                } else throw new IllegalArgumentException(
                        card + " is not in: " + componentMap);

            // A Card has been added.
            else {
                GObjectButton<InterfaceCard> gCard = (GObjectButton<InterfaceCard>)
                        creator.create(card, RotatedIcon.Rotate.ABOUT_CENTER);
                resizer.resize(gCard, 2.5);

                // If the game has started, add the actions.
                if(gameStarted) {
                    gCard.addActionListener(new GSetterAction<>(gCard, discardedCardSetter));
                }

                // If the added card was drawn on the human player's turn,
                // it's compatibility is calculated while the remaining
                // cards cannot be played.
                if(currentPlayerProvider.provide() == humanPlayer
                        && dispenser && !penalty) {
                    for (Component c : getComponents()) c.setEnabled(false);
                    gCard.setEnabled(compatibilityChecker.isCompatible(card));
                }

                // Otherwise the card was drawn during another
                // player's turn, so it cannot be played.
                else
                    gCard.setEnabled(false);

                addComponent(gCard);
            }
        }

        // This update comes from the TurnMover class.
        else if(object instanceof InterfaceTurnMover) {
            if(currentPlayerProvider.provide() == humanPlayer && gameStarted)

                // Sets the cards playable this turn relative
                // to the top card of the discarded pile.
                playableCardSetter.set(Arrays.stream(getComponents())
                        .map(component -> (GObjectButton<InterfaceCard>) component)
                        .toList());

            // Disability all cards.
            else for(Component c : getComponents()) c.setEnabled(false);
        }

        // Discarded card setter notifies.
        else if(object instanceof DiscardedCardSetter<?>) {
            for(Component c : getComponents()) c.setEnabled(false);
        }

        // GameStarter notifies that the game has started
        // and therefore the added cards must encapsulate
        // the appropriate actions.
        else if(object instanceof GameStarter) {
            gameStarted = true;
        }

        // Card Dispenser notifies that all cards have
        // been dealt and therefore from this point on,
        // when a card is added in the human player's
        // turn the compatibility check must take place.
        else if(object instanceof CardDispenser<?>) {
            dispenser = true;
        }

        // Penalty is started.
        else if(object instanceof PenaltyTimer penaltyTimer)
            penalty = !penaltyTimer.getTimer().isRunning();

        // The penalty is over.
        else if(object instanceof PenaltyExecutor<?>)
            penalty = false;

        // Unrecognized update case.
        else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass());

        // Always after editing.
        revalidate();
        repaint();
    }

    @Override
    public void restore() {
        setOpaque(false);
        penalty = false;
        gameStarted = false;
        dispenser = false;
        componentMap.clear();
        removeAll();
        revalidate();
        repaint();
    }

}