package juno.model.card;

public interface InterfaceActionPerformer<T, E> {

    void performAction(T action, E color);
}
