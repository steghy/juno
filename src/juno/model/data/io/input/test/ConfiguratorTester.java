package juno.model.data.io.input.test;

import juno.init.Directories;
import juno.model.data.io.input.*;
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
        String myClassConfigPath = PathGenerator.generate(Directories.CONFIG.absolutePath(), "");
        String myObjectConfigPath = PathGenerator.generate("");

        PropertyDeepCopier deepCopier = PropertyDeepCopier.getInstance();

        // INITIALIZATION
        InputDataInitializer.initialize();

        // RCONFIGURATOR TEST
        System.out.println("///// Pre configuration /////");
        System.out.println(deepCopier.deepCopy(clazz));


        // Objects.requireNonNull(configurationFilesObject(myObjectConfigPath)).forEach(System.out::println);
        // configureObjectWithRConfigurator(myObjectConfigPath);
        Objects.requireNonNull(configurationFilesClass(myClassConfigPath)).forEach(System.out::println);
        // configureClassWithRConfigurator(myClassConfigPath);

        System.out.println("///// Post configuration /////");
        System.out.println(deepCopier.deepCopy(clazz));
    }

    private static List<File> configurationFilesObject(String path) {
        try {
            return configurationFilesProvider.getConfigurationFiles((Object)object, path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<File> configurationFilesClass(String path) {
        try {
            return configurationFilesProvider.getConfigurationFiles(clazz, path);
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
}