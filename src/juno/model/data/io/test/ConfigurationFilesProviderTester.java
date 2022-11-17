package juno.model.data.io.test;

import juno.model.data.io.AbstractConfigurationFilesProvider;
import juno.model.data.io.ConfigurationFilesProvider;
import juno.model.data.io.DataIOInitializer;
import juno.model.data.user.User;
import juno.model.util.PathGenerator;

import java.io.File;
import java.util.List;

public class ConfigurationFilesProviderTester {

    public static void main(String[] args) {
        String data = PathGenerator.generate("data");
        String profiles = PathGenerator.generate(data, "profiles");

        User user = new User();

        DataIOInitializer.initialize();

        AbstractConfigurationFilesProvider configurationFilesProvider = ConfigurationFilesProvider.getInstance();

        List<File> configurationFiles = configurationFilesProvider.getConfigurationFiles(profiles, user);

        configurationFiles.forEach(System.out::println);
    }
}
