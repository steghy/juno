package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Map;

public class CCompatibilityChecker
        extends AbstractCompatibilityChecker
        implements InterfaceCCompatibilityChecker {

    private final Map<Configurable, String> incompatibleFiles;

    private static CCompatibilityChecker instance;

    private CCompatibilityChecker() {
        incompatibleFiles = new HashMap<>();
    }

    public static CCompatibilityChecker getInstance() {
        if(instance == null) instance = new CCompatibilityChecker();
        return instance;
    }

    @Override
    public boolean checkCompatibilityOf(@NotNull Configurable configurable,
                                        @NotNull String path) {
        incompatibleFiles.clear();
        Map<String, Object> properties = getPropertyCopier().copy(configurable);
        boolean isValid = false;
        try {
            configurable.configure(getDataImporter().importData(path));
            isValid = true;
        } catch(Exception e) {
            e.printStackTrace();
            incompatibleFiles.put(configurable, path);
        }
        configurable.configure(properties);
        return isValid;
    }

    public Map<Configurable, String> getIncompatibleFiles() {
        return new HashMap<>(incompatibleFiles);
    }
}
