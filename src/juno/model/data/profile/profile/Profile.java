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

import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import juno.controller.log_out.Restorable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;


/**
 * @author Simone Gentili
 */
public class Profile
        extends AbstractProfile
        implements InterfaceProfile, Configurable, Exportable, Restorable {

    /** The maximum length. */
    public static final int MAXIMUM_LENGTH = 15;

    /** The maximum age. */
    public static final int MAXIMUM_AGE = 150;

    /** The Profile name key. */
    public static final String PROFILE_NAME_KEY = "profileName";

    /** The name key. */
    public static final String NAME_KEY = "name";

    /** The last name key. */
    public static final String LAST_NAME_KEY = "lastName";

    /** The age key. */
    public static final String AGE_KEY = "age";

    /** The Guest name. */
    public static final String GUEST_NAME = "Guest";

    // The profile name.
    String profileName;

    // The name.
    String name;

    // The last name.
    String lastName;

    // The age.
    Integer age;

    // The Profile instance.
    private static Profile instance;

    // Builds the Profile instance.
    private Profile() {}

    /**
     * Returns the Profile instance.
     * @return The Profile instance.
     */
    public static Profile getInstance() {
        if(instance == null) instance = new Profile();
        return instance;
    }

    @Override
    public void configure(@NotNull Map<String, Object> map) {
        Map<String, String> errors = Objects.requireNonNull(getProvider()).getErrors();
        errors.clear(); // Cleaning up old errors.
        // Profile name case.
        if (map.containsKey(PROFILE_NAME_KEY)) {
            Object profileNameFromMap = map.get(PROFILE_NAME_KEY);
            if (profileNameFromMap instanceof String temp) {
                try {
                    ProfileNameSetter.getInstance().set(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(PROFILE_NAME_KEY, e.getMessage());
                }
            } else if (profileNameFromMap == null) profileName = null;
            else errors.put(PROFILE_NAME_KEY, "Profile name must be a String");
        } else errors.put(PROFILE_NAME_KEY, "The profile name is required");
        // Name case.
        if (map.containsKey(NAME_KEY)) {
            Object nameFromMap = map.get(NAME_KEY);
            if (map.get(NAME_KEY) instanceof String temp) {
                try {
                    NameSetter.getInstance().set(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(NAME_KEY, e.getMessage());
                }
            } else if (nameFromMap == null) name = null;
            else errors.put(NAME_KEY, "Name must be a String");
        }
        // Last name.
        if (map.containsKey(LAST_NAME_KEY)) {
            Object lastNameFromMap = map.get(LAST_NAME_KEY);
            if (map.get(LAST_NAME_KEY) instanceof String temp) {
                try {
                    LastNameSetter.getInstance().set(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(LAST_NAME_KEY, e.getMessage());
                }
            } else if (lastNameFromMap == null) lastName = null;
            else errors.put(LAST_NAME_KEY, "Last name must be a String.");
        }
        // Age case.
        if (map.containsKey(AGE_KEY)) {
            Object ageFromMap = map.get(AGE_KEY);
            if (map.get(AGE_KEY) instanceof Integer temp) {
                try {
                    AgeSetter.getInstance().set(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(AGE_KEY, e.getMessage());
                }
            } else if (ageFromMap == null) age = null;
            else errors.put(AGE_KEY, "Age must be a number");
        }

        // Checking for errors.
        if(!errors.isEmpty()) {
            restore();
            throw new IllegalArgumentException(errors.toString());
        }
    }

    @Override
    public Map<String, Object> exportData() {
        Map<String, Object> map = new HashMap<>();
        map.put(PROFILE_NAME_KEY, profileName);
        map.put(NAME_KEY, name);
        map.put(LAST_NAME_KEY, lastName);
        map.put(AGE_KEY, age);
        return map;
    }

    /**
     * Returns the profile name of this object.
     * @return A String object.
     */
    @Nullable
    public String profileName() {
        return profileName;
    }

    /**
     * Returns the name of this object.
     * @return A String object.
     */
    @Nullable
    public String getName() {
        return name;
    }

    @Override
    public void restore() {
        profileName = null;
        name = null;
        lastName = null;
        age = null;
    }

    @Override
    public String toString() {
        return "[" +
                this.profileName +
                ", " +
                this.name +
                ", " +
                this.lastName +
                ", " +
                this.age +
                "]";
    }

}