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

import juno.controller.pre_access.RegistrationDataSender;
import juno.controller.pre_access.RegistrationPanelRestorer;
import juno.model.data.profile.Profile;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.pages.pre_access.card.PreAccessCardPanel;
import juno.view.pages.pre_access.registration.RegistrationPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class MenuPanelConfigurator {

    // Builds a MenuPanelConfigurator object.
    private MenuPanelConfigurator() {}

    public static void configure() {
        // Main component.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // components.
        JLabel profileNameLabel = new JLabel("username:");
        JLabel nameLabel = new JLabel("name:");
        JLabel lastNameLabel= new JLabel("last name:");
        JLabel ageLabel = new JLabel("age:");

        // Colors.
        profileNameLabel.setForeground(Color.WHITE);
        nameLabel.setForeground(Color.WHITE);
        lastNameLabel.setForeground(Color.WHITE);
        ageLabel.setForeground(Color.WHITE);

        // Texts.
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 18);
        profileNameLabel.setFont(font);
        nameLabel.setFont(font);
        lastNameLabel.setFont(font);
        ageLabel.setFont(font);

        // Text fields.
        JTextField profileNameTextField = new JTextField(15);
        JTextField nameTextField = new JTextField(15);
        JTextField lastNameTextField = new JTextField(15);
        JTextField ageTextField = new JTextField(15);

        // RegistrationDataLine objects.
        RegistrationDataLine profileName = new RegistrationDataLine(profileNameLabel, profileNameTextField);
        RegistrationDataLine name = new RegistrationDataLine(nameLabel, nameTextField);
        RegistrationDataLine lastName = new RegistrationDataLine(lastNameLabel, lastNameTextField);
        RegistrationDataLine age = new RegistrationDataLine(ageLabel, ageTextField);

        // Buttons.
        AbstractButton confirmButton = ButtonFactory.createButton(ButtonLibrary.CONFIRM);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // Labels.
        menuPanel.setFirstComponent(profileName);   // Profile name.
        menuPanel.setSecondComponent(name);         // Name.
        menuPanel.setThirdComponent(lastName);      // Last name.
        menuPanel.setFourthComponent(age);          // Age.

        // Buttons.
        menuPanel.setFifthComponent(confirmButton); // Confirm button.
        menuPanel.setSixthComponent(backButton);    // Back button.

        // Images resizing.
        ImageResizer.resize(confirmButton, 3.0);
        ImageResizer.resize(backButton, 3.0);

        // Action listeners.
        confirmButton.addActionListener(new RegistrationDataSender(Profile.getInstance(), menuPanel));

        backButton.addActionListener(listener -> {
            LayoutManager layoutManager = PreAccessCardPanel.getInstance().getLayout();
            if(layoutManager instanceof CardLayout cardLayout) {
                if(RegistrationPanel.getInstance().isFromWelcomePanel())
                    cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.WELCOME_PANEL);
                else
                    cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.ACCESS_PANEL);
            } else {
                throw new IllegalArgumentException(
                        "Invalid object type: " + layoutManager.getClass() +
                        ". CardLayout expected.");
            }
        });

        backButton.addActionListener(RegistrationPanelRestorer.getInstance());

        // Inside border.
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        // Outside border.
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        // Composed border.
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Main component initialization.
        menuPanel.init();
    }

}