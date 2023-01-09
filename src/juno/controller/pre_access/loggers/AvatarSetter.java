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

package juno.controller.pre_access.loggers;

import java.util.Objects;

/**
 * This class defines an avatar setter.
 * @author Simone Gentili
 */
public class AvatarSetter
        extends AbstractAvatarSetter {

    // The AvatarSetter instance.
    private static AvatarSetter instance;

    // Builds the AvatarSetter instance.
    private AvatarSetter() {}

    /**
     * Returns the AvatarSetter instance.
     * @return The AvatarSetter instance.
     */
    public static AvatarSetter getInstance() {
        if(instance == null) instance = new AvatarSetter();
        return instance;
    }

    @Override
    public void setAvatar() {
        Objects.requireNonNull(getAvatarImageSetter()).set(getAvatarImage());
    }

}