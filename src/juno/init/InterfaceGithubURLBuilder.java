package juno.init;

import java.net.MalformedURLException;
import java.net.URL;

@FunctionalInterface
public interface InterfaceGithubURLBuilder {

    URL getGithubURL(String path) throws MalformedURLException;
}
