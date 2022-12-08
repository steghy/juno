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
        implements AbstractProfile, Configurable, Exportable {

    public static final int MAXIMUM_LENGTH = 15;
    public static final int MAXIMUM_AGE = 150;
    public static final String PROFILE_NAME = "profileName";
    public static final String NAME = "name";
    public static final String LAST_NAME = "lastName";
    public static final String AGE = "age";

    /* The profile name. */
    private String profileName;

    /* The name. */
    private String name;

    /* The last name. */
    private String lastName;

    /* The age. */
    private Integer age;

    /* The errors of the configuration process. */
    private final Map<String, String> errors;

    /* The Profile instance. */
    private static Profile instance;

    /* Builds the Profile instance. */
    private Profile() {
        errors = new HashMap<>();
    }

    /**
     * Returns the Profile instance.
     * @return The Profile instance.
     */
    public static Profile getInstance() {
        if(instance == null) instance = new Profile();
        return instance;
    }

    public Map<String, String> getErrors() {
        return errors;
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
                    errors.put(PROFILE_NAME, "Invalid profile name");
                }
            } else if (profileNameFromMap == null) profileName = null;
            else errors.put(PROFILE_NAME, "Invalid profile name");
        } else errors.put(PROFILE_NAME, "The profile name is required");

        // Name case.
        if (map.containsKey(NAME)) {
            Object nameFromMap = map.get(NAME);
            if (map.get(NAME) instanceof String temp) {
                try {
                    setName(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(NAME, "Invalid name");
                }
            } else if (nameFromMap == null) name = null;
            else errors.put(NAME, "Invalid name");
        }

        // Last name.
        if (map.containsKey(LAST_NAME)) {
            Object lastNameFromMap = map.get(LAST_NAME);
            if (map.get(LAST_NAME) instanceof String temp) {
                try {
                    setLastName(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(LAST_NAME, "Invalid last name");
                }
            } else if (lastNameFromMap == null) lastName = null;
            else errors.put(LAST_NAME, "Invalid last name");
        }

        // Age case.
        if (map.containsKey(AGE)) {
            Object ageFromMap = map.get(AGE);
            if (map.get(AGE) instanceof Integer temp) {
                try {
                    setAge(temp);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    errors.put(AGE, "Invalid age");
                }
            } else if (ageFromMap == null) age = null;
            else errors.put(AGE, "Invalid age");
        }

        // Checking for errors.
        if(!errors.isEmpty()) throw new IllegalArgumentException();
    }

    @Override
    public Map<String, Object> exportData() {
        Map<String, Object> map = new HashMap<>();
        if(profileName.length() > 0) map.put(PROFILE_NAME, profileName);
        if(name.length() > 0) map.put(NAME, name);
        if(lastName.length() > 0) map.put(LAST_NAME, lastName);
        if(age > 0) map.put(AGE, age);
        return map;
    }

    /**
     * Sets the profile name of this object.
     * @param profileName A String object.
     * @throws IllegalArgumentException
     */
    public void setProfileName(@NotNull String profileName) {
        int length = profileName.length();
        if(length == 0 || length > MAXIMUM_LENGTH)
            throw new IllegalArgumentException(
                    "Invalid profile name length " + length);
        this.profileName = profileName;
    }

    /**
     * Sets the name of this object.
     * @param name A String object.
     * @throws IllegalArgumentException
     */
    public void setName(@NotNull String name) {
        int length = name.length();
        if(length == 0 || length > MAXIMUM_LENGTH)
            throw new IllegalArgumentException(
                    "Invalid name length " + length);
        this.name = name;
    }

    /**
     * Sets the last name of this object.
     * @param lastName A String object.
     * @throws IllegalArgumentException
     */
    public void setLastName(@NotNull String lastName) {
        int length = lastName.length();
        if(length == 0 || length > MAXIMUM_LENGTH)
            throw new IllegalArgumentException(
                    "Invalid last name length " + length);
        this.lastName = lastName;
    }

    /**
     * Sets the age of this object.
     * @param age An integer value.
     * @throws IllegalArgumentException
     */
    public void setAge(int age) {
        if(age > 1 && age < MAXIMUM_AGE) this.age = age;
        else throw new IllegalArgumentException(
                "Invalid age: " + age);
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
    public Integer getAge() {
        return age;
    }

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