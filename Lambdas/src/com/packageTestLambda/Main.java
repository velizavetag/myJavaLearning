package com.packageTestLambda;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        new Thread(new CodeToRun()).start();
//        new Thread(() -> System.out.println("printing from the runnable")).start();

        Employee john = new Employee("John Doe",30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//==========Printing employees with the forEach loop===============
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });



//        for(Employee  employee : employees){
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }


////
////        Collections.sort(employees, new Comparator<Employee>() {
////            @Override
////            public int compare(Employee employee1, Employee employee2) {
////                return employee1.getName().compareTo(employee2.getName());
////            }
////        });
//
//
//        Collections.sort(employees, (e1,e2) -> e1.getName().compareTo(e2.getName()));
//
//        for(Employee employee : employees){
//            System.out.println(employee.getName());
//        }
//
////        String sillyString = doStringStuff(new Employee.UpperConcat() {
////            @Override
////            public String upperConcat(String s1, String s2) {
////                return s1.toUpperCase() + s2.toUpperCase();
////            }
////        },
////           employees.get(0).getName(), employees.get(1).getName());
////        System.out.println(sillyString);
//
//
//        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase() + " " + s2.toUpperCase();
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());


        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
        System.out.println("\n\n");
        anotherClass.printValue();


    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperConcat(s1,s2);
    }

}

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
interface UpperConcat{
    public String upperConcat(String s1, String s2);
}

class AnotherClass{

    public String doSomething(){

        UpperConcat uc = (s1,s2) -> {
            System.out.println("the lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The another class's name is "+ getClass().getSimpleName());
        return Main.doStringStuff(uc, "String 1 " ," String 2");

//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String 1" , " String 2");

    }

    public void printValue(){
        int number = 25;

        Runnable r = () -> {
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println("The value is " + number);
        };


        new Thread(r).start();
    }

}

