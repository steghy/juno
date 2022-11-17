package juno.model.data.io.output;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExitManager implements AbstractExitManager {

    private final Map<Exportable, String> map;

    private AbstractDataExporter dataExporter;

    private static ExitManager instance;

    private ExitManager() {
        map = new HashMap<>();
    }

    public static ExitManager getInstance() {
        if(instance == null) {
            instance = new ExitManager();
        } return instance;
    }

    public void addExportable(@NotNull Exportable exportable,@NotNull String path) {
        map.put(exportable, path);
    }

    public void exit() {
        if(dataExporter != null) {
            map.forEach((key, value) -> {
                try {
                    dataExporter.exportData(value, key.getDataMap());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            System.exit(0);
        } else {
            throw new IllegalArgumentException("DataExporter is null");
        }
    }
}
