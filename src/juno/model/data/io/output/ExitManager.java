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

package juno.model.data.io.output;


import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class defines an exit manager.
 * @author Simone Gentili
 */
public class ExitManager
        extends AbstractExitManager<String> {

    // The guest name.
    private String guest;

    // The ExitManager instance.
    private static ExitManager instance;

    // Builds the ExitManager instance.
    private ExitManager() {}

    /**
     * Returns the ExitManager instance.
     * @return The ExitManager instance.
     */
    public static ExitManager getInstance() {
        if(instance == null) instance = new ExitManager();
        return instance;
    }

    /**
     * Sets the guest name of this object.
     * @param guest A String object.
     */
    public void setGuest(@NotNull String guest) {
        this.guest = guest;
    }

    @Override
    public void exit() {
        // The profile name.
        String profileName = Objects.requireNonNull(getProvider()).provide();

        // Does not export data related to the
        // Guest account during the log-out phase.
        if(!profileName.equalsIgnoreCase(guest))
            Objects.requireNonNull(getExporter())
                    .export(profileName);

        // Exit from j-uno application.
        System.exit(0);
    }

}