package juno.model.data.io.input.test;

import juno.init.Directories;
import juno.model.data.io.input.JSONDataImporter;
import juno.model.util.PathGenerator;

import java.io.IOException;
import java.util.Map;

public class JSONDataImporterTester {

    public static void main(String[] args) throws IOException {
        JSONDataImporter dataImporter = JSONDataImporter.getInstance();
        String targetPath = PathGenerator.generate(Directories.CONFIG.absolutePath(), "output-file.json");
        Map<String, Object> map = dataImporter.importData(targetPath);
        printMap(map);
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
