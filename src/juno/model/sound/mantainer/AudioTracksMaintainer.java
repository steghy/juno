package juno.model.sound.mantainer;

import juno.model.util.Observer;
import juno.model.util.Subject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AudioTracksMaintainer implements AbstractTracksMaintainer, AbstractTracksGenerator, Subject {

    private Collection<File> files;
    private final List<Observer> observerList;
    private static AudioTracksMaintainer instance;

    private AudioTracksMaintainer() {
       observerList = new ArrayList<>();
    }

    public static AudioTracksMaintainer getInstance() {
        if(instance == null) {
            instance = new AudioTracksMaintainer();
        } return instance;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    public Collection<File> getTracks() {
        return this.files;
    }

    @Override
    public void setTracks(Collection<File> files) {
        this.files = files;
        updateAll();
    }
}
