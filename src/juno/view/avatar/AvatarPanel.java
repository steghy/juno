package juno.view.avatar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import juno.view.exception.JLabelNotSettedException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AvatarPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The picture */
	private JLabel picture;
	
	/* The picture frame */
	private JLabel pictureFrame;

	
	/**
	 * Builds an AvatarPanel object with the specified 
	 * JLabel objects.
	 * @param picture A JLabel object that represents
	 * 				the picture for this object
	 * @param pictureFrame A JLabel object that represents
	 * 				the picture frame for this object
	 */
	public AvatarPanel(JLabel picture, JLabel pictureFrame) {
		this.picture = picture;
		this.pictureFrame = pictureFrame;
	}
	
	
	/**
	 * Builds an AvatarPanel obejct with the specified
	 * JLabel object.
	 * @param picture A JLabel object that represents 
	 * 				the picture for this object
	 */
	public AvatarPanel(JLabel picture) {
		this.picture = picture;
	}

	
	/**
	 * Builds an empty AvatarPanel object 
	 */
	public AvatarPanel() {}
	
	
	/**
	 * Sets the picture of this object
	 * @param label A JLabel object
	 */
	public void setPicture(JLabel label) {
		this.picture = label;
	}
	
	
	/**
	 * Sets the picture frame of this object
	 * @param label A JLabel object
	 */
	public void setPictureFrame(JLabel label) {
		this.pictureFrame = label;
	}
	
	
	/* Initialize this AvatarPanel object */
	public void init() throws JLabelNotSettedException {
		if(picture == null) {
			throw new JLabelNotSettedException(""
					+ "JLabel picture isn't setted");
		} if(pictureFrame == null) {
			throw new JLabelNotSettedException(""
					+ "JLabel picture frame isn't setted");
		}
		
		this.add(picture);
		picture.add(pictureFrame);
		this.setOpaque(false);
	}
}