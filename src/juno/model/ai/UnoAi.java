package juno.model.ai;

public class UnoAi<T> implements AbstractUnoAi<T> {

    private InterfaceUnoExaminer<T> examiner;

    @Override
    public T makeAChoice() {
        return examiner.response();
    }

    public void setExaminer(InterfaceUnoExaminer<T> examiner) {
        this.examiner = examiner;
    }

    public InterfaceUnoExaminer<T> getExaminer() {
        return examiner;
    }
}
