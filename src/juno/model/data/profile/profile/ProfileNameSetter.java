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

package juno.model.data.profile.profile;

import juno.model.data.profile.Characters;
import juno.model.util.AbstractObservable;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 */
public class ProfileNameSetter
        extends AbstractObservable
        implements InterfaceProfileNameSetter {

    // The ProfileNameSetter instance.
    private static ProfileNameSetter instance;

    // Builds the ProfileNameSetter instance.
    private ProfileNameSetter() {}

    /**
     * Returns the ProfileNameSetter instance.
     * @return The ProfileNameSetter instance.
     */
    public static ProfileNameSetter getInstance() {
        if(instance == null) instance = new ProfileNameSetter();
        return instance;
    }

    @Override
    public void setProfileName(@NotNull String profileName) {
        int length = profileName.length();
        if(length == 0) throw new IllegalArgumentException(
                "the length must be greater than zero");
        if(length > Profile.MAXIMUM_LENGTH) throw new IllegalArgumentException(
                "the length must be less than fifteen");
        if(!Characters.isAlphaNumeric(profileName)) throw new IllegalArgumentException(
                "alphanumeric characters only");
        Profile.getInstance().profileName = profileName;
        updateAll();
    }

}