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
import juno.controller.new_game.dispenser.InterfaceCardDispenser;
import juno.controller.new_game.human.CardRemover;
import juno.controller.new_game.controller.Mover;
import juno.controller.new_game.human.PassTurnAction;
import juno.controller.util.SetterAction;
import juno.model.card.InterfaceCard;
import juno.model.deck.CompatibilityChecker;
import juno.model.subjects.human.HumanPlayer;
import juno.model.util.Setter;
import juno.model.util.Observer;
import juno.view.gobject.GObjectButton;
import juno.view.gobject.cards.GCardCreator;
import juno.view.util.ImageResizer;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class SouthCardPanel
        extends JPanel
        implements Observer, Restorable {

    // The 'Game is started' boolean value.
    private boolean gameStarted;

    // The dispenser boolean value.
    private boolean dispenser;

    // 'Left' insects value parameter.
    private final int leftInsectsParameter;

    // The card -> graphic card map.
    private final Map<InterfaceCard, GObjectButton<InterfaceCard>> componentMap;

    // The grid bag constraints.
    private final GridBagConstraints gbc;

    // The playable card setter.
    private Setter<List<GObjectButton<InterfaceCard>>> playableCardSetter;

    // The discarded card setter.
    private Setter<InterfaceCard> discardedCardSetter;

    // The SouthCardPanel instance.
    private static SouthCardPanel instance;

    // Builds the SouthCardPanel instance.
    private SouthCardPanel() {
        gameStarted = false;
        dispenser = false;
        componentMap = new HashMap<>();
        leftInsectsParameter = 50;
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
        if(object instanceof HumanPlayer<?> humanPlayer) {
            InterfaceCard card = (InterfaceCard) humanPlayer.provide();
            if(humanPlayer.isRemoved())
                if(componentMap.containsKey(card)) {
                    removeComponent(componentMap.get(card));
                } else throw new IllegalArgumentException(
                        card + " is not in: " + componentMap);
            else {
                GObjectButton<InterfaceCard> gCard = (GObjectButton<InterfaceCard>)
                        GCardCreator.getInstance().create(card, RotatedIcon.Rotate.ABOUT_CENTER);
                ImageResizer.resize(gCard, 2.5);

                if(gameStarted) {
                    SetterAction<InterfaceCard> setterAction =
                            new SetterAction<>(gCard.object(), discardedCardSetter);
                    gCard.addActionListener(setterAction);
                    gCard.addActionListener(CardRemover.getInstance());
                }

                if(dispenser) {
                    for (Component c : getComponents()) c.setEnabled(false);
                    gCard.setEnabled(CompatibilityChecker.getInstance().isCompatible(card));
                }

                // Adding the card.
                addComponent(gCard);
            }
        } else if(object instanceof Mover) {
            playableCardSetter.set(
                    Arrays.stream(getComponents())
                            .map(component -> (GObjectButton<InterfaceCard>) component).toList()
            );
        } else if(object instanceof PassTurnAction) {
            for(Component c : getComponents()) c.setEnabled(false);
        } else if(object instanceof InterfaceCardDispenser) {
            dispenser = true;
        } else if(object instanceof GameStarter) {
            gameStarted = true;
        } else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass() +
                            ". InterfaceAdder, InterfaceRemover " +
                            "or InterfaceInitializer type expected.");
        revalidate();
        repaint();
    }

    @Override
    public void restore() {
        setOpaque(false);
        gameStarted = false;
        dispenser = false;
        componentMap.clear();
        removeAll();
        revalidate();
        repaint();
    }

}