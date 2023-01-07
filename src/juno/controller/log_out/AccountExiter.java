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

package juno.controller.log_out;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class defines an account exiter.
 * @author Simone Gentili
 */
public class AccountExiter
        extends AbstractAccountExiter<String> {

    // The guest name.
    private String guest;

    // The Account exiter.
    private static AccountExiter instance;

    // Builds the account exiter.
    private AccountExiter() {}

    /**
     * Returns the AccountExiter instance.
     * @return The AccountExiter instance.
     */
    public static AccountExiter getInstance() {
        if(instance == null) instance = new AccountExiter();
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
    public void logOut() {
        // Profile name.
        String profileName = Objects.requireNonNull(getProvider()).provide();

        // Does not export data related to the
        // Guest account during the log-out phase.
        if(!profileName.equalsIgnoreCase(guest)) {
            Objects.requireNonNull(getExporterManager()).export(profileName);
            Objects.requireNonNull(getRefresher()).refresh();
        }
        // Either way the recovery has to happen
        Objects.requireNonNull(getRestorableList()).forEach(Restorable::restore);
    }

}