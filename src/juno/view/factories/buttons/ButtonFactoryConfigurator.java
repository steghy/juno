package juno.view.factories.buttons;

import juno.model.data.io.input.AbstractDataImporter;
import juno.model.data.io.input.ReflectedConfigurator;

import java.io.IOException;

public class ButtonFactoryConfigurator {

    private AbstractDataImporter dataImporter;

    private static ButtonFactoryConfigurator instance;

    private ButtonFactoryConfigurator() {}

    public static ButtonFactoryConfigurator getInstance() {
        if(instance == null) {
            instance = new ButtonFactoryConfigurator();
        } return instance;
    }

    public void configure(String path) throws IOException {
        ReflectedConfigurator.configure(dataImporter.importData(path), ButtonFactory.class);
    }
}
