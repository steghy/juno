package juno.model.data.io.input.test;

import juno.init.Directories;
import juno.model.data.io.input.ConfigurationFilesProvider;
import juno.model.data.io.input.InputDataInitializer;
import juno.model.data.io.input.JSONDataImporter;
import juno.model.data.io.input.RConfigurator;
import juno.model.util.PathGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConfiguratorTester {

    // DATA IMPORTER COMPONENT
    private final static JSONDataImporter jsonDataImporter = JSONDataImporter.getInstance();

    // CONFIGURATION FILES PROVIDER
    private static final ConfigurationFilesProvider configurationFilesProvider = ConfigurationFilesProvider.getInstance();

    // OBJECT TARGET
    private final static MyObject object = new MyObject();

    // CLASS TARGET
    private final static Class<?> clazz = MyClass.class;

    public static void main(String[] args) {
        // TEST TARGETS
        String myClassConfigPath = PathGenerator.generate(Directories.CONFIG.absolutePath(), "my-lass-config.json");
        String myObjectConfigPath = PathGenerator.generate(Directories.CONFIG.absolutePath(), "");

        // INITIALIZATION
        InputDataInitializer.initialize();

        // RCONFIGURATOR TEST
        System.out.println("///// Pre configuration /////");
        printObjectDetails();
        // printClassDetails();

        Objects.requireNonNull(configurationFilesObject(myObjectConfigPath)).forEach(System.out::println);
        // configureObjectWithRConfigurator(myObjectConfigPath);
        // configureClassWithRConfigurator(myClassConfigPath);

        System.out.println("///// Post configuration /////");
        printObjectDetails();
        // printClassDetails();
    }

    private static List<File> configurationFilesObject(String path) {
        try {
            return configurationFilesProvider.getConfigurationFiles((Object)object, path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void configureObjectWithRConfigurator(String path) {
        RConfigurator rConfigurator = RConfigurator.getInstance();
        try {
            rConfigurator.configure(jsonDataImporter.importData(path), object);
        } catch (NoSuchFieldException |
                 IllegalAccessException |
                 InvocationTargetException |
                 IOException e) {
            e.printStackTrace();
        }
    }

    private static void configureClassWithRConfigurator(String path) {
        RConfigurator rConfigurator = RConfigurator.getInstance();
        try {
            rConfigurator.configure(jsonDataImporter.importData(path), clazz);
        } catch (NoSuchFieldException |
                 IllegalAccessException |
                 InvocationTargetException |
                 IOException e) {
            e.printStackTrace();
        }
    }

    private static void printClassDetails() {
        Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            try {
                // Prevent NullPointerException
                if(Modifier.isStatic(field.getModifiers())) {
                    System.out.println(field.getName() + " = " + field.get(null));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void printObjectDetails() {
        Arrays.stream(object.getClass().getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + " = " + field.get(object));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
