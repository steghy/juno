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

package juno.view.pages.main;

import juno.view.avatar.AvatarPanel;
import juno.view.pages.main.menu.MenuPanel;
import juno.view.pages.main.title.TitlePanel;

/**
 * @author Simone Gentili
 */
public class MainPanelConfigurator {

    // Builds a MainPanelConfigurator instance.
    private MainPanelConfigurator() {}

    public static void configure() {
        // Main component.
        MainPanel mainPanel = MainPanel.getInstance();

        // Components.
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();
        AvatarPanel avatarPanel = new AvatarPanel(3.0);

        // Components settings.
        mainPanel.setFirstComponent(titlePanel);  // title panel
        mainPanel.setSecondComponent(menuPanel);  // Menu panel.
        mainPanel.setThirdComponent(avatarPanel); // Avatar panel.

        // Main component initialization.
        mainPanel.init();
    }

}