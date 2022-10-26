package juno.model.deck;

import juno.model.card.AbstractUnoCard;

import java.util.List;

public class FactoryUnoCard implements AbstractFactoryUnoCard {

    private static FactoryUnoCard instance;

    private FactoryUnoCard() {}

    public static FactoryUnoCard getInstance(){
        if(instance == null){
            instance = new FactoryUnoCard();
        } return instance;
    }

    @Override
    public List<AbstractUnoCard> getRedCards() {
        return null;
    }

    @Override
    public List<AbstractUnoCard> getBlueCards() {
        return null;
    }

    @Override
    public List<AbstractUnoCard> getGreenCards() {
        return null;
    }

    @Override
    public List<AbstractUnoCard> getYellowCards() {
        return null;
    }

    @Override
    public List<AbstractUnoCard> getJollyCards() {
        return null;
    }
}
