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

package juno.controller.new_game.connector;

import juno.controller.util.InterfaceInitializer;
import juno.model.card.InterfaceCard;
import juno.model.data.awards.avatar.AvatarImage;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.factory.AiFactory;
import juno.model.subjects.shift.CurrentPlayerProvider;
import juno.model.subjects.shift.PlayersProvider;
import juno.model.subjects.shift.TurnMover;
import juno.model.util.Provider;
import juno.view.avatar.AvatarPanel;
import juno.view.gobject.avatars.GAvatarImageCreator;
import juno.view.pages.new_game.single_player.match.panels.east.EastCardPanel;
import juno.view.pages.new_game.single_player.match.panels.east.EastPanel;
import juno.view.pages.new_game.single_player.match.panels.north.NorthCardPanel;
import juno.view.pages.new_game.single_player.match.panels.north.NorthPanel;
import juno.view.pages.new_game.single_player.match.panels.south.SouthPanel;
import juno.view.pages.new_game.single_player.match.panels.west.WestCardPanel;
import juno.view.pages.new_game.single_player.match.panels.west.WestPanel;

import java.awt.*;
import java.util.List;
import java.util.Objects;

/**
 * This class defines an initializer.
 * @author Simone Gentili
 */
public class Initializer
        implements InterfaceInitializer {

    // Builds the Initializer instance.
    private static Initializer instance;

    // Builds the Initializer instance.
    private Initializer() {}

    /**
     * Returns the Initializer instance.
     * @return The Initializer instance.
     */
    public static Initializer getInstance() {
        if(instance == null) instance = new Initializer();
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void initialize() {
        // Panel illuminator.
        PanelIlluminator panelIlluminator = PanelIlluminator.getInstance();

        // Connector.
        Connector<InterfaceCard> connector = (Connector<InterfaceCard>) Connector.getInstance();

        // Ai avatar setter.
        AiAvatarSetter aiAvatarSetter = AiAvatarSetter.getInstance();

        // Ai player factory.
        AiFactory<?, ?> aiPlayerFactory = AiFactory.getInstance();

        // Avatar connector.
        AvatarConnector<InterfaceCard> avatarConnector =
                (AvatarConnector<InterfaceCard>) AvatarConnector.getInstance();

        // Circle connector.
        CircleConnector<InterfaceCard> circleConnector =
                (CircleConnector<InterfaceCard>) CircleConnector.getInstance();

        // Avatars.
        Component northAvatar = NorthPanel.getInstance().getSecondComponent();
        Component westAvatar  = WestPanel.getInstance().getSecondComponent();
        Component eastAvatar  = EastPanel.getInstance().getSecondComponent();
        Component southAvatar = SouthPanel.getInstance().getSecondComponent();

        ///////////////////////////////////////////////////////////////////

        // Connector.
        connector.setEast(EastCardPanel.getInstance());
        connector.setNorth(NorthCardPanel.getInstance());
        connector.setWest(WestCardPanel.getInstance());
        aiPlayerFactory.addObserver(connector);

        // Circle connector.
        circleConnector.setNorth(Objects.requireNonNull(NorthPanel.getInstance().getThirdComponent()));
        circleConnector.setWest(Objects.requireNonNull(WestPanel.getInstance().getThirdComponent()));
        circleConnector.setEast(Objects.requireNonNull(EastPanel.getInstance().getThirdComponent()));
        circleConnector.setSouth(Objects.requireNonNull(SouthPanel.getInstance().getThirdComponent()));
        PlayersProvider.getInstance().addObserver(circleConnector);

        // Panel illuminator.
        panelIlluminator.setPlayerProvider((Provider<InterfacePlayer<?>>) CurrentPlayerProvider.getInstance());
        TurnMover.getInstance().addObserver(panelIlluminator);
        circleConnector.addObserver(panelIlluminator);

        // Ai avatar setter.
        aiAvatarSetter.setNorth((AvatarPanel) Objects.requireNonNull(northAvatar));
        aiAvatarSetter.setEast((AvatarPanel) Objects.requireNonNull(eastAvatar));
        aiAvatarSetter.setWest((AvatarPanel) Objects.requireNonNull(westAvatar));
        aiAvatarSetter.setAvatarImageProvider(new RandomObjectProvider<>(List.of(AvatarImage.values())));
        aiAvatarSetter.setAvatarImageCreator(GAvatarImageCreator.getInstance());
        aiPlayerFactory.addObserver(aiAvatarSetter);

        // Avatar connector.
        avatarConnector.setNorth(northAvatar);
        avatarConnector.setWest(westAvatar);
        avatarConnector.setEast(eastAvatar);
        avatarConnector.setSouth(Objects.requireNonNull(southAvatar));
        PlayersProvider.getInstance().addObserver(avatarConnector);
    }

}