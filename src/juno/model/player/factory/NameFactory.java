package juno.model.player.factory;

import java.util.*;

public class NameFactory implements AbstractNameFactory {

    private Collection<String> names;
    private static NameFactory instance;

    private NameFactory() {
        init();
    }

    public static NameFactory getInstance() {
        if(instance == null) {
            instance = new NameFactory();
        } return instance;
    }

    @Override
    public Collection<String> getNames(int num) {
        if(num > names.size()) {
            throw new IllegalArgumentException("" +
                    "Only up to twenty");
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
        names = Arrays.asList(
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
                "Fred");
    }
}