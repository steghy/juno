package juno.model.data.profile.test;

import juno.init.Directories;
import juno.model.data.io.input.JSONDataImporter;
import juno.model.data.profile.Profile;
import juno.model.util.PathGenerator;

import java.io.IOException;

public class ProfileTester {

    public static void main(String[] args) throws IOException {

        Profile profile = Profile.getInstance();

        String profileConfigurationFilePath = PathGenerator.generate(Directories.PROFILES.absolutePath(), "steghy-profile.json");

        profile.configure(JSONDataImporter.getInstance().importData(profileConfigurationFilePath));

        System.out.println(profile);
    }
}