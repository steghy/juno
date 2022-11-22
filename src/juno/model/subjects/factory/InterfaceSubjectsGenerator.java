package juno.model.subjects.factory;

import juno.model.subjects.ai.Difficulty;

public interface InterfaceSubjectsGenerator<T> {

    void generate(Difficulty difficulty, int num, String name);
}
