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

package juno.view.pages.score;

import juno.model.data.avatar.AvatarImageProvider;
import juno.model.data.avatar.AvatarImageSetter;
import juno.model.data.avatar.AvatarNameProvider;
import juno.model.data.avatar.AvatarNameSetter;
import juno.view.avatar.UserAvatarPanel;
import juno.view.gobject.avatars.GAvatarImageCreator;
import juno.view.pages.score.menu.MenuPanel;
import juno.view.pages.score.title.TitlePanel;


/**
 * This class defines a configurator.
 * @author Simone Gentili
 */
public class ScorePanelConfigurator {

    // Builds a ScorePanelConfigurator object.
    private ScorePanelConfigurator() {}

    /**
     * Configures the ScorePanel instance.
     */
    public static void configure() {
        // Main component.
        ScorePanel scorePanel = ScorePanel.getInstance();

        // Components.
        MenuPanel menuPanel = MenuPanel.getInstance();
        TitlePanel titlePanel = TitlePanel.getInstance();
        UserAvatarPanel avatarPanel = new UserAvatarPanel(
                AvatarNameSetter.getInstance(),
                AvatarImageSetter.getInstance(),
                GAvatarImageCreator.getInstance(),
                AvatarImageProvider.getInstance(),
                AvatarNameProvider.getInstance());

        // Adding components.
        scorePanel.setFirstComponent(titlePanel);   // Title panel.
        scorePanel.setSecondComponent(menuPanel);   // Menu panel.
        scorePanel.setThirdComponent(avatarPanel);  // Avatar panel.
        scorePanel.setFourthComponent(GamesWonPanel.getInstance());
        scorePanel.setFifthComponent(LostGamesPanel.getInstance());

        // Main component initialization.
        scorePanel.init();
    }

}