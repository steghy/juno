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

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Map;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ErrorNotifier
        extends AbstractErrorNotifier
        implements InterfaceErrorNotifier{

    // The ChangeRegistrationPanelState instance.
    private static ErrorNotifier instance;

    // Builds the ChangeRegistrationPanel instance.
    private ErrorNotifier() {}

    /**
     * Returns the ChangeRegistrationPanelState instance.
     * @return The ChangeRegistrationPanelState instance.
     */
    public static ErrorNotifier getInstance() {
        if(instance == null) instance = new ErrorNotifier();
        return instance;
    }

    @Override
    public void notifyErrors() {
        Map<String, String> errors = Objects.requireNonNull(getProvider()).getErrors();
        Map<String, JPanel> dataLine = Objects.requireNonNull(getDataLineProvider()).getDataLines();
        if(errors.isEmpty()) throw new IllegalArgumentException("nothing to report");
        if(dataLine.isEmpty()) throw new IllegalArgumentException("Empty map");

        Border border = BorderFactory.createLineBorder(Color.RED);

        for(Map.Entry<String, String> entry : errors.entrySet()) {
            String errorKey = entry.getKey();
            String errorValue = entry.getValue();

            for(String inputKey : dataLine.keySet()) {
                if(errorKey.equals(inputKey)) dataLine.get(inputKey).setBorder(
                        BorderFactory.createTitledBorder(
                                border,
                                errorValue,
                                0,
                                0,
                                new Font(Font.MONOSPACED, Font.ITALIC, 13),
                                Color.RED
                        )
                );
            }
        }
    }

}