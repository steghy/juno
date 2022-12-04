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

import java.util.HashMap;
import java.util.Map;


/**
 * @author Simone Gentili
 */
public class Profile
        implements AbstractProfile, Configurable, Exportable {

    public static final int MAXIMUM_LENGTH = 15;
    public static final int MAXIMUM_AGE = 150;
    public static final String PROFILE_NAME = "profile name";
    public static final String NAME = "name";
    public static final String LAST_NAME = "last name";
    public static final String AGE = "age";

    /* The profile name. */
    private String profileName;

    /* The name. */
    private String name;

    /* The last name. */
    private String lastName;

    /* The age. */
    private Integer age;

    /* Builds the Profile instance. */
    private Profile() {}

    /* The Profile instance. */
    private static Profile instance;

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
        // Profile name.
        if (map.containsKey(PROFILE_NAME)) {
            if (map.get(PROFILE_NAME) instanceof String profileNameFromMap) {
                setProfileName(profileNameFromMap);
            } else {
                throw new IllegalArgumentException("Invalid object type " + map.get(PROFILE_NAME) +
                        ". String expected");
            }
        } else {
            throw new IllegalArgumentException(PROFILE_NAME + " not found in " + map);
        }


        // Name.
        if (map.containsKey(NAME)) {
            if (map.get(NAME) instanceof String nameFromMap) {
                if (nameFromMap.length() > 0)
                    setName(nameFromMap);
            } else {
                throw new IllegalArgumentException("Invalid object type " + map.get(NAME).getClass() +
                        ". String expected");
            }
        } else {
            throw new IllegalArgumentException(NAME + " key not found in " + map);
        }

        // Last name.
        if (map.containsKey(LAST_NAME)) {
            if (map.get(LAST_NAME) instanceof String lastNameFromMap) {
                if (lastNameFromMap.length() > 0)
                    setLastName(lastNameFromMap);
            } else {
                throw new IllegalArgumentException("Invalid object type " + map.get(LAST_NAME).getClass() +
                        ". String expected");
            }
        }
        else {
            throw new IllegalArgumentException(LAST_NAME + " key not found in " + map);
        }

        // Age.
        if (map.containsKey(AGE)) {
            if (map.get(AGE) instanceof Integer ageFromMap) {
                if (ageFromMap > 0)
                    setAge(ageFromMap);
            } else {
                throw new IllegalArgumentException("Invalid object type " + map.get(AGE) +
                        ". Integer expected");
            }
        } else {
            throw new IllegalArgumentException(AGE + " key not found in " + map);
        }
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

    /**
     * Sets the profile name of this object.
     * @param profileName A String object.
     * @throws IllegalArgumentException
     */
    public void setProfileName(@NotNull String profileName) {
        int length = profileName.length();
        if(length == 0 || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("Invalid length " + length);
        }
        this.profileName = profileName;
    }

    /**
     * Sets the name of this object.
     * @param name A String object.
     * @throws IllegalArgumentException
     */
    public void setName(@NotNull String name) {
        int length = name.length();
        if(length == 0 || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("Invalid length " + length);
        }
        this.name = name;
    }

    /**
     * Sets the last name of this object.
     * @param lastName A String object.
     * @throws IllegalArgumentException
     */
    public void setLastName(@NotNull String lastName) {
        int length = lastName.length();
        if(length == 0 || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("Invalid length " + length);
        }
        this.lastName = lastName;
    }

    /**
     * Sets the age of this object.
     * @param age An integer value.
     * @throws IllegalArgumentException
     */
    public void setAge(int age) {
        if(age > 1 && age < MAXIMUM_AGE) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
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