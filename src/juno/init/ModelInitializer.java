package juno.init;

import juno.model.data.io.input.InputDataInitializer;

public class ModelInitializer {

    private ModelInitializer() {}

    public static void initialize() {
        InputDataInitializer.initialize();
    }
}