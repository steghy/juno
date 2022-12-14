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

package juno.view.pages.pre_access.registration.menu;

import juno.controller.pre_access.registration.InterfaceDataLineProvider;
import juno.controller.pre_access.registration.InterfaceRegistrationDataSelector;
import juno.model.data.io.output.Exportable;
import juno.model.data.profile.profile.Profile;
import juno.model.util.Observer;
import juno.view.panels.AbstractSixthComponent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class defines a menu panel.
 * @author Simone Gentili
 */
public class MenuPanel
        extends AbstractSixthComponent
        implements Exportable, InterfaceDataLineProvider, Observer {

    /** The data lines map. */
    private final Map<String, DataLine> dataLines;

    // The MenuPanel instance.
    private static MenuPanel instance;

    // Builds the MenuPanel instance.
    private MenuPanel() {
        dataLines = new HashMap<>();
    }

    /**
     * Returns the MenuPanel instance.
     * @return The MenuPanel instance.
     */
    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    /** Initialize the MenuPanel instance. */
    public void init() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Profile name.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,15,0);
        this.add(Objects.requireNonNull(getFirstComponent()), gbc);
        dataLines.put(Profile.PROFILE_NAME_KEY, (DataLine) getFirstComponent());

        // Name.
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,15,0);
        this.add(Objects.requireNonNull(getSecondComponent()), gbc);
        dataLines.put(Profile.NAME_KEY, (DataLine) getSecondComponent());

        // Last name.
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,30,0);
        this.add(Objects.requireNonNull(getThirdComponent()), gbc);
        dataLines.put(Profile.LAST_NAME_KEY, (DataLine) getThirdComponent());

        // Age.
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,30,0);
        this.add(Objects.requireNonNull(getFourthComponent()), gbc);
        dataLines.put(Profile.AGE_KEY, (DataLine) getFourthComponent());

        // Confirm button.
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,47);
        this.add(Objects.requireNonNull(getFifthComponent()), gbc);

        // Back button.
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        this.add(Objects.requireNonNull(getSixthComponent()), gbc);
    }

    @Override
    public Map<String, Object> exportData() {
        Map<String, Object> map = new HashMap<>();
        getDataLines().forEach((k,v) -> {
            switch (k) {
                // Profile, Name, Last name case.
                case (Profile.PROFILE_NAME_KEY),
                        (Profile.NAME_KEY),
                        (Profile.LAST_NAME_KEY) -> {
                    String text = v.getTextField().getText();
                    if(text.length() != 0)
                        map.put(k, text);
                    // Age case.
                } case (Profile.AGE_KEY) -> {
                    String text = v.getTextField().getText();
                    if(text.length() != 0) {
                        int age;
                        try {
                            age = Integer.parseInt(text);
                            map.put(k, age);
                        } catch (Exception e) {
                            map.put(k, text);
                        }
                    }
                }
            }
        }); return map;
    }

    @Override
    public Map<String, DataLine> getDataLines() {
        return dataLines;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceRegistrationDataSelector)
            getDataLines().forEach((k, v) -> {
                v.setBorder(null); v.getTextField().setText("");
            });
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceRegistrationDataSelector type expected.");
    }

}