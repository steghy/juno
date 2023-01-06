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

package juno.view.pages.new_game.single_player.match.panels.east;

import juno.controller.log_out.Restorable;
import juno.controller.new_game.GameStarter;
import juno.init.ProgramDirectory;
import juno.model.card.InterfaceCard;
import juno.model.requester.PathProviderAssembler;
import juno.model.subjects.ai.AI;
import juno.model.util.Observer;
import juno.view.gobject.cards.GCardCreator;
import juno.view.img_initializer.InterfaceImageComponentInitializer;
import juno.view.panels.AbstractFirstComponent;
import juno.view.util.ImageButton;
import juno.view.util.InterfaceImageResizer;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class EastCardPanel
        extends AbstractFirstComponent
        implements Observer, Restorable {

    // 'Bottom' insects value parameter.
    private final int bottomInsectsParameter;

    // The Image component initializer.
    private InterfaceImageComponentInitializer initializer;

    // The image resizer.
    private InterfaceImageResizer resizer;

    // The grid bag constraints.
    private final GridBagConstraints gbc;

    // The show card boolean value.
    private boolean showCard = true;

    // The EastCardPanel instance.
    private static EastCardPanel instance;

    // Builds the EastCardPanel instance.
    private EastCardPanel() {
        bottomInsectsParameter = 50;
        setOpaque(false);
        setLayout(new GridBagLayout());
        setBackground(Color.GRAY);
        gbc = new GridBagConstraints();
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.ipadx = 0;
        gbc.ipady = 0;
    }

    /**
     * Returns the EastCardPanel instance.
     * @return The EastCardPanel instance.
     */
    public static EastCardPanel getInstance() {
        if(instance == null) instance = new EastCardPanel();
        return instance;
    }

    /**
     * Adds the specified component to this object.
     * @param c A Component object.
     */
    public void addComponent(@NotNull Component c) {
        if(getComponents().length == 0) gbc.insets = new Insets(0, 0, 0, 0);
        else gbc.insets = new Insets(0, 0, gbc.insets.bottom + bottomInsectsParameter, 0);
        add(c, gbc);
        revalidate();
        repaint();
    }

    /**
     * Removes the first component from this object.
     */
    public void removeComponent() {
        remove(0);
        List<Component> components = new ArrayList<>(List.of(getComponents()));
        removeAll();
        components.forEach(this::addComponent);
    }

    /**
     * Sets the image component initializer of this object.
     * @param initializer An InterfaceImageComponentInitializer object.
     */
    public void setInitializer(@NotNull InterfaceImageComponentInitializer initializer) {
        this.initializer = initializer;
    }

    /**
     * Sets the image resizer of this object.
     * @param resizer An InterfaceImageResizer object.
     */
    public void setResizer(@NotNull InterfaceImageResizer resizer) {
        this.resizer = resizer;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof GameStarter)
            showCard = false;
        else if(object instanceof AI<?, ?> ai) {
            if(ai.hasRemoved()) {
                int count = getComponentCount();
                if(count == 0) throw new IllegalArgumentException(
                        "There is no components to remove.");
                if(showCard) removeAll();
                else removeComponent();
            } else {
                AbstractButton gCard = new ImageButton(resizer);
                if(showCard) {
                    InterfaceCard card = (InterfaceCard) ai.provide();
                    gCard = (AbstractButton) GCardCreator.getInstance()
                            .create(Objects.requireNonNull(card), RotatedIcon.Rotate.UP);
                    resizer.resize(gCard, 2.5);
                    gCard.setEnabled(false);
                    add(gCard);
                } else {
                    initializer.initialize(
                            gCard,
                            PathProviderAssembler.getInstance().assemble(ProgramDirectory.COVER, "COVER.png"),
                            PathProviderAssembler.getInstance().assemble(ProgramDirectory.COVER, "COVER_ROLLOVER.png"),
                            RotatedIcon.Rotate.UP);
                    resizer.resize(gCard, 4.0);
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
        removeAll();
        setOpaque(false);
        showCard = true;
        revalidate();
        repaint();
    }

}