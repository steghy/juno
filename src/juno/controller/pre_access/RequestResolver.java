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

package juno.controller.pre_access;

import juno.controller.awards.AvatarFrameSetterAction;
import juno.controller.awards.AvatarImageSetterAction;
import juno.model.data.avatar.AvatarFrameSetter;
import juno.model.data.avatar.AvatarImageSetter;
import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.awards.frame.AvatarFrame;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class RequestResolver
        extends AbstractRequestResolver {

    // The RequestResolver instance.
    private static RequestResolver instance;

    // Builds the RequestResolver instance.
    private RequestResolver() {}

    /**
     * Returns the RequestResolver instance.
     * @return The RequestResolver instance.
     */
    public static RequestResolver getInstance() {
        if(instance == null) instance = new RequestResolver();
        return instance;
    }

    @Override
    public void resolve() {
        AvatarImageSetter.getInstance().setAvatarImage(AvatarImage.AVATAR_IMAGE_1);
        AvatarFrameSetter.getInstance().setAvatarFrame(AvatarFrame.GREY_FRAME);
        Objects.requireNonNull(getExporterManager()).export();
        Objects.requireNonNull(getPanelChanger()).changePanel(getCardPanel(), getPanelKey());
    }

}