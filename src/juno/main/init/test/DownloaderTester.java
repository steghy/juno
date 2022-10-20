package juno.main.init.test;

import java.io.IOException;

import juno.main.init.Downloader;

public class DownloaderTester {

    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/steghy/juno/main/data/images/cards/green/green-7.png?token=GHSAT0AAAAAABZZHKB4TCCVWR7F3XGD4OCYY2RD35A";
        
        try {
            Downloader.downloadUsingNIO(url, "/home/steghy/card.png");
            Downloader.downloadUsingStream(url, "/home/steghy/card.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
