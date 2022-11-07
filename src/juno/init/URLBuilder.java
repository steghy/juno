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

    public String getURL(Path pathObject) {
        String div = "/";
        String path = pathObject.getPath();
        if(path != null) {
            String subPath = pathObject.getPath().replace('\\', '/');
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix == null ? PREFIX : prefix);
        builder.append(adminName == null ? "" : div.concat(adminName));
        builder.append(repositoryName == null ? "" : div.concat(repositoryName));
        builder.append(branchName == null ? "" : div.concat(branchName));
        builder.append(path);
        builder.append(token == null ? "" : "?token=".concat(token));
        return builder.toString();
    }

    public String getURL(Path pathObject, String fileName) {
        String div = "/";
        String path = pathObject.getPath();
        if(path != null) {
            String subPath = pathObject.getPath().replace('\\', '/');
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix == null ? PREFIX : prefix);
        builder.append(adminName == null ? "" : div.concat(adminName));
        builder.append(repositoryName == null ? "" : div.concat(repositoryName));
        builder.append(branchName == null ? "" : div.concat(branchName));
        builder.append(path);
        builder.append(fileName == null ? "" : div.concat(fileName));
        builder.append(token == null ? "" : "?token=".concat(token));
        return builder.toString();
    }

    public static void main(String[] args) {
        URLBuilder urlBuilder = URLBuilder.getInstance();
        urlBuilder.adminName = "steghy";
        urlBuilder.repositoryName = "juno";
        urlBuilder.branchName = "main";
        urlBuilder.token = "GHSAT0AAAAAABZZHKB4WTRFN4R52KTYJDB6Y3JSW2A";
        String result = urlBuilder.getURL(Directories.BUTTONS);
        System.out.println(result);
    }


}
