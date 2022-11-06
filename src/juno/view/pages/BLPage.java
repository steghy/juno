package juno.view.pages;

import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.Component;
import java.awt.BorderLayout;

public class BLPage extends JPanel {

	public static final long serialVersionUID = 1L;
	private JComponent background;
	private Component northComponent;
	private Component centerComponent;
	private Component eastComponent;
	private Component westComponent;
	private Component southComponent;

	public BLPage() {}

	public BLPage(JComponent background,
				  Component northComponent,
				  Component centerComponent,
				  Component eastComponent,
				  Component westComponent,
				  Component southComponent) {
		this.background = background;
		this.northComponent = northComponent;
		this.centerComponent = centerComponent;
		this.eastComponent = eastComponent;
		this.westComponent = westComponent;
		this.southComponent = southComponent;
	}

	public void setNorthPanel(Component northComponent) {
		this.northComponent = northComponent;
	}
	public void setCenterComponent(Component centerComponent) {
		this.centerComponent = centerComponent;
	}
	public void setEastComponent(Component eastComponent) {
		this.eastComponent = eastComponent;
	}
	public void setSouthComponent(Component southComponent) {
		this.southComponent = southComponent;
	}
	public void setWestComponent(Component westComponent) {
		this.westComponent = westComponent;
	}
	public void setBackground(JComponent background) {
		this.background = background;
	}

	public void init() {
		if(northComponent == null) {
			throw new IllegalArgumentException("North component is not set");
		} if(centerComponent == null) {
			throw new IllegalArgumentException("Center component is not set");
		} if(eastComponent == null) {
			throw new IllegalArgumentException("East component is not set");
		} if(southComponent == null) {
			throw new IllegalArgumentException("South component is not set");
		} if(westComponent == null) {
			throw new IllegalArgumentException("West component is not set");
		} if(background == null) {
			throw new IllegalArgumentException("Background is not set");
		}

		this.add(background);
		background.setLayout(new BorderLayout());
		background.add(northComponent, BorderLayout.NORTH);
		background.add(centerComponent, BorderLayout.CENTER);
		background.add(eastComponent, BorderLayout.EAST);
		background.add(westComponent, BorderLayout.WEST);
		background.add(southComponent, BorderLayout.SOUTH);
	}
}