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
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractAvatar
        implements
        InterfaceAvatar,
        Configurable,
        Exportable,
        Observable {

    /** The avatar image label key. */
    public static final String AVATAR_LABEL_KEY = "avatarImageLabel";

    /** The avatar frame image label key. */
    public static final String FRAME_LABEL_KEY = "avatarFrameImageLabel";

    /** The avatar profile name label key. */
    public static final String PROFILE_NAME_LABEL_KEY = "avatarProfileNameLabel";

    // The Observers List.
    private final List<Observer> observerList = new ArrayList<>();

    // The Avatar image.
    private InterfaceAvatarImage avatarImage;

    // The Avatar frame.
    private InterfaceAvatarFrame avatarFrame;

    // The Avatar name.
    private String name;

    @Override
    public void configure(@NotNull Map<String, Object> map) {}

    @Override
    public Map<String, Object> exportData() {
        return null;
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

}