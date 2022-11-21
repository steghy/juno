package juno.model.data.io.input;

public abstract class AbstractCompatibilityChecker {

    private InterfaceDataImporter dataImporter;

    private InterfacePropertyCopier propertyCopier;

    public void setDataImporter(InterfaceDataImporter dataImporter) {
        this.dataImporter = dataImporter;
    }

    public void setPropertyCopier(InterfacePropertyCopier propertyCopier) {
        this.propertyCopier = propertyCopier;
    }

    public InterfaceDataImporter getDataImporter() {
        return dataImporter;
    }

    public InterfacePropertyCopier getPropertyCopier() {
        return propertyCopier;
    }
}
