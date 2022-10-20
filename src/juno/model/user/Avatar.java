package juno.model.user;

import java.awt.Image;

/**
 * Avatar class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Avatar {

	/* The Avatar object image */
	Image avatarImage;
	
	/**
	 * Builds an empty Avatar object
	 */
	public Avatar() {}
	
	/**
	 * Builds an Avatar object with the specified
	 * Image object
	 * @param avatarImage The Avatar object image.
	 */
	public Avatar(Image avatarImage) {
		setAvatarImage(avatarImage);
	}

	
	/**
	 * Returns the Avatar object image
	 * @return The Avatar object image
	 */
	public Image getAvatarImage() {
		return this.avatarImage;
	}
	
	
	/**
	 * Sets the Avatar object image
	 * @param avatarImage The new Avatar object image
	 */
	public void setAvatarImage(Image avatarImage) {
		checkImageValidity(avatarImage);
		this.avatarImage = avatarImage;
	}

	
	/* Checks the image validity */
	private void checkImageValidity(Image avatarImage) {
		int height = avatarImage.getHeight(null);
		int width =  avatarImage.getWidth(null);
		if(height > 350 || width > 350) {
			throw new IllegalArgumentException(""
					+ "The specified image is to big");
		} else if(height < 100 || width < 100) {
			throw new IllegalArgumentException(""
					+ "The specified image is to small");
		}
	}
}