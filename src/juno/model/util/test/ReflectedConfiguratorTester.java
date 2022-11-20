package juno.model.util.test;

import juno.init.Directories;
import juno.model.util.PathGenerator;
import java.io.IOException;

public class ReflectedConfiguratorTester {

    static String configFilePath = PathGenerator.generate(Directories.CONFIG.absolutePath(), "button-factory.json");

    public static void main(String[] args) throws IOException {
        importData();
    }

    public static void importData() throws IOException {

    }
}
