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

import juno.model.data.score.InterfaceGamesWonCounter;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class GamesWonPanel
        extends JPanel
        implements Observer {

    // The games won points.
    private final JLabel gamesWonPoints;

    // The GamesWonPanel instance.
    private static GamesWonPanel instance;

    /**
     * Returns the GamesWonPanel instance.
     * @return The GamesWonPanel instance.
     */
    public static GamesWonPanel getInstance() {
        if(instance == null) instance = new GamesWonPanel();
        return instance;
    }

    // Builds the GamesWonPanel instance.
    private GamesWonPanel() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Games won label.
        JLabel gamesWonLabel = new JLabel("Games won");
        gamesWonLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
        gamesWonLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(gamesWonLabel, gbc);

        // Games won points.
        gamesWonPoints = new JLabel("0");
        gamesWonPoints.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
        gamesWonPoints.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(gamesWonPoints, gbc);
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceGamesWonCounter gamesWonCounter)
            gamesWonPoints.setText(String.valueOf(gamesWonCounter.getCount()));
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceGamesWonCounter type expected.");

    }

}