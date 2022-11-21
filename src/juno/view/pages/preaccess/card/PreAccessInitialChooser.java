package juno.view.pages.preaccess.card;

import juno.model.data.io.input.InterfaceConfigurationFilesProvider;
import juno.model.data.io.input.Configurable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class PreAccessInitialChooser {

    private InterfaceConfigurationFilesProvider configurationFilesProvider;

    private static PreAccessInitialChooser instance;

    private PreAccessInitialChooser() {}

    public static PreAccessInitialChooser getInstance() {
        if(instance == null) instance = new PreAccessInitialChooser();
        return instance;
    }

    public void setFirstPanelToShow(@NotNull String path,
                                    @NotNull Configurable configurable) {
        List<File> files = null;
        try {
            files = configurationFilesProvider.getConfigurationFiles(configurable, path);
        } catch (FileNotFoundException e) {
            // Directory not found !!! solve.
            e.printStackTrace();
        } if(files != null) {
            LayoutManager layoutManager = PreAccessCardPanel.getInstance().getLayout();
            if(layoutManager instanceof CardLayout cardLayout) {
                cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.ACCESS_PANEL);
            } else {
                throw new IllegalArgumentException("CardLayout expected");
            }
        }
    }

    public void setConfigurationFilesProvider(@NotNull InterfaceConfigurationFilesProvider configurationFilesProvider) {
        this.configurationFilesProvider = configurationFilesProvider;
    }
}
