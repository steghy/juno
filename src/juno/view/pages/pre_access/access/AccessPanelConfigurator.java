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

package juno.view.pages.pre_access.access;

import juno.view.pages.pre_access.access.menu.MenuPanel;
import juno.view.pages.pre_access.access.title.TitlePanel;

/**
 * @author Simone Gentili
 */
public class AccessPanelConfigurator {

    /* Builds the AccessPanelConfigurator */
    private AccessPanelConfigurator() {}

    /** Configure juno.view.pages.pre_access.access.AccessPanel instance. */
    public static void configure() {

        // Main component.
        AccessPanel welcomePanel = AccessPanel.getInstance();

        // Sub components.
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Main component setting.
        welcomePanel.setTitlePanel(titlePanel);
        welcomePanel.setMenuPanel(menuPanel);

        // Main component initialization.
        welcomePanel.init();
    }
}