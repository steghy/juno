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

package juno.view.pages.score.menu;

import juno.model.data.score.InterfaceLostGamesCounter;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class LostGamesPanel
        extends JPanel
        implements Observer {

    // The lost games points.
    private final JLabel lostGamesPoints;

    // The LostGamesPanel instance.
    private static LostGamesPanel instance;

    /**
     * Returns the LostGamesPanel instance.
     * @return The LostGamesPanel instance.
     */
    public static LostGamesPanel getInstance() {
        if(instance == null) instance = new LostGamesPanel();
        return instance;
    }

    // Builds the LostGamesPanel instance.
    private LostGamesPanel() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Lost games label.
        JLabel lostGamesLabel = new JLabel("Lost games");
        lostGamesLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
        lostGamesLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(lostGamesLabel, gbc);

        // Lost games points.
        lostGamesPoints = new JLabel("0");
        lostGamesPoints.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
        lostGamesPoints.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(lostGamesPoints, gbc);
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceLostGamesCounter lostGamesCounter)
            lostGamesPoints.setText(String.valueOf(lostGamesCounter.getCount()));
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceLostGamesCounter type expected.");
    }

}