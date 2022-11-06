package juno.view.pages;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.pages.main.center.CenterPanel;
import juno.view.pages.main.east.EastPanel;
import juno.view.pages.main.north.NorthPanel;
import juno.view.pages.main.south.SouthPanel;
import juno.view.pages.main.west.WestPanel;
import juno.view.util.ImageResizer;
import juno.view.util.LabelConfigurator;
import juno.view.util.PanelConfigurator;

import javax.swing.*;
import java.awt.*;

public class MainPageConfigurator {

	private MainPageConfigurator() {}

	public static void configure() {
		// BLANK PAGE
		BLPage page = new BLPage(); // Use BorderLayout

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		PanelConfigurator.configure(page, dimension);

		// COMPONENTS
		JLabel background = new JLabel();
		NorthPanel northPanel = NorthPanel.getInstance();
		CenterPanel centerPanel = CenterPanel.getInstance();
		EastPanel eastPanel = EastPanel.getInstance();
		WestPanel westPanel = WestPanel.getInstance();
		SouthPanel southPanel = SouthPanel.getInstance();

		// BACKGROUND IMAGE
		String backgroundImage = PathGenerator.generate(Paths.BACKGROUNDS.getPath(), "background.gif");

		// BACKGROUND SETTINGS
		LabelConfigurator.configure(background, dimension);
		background.setIcon(new ImageIcon(ImageResizer.resize(background, backgroundImage)));

		// MAIN-PAGE SETTINGS
		page.setBackground(background);
		page.setNorthPanel(northPanel);
		page.setCenterComponent(centerPanel);
		page.setWestComponent(westPanel);
		page.setEastComponent(eastPanel);
		page.setSouthComponent(southPanel);

		// INITIALIZATION
		page.init();
	}
}
