package com.example.workflow.service;

import java.util.Map;

public class CheckstyleService {
    private String fullName;
    private int age;
    private static final String EXPERTISE = "Backend Development";
    private static String myStatus = "single";

    private static final String PASSWORD = "SeCreT150199";

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean fullNameIsSetted() {
        boolean isSetted = false;
        if (this.fullName != null) {
            isSetted = true;
        }
        return isSetted;
    }

    public String getFullName() {
        return fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Map<String, Object> getAll() {
        return Map.of(
                "full-name", fullName,
                "age", age,
                "expertise", EXPERTISE,
                "status", myStatus,
                "password", PASSWORD);
    }
}
