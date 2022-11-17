package juno.model.data.profile;

import juno.model.data.io.input.Configurable;
import juno.model.data.io.output.Exportable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import java.util.Map;


public class Profile implements AbstractProfile, Configurable, Exportable {

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

    public Profile() {}

    @Override
    public void configure(@NotNull Map<String, Object> map) {
        // PROFILE NAME
        if(map.containsKey(PROFILE_NAME)) {
            if(map.get(PROFILE_NAME) instanceof String usernameFromMap) {
                int length = usernameFromMap.length();
                if(length > 0 && length < MAXIMUM_LENGTH) {
                    this.profileName = usernameFromMap;
                } else {
                    throw new IllegalArgumentException("Invalid length " + length);
                }
            } else {
                throw new IllegalArgumentException("Invalid type " + map.get(PROFILE_NAME).getClass());
            }
        } else {
            throw new IllegalArgumentException(PROFILE_NAME + " key not found in " + map);
        }

        // NAME
        if(map.containsKey(NAME)) {
            if(map.get(NAME) instanceof String nameFromMap) {
                int length = nameFromMap.length();
                if(length > 0 && length < MAXIMUM_LENGTH) {
                    this.name = nameFromMap;
                } else {
                    throw new IllegalArgumentException("Invalid length " + length);
                }
            } else {
                throw new IllegalArgumentException("Invalid type " + map.get(NAME).getClass());
            }
        }

        // LAST NAME
        if(map.containsKey(LAST_NAME)) {
            if(map.get(LAST_NAME) instanceof String lastNameFromMap) {
                int length = lastNameFromMap.length();
                if(length > 0 && length < MAXIMUM_LENGTH) {
                    this.lastName = lastNameFromMap;
                } else {
                    throw new IllegalArgumentException("Invalid length " + length);
                }
            } else {
                throw new IllegalArgumentException("Invalid type " + map.get(LAST_NAME).getClass());
            }
        }

        // AGE
        if(map.containsKey(AGE)) {
            if(map.get(AGE) instanceof Integer ageFromMap) {
                if(ageFromMap > 1 && ageFromMap < MAXIMUM_AGE) {
                    this.age = ageFromMap;
                } else {
                    throw new IllegalArgumentException("Invalid age: " + ageFromMap);
                }
            } else {
                throw new IllegalArgumentException("Invalid type " + map.get(AGE).getClass());
            }
        }
    }

    @Override
    public Map<String, Object> getDataMap() {
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("[")
                .append(this.profileName)
                .append(", ")
                .append(this.name)
                .append(", ")
                .append(this.lastName)
                .append(", ")
                .append(this.age)
                .append("]");
        return stringBuilder.toString();
    }
}