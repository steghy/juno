package juno.model.data.io.input.reflection.test;

import juno.model.card.Card;
import juno.model.card.actions.Action;
import juno.model.card.colors.Color;
import juno.model.data.io.input.PropertyDeepCopier;

import java.util.Map;

/**
 * This class defines a property copier tester.
 * @author Simone Gentili
 */
public class PropertyDeepCopierTester {

    private PropertyDeepCopierTester() {}

    public static void main(String[] args) {
        // Object target.
        TestObject testObject = new TestObject(
                10,
                "MyTestObject",
                new Card(Color.GREEN, 9, null));

        // Other target.
        Card otherTargetObject = new Card(Color.BLUE, 9, Action.DRAW_TWO);

        // Property deep copier component
        PropertyDeepCopier propertyDeepCopier = PropertyDeepCopier.getInstance();

        // Try to get all the data from the object.
        try {
            Map<String, Object> data = propertyDeepCopier
                    .deepCopy(otherTargetObject);
            System.out.println(data);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}