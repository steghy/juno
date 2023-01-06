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

package juno.controller.new_game.connector;

import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.shift.InterfaceTurnMover;
import juno.model.util.Provider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class PanelIlluminator
        implements Observer {

    // The current player provider.
    private Provider<InterfacePlayer<?>> playerProvider;

    // The last player's circle involved.
    private JLabel lastCircle;

    // Map players - panel.
    private Map<InterfacePlayer<?>, JLabel> map;

    // The PanelIlluminator instance.
    private static PanelIlluminator instance;

    // Builds the PanelIlluminator instance.
    private PanelIlluminator() {}

    /**
     * Returns the PanelIlluminator instance.
     * @return The PanelIlluminator instance.
     */
    public static PanelIlluminator getInstance() {
        if(instance == null) instance = new PanelIlluminator();
        return instance;
    }

    /**
     * Sets the player provider of this object.
     * @param playerProvider A Provider object.
     */
    public void setPlayerProvider(@NotNull Provider<InterfacePlayer<?>> playerProvider) {
        this.playerProvider = playerProvider;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        // Update from CircleConnector class.
        if(object instanceof Provider<?> provider) {
            map = (Map<InterfacePlayer<?>, JLabel>) provider.provide();
        }

        // Update from Mover class.
        else if(object instanceof InterfaceTurnMover) {
            // Current player.
            InterfacePlayer<?> player = playerProvider.provide();

            // Old circle.
            if(lastCircle != null) {
                lastCircle.setVisible(false);
                lastCircle.revalidate();
                lastCircle.repaint();
            }

            // Current circle.
            JLabel circle = map.get(player);
            circle.setVisible(true);
            circle.revalidate();
            circle.repaint();
            lastCircle = circle;
        }

        // Invalid case.
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceTurnMover or Connector type expected");
    }

}