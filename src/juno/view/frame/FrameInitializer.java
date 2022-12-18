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

package juno.view.frame;

import juno.init.PathProvider;
import juno.view.pages.card.TopCardPanel;
import juno.view.download.ImageComponentInitializer;
import juno.view.download.PathObjectAssembler;

import javax.swing.*;

public class FrameInitializer {

    private FrameInitializer() {}

    public static void initializer() {
        Frame frame = Frame.getInstance();

        JLabel background = new JLabel();
        JPanel topCardPanel = TopCardPanel.getInstance();
                ImageComponentInitializer.getInstance()
                        .initialize(
                                background,
                                PathObjectAssembler.getInstance().assemble(PathProvider.BACKGROUNDS, "background.gif"));
        frame.setBackground(background);
        frame.setPanel(topCardPanel);
        frame.init();
    }
}
