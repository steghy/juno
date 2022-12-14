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

/**
 * @author Simone Gentili
 */
public class Avatar<T, E>
        implements InterfaceAvatarProvider<T, E> {

    // The avatar name.
    String name;

    // The avatar image.
    T avatarImage;

    // The avatar frame.
    E avatarFrame;

    // The AvatarPanelModel instance.
    private static Avatar<?, ?> instance;

    // Builds the AvatarPanelModel instance.
    private Avatar() {}

    /**
     * Returns the AvatarPanelModel instance.
     * @return The AvatarPanelModel instance.
     */
    public static Avatar<?, ?> getInstance() {
        if(instance == null) instance = new Avatar<>();
        return instance;
    }

    @Override
    public T avatarImage() {
        return avatarImage;
    }


    @Override
    public E frame() {
        return avatarFrame;
    }

    @Override
    public String name() {
        return name;
    }

}