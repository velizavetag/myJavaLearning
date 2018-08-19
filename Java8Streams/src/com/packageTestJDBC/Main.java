package com.packageTestJDBC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50",
                "I26", "I17", "I29",
                "071");
        List<String> gNumbers = new ArrayList<>();




//        someBingoNumbers.forEach(number -> {
//            if(number.startsWith("G")){
//                gNumbers.add(number);
////                System.out.print(number + "\t");
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        someBingoNumbers.stream()
                .map(String :: toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out :: println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29" , "O71");
        Stream<String> inNumberStream = Stream.of("N40,", "N36", "I26", "I17", "I29", "017");

        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        System.out.println("--------------------------------");
//        System.out.println(concatStream
//                            .distinct()
//                            .peek(System.out::println)
//                            .count());


        Employee john = new Employee("John Doe",30);
        Employee jane = new Employee("Jane Deer",25);
        Employee jack = new Employee("Jack Hill",40);
        Employee snow = new Employee("Snow White",22);

        Department hr = new Department("Human Resources ");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        hr.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployee().stream())
                .forEach(System.out::println);


        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for(String s : someBingoNumbers){
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupedByAge = departments
                .stream()
                .flatMap(department -> department.getEmployee().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployee().stream())
                .reduce((e1,e2) -> e1.getAge()<e2.getAge() ?e1:e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCC","CY","ST")
                .filter(s ->{
                    System.out.println(s);
                    return s.length() ==3;
                })
                .count();
    }
}
