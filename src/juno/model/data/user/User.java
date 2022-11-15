package juno.model.data.user;

import juno.model.data.*;

import java.util.Map;


public class User implements Configurable<Object, Object>, Exportable<Object, Object> {

    public static final int MAXIMUM_USERNAME_LENGTH = 15;
    public static final int MINIMUM_USERNAME_LENGTH = 3;

    public static final int MAXIMUM_NAME_LENGTH = 15;
    public static final int MINIMUM_NAME_LENGTH = 3;

    public static final int MAXIMUM_LAST_NAME_LENGTH = 15;
    public static final int MINIMUM_LAST_NAME_LENGTH = 3;

    public static final String USERNAME = "username";
    public static final String NAME = "name";
    public static final String LAST_NAME = "last_name";
    public static final String AGE = "age";
    public static final String EMAIL = "email";
    public static final String TELEPHONE = "telephone";
    public static final String COUNTRY = "country";
    public static final String PASSWORD = "password";

    private String username;
    private String name;
    private String lastName;
    private int age;
    private Email email;
    private Telephone telephone;
    private Country country;
    private Password password;

    public User() {}

    @Override
    public void configure(AbstractDataProvider<Object, Object> data) throws DataCorruptedException {
        Map<Object, Object> dataMap = data.getDataMap();

        // USER NAME
        if(dataMap.containsKey(USERNAME)) {
            if(dataMap.get(USERNAME) instanceof String temp) {
                if (temp.length() < MINIMUM_USERNAME_LENGTH ||
                        temp.length() > MAXIMUM_USERNAME_LENGTH) {
                    throw new DataCorruptedException(USERNAME + " length error, length " +
                            temp.length() + " is not permitted",
                            Constant.THROW_RUNTIME_EXCEPTION);
                } else {
                    this.username = temp;
                }
            } else {
                throw new DataCorruptedException(USERNAME + " type error. Object type " +
                        dataMap.get(USERNAME).getClass(),
                        Constant.THROW_RUNTIME_EXCEPTION);
            }
        } else {
            throw new DataCorruptedException(USERNAME + " key not found in " + dataMap,
                    Constant.THROW_RUNTIME_EXCEPTION);
        }

        // NAME
        if(dataMap.containsKey(NAME)) {
            if(dataMap.get(NAME) instanceof String temp) {
                if (temp.length() < MINIMUM_NAME_LENGTH ||
                        temp.length() > MAXIMUM_NAME_LENGTH) {
                    throw new DataCorruptedException(NAME + " length error, length " +
                            temp.length() + " is not permitted",
                            Constant.THROW_RUNTIME_EXCEPTION);
                } else {
                    this.name = temp;
                }
            } else {
                throw new DataCorruptedException(NAME + " type error. Object type " +
                        dataMap.get(NAME).getClass(),
                        Constant.THROW_RUNTIME_EXCEPTION);
            }
        } else {
            throw new DataCorruptedException(NAME + " key not found in " + dataMap,
                    Constant.THROW_RUNTIME_EXCEPTION);
        }

        // LAST NAME
        if(dataMap.containsKey(LAST_NAME)) {
            if(dataMap.get(LAST_NAME) instanceof String temp) {
                if (temp.length() < MINIMUM_LAST_NAME_LENGTH ||
                        temp.length() > MAXIMUM_LAST_NAME_LENGTH) {
                    throw new DataCorruptedException(LAST_NAME + " length error, length " +
                            temp.length() + " is not permitted",
                            Constant.THROW_RUNTIME_EXCEPTION);
                } else {
                    this.lastName = temp;
                }
            } else {
                throw new DataCorruptedException(LAST_NAME + " type error. Object type " +
                        dataMap.get(LAST_NAME).getClass(),
                        Constant.THROW_RUNTIME_EXCEPTION);
            }
        } else {
            throw new DataCorruptedException(LAST_NAME + " key not found in " + dataMap,
                    Constant.THROW_RUNTIME_EXCEPTION);
        }
    }

    @Override
    public AbstractDataProvider<Object, Object> export() {
        Data<Object, Object> data = new Data<>();
        data.put(USERNAME, username);
        data.put(NAME, name);
        data.put(LAST_NAME, lastName);
        data.put(AGE, age);
        data.put(EMAIL, email);
        data.put(TELEPHONE, telephone);
        data.put(COUNTRY, country);
        data.put(PASSWORD, password);
        return data;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void setEmail(Email email) {
        this.email = email;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setPassword(Password password) {
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public Email getEmail() {
        return email;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public Country getCountry() {
        return country;
    }

    public Password getPassword() {
        return password;
    }

}
