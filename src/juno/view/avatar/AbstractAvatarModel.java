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

import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public abstract class AbstractAvatarModel
        implements
        InterfaceAvatarModel,
        Configurable,
        Exportable {

    /** The avatar image label key. */
    public static final String AVATAR_LABEL_KEY = "avatarImageLabel";

    /** The avatar frame image label key. */
    public static final String FRAME_LABEL_KEY = "avatarFrameImageLabel";

    /** The avatar profile name label key. */
    public static final String PROFILE_NAME_LABEL_KEY = "avatarProfileNameLabel";

    // The Avatar image label.
    private JLabel avatarImageLabel;

    // The Avatar frame label.
    private JLabel avatarFrameImageLabel;

    // The Avatar profile name label.
    private JLabel avatarProfileNameLabel;

    /**
     * Sets the avatar image label of this object.
     * @param avatarImageLabel A JLabel object.
     */
    public void setAvatarImageLabel(@NotNull JLabel avatarImageLabel) {
        this.avatarImageLabel = avatarImageLabel;
    }

    /**
     * Sets the avatar profile name label of this object.
     * @param avatarProfileNameLabel A JLabel object.
     */
    public void setAvatarProfileNameLabel(@NotNull JLabel avatarProfileNameLabel) {
        this.avatarProfileNameLabel = avatarProfileNameLabel;
    }

    /**
     * Sets the avatar frame image label of this object.
     * @param avatarFrameImageLabel A JLabel object.
     */
    public void setAvatarFrameImageLabel(@NotNull JLabel avatarFrameImageLabel) {
        this.avatarFrameImageLabel = avatarFrameImageLabel;
    }

    /**
     * Returns the avatar image label of this object.
     * @return A JLabel object.
     */
    @Nullable
    public JLabel getAvatarImageLabel() {
        return avatarImageLabel;
    }

    /**
     * Returns the avatar frame image label of this object.
     * @return A JLabel object.
     */
    @Nullable
    public JLabel getAvatarFrameImageLabel() {
        return avatarFrameImageLabel;
    }

    /**
     * Returns the avatar profile name label of this object.
     * @return A JLabel object.
     */
    @Nullable
    public JLabel getAvatarProfileNameLabel() {
        return avatarProfileNameLabel;
    }

    @Override
    public void configure(@NotNull Map<String, Object> map) {}

    @Override
    public Map<String, Object> exportData() {
        return null;
    }

}