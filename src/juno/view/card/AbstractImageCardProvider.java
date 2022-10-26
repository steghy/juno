package juno.view.card;

import juno.model.card.AbstractUnoCard;

import java.awt.Image;

/**
 *
 * @author steghy
 * @email steghy.github@proton.me
 */
public interface AbstractImageCardProvider {

    /**
     * Returns the Image associated with the
     * specified AbstractUnoCard object
     * @param card An AbstractUnoCard object
     * @return An Image
     */
    Image getIconCardFrom(AbstractUnoCard card);
}
