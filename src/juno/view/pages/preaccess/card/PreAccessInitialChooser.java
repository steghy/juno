package juno.view.pages.preaccess.card;

import juno.model.data.io.input.InterfaceConfigurationFilesProvider;
import juno.model.data.io.input.Configurable;

import java.awt.*;
import java.io.File;
import java.util.List;

public class PreAccessInitialChooser {

    private InterfaceConfigurationFilesProvider configurationFilesProvider;

    private static PreAccessInitialChooser instance;

    private PreAccessInitialChooser() {}

    public static PreAccessInitialChooser getInstance() {
        if(instance == null) {
            instance = new PreAccessInitialChooser();
        } return instance;
    }

    public void setFirstPanelToShow(String path, Configurable configurable) {
        List<File> files = configurationFilesProvider.getConfigurationFiles(path, configurable);
        if(files.size() != 0) {
            LayoutManager layoutManager = PreAccessCardPanel.getInstance().getLayout();
            if(layoutManager instanceof CardLayout cardLayout) {
                cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.ACCESS_PANEL);
            } else {
                throw new IllegalArgumentException("CardLayout expected");
            }
        }
    }

    public void setDataCompatibilityChecker(InterfaceConfigurationFilesProvider configurationFilesProvider) {
        this.configurationFilesProvider = configurationFilesProvider;
    }
}
