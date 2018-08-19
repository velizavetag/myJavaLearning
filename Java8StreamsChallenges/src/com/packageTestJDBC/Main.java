package com.packageTestJDBC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Convert the following code into a lambda:


//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                String myString = "Let's split this up into array";
//                String[] parts = myString.split(" ");
//                for(String part: parts){
//                    System.out.println(part);
//                }
//            }
//        };

        Runnable runnable = () -> {
            String myString = "Let's split this up into array";
                String[] parts = myString.split(" ");
            for(String part: parts){
                    System.out.println(part);
                }

        };

//       ============Write the following method using a String========


//        public static String everySecondChar(String source){
//            StringBuilder returnValue = new StringBuilder();
//            for(int i = 0; i< source.length(); i++){
//                if(i%2 == 1){
//                    returnValue.append(source.charAt(i));
//                }
//            }
//            return returnValue.toString();
//
//
//        }

        Function<String, String> lambda = s ->{
            StringBuilder returnValue = new StringBuilder();
            for(int i = 0; i< s.length(); i++){
                if(i%2 == 1){
                    returnValue.append(s.charAt(i));
                }
            }
            return returnValue.toString();
        };

        System.out.println(everySeconCharacter(lambda,"12345678"));
        Supplier<String> iloveJava = () -> {
            return "I love java"; };

        String supplierResult = iloveJava.get();
        System.out.println(supplierResult);

//       ============ Challenge 8 ===============

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "ava",
                "Oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        System.out.println(topNames2015.stream()
                .map(s->s.substring(0,1).toUpperCase() +s.substring(1))
                .filter(s->s.startsWith("A"))
                .count());
                



    }

    private static String everySeconCharacter(Function<String, String> f, String s){
        return f.apply(s);
    }
}
