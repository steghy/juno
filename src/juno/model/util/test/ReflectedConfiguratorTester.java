package juno.model.util.test;

import juno.init.Directories;
import juno.model.data.io.input.AbstractDataImporter;
import juno.model.data.io.input.JSONDataImporter;
import juno.model.data.io.output.JSONDataExporter;
import juno.model.util.PathGenerator;
import juno.model.data.io.input.ReflectedConfigurator;
import juno.view.factories.buttons.ButtonFactory;

import java.io.IOException;
import java.util.Arrays;

public class ReflectedConfiguratorTester {

    static String configFilePath = PathGenerator.generate(Directories.CONFIG.absolutePath(), "button-factory.json");

    public static void main(String[] args) throws IOException {
        importData();
    }

    public static void importData() throws IOException {
        AbstractDataImporter dataImporter = JSONDataImporter.getInstance();

        System.out.println("//////////// PRE CONFIGURATION ///////////");
        Arrays.stream(ButtonFactory.class
                .getDeclaredFields()).forEach(field -> {
            System.out.print("Field: " + field.getName() + " ");
            System.out.print("Type: " + field.getType() + " ");
            field.setAccessible(true);
            try {
                System.out.println("Value: " + field.get(null));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        ReflectedConfigurator.configure(dataImporter.importData(configFilePath), ButtonFactory.class);

        System.out.println("//////////// POST CONFIGURATION ///////////");
        Arrays.stream(ButtonFactory.class
                .getDeclaredFields()).forEach(field -> {
            System.out.print("Field: " + field.getName() + " ");
            System.out.print("Type: " + field.getType() + " ");
            field.setAccessible(true);
            try {
                System.out.println("Value: " + field.get(null));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
