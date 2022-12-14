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
import juno.model.data.io.ProgramDirectory;
import juno.model.card.InterfaceCard;
import juno.model.requester.PathProviderAssembler;
import juno.model.subjects.ai.AI;
import juno.model.util.Observer;
import juno.view.gobject.GObjectButton;
import juno.view.gobject.cards.GCardCreator;
import juno.view.img_initializer.InterfaceImageComponentInitializer;
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
 * This class defines the north card panel.
 * @author Simone Gentili
 */
public class NorthCardPanel
        extends JPanel
        implements Observer, Restorable {

    /** The left insects' parameter. */
    private final int rightInsectsParameter;

    /** The image component initializer. */
    private InterfaceImageComponentInitializer initializer;

    /** The image resizer. */
    private InterfaceImageResizer resizer;

    /** The grid bag constraints. */
    private final GridBagConstraints gbc;

    /** The show card boolean value. */
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

    /**
     * Adds the specified component to this object.
     * @param c A Component object.
     */
    public void addComponent(@NotNull Component c) {
        if(getComponents().length == 0) gbc.insets = new Insets(0, 0, 0, 0);
        else gbc.insets = new Insets(0, 0, 0, gbc.insets.right + rightInsectsParameter);
        super.add(c, gbc);
        revalidate();
        repaint();
    }

    /**
     * Removes the first component from this object.
     */
    public void removeComponent() {
        super.remove(0);
        List<Component> components = new ArrayList<>(List.of(getComponents()));
        super.removeAll();
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
                AbstractButton gCard;
                if(showCard) {
                    InterfaceCard card = (InterfaceCard) ai.provide();
                    gCard = (GObjectButton<InterfaceCard>)
                            GCardCreator.getInstance().create(Objects.requireNonNull(card), RotatedIcon.Rotate.UPSIDE_DOWN);
                    resizer.resize(gCard, 2.5);
                    gCard.setEnabled(false);
                    add(gCard);
                } else {
                    gCard = new ImageButton(resizer);
                    initializer.initialize(
                            gCard,
                            PathProviderAssembler.getInstance().assemble(ProgramDirectory.COVER, "COVER.png"),
                            PathProviderAssembler.getInstance().assemble(ProgramDirectory.COVER, "COVER_ROLLOVER.png"),
                            RotatedIcon.Rotate.UPSIDE_DOWN);
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
        setOpaque(false);
        removeAll();
        showCard = true;
        revalidate();
        repaint();
    }

}