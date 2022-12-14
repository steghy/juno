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

package juno.view.avatar.test;


import juno.init.Repository;
import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.avatar.Avatar;
import juno.view.avatar.AvatarPanel;
import juno.view.awards.avatars.factory.GAvatarCreator;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Simone Gentili
 */
public class AvatarPanelTester {

    public static void main(String[] args) {
        Repository.setRepository();
        juno.view.awards.avatars.Initializer.initialize();
        juno.view.awards.frames.Initializer.initialize();
        juno.view.avatar.Initializer.initialize();

        AvatarPanel avatarPanel = new AvatarPanel(Avatar.getInstance());

        JFrame frame = new JFrame();
        frame.setBackground(java.awt.Color.BLUE);
        frame.add(avatarPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Avatar.getInstance().setAvatarImage((JLabel) GAvatarCreator.getInstance().create(AvatarImage.AVATAR_IMAGE_9));
    }

}