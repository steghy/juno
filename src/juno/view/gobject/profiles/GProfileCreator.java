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

package juno.view.gobject.profiles;

import juno.model.requester.InterfacePathProvider;
import juno.model.requester.InterfacePathProviderAssembler;
import juno.view.gobject.AbstractGObjectCreator;
import juno.view.gobject.InterfaceGObject;
import juno.view.gobject.InterfaceGObjectCreator;
import juno.view.gobject.InterfacePathObjectProvider;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GProfileCreator
        extends AbstractGObjectCreator<File>
        implements InterfaceGObjectCreator<File> {

    // The GProfileCreator instance.
    private static GProfileCreator instance;

    // Builds the GProfileCreator instance.
    private GProfileCreator() {}

    /**
     * Returns the GProfileCreator instance.
     * @return The GProfileCreator instance.
     */
    public static GProfileCreator getInstance() {
        if(instance == null) instance = new GProfileCreator();
        return instance;
    }

    @Override
    public InterfaceGObject<File> create(@NotNull File profile) {
        GProfile<File> graphicProfile = new GProfile<>(profile);
        InterfacePathProviderAssembler assembler = getAssembler();
        InterfacePathObjectProvider<File> provider = getProvider();
        InterfacePathProvider pathObject = Objects.requireNonNull(provider).getPathObjectOf(profile);
        Objects.requireNonNull(assembler);
        Objects.requireNonNull(getInitializer()).initialize(
                graphicProfile,
                assembler.assemble(pathObject, "PROFILE_BUTTON" + ".png"),
                assembler.assemble(pathObject, "PROFILE_BUTTON" + "_ROLLOVER" + ".png"));
        return graphicProfile;
    }

}