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

package juno.view.awards.avatars.factory;

import juno.model.data.awards.avatar.InterfaceAvatar;
import juno.view.awards.avatars.InterfaceGAvatar;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GAvatarsFactory
        extends AbstractGAvatarsFactory<InterfaceAvatar>
        implements InterfaceGAvatarsFactory<InterfaceAvatar> {

    // The GAvatarsFactory instance.
    private static GAvatarsFactory instance;

    // Builds the GAvatarsFactory instance.
    private GAvatarsFactory() {}

    /**
     * Returns the GAvatarsFactory instance.
     * @return The GAvatarsFactory instance.
     */
    public static GAvatarsFactory getInstance() {
        if(instance == null) instance = new GAvatarsFactory();
        return instance;
    }

    @Override
    public List<InterfaceGAvatar<InterfaceAvatar>> getGAvatars(@NotNull List<InterfaceAvatar> avatarList) {
        return avatarList.stream()
                .map(Objects.requireNonNull(getCreator())::create).toList();
    }

}