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

import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.awards.frame.AvatarFrame;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Simone Gentili
 */
public class AvatarConfigurationMapDecorator
        implements InterfaceConfigurationMapDecorator {

    // The AvatarConfigurationMapDecorator instance.
    private static AvatarConfigurationMapDecorator instance;

    // Builds the AvatarConfigurationMapDecorator instance.
    private AvatarConfigurationMapDecorator() {}

    /**
     * Returns the AvatarConfigurationMapDecorator instance.
     * @return The AvatarConfigurationMapDecorator instance.
     */
    public static AvatarConfigurationMapDecorator getInstance() {
        if(instance == null) instance = new AvatarConfigurationMapDecorator();
        return instance;
    }

    @Override
    public Map<String, Object> decorate(@NotNull Map<String, Object> map) {
        // Avatar image case.
        if(map.containsKey(Avatar.AVATAR_IMAGE_KEY)) {
            Object object = map.get(Avatar.AVATAR_IMAGE_KEY);
            if(object instanceof String name) {
                map.put(Avatar.AVATAR_IMAGE_KEY, AvatarImage.valueOf(name));
            } else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass() +
                            ". String type expected.");
        } else throw new IllegalArgumentException(
                Avatar.AVATAR_IMAGE_KEY + " key is missing.");
        // Frame case.
        if(map.containsKey(Avatar.AVATAR_FRAME_KEY)) {
            Object object = map.get(Avatar.AVATAR_FRAME_KEY);
            if(object instanceof String name) {
                map.put(Avatar.AVATAR_FRAME_KEY, AvatarFrame.valueOf(name));
            } else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass() +
                            ". String type expected.");
        } else throw new IllegalArgumentException(
                Avatar.AVATAR_FRAME_KEY + " key is missing.");
        return map;
    }

}