package juno.model.player;

import juno.model.util.Donut;

import java.util.Collection;

public interface AbstractInverter<T> {

    void invert(Donut<T> items);
}
