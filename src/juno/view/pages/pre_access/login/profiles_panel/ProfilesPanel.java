/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.view.pages.pre_access.login.profiles_panel;

import juno.model.util.Observer;
import juno.view.gobject.InterfaceGObjectFactory;
import juno.view.gobject.profiles.GProfile;
import juno.view.util.ImageResizer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Simone Gentili
 */
public class ProfilesPanel
        extends JPanel
        implements Observer {

    // The graphic profiles button list.
    private final java.util.List<GProfile<File>> gProfiles;

    // The ProfilesPanel instance.
    private static ProfilesPanel instance;

    // Builds the ProfilesPanel instance.
    private ProfilesPanel() {
        setOpaque(false);
        setLayout(new GridLayout(1, 1));
        gProfiles = new ArrayList<>();
    }

    /**
     * Returns the ProfilesPanel instance.
     * @return The ProfilesPanel instance.
     */
    public static ProfilesPanel getInstance() {
        if(instance == null) instance = new ProfilesPanel();
        return instance;
    }

    /**
     * Returns the graphic profiles list of this object.
     * @return A List object.
     */
    public java.util.List<GProfile<File>> gProfiles() {
        return gProfiles;
    }

    @Override @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceGObjectFactory<?> factory) {
            factory.getGObjects().forEach(gObject -> {
                GProfile<File> gProfile = (GProfile<File>) gObject;
                ImageResizer.resize(gProfile, 15.0);
                add(gProfile);
                gProfiles.add(gProfile);
            });
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceGObjectFactory type expected.");
    }

}