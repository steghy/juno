package juno.model.subjects.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NameFactory
        implements InterfaceNameFactory {

    private final List<String> names;
    private static NameFactory instance;

    private NameFactory() {
        names = new ArrayList<>();
    }

    public static NameFactory getInstance() {
        if(instance == null) instance = new NameFactory();
        return instance;
    }

    @Override
    public List<String> getNames(int num) {
        if(num > names.size()) {
            throw new IllegalArgumentException("Only up to twenty");
        }
        List<String> outputNames = new ArrayList<>();
        List<String> namesClone = new ArrayList<>(names);
        Random random = new Random();
        for(int i = 0; i < num; i ++) {
            int index = random.nextInt(namesClone.size());
            String name = namesClone.get(index);
            outputNames.add(name);
            namesClone.remove(index);
        }
        return outputNames;
    }

    private void init() {
        names.addAll(Arrays.asList(
                "Wade",
                "Dave",
                "Seth",
                "Ivan",
                "Riley",
                "Jorge",
                "Joshua",
                "Glen",
                "Peter",
                "Carlos",
                "Shane",
                "Harvey",
                "Clark",
                "Stefan",
                "Robin",
                "Tommy",
                "Neil",
                "Ted",
                "Benjamin",
                "Fred"));
    }
}