package juno.model.subjects.factory;

import juno.model.subjects.ai.Difficulty;

public interface AbstractSubjectsGenerator<T> {

    void generate(Difficulty difficulty, int num, String name);
}
