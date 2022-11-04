package juno.view.audio.container;

import java.awt.Image;
import java.io.Serial;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background extends JLabel {

	@Serial
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private static Background instance;

	private Background() {}

	public static Background getInstance() {
		if(instance == null) {
			instance = new Background();
		} return instance;
	}
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void setIcon(Icon icon) {
		if(this.panel != null) {
			if(icon instanceof ImageIcon) {
				Image scaledImage = ((ImageIcon)icon).getImage()
						.getScaledInstance(this.panel.getWidth(), 
										   this.panel.getHeight(), 0);
				super.setIcon(new ImageIcon(scaledImage));
			}
		}
	}
}