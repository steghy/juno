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

package juno.model.data.settings;

import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Simone Gentili
 */
public class UserSettings
        implements Configurable, Exportable {

    /** The mute key. */
    public static final String MUTE_KEY = "mute";

    /** The fullscreen key. */
    public static final String FULLSCREEN = "fullscreen";

    // The UserSettings instance.
    private static UserSettings instance;

    // Builds the UserSettings instance.
    private UserSettings() {}

    /**
     * Returns the UserSettings instance.
     * @return The UserSettings instance.
     */
    public static UserSettings getInstance() {
        if(instance == null) instance = new UserSettings();
        return instance;
    }

    @Override
    public void configure(@NotNull Map<String, Object> map) {

    }

    @Override
    public Map<String, Object> exportData() {
        return null;
    }

}