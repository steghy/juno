package juno.init;

public class Repository {

    private Repository() {}

    public static void setRepository() {
        GithubURLBuilder url = GithubURLBuilder.getInstance();
        url.adminName = "steghy";
        url.repositoryName = "juno";
        url.branchName = "main";
    }
}