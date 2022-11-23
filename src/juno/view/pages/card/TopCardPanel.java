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

package juno.view.pages.card;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class TopCardPanel
        extends JPanel {

    public static final String PRE_ACCESS_PANEL = "Pre access panel";
    public static final String MAIN_PANEL = "Main panel";

    private JPanel preAccessPanel;
    private JPanel mainPanel;
    private static TopCardPanel instance;

    private TopCardPanel() {}

    public static TopCardPanel getInstance() {
        if(instance == null) instance = new TopCardPanel();
        return instance;
    }

    public void init() {
        if(preAccessPanel == null) {
            throw new IllegalArgumentException("Pre access panel is null");
        } if(mainPanel == null) {
            throw new IllegalArgumentException("Main panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(preAccessPanel, PRE_ACCESS_PANEL);
        add(mainPanel, MAIN_PANEL);
    }

    public void setPreAccessPanel(@NotNull JPanel preAccessPanel) {
        this.preAccessPanel = preAccessPanel;
    }

    public void setMainPanel(@NotNull JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}