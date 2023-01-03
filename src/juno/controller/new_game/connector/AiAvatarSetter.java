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

import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.model.subjects.InterfacePlayer;
import juno.model.util.Observer;
import juno.model.util.Provider;
import juno.view.avatar.AvatarPanel;
import juno.view.gobject.InterfaceGObjectCreator;
import juno.view.util.ImageButton;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class AiAvatarSetter
        implements Observer {

    // The north avatar panel.
    @Nullable
    private AvatarPanel north;

    // The west avatar panel.
    @Nullable
    private AvatarPanel west;

    // The east avatar panel.
    @Nullable
    private AvatarPanel east;

    // The avatar image provider.
    @Nullable
    private RandomObjectProvider<InterfaceAvatarImage> avatarImageProvider;

    // The avatar frame provider.
    @Nullable
    private RandomObjectProvider<InterfaceAvatarFrame> avatarFrameProvider;

    // The avatar image creator.
    @Nullable
    private InterfaceGObjectCreator<InterfaceAvatarImage> avatarImageCreator;

    // The graphic avatar frame creator.
    @Nullable
    private InterfaceGObjectCreator<InterfaceAvatarFrame> avatarFrameCreator;

    // The AiAvatarSetter instance.
    private static AiAvatarSetter instance;

    // Builds the AiAvatarSetter instance.
    private AiAvatarSetter() {}

    /**
     * Returns the AiAvatarSetter instance.
     * @return The AiAvatarSetter instance.
     */
    public static AiAvatarSetter getInstance() {
        if(instance == null) instance = new AiAvatarSetter();
        return instance;
    }

    /**
     * Sets the avatar image provider of this object.
     * @param avatarImageProvider A Provider object.
     */
    public void setAvatarImageProvider(@NotNull RandomObjectProvider<InterfaceAvatarImage> avatarImageProvider) {
        this.avatarImageProvider = avatarImageProvider;
    }

    /**
     * Sets the avatar frame provider of this object.
     * @param avatarFrameProvider A Provider object.
     */
    public void setAvatarFrameProvider(@NotNull RandomObjectProvider<InterfaceAvatarFrame> avatarFrameProvider) {
        this.avatarFrameProvider = avatarFrameProvider;
    }

    /**
     * Sets the graphic avatar image creator of this object.
     * @param avatarImageCreator An InterfaceGObjectCreator object.
     */
    public void setAvatarImageCreator(@NotNull InterfaceGObjectCreator<InterfaceAvatarImage> avatarImageCreator) {
        this.avatarImageCreator = avatarImageCreator;
    }

    /**
     * Sets the graphic avatar frame creator of this object.
     * @param avatarFrameCreator An InterfaceGObjectCreator object.
     */
    public void setAvatarFrameCreator(@NotNull InterfaceGObjectCreator<InterfaceAvatarFrame> avatarFrameCreator) {
        this.avatarFrameCreator = avatarFrameCreator;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        // The update comes from the AI player provider.
        if(object instanceof Provider<?> provider) {
            // The AI player list.
            List<InterfacePlayer<?>> players = (List<InterfacePlayer<?>>) provider.provide();

            // Avatar panels.
            Objects.requireNonNull(north);
            Objects.requireNonNull(east);
            Objects.requireNonNull(west);

            // Provider.
            Objects.requireNonNull(avatarImageProvider);
            Objects.requireNonNull(avatarFrameProvider);

            // Creators.
            Objects.requireNonNull(avatarImageCreator);
            Objects.requireNonNull(avatarFrameCreator);

            // One player case.
            if(players.size() == 1) {
                north.setAvatarName(new JLabel(players.get(0).name()));
                north.setAvatarImage((ImageButton) avatarImageCreator.create(avatarImageProvider.provide(), null));
                north.setAvatarFrame((ImageButton) avatarFrameCreator.create(avatarFrameProvider.provide(), null));
                north.init();
            }

            // Two players case.
            else if(players.size() == 2) {

                // West panel.
                west.setAvatarName(new JLabel(players.get(0).name()));
                west.setAvatarImage((ImageButton) avatarImageCreator.create(avatarImageProvider.provide(), null));
                west.setAvatarFrame((ImageButton) avatarFrameCreator.create(avatarFrameProvider.provide(), null));
                west.init();

                // North panel.
                north.setAvatarName(new JLabel(players.get(1).name()));
                north.setAvatarImage((ImageButton) avatarImageCreator.create(avatarImageProvider.provide(), null));
                north.setAvatarFrame((ImageButton) avatarFrameCreator.create(avatarFrameProvider.provide(), null));
                north.init();
            }

            // Three players case.
            else if(players.size() == 3) {

                // West panel.
                west.setAvatarName(new JLabel(players.get(0).name()));
                west.setAvatarImage((ImageButton) avatarImageCreator.create(avatarImageProvider.provide(), null));
                west.setAvatarFrame((ImageButton) avatarFrameCreator.create(avatarFrameProvider.provide(), null));
                west.init();

                // North panel.
                north.setAvatarName(new JLabel(players.get(1).name()));
                north.setAvatarImage((ImageButton) avatarImageCreator.create(avatarImageProvider.provide(), null));
                north.setAvatarFrame((ImageButton) avatarFrameCreator.create(avatarFrameProvider.provide(), null));
                north.init();

                // East panel.
                east.setAvatarName(new JLabel(players.get(2).name()));
                east.setAvatarImage((ImageButton) avatarImageCreator.create(avatarImageProvider.provide(), null));
                east.setAvatarFrame((ImageButton) avatarFrameCreator.create(avatarFrameProvider.provide(), null));
                east.init();
            }

            // Invalid case.
            else throw new IllegalArgumentException(
                    "Invalid number of players.");

            // Reset.
            avatarFrameProvider.reset();
            avatarImageProvider.reset();


        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". Provider type expected.");
    }

    /**
     * Sets the north avatar panel of this object.
     * @param north An Avatar panel object.
     */
    public void setNorth(@NotNull AvatarPanel north) {
        this.north = north;
    }

    /**
     * Sets the west avatar panel of this object.
     * @param west An Avatar panel object.
     */
    public void setWest(@NotNull AvatarPanel west) {
        this.west = west;
    }

    /**
     * Sets the east avatar panel of this object.
     * @param east An AvatarPanel object.
     */
    public void setEast(@NotNull AvatarPanel east) {
        this.east = east;
    }

}