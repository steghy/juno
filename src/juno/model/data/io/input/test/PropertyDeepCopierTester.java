package juno.model.data.io.input.test;

import juno.init.Directories;
import juno.model.data.io.input.PropertyDeepCopier;
import juno.model.data.io.output.JSONDataExporter;
import juno.model.util.PathGenerator;

import java.io.IOException;
import java.util.Map;

public class PropertyDeepCopierTester {

    public static void main(String[] args) throws IOException {
        PropertyDeepCopier deepCopier = PropertyDeepCopier.getInstance();

        Class<?> clazz = MyClass.class;

        JSONDataExporter jsonDataExporter = JSONDataExporter.getInstance();

        Map<String, Object> map = deepCopier.deepCopy(clazz);

        printMap(map);

        String path = PathGenerator.generate(Directories.CONFIG.absolutePath(), "output-file.json");
        jsonDataExporter.exportData(path, map);
    }

    @SuppressWarnings("unchecked")
    private static void printMap(Map<String, Object> map) {
        map.forEach((k, v) -> {
            System.out.print(k + " = ");
            if(v instanceof Map<?, ?> anotherMap) {
                System.out.print(" { ");
                printMap((Map<String, Object>) v);
                System.out.println(" } ");
            } else {
                System.out.print(v + " type -> ");
                System.out.println(v.getClass().getSimpleName());
            }
        });
    }
}
