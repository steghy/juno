package juno.model.data.user;

import juno.model.data.*;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import java.util.Map;


public class User implements Configurable<Object, Object>, Exportable<Object, Object> {

    public static final int MAXIMUM_LENGTH = 15;

    public static final String USERNAME = "username";

    private String username;

    public User() {}

    @Override
    public void configure(@NotNull Map<Object, Object> map) {
        if(!map.containsKey(USERNAME)) {
            throw new IllegalArgumentException(USERNAME + " key not found in " + map);
        }
        if(!(map.get(USERNAME) instanceof String usernameFromMap)) {
            throw new IllegalArgumentException("Invalid type " + map.get(USERNAME).getClass());
        }

        int length = usernameFromMap.length();

        if(length == 0 || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("Invalid length " + length);
        }

        this.username = usernameFromMap;
    }

    @Override
    public Map<Object, Object> export() {
        Map<Object, Object> map = new HashMap<>();
        map.put(USERNAME, username);
        return map;
    }

    public void setUsername(@NotNull String username) {
        int length = username.length();
        if(length == 0 || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("Invalid length " + length);
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}