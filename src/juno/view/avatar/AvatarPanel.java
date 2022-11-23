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

package juno.view.avatar;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class AvatarPanel
        extends JPanel {

    private JLabel avatar;

    private static AvatarPanel instance;

    private AvatarPanel() {}

    public static AvatarPanel getInstance() {
        if(instance == null) instance = new AvatarPanel();
        return instance;
    }

    public void init() {
        if(avatar == null) {
            throw new IllegalArgumentException("Avatar is null");
        }

        setOpaque(false);
        setLayout(new BorderLayout());
        add(avatar, BorderLayout.CENTER);
    }

    public void setAvatar(@NotNull JLabel avatar) {
        this.avatar = avatar;
    }
}