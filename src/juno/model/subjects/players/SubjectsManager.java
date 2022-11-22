package juno.model.subjects.players;

import juno.model.util.Donut;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

public class SubjectsManager<T>
        implements InterfaceSubjectsManager<T>, Observer {

    private Donut<T> subjects;
    private static SubjectsManager<?> instance;

    private SubjectsManager() {}

     public static SubjectsManager<?> getInstance() {
        if(instance == null) instance = new SubjectsManager<>();
        return instance;
    }

    @Override
    public T currentSubject() {
        if(subjects != null) {
            return subjects.current();
        } else {
            throw new IllegalArgumentException("Players is null");
        }
    }

    @Override
    public T nextSubject() {
        if(subjects != null) {
            return subjects.peek();
        } else {
            throw new IllegalArgumentException("Players is null");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceSubjectsProvider<?> obj) {
            subjects = new Donut<>();
            this.subjects = (Donut<T>) obj.getSubjects();
        } else {
            throw new IllegalArgumentException("Invalid object type (" + object.getClass() +") " +
                    "InterfaceSubjectsProvider expected.");
        }
    }
}
