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

package juno.model.data.profile;

import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import juno.model.util.Observable;
import juno.model.util.Observer;
import juno.model.util.Restorable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;


/**
 * @author Simone Gentili
 */
public class Profile
        extends AbstractProfile
        implements InterfaceProfiler, Configurable, Exportable, Observable, Restorable {

    public static final int MAXIMUM_LENGTH = 15;
    public static final int MAXIMUM_AGE = 150;
    public static final String PROFILE_NAME_KEY = "profileName";
    public static final String NAME_KEY = "name";
    public static final String LAST_NAME_KEY = "lastName";
    public static final String AGE_KEY = "age";

    // The Observers List.
    private final List<Observer> observerList;

    // The profile name.
    private String profileName;

    // The name.
    private String name;

    // The last name.
    private String lastName;

    // The age.
    private Integer age;

    // The Profile instance.
    private static Profile instance;

    // Builds the Profile instance.
    private Profile() {
        observerList = new ArrayList<>();
    }

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
                    setProfileName(temp);
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
                    setName(temp);
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
                    setLastName(temp);
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
                    setAge(temp);
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
            throw new IllegalArgumentException();
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
     * Sets the profile name of this object.
     * @param profileName A String object.
     */
    public void setProfileName(@NotNull String profileName) {
        int length = profileName.length();
        if(length == 0) throw new IllegalArgumentException(
                "the length must be greater than zero");
        if(length > MAXIMUM_LENGTH) throw new IllegalArgumentException(
                "the length must be less than fifteen");
        if(!Characters.isAlphaNumeric(profileName)) throw new IllegalArgumentException(
                "alphanumeric characters only");
        this.profileName = profileName;
    }

    /**
     * Sets the name of this object.
     * @param name A String object.
     */
    public void setName(@NotNull String name) {
        int length = name.length();
        if(length == 0) throw new IllegalArgumentException(
                "the length must be greater than zero");
        if(length > MAXIMUM_LENGTH) throw new IllegalArgumentException(
                    "the length must be less than fifteen" + length);
        if(Characters.IsNotAlpha(name)) throw new IllegalArgumentException(
                "alphabetic characters only");
        this.name = name;
    }

    /**
     * Sets the last name of this object.
     * @param lastName A String object.
     */
    public void setLastName(@NotNull String lastName) {
        int length = lastName.length();
        if(length == 0) throw new IllegalArgumentException(
                "the length must be greater than zero");
        if(length > MAXIMUM_LENGTH) throw new IllegalArgumentException(
                    "the length must be less than fifteen");
        if(Characters.IsNotAlpha(lastName)) throw new IllegalArgumentException(
                "alphabetic characters only");
        this.lastName = lastName;
    }

    /**
     * Sets the age of this object.
     * @param age An integer value.
     */
    public void setAge(int age) {
        if(age < 1) throw new IllegalArgumentException(
                "must be greater than 0");
        if(age > MAXIMUM_AGE) throw new IllegalArgumentException(
                "must be less than 150");
        this.age = age;
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

}