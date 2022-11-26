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

import juno.model.data.io.input.Configurable;
import juno.model.data.io.output.Exportable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class
Profile
        implements AbstractProfile, Configurable, Exportable {

    public static final int MAXIMUM_LENGTH = 15;
    public static final int MAXIMUM_AGE = 150;

    public static final String PROFILE_NAME = "profile name";
    public static final String NAME = "name";
    public static final String LAST_NAME = "last name";
    public static final String AGE = "age";

    private String profileName;
    private String name;
    private String lastName;
    private Integer age;
    private List<String> errorsList;

    private Profile() {}

    private static Profile instance;

    public static Profile getInstance() {
        if(instance == null) instance = new Profile();
        return instance;
    }

    @Override
    public void configure(@NotNull Map<String, Object> map) {
        // PROFILE NAME
        if(map.containsKey(PROFILE_NAME)) {
            if(map.get(PROFILE_NAME) instanceof String profileNameFromMap) {
                setProfileName(profileNameFromMap);
            } else {
                throw new IllegalArgumentException("Invalid object type " + map.get(PROFILE_NAME) +
                        ". String expected");
            }
        } else {
            throw new IllegalArgumentException(PROFILE_NAME + " not found in " + map);
        }


        // NAME
        if(map.containsKey(NAME)) {
            if (map.get(NAME) instanceof String nameFromMap) {
                setName(nameFromMap);
            } else {
                throw new IllegalArgumentException("Invalid object type " + map.get(NAME).getClass() +
                        ". String expected");
            }
        } else {
            throw new IllegalArgumentException(NAME + " key not found in " + map);
        }

        // LAST NAME
        if(map.containsKey(LAST_NAME)) {
            if(map.get(LAST_NAME) instanceof String lastNameFromMap) {
                setLastName(lastNameFromMap);
            } else {
                throw new IllegalArgumentException("Invalid object type " + map.get(LAST_NAME).getClass() +
                        ". String expected");
            }
        }
        else {
            throw new IllegalArgumentException(LAST_NAME + " key not found in " + map);
        }

        // AGE
        if(map.containsKey(AGE)) {
            if(map.get(AGE) instanceof Integer ageFromMap) {
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

    public void setProfileName(@NotNull String profileName) {
        int length = profileName.length();
        if(length == 0 || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("Invalid length " + length);
        }
        this.profileName = profileName;
    }

    public void setName(@NotNull String name) {
        int length = name.length();
        if(length == 0 || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("Invalid length " + length);
        }
        this.name = name;
    }

    public void setLastName(@NotNull String lastName) {
        int length = lastName.length();
        if(length == 0 || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("Invalid length " + length);
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age > 1 && age < MAXIMUM_AGE) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
    }

    public String getProfileName() {
        return profileName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

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