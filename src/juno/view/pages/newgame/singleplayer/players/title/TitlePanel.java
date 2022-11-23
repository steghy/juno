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

package juno.view.pages.newgame.singleplayer.players.title;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    private AbstractButton title;
    private static TitlePanel instance;

    private TitlePanel() {}

    public static TitlePanel getInstance() {
        if(instance == null) {
            instance = new TitlePanel();
        } return instance;
    }

    public void init() {
        if(title == null) {
            throw new IllegalArgumentException("Title is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TITLE
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        this.add(title, gbc);
    }

    public void setTitle(AbstractButton title) {
        this.title = title;
    }

    public AbstractButton getTitle() {
        return title;
    }
}
