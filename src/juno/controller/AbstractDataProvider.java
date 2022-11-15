package juno.controller;

import java.util.Map;

public interface AbstractDataProvider<T, E> {

    Map<T, E> getData();

}
