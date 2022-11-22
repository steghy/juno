package juno.model.data.io.input.test;

import juno.init.Directories;
import juno.model.data.io.input.PropertyDeepCopier;
import juno.model.data.io.output.JSONDataExporter;
import juno.model.util.PathGenerator;

import java.io.IOException;

public class PropertyDeepCopierTester {

    public static void main(String[] args) throws IOException {
        PropertyDeepCopier deepCopier = PropertyDeepCopier.getInstance();

        Class<?> clazz = MyClass.class;

        JSONDataExporter jsonDataExporter = JSONDataExporter.getInstance();

        String path = PathGenerator.generate(Directories.CONFIG.absolutePath(), "output-file.json");
        jsonDataExporter.exportData(path, deepCopier.deepCopy(clazz));
    }

}
