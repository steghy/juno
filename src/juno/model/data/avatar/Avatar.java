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

package juno.model.data.avatar;

import juno.model.data.achievements.AvatarImage;
import juno.model.data.achievements.InterfaceAvatarImage;
import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * This clas defines the Avatar.
 * @author Simone Gentili
 */
public class Avatar
        implements Configurable, Exportable {

    /** The avatar name key */
    public static final String AVATAR_NAME_KEY = "name";

    /** The avatar image key. */
    public static final String AVATAR_IMAGE_KEY = "avatarImage";

    // The avatar name.
    String avatarName;

    // The avatar image.
    InterfaceAvatarImage avatarImage;

    // The Avatar instance.
    private static Avatar instance;

    // Builds the Avatar instance.
    private Avatar() {}

    /**
     * Returns the Avatar instance.
     * @return The Avatar instance.
     */
    public static Avatar getInstance() {
        if(instance == null) instance = new Avatar();
        return instance;
    }

    @Override
    public void configure(@NotNull Map<String, Object> map) {
        // Avatar name case.
        if(map.containsKey(AVATAR_NAME_KEY)) {
            Object object = map.get(AVATAR_NAME_KEY);
            if(object instanceof String temp)
                AvatarNameSetter.getInstance().set(temp);
            else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass() +
                            ". String type expected.");
        } else throw new IllegalArgumentException(
                AVATAR_NAME_KEY + " is missing.");

        // Avatar image case.
        if(map.containsKey(AVATAR_IMAGE_KEY)) {
            Object object = map.get(AVATAR_IMAGE_KEY);
            if(object instanceof String temp) {
                AvatarImageSetter.getInstance().set(AvatarImage.valueOf(temp));
            } else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass() +
                            ". InterfaceAvatarImage expected.");
        } else throw new IllegalArgumentException(
                AVATAR_IMAGE_KEY + " is missing.");
    }

    @Override
    public Map<String, Object> exportData() {
        Map<String, Object> map = new HashMap<>();
        map.put(AVATAR_NAME_KEY, avatarName);
        map.put(AVATAR_IMAGE_KEY, avatarImage);
        return map;
    }

    /**
     * returns the avatar image of this object.
     * @return An InterfaceAvatarImage object.
     */
    public InterfaceAvatarImage getAvatarImage() {
        return avatarImage;
    }

    /**
     * Returns the avatar name of this object.
     * @return A String object.
     */
    public String getAvatarName() {
        return avatarName;
    }

}