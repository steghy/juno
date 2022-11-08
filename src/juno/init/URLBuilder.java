package juno.init;

public class URLBuilder {

    public static final String PREFIX = "https://raw.githubusercontent.com";

    public String prefix;
    public String repositoryName;
    public String adminName;
    public String branchName;
    public String token;

    private static URLBuilder instance;

    private URLBuilder() {}

    public static URLBuilder getInstance() {
        if(instance == null) {
            instance = new URLBuilder();
        } return instance;
    }

    public String getURL(String path) {
        String div = "/";
        StringBuilder builder = new StringBuilder();
        builder.append(prefix == null ? PREFIX : prefix);
        builder.append(adminName == null ? "" : div.concat(adminName));
        builder.append(repositoryName == null ? "" : div.concat(repositoryName));
        builder.append(branchName == null ? "" : div.concat(branchName));
        path = path.replace('\\', '/');
        builder.append(path.startsWith("/") ? path : div.concat(path));
        builder.append(token == null ? "" : "?token=".concat(token));
        return builder.toString();
    }

    public String getURL(String directory, String file) {
        String div = "/";
        StringBuilder builder = new StringBuilder();
        builder.append(prefix == null ? PREFIX : prefix);
        builder.append(adminName == null ? "" : div.concat(adminName));
        builder.append(repositoryName == null ? "" : div.concat(repositoryName));
        builder.append(branchName == null ? "" : div.concat(branchName));
        if(directory != null) {
            builder.append(directory.startsWith("/") ? directory : div.concat(directory));
        } if(file != null) {
            builder.append(file.startsWith("/") ? file : div.concat(file));
        }
        builder.append(token == null ? "" : "?token=".concat(token));
        return builder.toString();
    }

    public static void main(String[] args) {
        URLBuilder urlBuilder = URLBuilder.getInstance();
        urlBuilder.adminName = "steghy";
        urlBuilder.repositoryName = "configurator";
        urlBuilder.branchName = "main";
        // urlBuilder.token = "GHSAT0AAAAAABZZHKB4WTRFN4R52KTYJDB6Y3JSW2A";
        String result = urlBuilder.getURL("configurator.py");
        System.out.println(result);
    }


}
