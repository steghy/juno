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

package juno.view.pages.new_game.single_player.match.panels.north;

import juno.controller.log_out.Restorable;
import juno.controller.new_game.GameStarter;
import juno.model.card.InterfaceCard;
import juno.model.subjects.ai.AI;
import juno.model.util.Observer;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.gobject.cards.GCard;
import juno.view.gobject.cards.GCardCreator;
import juno.view.util.ImageResizer;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Simone Gentili
 */
public class NorthCardPanel
        extends JPanel
        implements Observer, Restorable {

    // 'Left' insects value parameter.
    private final int rightInsectsParameter;

    // The grid bag constraints.
    private final GridBagConstraints gbc;

    // The show card boolean value.
    private boolean showCard = true;

    // The NorthCardPanel instance.
    private static NorthCardPanel instance;

    // Builds the NorthCardPanel instance.
    private NorthCardPanel() {
        rightInsectsParameter = 50;
        setOpaque(false);
        setLayout(new GridBagLayout());
        setBackground(Color.GRAY);
        gbc = new GridBagConstraints();
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.ipadx = 0;
        gbc.ipady = 0;
    }

    /**
     * Returns the NorthCardPanel instance.
     * @return The NorthCardPanel instance.
     */
    public static NorthCardPanel getInstance() {
        if(instance == null) instance = new NorthCardPanel();
        return instance;
    }

    public void addComponent(@NotNull Component c) {
        if(getComponents().length == 0) gbc.insets = new Insets(0, 0, 0, 0);
        else gbc.insets = new Insets(0, 0, 0, gbc.insets.right + rightInsectsParameter);
        super.add(c, gbc);
        revalidate();
        repaint();
    }

    public void removeComponent() {
        super.remove(0);
        java.util.List<Component> components = new ArrayList<>(List.of(getComponents()));
        super.removeAll();
        components.forEach(this::addComponent);
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof GameStarter) showCard = false;
        else if(object instanceof AI<?, ?> ai) {
            if(ai.getRemoved()) {
                int count = getComponentCount();
                if(count == 0) throw new IllegalArgumentException(
                        "There is no components to remove.");
                if(showCard) removeAll();
                else removeComponent();
            } else {
                AbstractButton gCard;
                if(showCard) {
                    InterfaceCard card = (InterfaceCard) ai.provide();
                    gCard = (GCard<InterfaceCard>)
                            GCardCreator.getInstance().create(Objects.requireNonNull(card), RotatedIcon.Rotate.UPSIDE_DOWN);
                    ImageResizer.resize(gCard, 2.5);
                    add(gCard, gbc);
                } else {
                    gCard = ButtonCreator.getInstance().create(Button.COVER, RotatedIcon.Rotate.UPSIDE_DOWN);
                    ImageResizer.resize(gCard, 4.0);
                    addComponent(gCard);
                }
            }
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
        gbc.insets = new Insets(0, 0, 0, 0);
        removeAll();
        showCard = true;
        revalidate();
        repaint();
    }

}