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

import juno.controller.audio.SoundAction;
import juno.controller.pre_access.log_in.AccountSetter;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.GSetterAction;
import juno.controller.util.PanelChanger;
import juno.model.sound.WelcomeSoundPlayer;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.gobject.GObjectLabel;
import juno.view.gobject.InterfaceGObject;
import juno.view.pages.card.TopCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines a graphic profile processor.
 * @author Simone Gentili
 */
public class GProfileProcessor
        implements InterfaceGraphicProcessor<AbstractButton, InterfaceGObject<String>> {

    // The GProfileProcessor instance.
    private static GProfileProcessor instance;

    // Builds the GProfileProcessor instance.
    private GProfileProcessor() {}

    /**
     * Returns the GProfileProcessor instance.
     * @return The GProfileProcessor instance.
     */
    public static GProfileProcessor getInstance() {
        if(instance == null) instance = new GProfileProcessor();
        return instance;
    }

    @Override
    public AbstractButton process(@NotNull InterfaceGObject<String> gObject) {
        GObjectLabel<String> gProfile = (GObjectLabel<String>) gObject;
        AbstractButton button = ButtonCreator.getInstance()
                .create(Button.PROFILE_BUTTON, null);
        button.setLayout(new BorderLayout());
        button.setOpaque(false);
        button.add(gProfile, BorderLayout.CENTER);
        ImageResizer.getInstance().resize(button, 7.0);
        gProfile.setOpaque(false);
        gProfile.setText(gProfile.object());
        gProfile.setForeground(Color.WHITE);
        gProfile.setFont(new Font(Font.DIALOG, Font.ITALIC, 12));
        gProfile.setVerticalTextPosition(AbstractButton.CENTER);
        gProfile.setHorizontalTextPosition(AbstractButton.CENTER);
        gProfile.setHorizontalAlignment(AbstractButton.CENTER);
        button.addActionListener(new GSetterAction<>(gProfile, AccountSetter.getInstance()));
        button.addActionListener(new SoundAction(WelcomeSoundPlayer.getInstance(),
                new ChangePanelAction(new PanelChanger(TopCardPanel.getInstance(), TopCardPanel.MAIN_PANEL))));
        return button;
    }

}