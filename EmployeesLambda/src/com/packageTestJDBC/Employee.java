package com.packageTestJDBC;

import java.util.*;

class Employee{
    private String name;
    private int age;

    public Employee(String employee, int age) {
        this.name = employee;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setEmployee(String employee) {
        this.name = employee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
