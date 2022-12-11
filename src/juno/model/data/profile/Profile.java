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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Simone Gentili
 */
public class Profile
        implements InterfaceProfiler,
                    InterfaceErrorProvider,
                    Configurable,
                     Exportable,
                    Observable {

    public static final int MAXIMUM_LENGTH = 15;
    public static final int MAXIMUM_AGE = 150;
    public static final String PROFILE_NAME = "profileName";
    public static final String NAME = "name";
    public static final String LAST_NAME = "lastName";
    public static final String AGE = "age";

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

    // The errors of the configuration process.
    private final Map<String, String> errors;

    // The Profile instance.
    private static Profile instance;

    // Builds the Profile instance.
    private Profile() {
        errors = new HashMap<>();
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
        errors.clear(); // Cleaning up old errors.
        // Profile name case.
        if (map.containsKey(PROFILE_NAME)) {
            Object profileNameFromMap = map.get(PROFILE_NAME);
            if (profileNameFromMap instanceof String temp) {
                try {
                    setProfileName(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(PROFILE_NAME, e.getMessage());
                }
            } else if (profileNameFromMap == null) profileName = null;
            else errors.put(PROFILE_NAME, "Profile name must be a String");
        } else errors.put(PROFILE_NAME, "The profile name is required");
        // Name case.
        if (map.containsKey(NAME)) {
            Object nameFromMap = map.get(NAME);
            if (map.get(NAME) instanceof String temp) {
                try {
                    setName(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(NAME, e.getMessage());
                }
            } else if (nameFromMap == null) name = null;
            else errors.put(NAME, "Name must be a String");
        }
        // Last name.
        if (map.containsKey(LAST_NAME)) {
            Object lastNameFromMap = map.get(LAST_NAME);
            if (map.get(LAST_NAME) instanceof String temp) {
                try {
                    setLastName(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(LAST_NAME, e.getMessage());
                }
            } else if (lastNameFromMap == null) lastName = null;
            else errors.put(LAST_NAME, "Last name must be a String.");
        }
        // Age case.
        if (map.containsKey(AGE)) {
            Object ageFromMap = map.get(AGE);
            if (map.get(AGE) instanceof Integer temp) {
                try {
                    setAge(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(AGE, e.getMessage());
                }
            } else if (ageFromMap == null) age = null;
            else errors.put(AGE, "Age must be a number");
        }
        // Checking for errors.
        if(!errors.isEmpty()) throw new IllegalArgumentException();
    }

    @Override
    public Map<String, Object> exportData() {
        Map<String, Object> map = new HashMap<>();
        map.put(PROFILE_NAME, profileName);
        map.put(NAME, name);
        map.put(LAST_NAME, lastName);
        map.put(AGE, age);
        return map;
    }

    @Override
    public Map<String, String> getErrors() {
        return errors;
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
        if(!Characters.isAlpha(profileName)) throw new IllegalArgumentException(
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
        if(!Characters.isAlpha(name)) throw new IllegalArgumentException(
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
        if(!Characters.isAlpha(lastName)) throw new IllegalArgumentException(
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

    /**
     * Returns the last name of this object.
     * @return A String object.
     */
    @Nullable
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the age of this object.
     * @return An integer value.
     */
    @Nullable
    public Integer getAge() {
        return age;
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