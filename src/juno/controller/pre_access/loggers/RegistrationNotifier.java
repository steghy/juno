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

import juno.controller.pre_access.registration.InterfaceRegistrationDataSelector;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * This class defines a registration notifier.
 * @author Simone Gentili
 */
public class RegistrationNotifier
        implements Observer {

    // The RegistrationNotifier instance.
    private static RegistrationNotifier instance;

    // Builds the RegistrationNotifier.
    private RegistrationNotifier() {}

    /**
     * Returns the RegistrationNotifier instance.
     * @return The RegistrationNotifier instance.
     */
    public static RegistrationNotifier getInstance() {
        if(instance == null) instance = new RegistrationNotifier();
        return instance;
    }

    /**
     * Notifies the registration with
     * a message dialog.
     */
    public void notifyRegistrationMessage() {
        JOptionPane.showMessageDialog(null, "Thank you for the registration.");
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceRegistrationDataSelector) {
            notifyRegistrationMessage();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceRegistrationDataSelector type expected.");
    }

}