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

import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class AvatarsPanelConfigurator {

    private AvatarsPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        AvatarsPanel avatarsPanel = AvatarsPanel.getInstance();

        // INITIALIZATION
        avatarsPanel.init();

        // SUB COMPONENTS
        AbstractButton avatar1 = ButtonFactory.createButton(ButtonLibrary.AVATAR_1);
        AbstractButton avatar2 = ButtonFactory.createButton(ButtonLibrary.AVATAR_2);
        AbstractButton avatar3 = ButtonFactory.createButton(ButtonLibrary.AVATAR_3);
        AbstractButton avatar4 = ButtonFactory.createButton(ButtonLibrary.AVATAR_4);
        AbstractButton avatar5 = ButtonFactory.createButton(ButtonLibrary.AVATAR_5);
        AbstractButton avatar6 = ButtonFactory.createButton(ButtonLibrary.AVATAR_6);
        AbstractButton avatar7 = ButtonFactory.createButton(ButtonLibrary.AVATAR_7);
        AbstractButton avatar8 = ButtonFactory.createButton(ButtonLibrary.AVATAR_8);
        AbstractButton avatar9 = ButtonFactory.createButton(ButtonLibrary.AVATAR_9);
        AbstractButton avatar10 = ButtonFactory.createButton(ButtonLibrary.AVATAR_10);

        // ADDING COMPONENTS
        List<AbstractButton> avatarsList = Arrays.asList(
                avatar1,
                avatar2,
                avatar3,
                avatar4,
                avatar5,
                avatar6,
                avatar7,
                avatar8,
                avatar9,
                avatar10
        ); avatarsList.forEach(avatarsPanel::addAvatar);
    }
}