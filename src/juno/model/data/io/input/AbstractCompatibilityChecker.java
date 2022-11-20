package juno.model.data.io.input;

public abstract class AbstractCompatibilityChecker {

    private InterfaceDataImporter dataImporter;

    public void setDataImporter(InterfaceDataImporter dataImporter) {
        this.dataImporter = dataImporter;
    }

    public InterfaceDataImporter getDataImporter() {
        return dataImporter;
    }
}
