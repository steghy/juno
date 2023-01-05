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

package juno.view.pages.new_game.single_player.winner;

import juno.controller.new_game.connector.AvatarConnector;
import juno.controller.new_game.controller.WinnerManager;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.shift.CurrentPlayerProvider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class WinnerAvatarPanel
        extends JPanel
        implements Observer {

    // The WinnerAvatarPanel instance.
    private static WinnerAvatarPanel instance;

    // Builds the WinnerAvatarPanel instance.
    private WinnerAvatarPanel() {
        setOpaque(false);
        setLayout(new BorderLayout());
    }

    /**
     * Returns the WinnerAvatarPanel instance.
     * @return The WinnerAvatarPanel instance.
     */
    public static WinnerAvatarPanel getInstance() {
        if(instance == null) instance = new WinnerAvatarPanel();
        return instance;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof WinnerManager) {
            removeAll();
            InterfacePlayer<?> player =
                    (InterfacePlayer<?>) CurrentPlayerProvider.getInstance().provide();
            add(AvatarConnector.getInstance().provide().get(player), BorderLayout.CENTER);
            revalidate();
            repaint();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". WinnerManager type expected");

    }
}