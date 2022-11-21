package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractCompatibilityChecker {

    private InterfaceDataImporter dataImporter;

    private InterfacePropertyCopier propertyCopier;

    public void setDataImporter(@NotNull InterfaceDataImporter dataImporter) {
        this.dataImporter = dataImporter;
    }

    public void setPropertyCopier(@NotNull InterfacePropertyCopier propertyCopier) {
        this.propertyCopier = propertyCopier;
    }

    public InterfaceDataImporter getDataImporter() {
        return dataImporter;
    }

    public InterfacePropertyCopier getPropertyCopier() {
        return propertyCopier;
    }
}
