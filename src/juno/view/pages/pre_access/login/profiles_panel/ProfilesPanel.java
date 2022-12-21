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

package juno.view.pages.pre_access.login.profiles_panel;

import juno.controller.pre_access.log_in.AccountSetter;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.GSetterAction;
import juno.controller.util.PanelChanger;
import juno.model.util.Observer;
import juno.view.button.ButtonCreator;
import juno.view.gobject.InterfaceGObjectFactory;
import juno.view.gobject.profiles.GProfile;
import juno.view.pages.card.TopCardPanel;
import juno.view.util.ImageResizer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class ProfilesPanel
        extends JPanel
        implements Observer {

    // The ProfilesPanel instance.
    private static ProfilesPanel instance;

    // Builds the ProfilesPanel instance.
    private ProfilesPanel() {
        setOpaque(false);
        setLayout(new GridLayout(15, 1));
    }

    /**
     * Returns the ProfilesPanel instance.
     * @return The ProfilesPanel instance.
     */
    public static ProfilesPanel getInstance() {
        if(instance == null) instance = new ProfilesPanel();
        return instance;
    }

    @Override @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceGObjectFactory<?> factory) {
            this.removeAll();
            factory.getGObjects().forEach(gObject -> {
                GProfile<String> gProfile = (GProfile<String>) gObject;
                AbstractButton button = ButtonCreator.getInstance()
                        .create(juno.view.button.Button.PROFILE_BUTTON);
                button.setLayout(new BorderLayout());
                button.add(gProfile, BorderLayout.CENTER);
                ImageResizer.resize(button, 8.0);
                gProfile.setForeground(Color.WHITE);
                gProfile.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
                gProfile.setVerticalTextPosition(AbstractButton.CENTER);
                gProfile.setHorizontalTextPosition(AbstractButton.CENTER);
                gProfile.setHorizontalAlignment(AbstractButton.CENTER);
                button.addActionListener(new GSetterAction<>(gProfile, AccountSetter.getInstance()));
                button.addActionListener(new ChangePanelAction(new PanelChanger(TopCardPanel.getInstance(), TopCardPanel.MAIN_PANEL)));
                add(button);
            });
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceGObjectFactory type expected.");
    }

}