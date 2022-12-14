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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * This class defines a guest logger.
 * @author Simone Gentili
 */
public class GuestLogger
        extends AbstractGuestLogger
        implements ActionListener {

    // The GuestLogger instance.
    private static GuestLogger instance;

    // Builds the GuestLogger instance.
    private GuestLogger() {}

    /**
     * Returns the GuestLogger instance.
     * @return The GuestLogger instance.
     */
    public static GuestLogger getInstance() {
        if(instance == null) instance = new GuestLogger();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logIn();
    }

    @Override
    public void logIn() {
        Objects.requireNonNull(getGuestNameSetter()).setGuestProfileName();
        Objects.requireNonNull(getAchievement()).unlock();
        Objects.requireNonNull(getAvatarSetter()).setAvatar();
        Objects.requireNonNull(getPanelChanger()).changePanel();
    }

}