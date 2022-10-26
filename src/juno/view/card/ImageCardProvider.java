package juno.view.card;

import java.awt.*;
import java.util.Map;

import juno.model.card.AbstractUnoCard;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class ImageCardProvider implements AbstractImageCardProvider {

	private Map<AbstractUnoCard, Image> map;

	@Override
	public Image getIconCardFrom(AbstractUnoCard card) {
		return null;
	}
}