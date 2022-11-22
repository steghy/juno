package juno.init;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;

public class GithubURLBuilder implements InterfaceGithubURLBuilder {

    public static final String PREFIX = "https://raw.githubusercontent.com";
    public static final String TOKEN = "?token=";

    public String prefix;
    public String repositoryName;
    public String adminName;
    public String branchName;
    public String token;

    private static GithubURLBuilder instance;

    private GithubURLBuilder() {}

    public static GithubURLBuilder getInstance() {
        if(instance == null) instance = new GithubURLBuilder();
        return instance;
    }

    @Override
    public URL getGithubURL(@NotNull String path) throws MalformedURLException {
        String div = "/";
        path = path.replace('\\', '/');
        String urlString = (prefix == null ? PREFIX : prefix) +
                (adminName == null ? "" : div.concat(adminName)) +
                (repositoryName == null ? "" : div.concat(repositoryName)) +
                (branchName == null ? "" : div.concat(branchName)) +
                (path.startsWith("/") ? path : div.concat(path)) +
                (token == null || token.length() == 0 ? "" : token.concat(token));
        return new URL(urlString);
    }
}