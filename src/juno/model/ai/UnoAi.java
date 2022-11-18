package juno.model.ai;

import juno.model.card.*;
import juno.model.subjects.factory.AbstractSubject;
import juno.model.subjects.factory.Subject;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UnoAi extends
        AbstractUnoAi<Subject,
                AbstractUnoCard<
                        AbstractUnoCardAction,
                        AbstractUnoCardColor<
                                AbstractUnoColor>,
                        AbstractUnoCardValue>>
        implements AbstractSubject,
                   Observer,
                   Observable {

    private List<Observer> observerList;
    private String subjectName;
    private Difficulty difficulty;

    public UnoAi(String subjectName, Difficulty difficulty) {
        this.subjectName = subjectName;
        this.difficulty = difficulty;
    }

    public UnoAi(String subjectName) {
        this.subjectName = subjectName;
    }

    public UnoAi() {}

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public AbstractUnoCard<
            AbstractUnoCardAction,
            AbstractUnoCardColor<
                    AbstractUnoColor>,
            AbstractUnoCardValue> makeAChoice() {
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public String subjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return "UnoAi[" +
                subjectName +
                ", " +
                difficulty +
                "]";
    }
}