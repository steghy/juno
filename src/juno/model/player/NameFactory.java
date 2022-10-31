package juno.model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author steghy
 */
public class NameFactory implements AbstractNameFactory {

    /* List of names */
    private List<String> names;

    /* The NameProvider instance */
    private static NameFactory instance;

    /* Builds the RandomNameProvider instance */
    private NameFactory() {
        init();
    }

    /**
     * Returns the NameProvider instance.
     * @return The NameProvider instance.
     */
    public static NameFactory getInstance() {
        if(instance == null) {
            instance = new NameFactory();
        } return instance;
    }

    @Override
    public List<String> getNames(int num) {
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

    /* Initialize the NameProvider instance */
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
