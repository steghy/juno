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
import juno.model.util.Donut;
import juno.model.util.InterfaceProvider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class PanelIlluminator
        implements Observer {

    // The players donut provider.
    private InterfaceProvider<Donut<InterfacePlayer<?>>> playersProvider;

    // The last panel involved.
    private JPanel lastPanel;

    // Map players panel.
    private Map<InterfacePlayer<?>, JPanel> map;

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
     * Sets the players list provider of this object.
     * @param playersProvider An InterfaceProvider object.
     */
    public void setPlayersProvider(@NotNull InterfaceProvider<Donut<InterfacePlayer<?>>> playersProvider) {
        this.playersProvider = playersProvider;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof InterfaceProvider<?> provider) {
            map = (Map<InterfacePlayer<?>, JPanel>) provider.provide();
        } else if(object instanceof InterfaceTurnMover) {
            InterfacePlayer<?> player = playersProvider.provide().current();
            if(lastPanel != null) {
                lastPanel.setOpaque(false);
                lastPanel.revalidate();
                lastPanel.repaint();
            } JPanel panel = map.get(player);
            panel.setOpaque(true);
            panel.revalidate();
            panel.repaint();
            lastPanel = panel;
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceTurnMover or Connector type expected");
    }

}