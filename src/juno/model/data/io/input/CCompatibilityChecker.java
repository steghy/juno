package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;
import java.util.Map;

public class CCompatibilityChecker
        extends AbstractCompatibilityChecker
        implements InterfaceCCompatibilityChecker {

    private static CCompatibilityChecker instance;

    private CCompatibilityChecker() {}

    public static CCompatibilityChecker getInstance() {
        if(instance == null) instance = new CCompatibilityChecker();
        return instance;
    }

    @Override
    public boolean checkCompatibilityOf(@NotNull Configurable configurable,
                                        @NotNull String path) {
        Map<String, Object> properties = getPropertyCopier().copy(configurable);
        boolean isValid = false;
        try {
            Map<String, Object> map = getDataImporter().importData(path);
            if(!map.isEmpty()) {
                configurable.configure(map);
                isValid = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        if(!properties.isEmpty())
            configurable.configure(properties);
        return isValid;
    }
}
