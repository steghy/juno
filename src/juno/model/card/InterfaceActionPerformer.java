package juno.model.card;

@FunctionalInterface
public interface InterfaceActionPerformer<T, E> {

    void performAction(T action, E color);
}
