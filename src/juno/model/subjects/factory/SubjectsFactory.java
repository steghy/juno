package juno.model.subjects.factory;

import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SubjectsFactory extends AbstractSubjectsFactory<AbstractSubject> implements Observable {

    private final List<Observer> observerList;
    private List<AbstractSubject> subjects;
    private static SubjectsFactory instance;

    private SubjectsFactory() {
        observerList = new ArrayList<>();
    }

    public static SubjectsFactory getInstance() {
        if(instance == null) {
            instance = new SubjectsFactory();
        } return instance;
    }

    @Override
    public void generate(int num,@NotNull String name) {
        if(this.getNameFactory() != null) {
                subjects = new ArrayList<>(this.getNameFactory().getNames(num)
                        .stream()
                        .map(Subject::new)
                        .toList());
                subjects.add(new Subject(name));
                updateAll();
        } else {
            throw new IllegalArgumentException("AbstractNameFactory is null");
        }
    }

    @Override
    public List<AbstractSubject> getSubjects() {
        if(subjects != null) {
            return subjects;
        } else {
            throw new IllegalArgumentException("Subjects is null");
        }
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
}
