package juno.init;

import juno.view.ViewInitializer;
import juno.view.frame.Frame;

public class Main {

    public static void main(String[] args) {

        URLBuilder url = URLBuilder.getInstance();
        url.adminName = "steghy";
        url.repositoryName = "juno";
        url.branchName = "main";
        url.token = "GHSAT0AAAAAABZZHKB4WTRFN4R52KTYJDB6Y3JSW2A";

        ViewInitializer.initialize();
        Frame frame = new Frame();
        frame.setVisible(true);
    }
}
