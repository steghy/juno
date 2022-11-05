package juno.view.mainpage;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.mainpage.center.CenterPanel;
import juno.view.mainpage.east.EastPanel;
import juno.view.mainpage.north.NorthPanel;
import juno.view.mainpage.south.SouthPanel;
import juno.view.mainpage.west.WestPanel;
import juno.view.util.ImageResizer;
import juno.view.util.LabelConfigurator;
import juno.view.util.PanelConfigurator;

import javax.swing.*;
import java.awt.*;

public class MainPageConfigurator {

	private MainPageConfigurator() {}

	public static void configure() {
		// MAIN-COMPONENT
		MainPage page = MainPage.getInstance();

		// MAIN-COMPONENT DIMENSION
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
		page.setCenterPanel(centerPanel);
		page.setWestPanel(westPanel);
		page.setEastPanel(eastPanel);
		page.setSouthPanel(southPanel);

		// INITIALIZATION
		page.init();
	}
}
