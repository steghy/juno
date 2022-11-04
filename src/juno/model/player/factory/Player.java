package juno.model.player.factory;

import juno.model.player.factory.AbstractPlayer;

/**
 * @param playerName The Player object name
 * @author steghy
 */
public record Player(String playerName) implements AbstractPlayer {

}