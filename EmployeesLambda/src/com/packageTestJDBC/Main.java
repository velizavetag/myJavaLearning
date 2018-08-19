package com.packageTestJDBC;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Employee john = new Employee("John Doe",30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Robinhood",35 );
        Employee charming = new Employee( "Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ')+1);
        };

        Function<Employee, String> getFirstName = (Employee employee) ->{
            return employee.getName().substring(0, employee.getName().indexOf(' '));

        };

        Random random1 = new Random();
        for(Employee employee : employees){
            if(random1.nextBoolean()){
                System.out.println(getName(getFirstName, employee));
            }
        }


        Function<Employee, String> uppercase = employee -> employee.getName().toUpperCase();
        Function <String , String> firstName = name -> name.substring(0, name.indexOf(' '));

        Function chainedFunction = uppercase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(1)));


        IntUnaryOperator incBy5 = i -> i+5;
        System.out.println(incBy5.applyAsInt(10));

    }


    private static String getName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText,
                                                Predicate<Employee> ageCondition){
        System.out.println(ageText);
        for(Employee employee : employees){
            if(ageCondition.test(employee)){
                if(ageCondition.test(employee)){
                    System.out.println(employee.getName());
                }
            }
        }
    }
}
