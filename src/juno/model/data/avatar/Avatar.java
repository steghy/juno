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

import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class Avatar
        implements InterfaceAvatarProvider<InterfaceAvatarImage, InterfaceAvatarFrame>, Configurable, Exportable {

    /** The avatar name key */
    public static final String NAME_KEY = "name";

    /** The avatar image key. */
    public static final String AVATAR_IMAGE_KEY = "avatarImage";

    /** The avatar frame key. */
    public static final String AVATAR_FRAME_KEY = "avatarFrame";

    // The avatar name.
    String name;

    // The avatar image.
    InterfaceAvatarImage avatarImage;

    // The avatar frame.
    InterfaceAvatarFrame avatarFrame;

    // The AvatarPanelModel instance.
    private static Avatar instance;

    // Builds the AvatarPanelModel instance.
    private Avatar() {}

    /**
     * Returns the AvatarPanelModel instance.
     * @return The AvatarPanelModel instance.
     */
    public static Avatar getInstance() {
        if(instance == null) instance = new Avatar();
        return instance;
    }

    @Override
    public InterfaceAvatarImage avatarImage() {
        return avatarImage;
    }

    @Override
    public InterfaceAvatarFrame frame() {
        return avatarFrame;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void configure(@NotNull Map<String, Object> map) {
        if(map.containsKey(NAME_KEY)) {
            Object object = map.get(NAME_KEY);
            if(object instanceof String temp)
                AvatarNameSetter.getInstance().setAvatarName(temp);
            else throw new IllegalArgumentException();
        } else throw new IllegalArgumentException();

        if(map.containsKey(AVATAR_IMAGE_KEY)) {
            Object object = map.get(AVATAR_IMAGE_KEY);
        }
    }

    @Override
    public Map<String, Object> exportData() {
        Map<String, Object> map = new HashMap<>();
        map.put(NAME_KEY, name);
        map.put(AVATAR_FRAME_KEY, avatarFrame);
        map.put(AVATAR_IMAGE_KEY, avatarImage);
        return map;
    }

}