package juno.init;

public class Repository {

    private Repository() {}

    public static void setRepository() {

        // GITHUB SERVER
        URLBuilder url = URLBuilder.getInstance();
        url.adminName = "steghy";
        url.repositoryName = "juno";
        url.branchName = "main";
        url.token = "GHSAT0AAAAAABZZHKB4WTRFN4R52KTYJDB6Y3JSW2A";
    }
}
