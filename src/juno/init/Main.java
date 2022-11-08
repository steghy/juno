package juno.init;

import juno.view.frame.Frame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        URLBuilder url = URLBuilder.getInstance();
        url.adminName = "steghy";
        url.repositoryName = "juno";
        url.branchName = "main";
        url.token = "GHSAT0AAAAAABZZHKB4WTRFN4R52KTYJDB6Y3JSW2A";

        try {
            Frame frame = new Frame();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unknown error has occurred. " +
                    "Consult the program logs for more information.");
        }
    }
}
