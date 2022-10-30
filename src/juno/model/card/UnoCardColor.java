package juno.model.card;

/**
 * @author steghy
 */
public class UnoCardColor implements AbstractUnoCardColor {

    /* The AbstractUnoColor object */
    private AbstractUnoColor color;

    /**
     * Builds an UnoCardColor object with
     * the specified AbstractUnoColor object
     * @param color An AbstractUnoColor object
     */
    public UnoCardColor(AbstractUnoColor color) {
       this.color = color;
    }

    /**
     * Builds an empty UnoCardColor object
     */
    public UnoCardColor(){}

    @Override
    public void setUnoColor(AbstractUnoColor color) {
        this.color = color;
    }

    @Override
    public AbstractUnoColor getUnoColor(){
        return this.color;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof UnoCardColor color) {
            return this.color.equals(color.getUnoColor());
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