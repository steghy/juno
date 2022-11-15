package juno.model.data.test;

import java.io.File;

public class DataTest {

    public static void main(String[] args) {
        File file = new File("/test-file");
        System.out.println(file.exists());
    }
}
