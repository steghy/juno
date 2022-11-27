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

package juno.view.pages.new_game.multiplayer.card;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MultiplayerCardPanel
        extends JPanel {

    public static final String UNAVAILABLE_SERVICE_PANEL = "Unavailable service panel";
    public static final String AVAILABLE_SERVICE_PANEL = "Available service panel";

    private JPanel availableServicePanel;
    private JPanel unavailableServicePanel;

    private static MultiplayerCardPanel instance;

    private MultiplayerCardPanel() {}

    public static MultiplayerCardPanel getInstance() {
        if(instance == null) instance = new MultiplayerCardPanel();
        return instance;
    }

    public void init() {
        if (availableServicePanel == null) {
            throw new IllegalArgumentException("Available service panel is null");
        } if (unavailableServicePanel == null) {
            throw new IllegalArgumentException("Unavailable service panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(unavailableServicePanel, UNAVAILABLE_SERVICE_PANEL);
        add(availableServicePanel, AVAILABLE_SERVICE_PANEL);
    }

    public void setAvailableServicePanel(@NotNull JPanel availableServicePanel) {
        this.availableServicePanel = availableServicePanel;
    }

    public void setUnavailableServicePanel(@NotNull JPanel unavailableServicePanel) {
        this.unavailableServicePanel = unavailableServicePanel;
    }
}