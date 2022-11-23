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

package juno.view.pages.newgame.multiplayer.unavailable;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class UnavailableServicePanel
        extends JPanel {

    private JPanel titlePanel;
    private JPanel menuPanel;

    private static UnavailableServicePanel instance;

    private UnavailableServicePanel() {}

    public static UnavailableServicePanel getInstance() {
        if(instance == null) instance = new UnavailableServicePanel();
        return instance;
    }

    public void init() {
        if (titlePanel == null) {
            throw new IllegalArgumentException("Title panel is null");
        } if (menuPanel == null) {
            throw new IllegalArgumentException("Menu panel is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TITLE PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(titlePanel, gbc);

        // MENU PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(menuPanel, gbc);
    }

    public void setTitlePanel(@NotNull JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public void setMenuPanel(@NotNull JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }
}