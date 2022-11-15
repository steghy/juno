package juno.model.data;

public interface AbstractDataExporter {

    void exportData(AbstractData<?, ?> data, String path);
}
