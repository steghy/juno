package juno.model.data.io.test;

import juno.model.data.io.ConfigurationFilesProvider;
import juno.model.data.io.DataIOInitializer;
import juno.model.data.io.JSONDataImporter;
import juno.model.data.profile.Profile;
import juno.model.util.PathGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigurationFilesProviderTester {

    public static void main(String[] args) {
        String dataDirectory = PathGenerator.generate("data");
        String configDirectory = PathGenerator.generate(dataDirectory, "config");
        String profilesDirectory = PathGenerator.generate(configDirectory, "profiles");

        Profile profile = new Profile();

        DataIOInitializer.initialize();

        List<File> configurationFiles = ConfigurationFilesProvider.getInstance().getConfigurationFiles(profilesDirectory, profile);

        List<Profile> profiles = configurationFiles.stream().map(configurationFile -> {
            try {
                Profile newProfile = new Profile();
                newProfile.configure(JSONDataImporter.getInstance().importData(configurationFile.getAbsolutePath()));
                return newProfile;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        // configurationFiles.forEach(System.out::println);

        profiles.forEach(System.out::println);
    }
}
