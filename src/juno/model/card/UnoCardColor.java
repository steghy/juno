package juno.model.card;

import org.jetbrains.annotations.NotNull;

public class UnoCardColor<T>
        implements InterfaceUnoCardColor<T> {

    private T color;

    public UnoCardColor(T color) {
       this.color = color;
    }

    @Override
    public void setUnoColor(T color) {
        this.color = color;
    }

    @Override
    public T getUnoColor(){
        return this.color;
    }

    @Override
    public boolean equals(@NotNull Object object) {
        if(object instanceof UnoCardColor<?> obj) {
            return this.color.equals(obj.getUnoColor());
        } else {
            throw new IllegalArgumentException("Invalid type "
            + object.getClass() + ", expected UnoCardColor type");
        }
    }

    @Override
    public String toString() {
        return this.color == null ? "NO_COLOR" : this.color.toString();
    }
}