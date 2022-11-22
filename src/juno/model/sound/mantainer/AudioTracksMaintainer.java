package juno.model.sound.mantainer;

import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AudioTracksMaintainer
        implements InterfaceTracksMaintainer,
        InterfaceTracksGenerator, Observable {

    private Collection<File> files;
    private final List<Observer> observerList;
    private static AudioTracksMaintainer instance;

    private AudioTracksMaintainer() {
       observerList = new ArrayList<>();
    }

    public static AudioTracksMaintainer getInstance() {
        if(instance == null) instance = new AudioTracksMaintainer();
        return instance;
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
    public Collection<File> getTracks() {
        return this.files;
    }

    @Override
    public void setTracks(@NotNull Collection<File> files) {
        this.files = files;
        updateAll();
    }
}
