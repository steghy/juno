package juno.controller;

import java.util.Map;

@FunctionalInterface
public interface InterfaceRegistrationDataProvider {

    Map<String, Object> provideRegistrationData();

}
