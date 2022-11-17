package juno.model.data.user;

import juno.model.data.io.Configurable;
import juno.model.data.io.Exportable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import java.util.Map;


public class User implements Configurable, Exportable {

    public static final int MAXIMUM_LENGTH = 15;
    public static final int MAXIMUM_AGE = 150;

    public static final String USERNAME = "username";
    public static final String NAME = "name";
    public static final String LAST_NAME = "last name";
    public static final String AGE = "age";

    private String username;
    private String name;
    private String lastName;
    private Integer age;

    public User() {}

    @Override
    public void configure(@NotNull Map<String, Object> map) {
        // USERNAME
        if(map.containsKey(USERNAME)) {
            if(map.get(USERNAME) instanceof String usernameFromMap) {
                int length = usernameFromMap.length();
                if(length > 0 && length < MAXIMUM_LENGTH) {
                    this.username = usernameFromMap;
                } else {
                    throw new IllegalArgumentException("Invalid length " + length);
                }
            } else {
                throw new IllegalArgumentException("Invalid type " + map.get(USERNAME).getClass());
            }
        } else {
            throw new IllegalArgumentException(USERNAME + " key not found in " + map);
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
        map.put(USERNAME, username);
        map.put(NAME, name);
        map.put(LAST_NAME, lastName);
        map.put(AGE, age);
        return map;
    }

    public void setUsername(@NotNull String username) {
        int length = username.length();
        if(length == 0 || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("Invalid length " + length);
        }
        this.username = username;
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

    public String getUsername() {
        return username;
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
}